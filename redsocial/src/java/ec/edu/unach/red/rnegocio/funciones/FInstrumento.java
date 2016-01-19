/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.unach.red.rnegocio.funciones;
import ec.edu.unach.red.clases.*;
import ec.edu.unach.red.accesodatos.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Jefferson
 */
public class FInstrumento {
    public static List<Instrumento> obtener(){
        ArrayList<Instrumento> lst= new ArrayList<>();
        String sql= "SELECT codins, codusu, codcat, descripcion, material FROM instrumento;";
        try {
            ConjuntoResultado cres= AccesoDatos.ejecutaQuery(sql);
            Instrumento ins;
            while(cres.next()){
                ins= new Instrumento();
                ins.setCodins(cres.getInt(1));
                ins.setUsuario(FUsuario.obtener(cres.getInt(2)));
                ins.setCategoria(FCategoria_instrumento.obtener(cres.getInt(3)));
                ins.setDescripcion(cres.getString(4));
                ins.setMaterial(cres.getString(5));
                lst.add(ins);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lst;
    }
    public static boolean insertar(Instrumento ins){
        boolean res=false;
        String sql= "INSERT INTO instrumento(codins, codusu, codcat, descripcion, material) VALUES (?, ?, ?, ?, ?);";
        try {
            ArrayList<Parametro> lstPar= new ArrayList<>();
            lstPar.add(new Parametro(1,ins.getCodins()));
            lstPar.add(new Parametro(2,ins.getUsuario().getCodigo()));
            lstPar.add(new Parametro(3,ins.getCategoria().getCodcat()));
            lstPar.add(new Parametro(4,ins.getDescripcion()));
            lstPar.add(new Parametro(5,ins.getMaterial()));
            res= AccesoDatos.ejecutaComando1(sql, lstPar);
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }        
        return res;
    }
     public static Instrumento obtener(int codins){
        Instrumento ins=null;
        String sql= "SELECT codins, codusu, codcat, descripcion, material FROM instrumento WHERE codins=? ;";
        try {
             ArrayList<Parametro> lstPar= new ArrayList<>();
            lstPar.add(new Parametro(1,codins));
            ConjuntoResultado cres= AccesoDatos.ejecutaQuery(sql,lstPar);           
            while(cres.next()){
                ins= new Instrumento();
                ins.setCodins(cres.getInt(1));
                ins.setUsuario(FUsuario.obtener(cres.getInt(2)));
                ins.setCategoria(FCategoria_instrumento.obtener(cres.getInt(3)));
                ins.setDescripcion(cres.getString(4));
                ins.setMaterial(cres.getString(5));
                
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return ins;
    }
       public static Instrumento eliminar(int codigo)
    {
        Instrumento ins=null;
        String sql= "DELETE FROM instrumento WHERE codins=?";
        try {
             ArrayList<Parametro> lstPar= new ArrayList<>();
            lstPar.add(new Parametro(1,codigo)); 
            ConjuntoResultado cres= AccesoDatos.ejecutaQuery(sql,lstPar);           
            while(cres.next()){
                ins= new Instrumento();
                ins.setCodins(cres.getInt(1));
                ins.setUsuario(FUsuario.obtener(cres.getInt(2)));
                ins.setCategoria(FCategoria_instrumento.obtener(cres.getInt(3)));
                ins.setDescripcion(cres.getString(4));
                ins.setMaterial(cres.getString(5));
                 
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return ins;
        
    }
         public static boolean modificar(Instrumento ins){
         boolean res=false;
        String sql= "UPDATE instrumento SET codusu=?, codcat=?, descripcion=?, material=? WHERE codins=?;";
        try {
             ArrayList<Parametro> lstPar= new ArrayList<>();
            lstPar.add(new Parametro(1,ins.getUsuario().getCodigo()));
            lstPar.add(new Parametro(2,ins.getCategoria().getCodcat()));
            lstPar.add(new Parametro(3,ins.getDescripcion()));
            lstPar.add(new Parametro(4,ins.getMaterial()));
            lstPar.add(new Parametro(5,ins.getCodins()));
            res=AccesoDatos.ejecutaComando(sql, lstPar);
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return res;
    }
}
