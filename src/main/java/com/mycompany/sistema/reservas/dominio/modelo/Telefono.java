/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */
package com.mycompany.sistema.reservas.dominio.modelo;

/**
 *
 * @author DanielMafla
 */

import java.util.regex.Pattern;

public record Telefono(String valor) {
    private static final Pattern PATRON_TELEFONO =
        Pattern.compile("^[0-9]$");

    public Telefono {
        if( valor == null || valor.isBlank() ) {
            throw new IllegalArgumentException("El numero de telefono es obligatorio");
        }

        if (!PATRON_TELEFONO.matcher(valor).matches()) {
            throw new IllegalArgumentException("El  formato de numero te telefono no es valido: " + valor);
        }

        if (valor.length() != 10) {
            throw new IllegalArgumentException("El numero debe contener 10 caracteres");

        }
    }
    }
    
    

