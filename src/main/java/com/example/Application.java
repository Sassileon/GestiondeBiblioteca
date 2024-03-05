package com.example;

import com.example.modelos.Biblioteca;
import com.example.modelos.Libro;
import com.example.modelos.Persona;

import java.util.Scanner;
public class Application {

    public static void main(String[] args) {
        Libro libro1 = new Libro("Santa biblia", "DIOS", 1000);
        libro1.mostrarinformacion();
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.agregarLibros("Santa Biblia", "DIOS", 1000);
        biblioteca.agregarLibros("Data Structures and Algorithms", "Alice Johnson", 400);
        biblioteca.agregarLibros("The Great Gatsby", "F. Scott Fitzgerald", 200);
        Scanner scanner = new Scanner(System.in);
        Integer opcion;
       
        do{
            System.out.println("Menú:");
            System.out.println("1. Agregar libro al catálogo");
            System.out.println("2. Mostrar catálogo");
            System.out.println("3. Prestar libro");
            System.out.println("4. Devolver libro");
            System.out.println("0. Salir");
            System.out.print("Ingrese la opción: ");
            opcion=scanner.nextInt();
            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el título del libro: ");
                    scanner.nextLine();
                    String titulo3 = scanner.nextLine();
                    System.out.print("Ingrese el autor del libro: ");
                    String autor = scanner.nextLine();
                    System.out.print("Ingrese el número de páginas del libro: ");
                    int numeroDePaginas = scanner.nextInt();
                    biblioteca.agregarLibros(titulo3, autor, numeroDePaginas);
                    break;

                case 2: 
                    // Mostrar catálogo
                    biblioteca.mostrarcatalogo();
                    break;

                case 3:// Prestar libro
                scanner.nextLine(); // Consumir el salto de línea después de nextInt()
                System.out.print("Ingrese el título del libro a prestar: ");
                String libroPrestar = scanner.nextLine();
                System.out.println("Ingrese su nombre");
                String persona1 = scanner.nextLine();
                System.out.println("Ahora su apellido");
                String apellidoPersona=scanner.nextLine();
                Persona usuarios = new Persona(persona1, apellidoPersona);
                biblioteca.prestarLibro(usuarios, libroPrestar);
                biblioteca.agregarUsuario(usuarios);
                break;
                case 4:  scanner.nextLine(); // Consumir el salto de línea después de nextInt()
                System.out.print("Ingrese el nombre de la persona: ");
                String nombrePersona = scanner.nextLine();
                System.out.print("Ingrese el apellido de la persona: ");
                String apellidoPersona6 = scanner.nextLine();
            
                // Buscar a la persona en base a nombre y apellido
                Persona personaADevolver = null;
                for (Persona persona : biblioteca.getUsuarios()) {
                    if (persona.getNombre().equals(nombrePersona) && persona.getApellido().equals(apellidoPersona6)) {
                        personaADevolver = persona;
                        break;

                    }
                }
            
                if (personaADevolver != null) {
                    // Mostrar los libros prestados por la persona
                    System.out.println("Libros prestados por " + nombrePersona + " " + apellidoPersona6 + ":");
                    for (Libro libro : personaADevolver.getLibrosPrestados()) {
                        libro.mostrarinformacion();
                    }
                    // Solicitar el título del libro a devolver
                    System.out.print("Ingrese el título del libro a devolver: ");
                    String tituloLibroDevolver = scanner.nextLine();
            
                    // Crear un libro con el título ingresado
                    Libro libroParaDevolver = new Libro(tituloLibroDevolver, "AutorDummy", 1);
            
                    // Intentar devolver el libro a la biblioteca
                    biblioteca.devolverLibro(personaADevolver, libroParaDevolver);
                } else {
                    System.out.println("No se encontró la persona con nombre y apellido especificados.");
                }
                break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }

        } while (opcion != 0);

        scanner.close();

}}
