/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.unach.red.rnegocio.clases;

/**
 *
 * @author user
 */
public class Juego {
     private int codigo;
    private Usuario usuario;
    private String titulo;
    private int jugadores;
    private CategoriaJuego categoria;

    public Juego() {
    }

    public Juego(int codigo, Usuario usuario, String titulo, int jugadores, CategoriaJuego categoria) {
        this.codigo = codigo;
        this.usuario = usuario;
        this.titulo = titulo;
        this.jugadores = jugadores;
        this.categoria = categoria;
    }

    public CategoriaJuego getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaJuego categoria) {
        this.categoria = categoria;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getJugadores() {
        return jugadores;
    }

    public void setJugadores(int jugadores) {
        this.jugadores = jugadores;
    }
    
}
