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
public class Categoria_instrumento {
    private int codcat;
    private String descripcion;

    public Categoria_instrumento() {
    }

    public Categoria_instrumento(int codcat, String descripcion) {
        this.codcat = codcat;
        this.descripcion = descripcion;
    }

    public int getCodcat() {
        return codcat;
    }

    public void setCodcat(int codcat) {
        this.codcat = codcat;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
}
