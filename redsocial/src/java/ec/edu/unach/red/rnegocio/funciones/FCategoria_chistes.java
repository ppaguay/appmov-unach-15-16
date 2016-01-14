/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.unach.red.rnegocio.funciones;
import ec.edu.unach.red.accesodatos.AccesoDatos;
import ec.edu.unach.red.accesodatos.*;
import ec.edu.unach.red.rnegocio.clases.*;
import java.util.*;

/**
 *
 * @author user
 */
public class FCategoria_chistes {
    public static List<Categoria_chistes> obtener(){
        ArrayList<Categoria_chistes> lst= new ArrayList<>();
        String sql= "select codigo, tipo from categoria_chistes";
        try {
            ConjuntoResultado cres= AccesoDatos.ejecutaQuery(sql);
            Categoria_chistes c;
            while(cres.next()){
                c= new Categoria_chistes();
                c.setCodigo(cres.getInt(1));
                c.setTipo(cres.getString(2));
                lst.add(c);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lst;
    }
    public static boolean insertar(Categoria_chistes c){
        boolean res=false;
        String sql= "insert into categoria_chistes values(?,?)";
        try {
            ArrayList<Parametro> lstPar= new ArrayList<>();
            lstPar.add(new Parametro(1,c.getCodigo()));
            lstPar.add(new Parametro(2,c.getTipo()));
            res= AccesoDatos.ejecutaComando1(sql, lstPar);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }        
        return res;
    }
    
     public static Categoria_chistes obtener(int codigo_c){
        Categoria_chistes categoria=null;
        String sql= "select codigo, tipo from categoria_chistes where codigo=?";
        try {
             ArrayList<Parametro> lstPar= new ArrayList<>();
            lstPar.add(new Parametro(1,codigo_c));
            ConjuntoResultado cres= AccesoDatos.ejecutaQuery(sql,lstPar);           
            while(cres.next()){
                categoria= new Categoria_chistes();
                categoria.setCodigo(cres.getInt(1));
                categoria.setTipo(cres.getString(2));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return categoria;
    }
}
