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
public class FUsuario {
    public static List<Usuario>obtener()
    {
        ArrayList<Usuario>lst =new ArrayList<>();
        String sql= "select codigo,\"user\",password, email, genero from usuario";
        try {
            ConjuntoResultado cres= AccesoDatos.ejecutaQuery(sql);
            Usuario us;
            while(cres.next()){
                us= new Usuario();
                us.setCodigo(cres.getInt(1));
                us.setUser(cres.getString(2));
                us.setPassword(cres.getString(3));
                us.setEmail(cres.getString(4));
                us.setGenero(cres.getString(5));
                lst.add(us);
            }
        } catch (Exception e) {
            
            System.out.println(e.getMessage());
        }
        return lst;
    }
    
     public static boolean insertar(Usuario us){
        boolean res=false;
        String sql= "insert into usuario values(?,?,?,?,?)";
        try {
            ArrayList<Parametro> lstPar= new ArrayList<>();
            lstPar.add(new Parametro(1,us.getCodigo()));
            lstPar.add(new Parametro(2,us.getUser()));
            lstPar.add(new Parametro(3,us.getPassword()));
            lstPar.add(new Parametro(4,us.getEmail()));
            lstPar.add(new Parametro(5,us.getGenero()));
            res= AccesoDatos.ejecutaComando1(sql, lstPar);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }        
        return res;
    }
    
     public static Usuario obtener(int codigo){
        Usuario usuario=null;
        String sql= "select codigo,\"user\",password, email, genero from usuario where codigo=?";
        try {
             ArrayList<Parametro> lstPar= new ArrayList<>();
            lstPar.add(new Parametro(1,codigo));
            ConjuntoResultado cres= AccesoDatos.ejecutaQuery(sql,lstPar);           
            while(cres.next()){
                usuario= new Usuario();
                usuario.setCodigo(cres.getInt(1));
                usuario.setUser(cres.getString(2));
                usuario.setPassword(cres.getString(3));
                usuario.setEmail(cres.getString(4));
                usuario.setGenero((cres.getString(5)));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return usuario;
    }
     public static Usuario eliminar(int codigo)
    {
        Usuario usuario=null;
        String sql= "DELETE FROM usuario WHERE  codigo=?";
        try {
             ArrayList<Parametro> lstPar= new ArrayList<>();
            lstPar.add(new Parametro(1,codigo));
            AccesoDatos.ejecutaQuery(sql,lstPar);           
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return usuario;
        
    }
     
     public static Usuario modificar(int codigo,String user,String password,String email,String genero, int cod2)
     {
        Usuario usuario=null;
        String sql= "update usuario set codigo,\"user\", password, email, genero from usuario where codigo=?" ;
        try {
             ArrayList<Parametro> lstPar= new ArrayList<>();
            lstPar.add(new Parametro(1,codigo));
            lstPar.add(new Parametro(2,user));
            lstPar.add(new Parametro(3,password));
            lstPar.add(new Parametro(4,email));   
            lstPar.add(new Parametro(5,genero));
            lstPar.add(new Parametro(6,cod2));
            AccesoDatos.ejecutaQuery(sql,lstPar);            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return usuario;
    }
     
     public static boolean modif(Usuario us, int cod2){
        boolean res=false;
        String sql= "update usuario set codigo=?, \"user\"=?, password=?, email=?,genero=?  where codigo=?";
        try {
            ArrayList<Parametro> lstPar= new ArrayList<>();
             lstPar.add(new Parametro(1,us.getCodigo()));
            lstPar.add(new Parametro(2,us.getUser()));
            lstPar.add(new Parametro(3,us.getPassword()));
            lstPar.add(new Parametro(4,us.getEmail()));
            lstPar.add(new Parametro(5,us.getGenero()));
            lstPar.add(new Parametro(6,cod2));
            res= AccesoDatos.ejecutaComando1(sql, lstPar);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }        
        return res;
    }
}
