/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.unach.red.rnegocio.clases;

/**
 *
 * @author USER
 */
public class Noticia {
    private int codigo;
    private Usuario usuario;
    private String titulo;
    private String descripcion;
    private CategoriaNoticia categoria;

    public Noticia() {
    }

    public Noticia(int codigo, Usuario usuario, String titulo, String descripcion, CategoriaNoticia categoria) {
        this.codigo = codigo;
        this.usuario = usuario;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.categoria = categoria;
    }

    public CategoriaNoticia getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaNoticia categoria) {
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}
