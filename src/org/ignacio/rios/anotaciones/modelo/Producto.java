package org.ignacio.rios.anotaciones.modelo;

import org.ignacio.rios.anotaciones.JsonAtributo;

import java.time.LocalDate;

public class Producto {

    @JsonAtributo(nombre = "description")
    private String nombre;

    @JsonAtributo
    private Long precio;


    private LocalDate fecha;


    public Producto() {
    }

    public Producto(String nombre, Long precio, LocalDate fecha) {
        this.nombre = nombre;
        this.precio = precio;
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getPrecio() {
        return precio;
    }

    public void setPrecio(Long precio) {
        this.precio = precio;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
}
