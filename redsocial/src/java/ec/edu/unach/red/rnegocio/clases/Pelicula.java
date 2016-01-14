/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.unach.red.rnegocio.clases;

/**
 *
 * @author Marlon
 */
public class Pelicula {
    private int codigo;
    private String titulo;
    private String director;
    private String pais;
    private Usuario usuario;
    private Categoria_Pelicula categoria;

    public Pelicula() {
    }

    public Pelicula(int codigo, String titulo, String director, String pais, Usuario usuario, Categoria_Pelicula categoria) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.director = director;
        this.pais = pais;
        this.usuario = usuario;
        this.categoria = categoria;
    }    

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Categoria_Pelicula getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria_Pelicula categoria) {
        this.categoria = categoria;
    }
    
        
    
}
