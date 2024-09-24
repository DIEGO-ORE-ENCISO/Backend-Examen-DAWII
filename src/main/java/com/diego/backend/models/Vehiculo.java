package com.diego.backend.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Vehiculo {

    private String placa;
    private String marca;
    private String modelo;
    private int nroAsientos;
    private double precio;
    private String color;
}
