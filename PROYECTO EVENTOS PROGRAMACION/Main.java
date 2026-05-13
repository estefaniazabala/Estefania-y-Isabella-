
import java.util.*;

// =========================
// INTERFACES
// =========================

interface IPago {
    boolean procesarPago(double monto);
    String confirmarPago();
}

interface Vendible {
    void vender();
    void cancelar();
}

interface Programable {
    void programarEvento();
    void cancelarEvento();
}

interface Patrocinado {
    void agregarPatrocinador(Patrocinador p);
    List<Patrocinador> getPatrocinadores();
}

// =========================
// CLASE ABSTRACTA EVENTO
// =========================

abstract class Evento {

    protected String id;
    protected String nombre;
    protected String fecha;
    protected Lugar lugar;

    public Evento(String id, String nombre, String fecha, Lugar lugar) {
        this.id = id;
        this.nombre = nombre;
        this.fecha = fecha;
        this.lugar = lugar;
    }

    public abstract void mostrarInfo();

    public List<Localidad> getLocalidades() {
        return new ArrayList<>();
    }

    public abstract String getTipo();
}

// =========================
// CONCIERTO
// =========================

class Concierto extends Evento implements Programable {

    private String artista;
    private String genero;

    public Concierto(String id, String nombre, String fecha,
                     Lugar lugar, String artista, String genero) {

        super(id, nombre, fecha, lugar);
        this.artista = artista;
        this.genero = genero;
    }

    @Override
    public void mostrarInfo() {
        System.out.println("Concierto: " + nombre);
        System.out.println("Artista: " + artista);
        System.out.println("Genero: " + genero);
    }

    @Override
    public String getTipo() {
        return "Concierto";
    }

    @Override
    public void programarEvento() {
        System.out.println("Concierto programado");
    }

    @Override
    public void cancelarEvento() {
        System.out.println("Concierto cancelado");
    }
}

// =========================
// CONFERENCIA
// =========================

class Conferencia extends Evento implements Programable {

    private String tema;
    private String ponente;

    public Conferencia(String id, String nombre, String fecha,
                       Lugar lugar, String tema, String ponente) {

        super(id, nombre, fecha, lugar);
        this.tema = tema;
        this.ponente = ponente;
    }

    @Override
    public void mostrarInfo() {
        System.out.println("Conferencia: " + nombre);
        System.out.println("Tema: " + tema);
        System.out.println("Ponente: " + ponente);
    }

    @Override
    public String getTipo() {
        return "Conferencia";
    }

    @Override
    public void programarEvento() {
        System.out.println("Conferencia programada");
    }

    @Override
    public void cancelarEvento() {
        System.out.println("Conferencia cancelada");
    }
}

// =========================
// LUGAR
// =========================

class Lugar implements Patrocinado {

    private String nombre;
    private String ciudad;
    private int capacidad;

    private List<Patrocinador> patrocinadores = new ArrayList<>();

    public Lugar(String nombre, String ciudad, int capacidad) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.capacidad = capacidad;
    }

    public String getInfo() {
        return nombre + " - " + ciudad;
    }

    public boolean tieneAforo() {
        return capacidad > 0;
    }

    @Override
    public void agregarPatrocinador(Patrocinador p) {
        patrocinadores.add(p);
    }

    @Override
    public List<Patrocinador> getPatrocinadores() {
        return patrocinadores;
    }
}

// =========================
// LOCALIDAD
// =========================

class Localidad {

    private String nombre;
    private double precio;
    private int cupos;
    private int cuposOcupados;

    public Localidad(String nombre, double precio, int cupos) {
        this.nombre = nombre;
        this.precio = precio;
        this.cupos = cupos;
        this.cuposOcupados = 0;
    }

    public boolean hayDisponibilidad() {
        return cuposOcupados < cupos;
    }

    public void reservarCupo() {
        if (hayDisponibilidad()) {
            cuposOcupados++;
        }
    }

    public double getPrecio() {
        return precio;
    }
}

// =========================
// BOLETA
// =========================

class Boleta implements Vendible {

    private String codigo;
    private double precio;
    private String estado;
    private Localidad localidad;

    public Boleta(String codigo, double precio, Localidad localidad) {
        this.codigo = codigo;
        this.precio = precio;
        this.localidad = localidad;
        this.estado = "Disponible";
    }

    @Override
    public void vender() {
        estado = "Vendida";
    }

    @Override
    public void cancelar() {
        estado = "Cancelada";
    }

    public String getInfo() {
        return codigo + " - " + estado;
    }
}

// =========================
// PATROCINADOR
// =========================

class Patrocinador {

    private String nombre;
    private String empresa;
    private double monto;

    public Patrocinador(String nombre, String empresa, double monto) {
        this.nombre = nombre;
        this.empresa = empresa;
        this.monto = monto;
    }

    public void patrocinar() {
        System.out.println("Patrocinio realizado");
    }

    public double getAporte() {
        return monto;
    }
}

// =========================
// ASISTENTE
// =========================

class Asistente implements Vendible {

    private String nombre;
    private String id;
    private String email;

    private List<Boleta> boletas = new ArrayList<>();

    public Asistente(String nombre, String id, String email) {
        this.nombre = nombre;
        this.id = id;
        this.email = email;
    }

    public void comprarBoleta(Boleta b) {
        boletas.add(b);
        b.vender();
    }

