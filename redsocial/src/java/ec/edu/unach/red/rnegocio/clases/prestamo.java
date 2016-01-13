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
public class prestamo {
    
    private int codigopres;
    private usuario codigous;
    private libro codigolib;
    private String descripcion;

    public prestamo() {
    }

    public prestamo(int codigopres, usuario codigous, libro codigolib, String descripcion) {
        this.codigopres = codigopres;
        this.codigous = codigous;
        this.codigolib = codigolib;
        this.descripcion = descripcion;
    }

    public int getCodigopres() {
        return codigopres;
    }

    public usuario getCodigous() {
        return codigous;
    }

    public libro getCodigolib() {
        return codigolib;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setCodigopres(int codigopres) {
        this.codigopres = codigopres;
    }

    public void setCodigous(usuario codigous) {
        this.codigous = codigous;
    }

    public void setCodigolib(libro codigolib) {
        this.codigolib = codigolib;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
    
}
