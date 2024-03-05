package com.example.modelos;

public class Revista extends ItemBiblioteca implements Catalogable{
    String nombre;

    @Override
   public void calcularMultas() {
       System.out.println("calculando multas");
    }

    @Override
    public void devolver() {
        System.out.println("devolviendo a la biblioteca");
    }

    @Override
    public void prestar() {
      System.out.println("sacando de la biblioteca");
    }

    @Override
    public void autor() {
       
    }

    @Override
    public void seccion() {
        
    }

    @Override
    public void titulo() {
        
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Revista(String nombre) {
        this.nombre = nombre;
    }
    
}
