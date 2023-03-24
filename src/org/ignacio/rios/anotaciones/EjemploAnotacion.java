package org.ignacio.rios.anotaciones;

import org.ignacio.rios.anotaciones.modelo.Producto;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.Arrays;

public class EjemploAnotacion {

    public static void main(String[] args) {

        Producto p = new Producto();
        p.setFecha(LocalDate.now());
        p.setNombre("silla");
        p.setPrecio(1000L);

        Field[] campos = p.getClass().getDeclaredFields();

        Arrays.stream(campos)
                .filter(f->f.isAnnotationPresent(JsonAtributo.class))
                .map(f-> {
                      String nombre = f.getAnnotation(JsonAtributo.class).nombre().equals("")
                              ? f.getName()
                              : f.getAnnotation(JsonAtributo.class).nombre();
                    try {
                        return "\""+nombre +"\":\"" + f.get(p) + "\"";
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException("Error de serializacion a Json"+e.getMessage());
                    }


                }).reduce("{",(a)->{



                })





    }
}
