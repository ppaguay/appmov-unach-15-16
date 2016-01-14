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
 * @author Ivancito
 */
public class FReceta 
{
    public static List<Receta> obtener(){
        ArrayList<Receta> lst= new ArrayList<>();
        String sql= "select codreceta,nombre,detalle,usuario,categoria from receta";
        try {
            ConjuntoResultado cres= AccesoDatos.ejecutaQuery(sql);
            Receta rec;
            while(cres.next()){
                rec= new Receta();
                rec.setCodigo(cres.getInt(1));
                rec.setNombre(cres.getString(2));
                rec.setDetalle(cres.getString(3));
                rec.setUsuario(FUsuario.obtener(cres.getInt(4)));
                rec.setCategoria(FCategoriaReceta.obtener(cres.getInt(5)));
                
                
                lst.add(rec);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lst;
    }
    
    
    
    public static boolean insertar(Receta rec){
        boolean res=false;
        String sql= "insert into receta values(?,?,?,?,?)";
        try {
            ArrayList<Parametro> lstPar= new ArrayList<>();
            lstPar.add(new Parametro(1,rec.getCodigo()));
            lstPar.add(new Parametro(2,rec.getNombre()));
            lstPar.add(new Parametro(3,rec.getDetalle()));
            lstPar.add(new Parametro(4,rec.getUsuario().getCodigo()));
            lstPar.add(new Parametro(5,rec.getCategoria().getCodcat()));
            
            
            res= AccesoDatos.ejecutaComando1(sql, lstPar);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }        
        return res;
    }
     public static Receta obtener(int codigo){
        Receta receta=null;
        String sql= "select codreceta, nombre, detalle, usuario, categoria from receta where codreceta=?";
        try {
             ArrayList<Parametro> lstPar= new ArrayList<>();
            lstPar.add(new Parametro(1,codigo));
            ConjuntoResultado cres= AccesoDatos.ejecutaQuery(sql,lstPar);           
            while(cres.next()){
                receta= new Receta();
                receta.setCodigo(cres.getInt(1));  
                receta.setNombre(cres.getString(2));
                receta.setDetalle(cres.getString(3));
                receta.setUsuario(FUsuario.obtener(cres.getInt(4)));
                receta.setCategoria(FCategoriaReceta.obtener(cres.getInt(5)));
                 
                
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return receta;
    }
     
     public static Receta eliminar(int codigo)
    {
        Receta receta=null;
        String sql= "DELETE FROM receta WHERE  codreceta=?";
        try {
             ArrayList<Parametro> lstPar= new ArrayList<>();
            lstPar.add(new Parametro(1,codigo));
            AccesoDatos.ejecutaQuery(sql,lstPar);           
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return receta;
        
    }
     
          
//     public static boolean modif(Receta rec, int cod2){
//        boolean res=false;
//        String sql= "update receta set codigo=?,usuario=?,categoria=?,detalle=?,nombre=? where codigo=?";
//        try {
//            ArrayList<Parametro> lstPar= new ArrayList<>();
//            lstPar.add(new Parametro(1,rec.getCodigo()));            
//            lstPar.add(new Parametro(2,rec.getUsuario().getCodusuario()));
//            lstPar.add(new Parametro(3,rec.getCategoria().getCodcat()));
//            lstPar.add(new Parametro(4,rec.getDetalle()));
//            lstPar.add(new Parametro(5,rec.getNombre()));
//            lstPar.add(new Parametro(6,cod2));
//            res= AccesoDatos.ejecutaComando1(sql, lstPar);
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }        
//        return res;
//    }
     
     //modificar2
     
     public static boolean modificar(Receta rec){
        boolean res=false;
        String sql= "UPDATE receta SET codreceta=?, nombre=?,detalle=?, \"usuario\"=?, \"categoria\"=? WHERE codreceta="+rec.getCodigo();         
        try {
            ArrayList<Parametro> lstPar= new ArrayList();
            lstPar.add(new Parametro(1,rec.getCodigo()));
            lstPar.add(new Parametro(2,rec.getNombre()));
            lstPar.add(new Parametro(3,rec.getDetalle()));
            lstPar.add(new Parametro(4,rec.getUsuario().getCodigo()));
            lstPar.add(new Parametro(5,rec.getCategoria().getCodcat()));                                
            res= AccesoDatos.ejecutaComando1(sql, lstPar);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }        
        return res;
    }
}
