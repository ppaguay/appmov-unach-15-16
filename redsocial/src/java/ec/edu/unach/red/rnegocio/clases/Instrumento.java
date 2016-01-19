/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.unach.red.rnegocio.clases;

/**
 *
 * @author Jefferson
 */
public class Instrumento {
    private int codins;
    private Usuario usuario;
    private Categoria_instrumento categoria;
    private String descripcion;
    private String material;

    public Instrumento() {
        
    }

    public Instrumento(int codins, Usuario usuario, Categoria_instrumento categoria, String descripcion, String material) {
        this.codins = codins;
        this.usuario = usuario;
        this.categoria = categoria;
        this.descripcion = descripcion;
        this.material = material;
    }

    public int getCodins() {
        return codins;
    }

    public void setCodins(int codins) {
        this.codins = codins;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Categoria_instrumento getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria_instrumento categoria) {
        this.categoria = categoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }
    
    
    
}
