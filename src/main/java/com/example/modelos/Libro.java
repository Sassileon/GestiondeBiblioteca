package com.example.modelos;

public class Libro extends ItemBiblioteca implements Catalogable {
    String titulo;
    String autor;
    Integer numeroDePaginas;
    boolean prestado;

    
    public void mostrarinformacion(){
     System.out.println(" Titulo : "+titulo);
     System.out.println(" Autor "+autor);
     System.out.println("Numero de paginas : "+numeroDePaginas);
     System.out.println("Estado: " + (prestado ? "Prestado" : "Disponible"));

    }
    @Override
    public void calcularMultas() {
        System.out.println("calculando multas");
     }
 
     @Override
     public void devolver() {
        if(prestado){
         prestado=false;
         System.out.println("LIBRO DEVUELTO");}
         else{
            System.out.println("El libro " +titulo+ " no estaba prestado");
         }
     }
 
     @Override
     public void prestar() {
        if(!prestado){
            prestado=true;
       System.out.println("sacando de la biblioteca la "+titulo);}
       else{
        System.out.println("El libro "+titulo+ " Ya esta prestado.");
       }
     }

    @Override
    public void autor() {
        
        System.out.println();
    }

    @Override
    public void seccion() {
        
    }

    @Override
    public void titulo() {
       
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }
    public Integer getNumeroDePaginas() {
        return numeroDePaginas;
    }
    public void setNumeroDePaginas(Integer numeroDePaginas) {
        this.numeroDePaginas = numeroDePaginas;
    }
    public Libro(String titulo, String autor, Integer numeroDePaginas) {
        this.titulo = titulo;
        this.autor = autor;
        this.numeroDePaginas = numeroDePaginas;
        this.prestado=false;
    }
    public boolean isPrestado() {
        return prestado;
    }
    public void setPrestado(boolean prestado) {
        this.prestado = prestado;
    }

    

    
}
