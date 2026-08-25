package com.mycompany.sistema.reservas.dominio.modelo;

import java.util.Objects;

public final class Habitacion {
    private final NumeroHabitacion numeroHabitacion;
    private final int capacidadMax;
    private final EstadoHabitacion estado;

    public Habitacion(NumeroHabitacion numeroHabitacion, int capacidadMax, EstadoHabitacion estado) {
        if (numeroHabitacion == null) {
            throw new IllegalArgumentException("El número de habitación no puede ser nulo");
        }
        if (capacidadMax < 1) {
            throw new IllegalArgumentException("La capacidad máxima debe ser al menos 1 persona");
        }
        if (estado == null) {
            throw new IllegalArgumentException("El estado no puede ser nulo");
        }

        this.numeroHabitacion = numeroHabitacion;
        this.capacidadMax = capacidadMax;
        this.estado = estado;
    }


    public NumeroHabitacion getNumeroHabitacion() {
        return numeroHabitacion;
    }

    public int getCapacidadMax() {
        return capacidadMax;
    }

    public EstadoHabitacion getEstado() {
        return estado;
    }

    public boolean estaDisponible() {
        return estado == EstadoHabitacion.DISPONIBLE;
    }

    public boolean tieneCapacidadPara(int personas) {
        return personas <= capacidadMax;
    }

    public Habitacion ocupar() {
        if (!estaDisponible()) {
            throw new IllegalStateException(
                    "Solo se puede ocupar una habitación en estado DISPONIBLE. Estado actual: " + estado);
        }
        return new Habitacion(numeroHabitacion, capacidadMax, EstadoHabitacion.OCUPADA);
    }

    public Habitacion liberar() {
        if (estado != EstadoHabitacion.OCUPADA) {
            throw new IllegalStateException(
                    "Solo se puede liberar una habitación en estado OCUPADA. Estado actual: " + estado);
        }
        return new Habitacion(numeroHabitacion, capacidadMax, EstadoHabitacion.DISPONIBLE);
    }

    public Habitacion enviarAMantenimiento() {
        if (estado == EstadoHabitacion.OCUPADA) {
            throw new IllegalStateException("No se puede enviar a mantenimiento una habitación ocupada");
        }
        return new Habitacion(numeroHabitacion, capacidadMax, EstadoHabitacion.MANTENIMIENTO);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Habitacion)) return false;
        Habitacion that = (Habitacion) o;
        return Objects.equals(numeroHabitacion, that.numeroHabitacion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numeroHabitacion);
    }

    @Override
    public String toString() {
        return "Habitacion{" +
                "numero=" + numeroHabitacion +
                ", capacidadMax=" + capacidadMax +
                ", estado=" + estado +
                '}';
    }
}