package com.example.modelos;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca extends ItemBiblioteca implements Catalogable{


    private Libro[] catalogo;
    public Integer cantidadDeLibros = 0;
    private List<Persona> usuarios;

   
    public Biblioteca() {
        this.usuarios = new ArrayList<>();
        catalogo = new Libro[100];
        usuarios.add(new Persona("Leon", "Sassi"));
    }
    

    public List<Persona> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Persona> usuarios) {
        this.usuarios = usuarios;
    }

    public void agregarLibros(String titulo, String autor, Integer numeroDePaginas) {
        if (cantidadDeLibros < 100) {
            Libro nuevoLibro = new Libro(titulo, autor,numeroDePaginas);
            catalogo[cantidadDeLibros] = nuevoLibro;
            System.out.println("Libro agregado al catalogo");
            cantidadDeLibros++;
        } else {
            System.out.println("El catálogo está lleno. No se pueden agregar más libros.");
        }
    }
    
    public void agregarUsuario(Persona usuario) {
        this.usuarios.add(usuario);
    }
    
    public void mostrarcatalogo(){
        for (int u= 0 ; u<cantidadDeLibros;u++){
            catalogo[u].mostrarinformacion();
        }
        
    }

    @Override
    public void autor() {
       
    }

    @Override
    public void titulo() {
        
    }

    @Override
    public void seccion() {
        
    }

    @Override
    public void prestar() {
        
    }

    @Override
    public void devolver() {
        
    }

    @Override
    public void calcularMultas() {
        
    }
    public void prestarLibro(Persona persona, String tituloLibro) {
        for (Libro libro : catalogo) {
            if (libro != null && libro.getTitulo().equals(tituloLibro) && !libro.isPrestado()) {
                libro.prestar();
                persona.getLibrosPrestados().add(libro);
                System.out.println("Libro prestado a " + persona.getNombre() + " " + persona.getApellido() + ".");

                return;
                
            }
        }
        System.out.println("El libro no está disponible para préstamo.");
    }
    public void devolverLibro(Persona persona, Libro tituloLibro) {
        Libro libroDevolver = persona.buscarLibroPrestado(tituloLibro);
    
        if (libroDevolver != null) {
            libroDevolver.devolver();
            persona.getLibrosPrestados().remove(libroDevolver);
            System.out.println("Libro devuelto por " + persona.getNombre() + " " + persona.getApellido() + ".");
        } else {
            System.out.println("No se encontró el libro en la lista de libros prestados por " +
                    persona.getNombre() + " " + persona.getApellido() + ".");
        }
    }
}
