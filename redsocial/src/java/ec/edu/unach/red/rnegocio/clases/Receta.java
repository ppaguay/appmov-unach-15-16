/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.unach.red.rnegocio.clases;

/**
 *
 * @author Ivancito
 */
public class Receta 
{
    private int codigo;
    private Usuario usuario;
    private CategoriaReceta categoria;
    private String detalle;
    private String nombre;

    public Receta() {
    }

    public Receta(int codigo, Usuario usuario, CategoriaReceta categoria, String detalle,String nombre) {
        this.codigo = codigo;
        this.usuario = usuario;
        this.categoria = categoria;
        this.detalle = detalle;
        this.nombre = nombre;
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

    public CategoriaReceta getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaReceta categoria) {
        this.categoria = categoria;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
