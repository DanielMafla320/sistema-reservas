package com.mycompany.sistema.reservas.dominio.modelo;

import java.util.Objects;

public final class NumeroHabitacion {
    private final int valor;

    public NumeroHabitacion(int valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("El número de habitación debe ser positivo");
        }
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NumeroHabitacion)) return false;
        NumeroHabitacion that = (NumeroHabitacion) o;
        return valor == that.valor;
    }

    @Override
    public int hashCode() {
        return Objects.hash(valor);
    }

    @Override
    public String toString() {
        return String.valueOf(valor);
    }
}
