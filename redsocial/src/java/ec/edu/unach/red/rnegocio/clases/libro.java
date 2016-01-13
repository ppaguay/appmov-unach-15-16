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
public class libro {
    private int codigolib;
    private String descripcion;

    public libro() {
    }

    public libro(int codigolib, String descripcion) {
        this.codigolib = codigolib;
        this.descripcion = descripcion;
    }

    public int getCodigolib() {
        return codigolib;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setCodigolib(int codigolib) {
        this.codigolib = codigolib;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
    
}
