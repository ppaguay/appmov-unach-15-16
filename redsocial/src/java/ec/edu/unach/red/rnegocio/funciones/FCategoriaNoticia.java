/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.unach.red.rnegocio.funciones;
import ec.edu.unach.red.accesodatos.*;
import ec.edu.unach.red.rnegocio.clases.*;
import java.util.*;

/**
 *
 * @author USER
 */
public class FCategoriaNoticia {
   public static List<CategoriaNoticia> obtener(){
        ArrayList<CategoriaNoticia> lst= new ArrayList<>();
        String sql= "select codigo, descripcion from categoria_noticia";
        try {
            ConjuntoResultado cres= AccesoDatos.ejecutaQuery(sql);
            CategoriaNoticia cat;
            while(cres.next()){
                cat= new CategoriaNoticia();
                cat.setCodigo(cres.getInt(1));
                cat.setDescripcion(cres.getString(2));
                lst.add(cat);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lst;
    }
    public static boolean insertar(CategoriaNoticia cat){
        boolean res=false;
        String sql= "insert into categoria_noticia values(?,?)";
        try {
            ArrayList<Parametro> lstPar= new ArrayList<>();
            lstPar.add(new Parametro(1,cat.getCodigo()));
            lstPar.add(new Parametro(2,cat.getDescripcion()));
            res= AccesoDatos.ejecutaComando1(sql, lstPar);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }        
        return res;
    }
    
     public static CategoriaNoticia obtener(int codigo){
        CategoriaNoticia categoria=null;
        String sql= "select codigo, descripcion from categoria_noticia where codigo=?";
        try {
             ArrayList<Parametro> lstPar= new ArrayList<>();
            lstPar.add(new Parametro(1,codigo));
            ConjuntoResultado cres= AccesoDatos.ejecutaQuery(sql,lstPar);           
            while(cres.next()){
                categoria= new CategoriaNoticia();
                categoria.setCodigo(cres.getInt(1));
                categoria.setDescripcion(cres.getString(2));                
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return categoria;
    }
}
