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

/**
 *
 * @author Mars
 */
public class FTipoaplicacion {
    
    public static List<Tipoaplicacion> obtener(){
        ArrayList<Tipoaplicacion> lst= new ArrayList<>();
        String sql="SELECT codigo, nombre, descripcion FROM public.tipoaplicacion;";

        try{
            ConjuntoResultado cres= AccesoDatos.ejecutaQuery(sql);
            Tipoaplicacion tipo;
            while(cres.next()){
            tipo = new Tipoaplicacion();
            tipo.setCodigo(cres.getInt(1));
            tipo.setNombre(cres.getString(2));
            tipo.setDescripcion(cres.getString(3));
           lst.add(tipo);
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    return lst;
    }
    
    
     public static boolean insertar(Tipoaplicacion lab){
        boolean res=false;
        String sql= "INSERT INTO public.tipoaplicacion(codigo, nombre, descripcion)VALUES (?, ?, ?);";
        try {
            ArrayList<Parametro> lstPar= new ArrayList<>();
            lstPar.add(new Parametro(1,lab.getCodigo()));
            lstPar.add(new Parametro(2,lab.getNombre()));
            lstPar.add(new Parametro(3,lab.getDescripcion()));
            res= AccesoDatos.ejecutaComando1(sql, lstPar);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }        
        return res;
    }
    
     public static Tipoaplicacion obtener(int codigo){
        Tipoaplicacion tipo=null;
        String sql= "SELECT codigo, nombre, descripcion FROM public.tipoaplicacion where codigo=?";
        try {
             ArrayList<Parametro> lstPar= new ArrayList<>();
            lstPar.add(new Parametro(1,codigo));
            ConjuntoResultado cres= AccesoDatos.ejecutaQuery(sql,lstPar);           
            while(cres.next()){
                tipo= new Tipoaplicacion();
                tipo.setCodigo(cres.getInt(1));
                tipo.setNombre(cres.getString(2)); 
                tipo.setDescripcion(cres.getString(3));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return tipo;
    } 
     
    
    
}