    public List<Boleta> verBoletas() {
        return boletas;
    }

    @Override
    public void vender() {
        System.out.println("Venta realizada");
    }

    @Override
    public void cancelar() {
        System.out.println("Venta cancelada");
    }
}

// =========================
// PAGO TARJETA
// =========================

class PagoTarjeta implements IPago {

    private String numeroTarjeta;
    private String token;

    public PagoTarjeta(String numeroTarjeta, String token) {
        this.numeroTarjeta = numeroTarjeta;
        this.token = token;
    }

    @Override
    public boolean procesarPago(double monto) {
        System.out.println("Pago con tarjeta: " + monto);
        return true;
    }

    @Override
    public String confirmarPago() {
        return "Pago confirmado con tarjeta";
    }
}

// =========================
// PAGO EFECTIVO
// =========================

class PagoEfectivo implements IPago {

    private String referencia;
    private String cajero;

    public PagoEfectivo(String referencia, String cajero) {
        this.referencia = referencia;
        this.cajero = cajero;
    }

    @Override
    public boolean procesarPago(double monto) {
        System.out.println("Pago en efectivo: " + monto);
        return true;
    }

    @Override
    public String confirmarPago() {
        return "Pago confirmado en efectivo";
    }
}

// =========================
// VENTA SERVICE
// =========================

class VentaService {

    private IPago pago;
    private List<Boleta> boletas = new ArrayList<>();

    public VentaService(IPago pago) {
        this.pago = pago;
    }

    public Boleta venderBoleta(Boleta b) {

        if (pago.procesarPago(50000)) {
            b.vender();
            boletas.add(b);
            return b;
        }

        return null;
    }

    public void cancelarBoleta(Boleta b) {
        b.cancelar();
    }

    public void generarReporte() {
        System.out.println("Boletas vendidas: " + boletas.size());
    }

    public void setPago(IPago pago) {
        this.pago = pago;
    }
}

// =========================
// MAIN
// =========================

public class ${NAME} {

    public static void main(String[] args) {

        // =========================
        // CREAR LUGAR
        // =========================

        Lugar lugar = new Lugar(
                "Movistar Arena",
                "Bogota",
                15000
        );

        // =========================
        // CREAR EVENTO
        // =========================

        Concierto concierto = new Concierto(
                "1",
                "Rock Fest",
                "20/06/2026",
                lugar,
                "Imagine Dragons",
                "Rock"
        );

        // =========================
        // CREAR LOCALIDAD
        // =========================

        Localidad vip = new Localidad(
                "VIP",
                500000,
                100
        );

        // =========================
        // CREAR BOLETA
        // =========================

        Boleta boleta1 = new Boleta(
                "B001",
                500000,
                vip
        );

        // =========================
        // CREAR ASISTENTE
        // =========================

        Asistente asistente = new Asistente(
                "Carlos Perez",
                "1001",
                "carlos@gmail.com"
        );

        // =========================
        // CREAR PATROCINADOR
        // =========================

        Patrocinador patrocinador = new Patrocinador(
                "Juan Lopez",
                "Coca Cola",
                10000000
        );

        lugar.agregarPatrocinador(patrocinador);

        // =========================
        // METODO DE PAGO
        // =========================

        IPago metodoPago = new PagoTarjeta(
                "123456789",
                "TOKEN123"
        );

        // =========================
        // SERVICIO DE VENTA
        // =========================

        VentaService venta = new VentaService(metodoPago);

        venta.venderBoleta(boleta1);

        asistente.comprarBoleta(boleta1);

        // =========================
        // MOSTRAR INFORMACION
        // =========================

        System.out.println("-----------------------------");
        System.out.println(" INFORMACION DEL EVENTO");
        System.out.println("-----------------------------");

        concierto.mostrarInfo();

        System.out.println("Fecha: 20/06/2026");
        System.out.println("Lugar: " + lugar.getInfo());
        System.out.println("Tipo Evento: " + concierto.getTipo());

        System.out.println();

        System.out.println("-----------------------------");
        System.out.println(" INFORMACION DE LOCALIDAD");
        System.out.println("-----------------------------");

        System.out.println("Localidad: VIP");
        System.out.println("Precio: 500000");
        System.out.println("Disponibilidad: " + vip.hayDisponibilidad());

        System.out.println();

        System.out.println("-----------------------------");
        System.out.println(" INFORMACION DE BOLETA");
        System.out.println("-----------------------------");

        System.out.println(boleta1.getInfo());

        System.out.println();

        System.out.println("-----------------------------");
        System.out.println(" INFORMACION DEL ASISTENTE");
        System.out.println("-----------------------------");

        System.out.println("Nombre: Carlos Perez");
        System.out.println("Correo: carlos@gmail.com");
        System.out.println("Boletas compradas: " + asistente.verBoletas().size());

        System.out.println();

        System.out.println("-----------------------------");
        System.out.println(" INFORMACION DEL PATROCINADOR");
        System.out.println("-----------------------------");

        System.out.println("Empresa patrocinadora agregada");
        System.out.println("Aporte: " + patrocinador.getAporte());

        System.out.println();

        System.out.println("-----------------------------");
        System.out.println(" REPORTE FINAL");
        System.out.println("-----------------------------");

        venta.generarReporte();

        System.out.println();
        System.out.println("Sistema ejecutado correctamente");
    }
}


