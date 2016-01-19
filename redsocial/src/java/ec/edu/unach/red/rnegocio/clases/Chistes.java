/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.unach.red.rnegocio.clases;

/**
 *
 * @author Pulpin
 */
public class Chistes {
    private int codigo_ch;
    private Usuario usuario;
    private String titulo;
    private String descripcion;
    private Categoria_chistes categoria;

    public Chistes() {
    }

    public Chistes(int codigo_ch, Usuario usuario, String titulo, String descripcion, Categoria_chistes categoria) {
        this.codigo_ch = codigo_ch;
        this.usuario = usuario;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.categoria = categoria;
    }

    public int getCodigo_ch() {
        return codigo_ch;
    }

    public void setCodigo_ch(int codigo_ch) {
        this.codigo_ch = codigo_ch;
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

    public Categoria_chistes getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria_chistes categoria) {
        this.categoria = categoria;
    }

 

    
}
