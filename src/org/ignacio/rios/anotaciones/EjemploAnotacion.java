package org.ignacio.rios.anotaciones;

import org.ignacio.rios.anotaciones.Procesador.JsonSerializar;
import org.ignacio.rios.anotaciones.modelo.Producto;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;


public class EjemploAnotacion {

    public static void main(String[] args) {

        Producto p = new Producto();
        p.setFecha(LocalDate.now());
        p.setHora(LocalTime.now());
        p.setNombre("silla");
        p.setPrecio(1000L);




           String json = JsonSerializar.ConvertirJason(p);

        System.out.println(JsonSerializar.ConvertirJason(p));

        try {
            FileWriter writer = new FileWriter("datos2.json", true);
            writer.write(json);
            writer.close();
            System.out.println("El JSON se ha escrito en el archivo correctamente.");
        } catch (IOException e) {
            System.out.println("Ocurrió un error al escribir el archivo JSON: " + e.getMessage());
        }
    }



    }

