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
public class FCategoria_instrumento {
    public static List<Categoria_instrumento> obtener(){
        ArrayList<Categoria_instrumento> lst= new ArrayList<>();
        String sql= "select codcat, descripcion from categoria_instrumento";
        try {
            ConjuntoResultado cres= AccesoDatos.ejecutaQuery(sql);
            Categoria_instrumento cat;
            while(cres.next()){
                cat= new Categoria_instrumento();
                cat.setCodcat(cres.getInt(1));
                cat.setDescripcion(cres.getString(2));
                lst.add(cat);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lst;
    }
    public static boolean insertar(Categoria_instrumento cat){
        boolean res=false;
        String sql= "insert into categoria_instrumento values(?,?)";
        try {
            ArrayList<Parametro> lstPar= new ArrayList<>();
            lstPar.add(new Parametro(1,cat.getCodcat()));
            lstPar.add(new Parametro(2,cat.getDescripcion()));
            res= AccesoDatos.ejecutaComando1(sql, lstPar);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }        
        return res;
    }
    
     public static Categoria_instrumento obtener(int codigo){
        Categoria_instrumento cat=null;
        String sql= "select codcat, descripcion from categoria_instrumento where codcat=?";
        try {
             ArrayList<Parametro> lstPar= new ArrayList<>();
            lstPar.add(new Parametro(1,codigo));
            ConjuntoResultado cres= AccesoDatos.ejecutaQuery(sql,lstPar);           
            while(cres.next()){
                cat= new Categoria_instrumento();
                cat.setCodcat(cres.getInt(1));
                cat.setDescripcion(cres.getString(2));                
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return cat;
    }
}
