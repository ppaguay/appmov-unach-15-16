/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.unach.red.rnegocio.funciones;

import ec.edu.unach.red.rnegocio.clases.*;
import ec.edu.unach.red.accesodatos.*;
import java.util.*;

/**
 *
 * @author Mars
 */
public class FAplicacion {

    public static List<Aplicacion> obtener() {
        ArrayList<Aplicacion> lst = new ArrayList<>();
        String sql = "SELECT codigo, cod_usuario, cod_tipoaplicacion, nombre, descripcion FROM public.aplicacion;";
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql);
            Aplicacion apli;
            while (cres.next()) {
                apli = new Aplicacion();
                apli.setCodigo(cres.getInt(1));
                apli.setUsuario(FUsuario.obtener(cres.getInt(2)));
                apli.setTipoaplicacion(FTipoaplicacion.obtener(cres.getInt(3)));
                apli.setNombre(cres.getString(4));
                apli.setDescripcion(cres.getString(5));

                lst.add(apli);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lst;
    }

    public static boolean insertar(Aplicacion apli) {
        boolean res = false;
        String sql = "INSERT INTO public.aplicacion(codigo, cod_usuario, cod_tipoaplicacion, nombre, descripcion)VALUES (?, ?, ?, ?, ?);";
        try {
            ArrayList<Parametro> lstPar = new ArrayList<>();
            lstPar.add(new Parametro(1, apli.getCodigo()));
            lstPar.add(new Parametro(2, apli.getUsuario().getCodigo()));
            lstPar.add(new Parametro(3, apli.getTipoaplicacion().getCodigo()));
            lstPar.add(new Parametro(4, apli.getNombre()));
            lstPar.add(new Parametro(5, apli.getDescripcion()));

            res = AccesoDatos.ejecutaComando1(sql, lstPar);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return res;
    }

    public static Aplicacion obtener(int codigo) {
        Aplicacion apli = null;
        String sql = "SELECT codigo, cod_usuario, cod_tipoaplicacion, nombre, descripcion FROM public.aplicacion where codigo=?";
        try {
            ArrayList<Parametro> lstPar = new ArrayList<>();
            lstPar.add(new Parametro(1, codigo));
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql, lstPar);
            while (cres.next()) {
                apli = new Aplicacion();
                apli.setCodigo(cres.getInt(1));
                apli.setUsuario(FUsuario.obtener(cres.getInt(2)));
                apli.setTipoaplicacion(FTipoaplicacion.obtener(cres.getInt(3)));
                apli.setNombre(cres.getString(4));
                apli.setDescripcion(cres.getString(5));

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return apli;
    }
    
    public static Aplicacion eliminar(int codigo)
    {
        Aplicacion apli=null;
        String sql= "DELETE FROM public.aplicacion WHERE codigo=?;";
        try {
             ArrayList<Parametro> lstPar= new ArrayList<>();
            lstPar.add(new Parametro(1,codigo));
            AccesoDatos.ejecutaQuery(sql,lstPar);           
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return apli;
        
    }
    
    public static boolean modificar(Aplicacion apli){
        boolean res=false;
        String sql= "UPDATE public.aplicacion SET cod_usuario=?, cod_tipoaplicacion=?, nombre=?, descripcion=? WHERE codigo="+apli.getCodigo();         
        try {
            ArrayList<Parametro> lstPar= new ArrayList();
            lstPar.add(new Parametro(1,apli.getUsuario().getCodigo()));
            lstPar.add(new Parametro(2,apli.getTipoaplicacion().getCodigo()));
            lstPar.add(new Parametro(3,apli.getNombre()));
            lstPar.add(new Parametro(4,apli.getDescripcion()));
            
            res= AccesoDatos.ejecutaComando1(sql, lstPar);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }        
        return res;
    }
}

