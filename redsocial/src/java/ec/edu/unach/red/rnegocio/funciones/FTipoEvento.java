/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.unach.red.rnegocio.funciones;
//import ec.edu.unach.evento.accesodatos.*;
//import ec.edu.unach.evento.clases.*;
import ec.edu.unach.red.accesodatos.*;
//import ec.edu.unach.evento.clases.*;
import ec.edu.unach.red.rnegocio.clases.*;
import java.util.*;


/**
 *
 * @author user
 */
public class FTipoEvento {
    
        public static List<TipoEvento> obtener(){
        ArrayList<TipoEvento> lst= new ArrayList<>();
        String sql="select cod_tipoevento, descripcion from tipo_evento;";

        try{
            ConjuntoResultado cres= AccesoDatos.ejecutaQuery(sql);
            TipoEvento teven;
            while(cres.next()){
            teven = new TipoEvento();
            teven.setCod_tipoevento(cres.getInt(1));
            teven.setDescripcion(cres.getString(2));
           lst.add(teven);
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    return lst;
        }
    
     
    public static boolean insertar(TipoEvento teven){
        boolean res=false;
        String sql= "INSERT INTO tipo_evento(cod_tipoevento, descripcion) VALUES (?, ?);";
        try {
            ArrayList<Parametro> lstPar= new ArrayList<>();
            lstPar.add(new Parametro(1,teven.getCod_tipoevento()));
            lstPar.add(new Parametro(2,teven.getDescripcion()));
            res= AccesoDatos.ejecutaComando1(sql, lstPar);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }        
        return res;
    }
    
     public static TipoEvento obtener(int codigo){
        TipoEvento teven=null;
        String sql= "select cod_tipoevento, descripcion from tipo_evento where cod_tipoevento=?";
        try {
             ArrayList<Parametro> lstPar= new ArrayList<>();
            lstPar.add(new Parametro(1,codigo));
            ConjuntoResultado cres= AccesoDatos.ejecutaQuery(sql,lstPar);           
            while(cres.next()){
                teven= new TipoEvento();
                teven.setCod_tipoevento(cres.getInt(1));
                teven.setDescripcion(cres.getString(2)); 
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return teven;
    } 
     
     
    
    }
    

