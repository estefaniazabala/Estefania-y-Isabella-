package com.techsolutions.empresa;


    public class Ingeniero extends Empleado {
        // ATRIBUTOS ESPECÍFICOS DEL INGENIERO
        private String especialidad;      // Ej: "Programación", "DevOps"
        private int añosExperiencia;      // Número de años
        private String lenguajesPrimarios; // Lenguajes que domina

        // CONSTRUCTOR
        public Ingeniero(String id, String nombre, double salarioBase,
                         String especialidad, int añosExperiencia, String lenguajesPrimarios) {
            super(id, nombre, salarioBase); // Llamar al constructor de la SuperClase
            this.especialidad = especialidad;
            this.añosExperiencia = añosExperiencia;
            this.lenguajesPrimarios = lenguajesPrimarios;
        }

        // GETTERS
        public String getEspecialidad() {
            return especialidad;
        }

        public int getAñosExperiencia() {
            return añosExperiencia;
        }

        public String getLenguajesPrimarios() {
            return lenguajesPrimarios;
        }

        // SETTERS
        public void setEspecialidad(String especialidad) {
            this.especialidad = especialidad;
        }

        public void setAñosExperiencia(int años) {
            if (años > 0) {
                this.añosExperiencia = años;
            }
        }

        // MÉTODO SOBRESCRITO: Calcular salario con bonificación por experiencia
        @Override
        public double calcularSalario() {
            double bonificacion = salarioBase * (añosExperiencia * 0.05); // 5% por año
            return salarioBase + bonificacion;
        }

        // MÉTODO SOBRESCRITO: Mostrar información específica
        @Override
        public void mostrarInfo() {
            System.out.println("════════════════════════════════════");
            System.out.println("👨‍💻 Información del INGENIERO");
            System.out.println("════════════════════════════════════");
            System.out.println("ID: " + id);
            System.out.println("Nombre: " + nombre);
            System.out.println("Especialidad: " + especialidad);
            System.out.println("Años de Experiencia: " + añosExperiencia);
            System.out.println("Lenguajes: " + lenguajesPrimarios);
            System.out.printf("Salario Base: $%.2f%n", salarioBase);
            System.out.printf("Bonificación por Experiencia: $%.2f%n", calcularSalario() - salarioBase);
            System.out.printf("Salario Total: $%.2f%n", calcularSalario());
            System.out.println("════════════════════════════════════");
        }
    }

