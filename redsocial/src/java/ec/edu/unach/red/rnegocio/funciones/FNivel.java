/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.unach.red.rnegocio.funciones;
import ec.edu.unach.red.rnegocio.clases.Nivel;
import ec.edu.unach.red.accesodatos.ConjuntoResultado;
import ec.edu.unach.red.accesodatos.Parametro;
import ec.edu.unach.red.accesodatos.AccesoDatos;
import java.util.*;
/**
 *
 * @author PAUL
 */
public class FNivel {
    public static List<Nivel> obtener(){
        ArrayList<Nivel> lst= new ArrayList();
        String sql= "select codigo, descripcion from nivel";
        try {
            ConjuntoResultado cres= AccesoDatos.ejecutaQuery(sql);
            Nivel niv;
            while(cres.next()){
                niv= new Nivel();
                niv.setCodigo(cres.getInt(1));
                niv.setDescripcion(cres.getString(2));
                lst.add(niv);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lst;
    }
    public static boolean insertar(Nivel niv){
        boolean res=false;
        String sql= "insert into nivel values(?,?)";
        try {
            ArrayList<Parametro> lstPar= new ArrayList();
            lstPar.add(new Parametro(1,niv.getCodigo()));
            lstPar.add(new Parametro(2,niv.getDescripcion()));
            res= AccesoDatos.ejecutaComando1(sql, lstPar);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }        
        return res;
    }
    
     public static Nivel obtener(int codigo){
        Nivel nivel=null;
        String sql= "select codigo, descripcion from nivel where codigo=?";
        try {
             ArrayList<Parametro> lstPar= new ArrayList();
            lstPar.add(new Parametro(1,codigo));
            ConjuntoResultado cres= AccesoDatos.ejecutaQuery(sql,lstPar);           
            while(cres.next()){
                nivel= new Nivel();
                nivel.setCodigo(cres.getInt(1));
                nivel.setDescripcion(cres.getString(2));                
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return nivel;
    }
    
    
}
