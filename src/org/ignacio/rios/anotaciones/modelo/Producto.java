package org.ignacio.rios.anotaciones.modelo;

import org.ignacio.rios.anotaciones.JsonAtributo;

import java.time.LocalDate;
import java.time.LocalTime;

public class Producto {

    @JsonAtributo(amayusculas = true)
    private String nombre;

    @JsonAtributo
    private Long precio;

    @JsonAtributo
    private LocalDate fecha;

    @JsonAtributo
    private LocalTime hora;

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }




    public Producto() {
    }

    public Producto(String nombre, Long precio, LocalDate fecha, LocalTime hora) {
        this.nombre = nombre;
        this.precio = precio;
        this.fecha = fecha;
        this.hora = hora;
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
