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
 * @author Pulpin
 */

public class FChistes {
    public static List<Chistes>obtener()
    {
        ArrayList<Chistes>lst =new ArrayList<>();
        String sql= "select codigo_ch, codigo_u, titulo, descripcion ,codigo_c from chistes";
        try {
            ConjuntoResultado cres= AccesoDatos.ejecutaQuery(sql);
            Chistes ch;
            while(cres.next()){
                ch= new Chistes();
                ch.setCodigo_ch(cres.getInt(1));
                ch.setUsuario(FUsuario.obtener(cres.getInt(2)));
                ch.setTitulo(cres.getString(3));
                ch.setDescripcion(cres.getString(4));
                ch.setCategoria(FCategoria_chistes.obtener(cres.getInt(5)));
                lst.add(ch);
            }
        } catch (Exception e) {
            
            System.out.println(e.getMessage());
        }
        return lst;
    }
    public static boolean insertar(Chistes ch){
        boolean res=false;
        String sql= "insert into chistes values(?,?,?,?,?)";
        try {
            ArrayList<Parametro> lstPar= new ArrayList<>();
            lstPar.add(new Parametro(1,ch.getCodigo_ch()));
            lstPar.add(new Parametro(2,ch.getUsuario().getCodigo()));
            lstPar.add(new Parametro(3,ch.getTitulo()));
            lstPar.add(new Parametro(4,ch.getDescripcion()));
            lstPar.add(new Parametro(5,ch.getCategoria().getCodigo()));
            res= AccesoDatos.ejecutaComando1(sql, lstPar);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }        
        return res;
    }
     public static Chistes obtener(int codigo_ch){
        Chistes chistes=null;
        String sql= "select codigo_ch, codigo_u, titulo, descripcion, codigo_c from chistes where codigo_ch=?";
        try {
             ArrayList<Parametro> lstPar= new ArrayList<>();
            lstPar.add(new Parametro(1,codigo_ch));
            ConjuntoResultado cres= AccesoDatos.ejecutaQuery(sql,lstPar);           
            while(cres.next()){
                chistes= new Chistes();
                chistes.setCodigo_ch(cres.getInt(1));
                chistes.setUsuario(FUsuario.obtener(cres.getInt(2)));
                chistes.setTitulo(cres.getString(3));
                chistes.setDescripcion(cres.getString(4));
                chistes.setCategoria(FCategoria_chistes.obtener(cres.getInt(5)));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return chistes;
    }
     
   public static Chistes eliminar(int codigo)
    {
        Chistes chiste=null;
        String sql= "DELETE FROM chistes WHERE  codigo_ch=?";
        try {
             ArrayList<Parametro> lstPar= new ArrayList<>();
            lstPar.add(new Parametro(1,codigo)); 
            ConjuntoResultado cres= AccesoDatos.ejecutaQuery(sql,lstPar);           
            while(cres.next()){
                chiste= new Chistes();
                chiste.setCodigo_ch(cres.getInt(1));
                chiste.setUsuario(FUsuario.obtener(cres.getInt(2)));
                chiste.setTitulo(cres.getString(3));
                chiste.setDescripcion(cres.getString(4));
                chiste.setCategoria(FCategoria_chistes.obtener(cres.getInt(5)));
                 
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return chiste;
        
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
     
   public static boolean modificar(Chistes ch){
         boolean res=false;
        String sql= " UPDATE chistes SET  codigo_u=?, titulo=?, descripcion=?, codigo_c=? WHERE codigo_ch=? ";
        try {
             ArrayList<Parametro> lstPar= new ArrayList<>();
             
            lstPar.add(new Parametro(1,ch.getUsuario().getCodigo()));
            lstPar.add(new Parametro(2,ch.getTitulo()));
            lstPar.add(new Parametro(3,ch.getDescripcion()));
            lstPar.add(new Parametro(4,ch.getCategoria().getCodigo()));
            lstPar.add(new Parametro(5,ch.getCodigo_ch()));
            res=AccesoDatos.ejecutaComando(sql, lstPar);
            
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return res;
    }
}


     