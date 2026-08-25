package com.mycompany.sistema.reservas.dominio.modelo;

public class Habitacion {
    private int numeroHabitacion;
    private int capacidadMax; // minimo 1 persona
    private EstadoHabitacion estado;

    public Habitacion(int numeroHabitacion, int capacidadMax, EstadoHabitacion estado) {

        this.numeroHabitacion = numeroHabitacion;
        this.capacidadMax = capacidadMax;
        this.estado = estado;
    }
}
