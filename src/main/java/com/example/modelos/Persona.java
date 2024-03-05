package com.example.modelos;

import java.util.ArrayList;
import java.util.List;

public class Persona {
    private String nombre;
    private String apellido;
    private List<Libro> librosPrestados;
    
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public List<Libro> getLibrosPrestados() {
        return librosPrestados;
    }
    public void setLibrosPrestados(List<Libro> librosPrestados) {
        this.librosPrestados = librosPrestados;
    }
    public Persona(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.librosPrestados = new ArrayList<>();
    }
    public Libro buscarLibroPrestado(Libro tituloLibro) {
        for (Libro libro : librosPrestados) {
            if (libro.getTitulo().equals(tituloLibro)) {
                return libro;
            }
        }
        return null; // Si no se encuentra el libro
    }
    
    
}
