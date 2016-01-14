/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.unach.red.rnegocio.funciones;
//import ec.edu.unach.evento.accesodatos.*;
import ec.edu.unach.red.accesodatos.*;
//import ec.edu.unach.evento.clases.*;
import ec.edu.unach.red.rnegocio.clases.*;
import java.util.*;


/**
 *
 * @author user
 */
public class FEvento {
    
      public static List<Evento> obtener(){
        ArrayList<Evento> lst= new ArrayList<>();
        String sql= "SELECT cod_evento, nombre, direccion, cod_usuario, cod_tipoevento FROM public.evento;";
        try {
            ConjuntoResultado cres= AccesoDatos.ejecutaQuery(sql);
            Evento est;
            while(cres.next()){
                est= new Evento();
                est.setCod_evento(cres.getInt(1));
                est.setNombre(cres.getString(2));
                est.setDireccion(cres.getString(3));
                est.setCod_usuario(FUsuario.obtener(cres.getInt(4)));
                est.setCod_tipoevento(FTipoEvento.obtener(cres.getInt(5)));
                lst.add(est);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lst;
    }
    public static boolean insertar(Evento even){
        boolean res=false;
        String sql= "INSERT INTO public.evento(cod_evento, nombre, direccion, cod_usuario, cod_tipoevento) VALUES (?, ?, ?, ?, ?);";
        try {
            ArrayList<Parametro> lstPar= new ArrayList<>();
            lstPar.add(new Parametro(1,even.getCod_evento()));
            lstPar.add(new Parametro(2,even.getNombre()));
            lstPar.add(new Parametro(3,even.getDireccion()));
            lstPar.add(new Parametro(4,even.getCod_usuario().getCodigo()));
            lstPar.add(new Parametro(5,even.getCod_tipoevento().getCod_tipoevento()));
            res= AccesoDatos.ejecutaComando1(sql, lstPar);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }        
        return res;
    }
    
    
    
public static Evento obtener(int codigo){
        Evento even=null;
        String sql= "SELECT cod_evento, nombre, direccion, cod_usuario, cod_tipoevento FROM public.evento where cod_evento =?";
        try {
             ArrayList<Parametro> lstPar= new ArrayList<>();
            lstPar.add(new Parametro(1,codigo));
            ConjuntoResultado cres= AccesoDatos.ejecutaQuery(sql,lstPar);           
            while(cres.next()){
                even= new Evento();
                even.setCod_evento(cres.getInt(1));
                even.setNombre(cres.getString(2));  
                even.setDireccion(cres.getString(3));  
                even.setCod_usuario(FUsuario.obtener(cres.getInt(4)));
                even.setCod_tipoevento(FTipoEvento.obtener(cres.getInt(5)));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return even;
    }

 public static Evento eliminar(int codigo)
    {
        Evento even=null;
        String sql= "DELETE FROM evento WHERE cod_evento=?";
        try {
             ArrayList<Parametro> lstPar= new ArrayList<>();
            lstPar.add(new Parametro(1,codigo));
            AccesoDatos.ejecutaQuery(sql,lstPar);           
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return even;
        
    }
       
//    public static Asignatura modificar(int codigo,String nombre,int proveedor,int categoria,int cod2)
//     {
//        Producto producto=null;
//        String sql= "UPDATE public.producto SET nombre=?, cod_proveedor=?, cod_categoria=? WHERE codigo=?;";
//        try {
//             ArrayList<Parametro> lstPar= new ArrayList<>();
//            lstPar.add(new Parametro(1,nombre));
//            lstPar.add(new Parametro(2,proveedor));
//            lstPar.add(new Parametro(3,categoria));
//            lstPar.add(new Parametro(4,cod2));
//            AccesoDatos.ejecutaQuery(sql,lstPar);            
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//        return producto;
//    }
    
    public static boolean modif(Evento asig, int cod2){
        boolean res=false;
        String sql= "UPDATE public.evento SET cod_evento=?, nombre=?, direccion=?, cod_usuario=?, cod_tipoevento=? where cod_evento =? ;";
        try {
            ArrayList<Parametro> lstPar= new ArrayList<>();
            lstPar.add(new Parametro(1,asig.getNombre()));
            lstPar.add(new Parametro(2,asig.getDireccion()));
            lstPar.add(new Parametro(3,asig.getCod_usuario().getCodigo()));
            lstPar.add(new Parametro(4,asig.getCod_tipoevento().getCod_tipoevento()));
            lstPar.add(new Parametro(5,cod2));
            res= AccesoDatos.ejecutaComando1(sql, lstPar);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }        
        return res;
    }
    
    public static boolean modificar(Evento asig){
        boolean res=false;
        String sql= "UPDATE public.evento SET cod_evento=?, nombre=?, direccion=?, cod_usuario=?, cod_tipoevento=? where cod_evento ="+asig.getCod_evento();         
        try {
            ArrayList<Parametro> lstPar= new ArrayList();
            lstPar.add(new Parametro(1,asig.getNombre()));
            lstPar.add(new Parametro(2,asig.getDireccion()));
            lstPar.add(new Parametro(3,asig.getCod_usuario().getCodigo()));
            lstPar.add(new Parametro(4,asig.getCod_tipoevento().getCod_tipoevento()));
            
            res= AccesoDatos.ejecutaComando1(sql, lstPar);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }        
        return res;
    }
    
    
    
}
