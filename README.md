Biblioteca digital
README.md
Profesor(a),

Adjuntamos la entrega correspondiente al proyecto de Programación y Diseño Orientado a Objetos.

A continuación se incluye el contenido del README del proyecto:

Sistema de Gestión de Eventos
Descripción del Sistema

Sistema para gestionar diferentes tipos de eventos como conciertos y conferencias.
Permite administrar localidades, venta de boletas, asistentes, patrocinadores y la programación de eventos, incluyendo su lugar y capacidad.

Integrantes
Nombre	Correo
Estefanía Zabala	zabalaestefania2007@gmail.com
Laura Isabella Rodríguez Bermeo	lirodriguez-2025a@corhuila.edu.co
Diagrama de Clases UML




Estructura del Proyecto
src/
└── com/
    └── eventos/
        ├── model/
        │   ├── Evento.java (Clase abstracta)
        │   ├── Concierto.java
        │   ├── Conferencia.java
        │   ├── Lugar.java
        │   ├── Localidad.java
        │   ├── Boleta.java
        │   ├── Asistente.java
        │   ├── Patrocinador.java
        │   ├── Vendible.java (Interface)
        │   ├── Programable.java (Interface)
        │   └── Patrocinado.java (Interface)
        └── Main.java
Explicación de Relaciones
Herencia (──▷)
Concierto y Conferencia heredan de Evento (clase abstracta).
Justificación: Ambos son tipos de eventos que comparten atributos comunes como nombre, fecha y lugar, pero tienen características específicas (artista o tema).
Composición (◆───)
Evento contiene un Lugar.
Multiplicidad: 1 Evento → 1 Lugar
Justificación: Un evento no puede existir sin un lugar asignado.
Agregación (◇───)
Evento contiene Localidades.
Multiplicidad: 1 Evento → 1..* Localidades
Justificación: Las localidades pertenecen al evento, pero pueden existir independientemente.
Asociación (─────)
Localidad se asocia con Boleta.
Multiplicidad: 1 Localidad → 1 Boleta
Boleta se asocia con Asistente.
Multiplicidad: 1 Asistente → 0..* Boletas
Evento se asocia con Patrocinador.
Multiplicidad: 1 Evento → 0..* Patrocinadores
Justificación:
Las boletas pertenecen a una localidad.
Los asistentes compran boletas.
Los eventos pueden tener varios patrocinadores.
Implementación de Interfaces (- - -▷)
Boleta implementa Vendible.
Evento implementa Programable.
Evento implementa Patrocinado.
Justificación:
Se definen comportamientos comunes como vender, programar eventos y agregar patrocinadores.
Clases Implementadas
Clase	Tipo	Atributos	Descripción
Evento	Abstracta	nombre, fecha, lugar	Clase base para eventos
Concierto	Concreta	artista	Evento musical
Conferencia	Concreta	tema	Evento académico o informativo
Lugar	Concreta	nombre, capacidad	Lugar donde se realiza el evento
Localidad	Concreta	nombre, precio, cupos	Secciones del evento
Boleta	Concreta	codigo	Entrada para el evento
Asistente	Concreta	nombre, id	Persona que asiste al evento
Patrocinador	Concreta	nombre, empresa	Entidad que patrocina
Vendible	Interface	vender()	Define acción de venta
Programable	Interface	programarEvento()	Define programación de eventos
Patrocinado	Interface	agregarPatrocinador()	Define gestión de patrocinadores
