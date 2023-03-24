**La reflexión en Java** es una característica que permite a un programa examinar y modificar su propia estructura y comportamiento en tiempo 
de ejecución. Con la reflexión, un programa puede examinar información sobre las clases y objetos que se están ejecutando, 
como el nombre de la clase, los campos y métodos definidos en la clase, las interfaces que implementa la clase, etc.

La reflexión también permite a un programa modificar la estructura y comportamiento de las clases y objetos en tiempo 
de ejecución, por ejemplo, creando nuevas instancias de objetos, accediendo a los campos y métodos de un objeto, 
invocando métodos en un objeto, etc. Esto se puede hacer sin necesidad de conocer los detalles de la implementación de la clase o el objeto.

La reflexión se basa en la API de reflexión de Java, que proporciona clases y métodos para examinar y manipular la estructura y el comportamiento de las clases y objetos. Algunas de las clases más comunes en la API de reflexión incluyen Class, Field, Method y Constructor.

La reflexión puede ser útil en situaciones en las que un programa necesita interactuar con clases y objetos que no conoce en tiempo de compilación. Por ejemplo, puede ser útil en entornos de programación dinámica,
como los frameworks de inyección de dependencias, en los que las clases y objetos se crean y modifican en tiempo 
de ejecución en función de las necesidades del programa. También puede ser útil para la creación de pruebas unitarias y herramientas de depuración.

Es importante tener en cuenta que, si bien la reflexión puede ser poderosa y útil en ciertos casos,  también puede tener un impacto en el rendimiento del programa y puede hacer que el código sea más difícil de leer y mantener. 
Por lo tanto, se recomienda usar la reflexión con precaución y sólo cuando sea necesario.



Ejemplo básico de cómo utilizar la reflexión en Java para obtener información sobre una clase:

Supongamos que tenemos una clase Persona con dos atributos nombre y edad:



public class Persona {
    private String nombre;
    private int edad;

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }
}

Podemos utilizar la reflexión para obtener información sobre la clase Persona. 
Por ejemplo, podemos obtener el nombre de la clase, los nombres y tipos de los atributos y los métodos definidos en la clase:


import java.lang.reflect.*;

public class EjemploReflexion {
    public static void main(String[] args) throws Exception {
        Class<Persona> clasePersona = Persona.class;

  

   

   // Obtener el nombre de la clase
        String nombreClase = clasePersona.getName();
        System.out.println("Nombre de la clase: " + nombreClase);

        // Obtener los atributos de la clase
        Field[] atributos = clasePersona.getDeclaredFields();
        System.out.println("Atributos de la clase:");
        for (Field atributo : atributos) {
            System.out.println("- " + atributo.getName() + ": " + atributo.getType().getName());
        }

        // Obtener los métodos de la clase
        Method[] metodos = clasePersona.getDeclaredMethods();
        System.out.println("Métodos de la clase:");
        for (Method metodo : metodos) {
            System.out.println("- " + metodo.getName() + "()");
        }
    }
}

Este programa producirá la siguiente salida:

Nombre de la clase: Persona Atributos de la clase:
    nombre: java.lang.String
  edad: int Métodos de la clase:
   getNombre()
 getEdad()


**Como se puede ver, la reflexión nos permite obtener información útil sobre la estructura de una clase, lo que puede ser útil en diferentes situaciones.***
