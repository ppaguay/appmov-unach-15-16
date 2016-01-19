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
 * @author COMPUTER
 */
public class FCategoriaJuego {
    public static List<CategoriaJuego> obtener(){
        ArrayList<CategoriaJuego> lst= new ArrayList<>();
        String sql= "select codigo, descripcion from categoria_juego";
        try {
            ConjuntoResultado cres= AccesoDatos.ejecutaQuery(sql);
            CategoriaJuego cat;
            while(cres.next()){
                cat= new CategoriaJuego();
                cat.setCodigo(cres.getInt(1));
                cat.setDescripcion(cres.getString(2));
                lst.add(cat);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lst;
    }
    public static boolean insertar(CategoriaJuego cat){
        boolean res=false;
        String sql= "insert into categoria_juego values(?,?)";
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
    
     public static CategoriaJuego obtener(int codigo){
        CategoriaJuego categoria=null;
        String sql= "select codigo, descripcion from categoria_juego where codigo=?";
        try {
             ArrayList<Parametro> lstPar= new ArrayList<>();
            lstPar.add(new Parametro(1,codigo));
            ConjuntoResultado cres= AccesoDatos.ejecutaQuery(sql,lstPar);           
            while(cres.next()){
                categoria= new CategoriaJuego();
                categoria.setCodigo(cres.getInt(1));
                categoria.setDescripcion(cres.getString(2));                
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return categoria;
    }
}
