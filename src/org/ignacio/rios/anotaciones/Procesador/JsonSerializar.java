package org.ignacio.rios.anotaciones.Procesador;

import org.ignacio.rios.anotaciones.JsonAtributo;
import org.ignacio.rios.anotaciones.Procesador.Execpcion.JasonSerializadorException;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Locale;
import java.util.Objects;

public class JsonSerializar {


    public static  String ConvertirJason(Object objeto){

        if(Objects.isNull(objeto)){
           throw new JasonSerializadorException("el objeto es nulo");

        }

        Field[] campos = objeto.getClass().getDeclaredFields();


       return Arrays.stream(campos)
                .filter(f->f.isAnnotationPresent(JsonAtributo.class)) // filtra los campos que tengan JsonAtributo
                .map(f-> {
                    f.setAccessible(true);
                    String nombre = f.getAnnotation(JsonAtributo.class).nombre().equals("")
                            ? f.getName()
                            : f.getAnnotation(JsonAtributo.class).nombre();
                    try {
                        Object valor = f.get(objeto);
                        if(f.getAnnotation(JsonAtributo.class).amayusculas()
                                && valor instanceof String){
                            String nvo = (String) valor;
                            nvo = nvo.substring(0,1).toUpperCase(Locale.ROOT) +
                                   nvo.substring(1).toLowerCase();
                            f.set(objeto,nvo);


                        }


                        return "\""+nombre +"\":\"" + f.get(objeto) + "\"";
                    } catch (IllegalAccessException e) {
                        throw new JasonSerializadorException("Error de serializacion a Json"+e.getMessage());
                    }


                }).reduce("{",(a,b)->{

                    if("{".equals(a)){

                        return a+b;
                    }
                    return a+","+b;


                }).concat("}");



    }


}
