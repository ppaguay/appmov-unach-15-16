/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.unach.red.rnegocio.funciones;
import ec.edu.unach.red.accesodatos.*;
import java.util.*;
import ec.edu.unach.red.rnegocio.clases.*;
/**
 *
 * @author Ivancito
 */
public class FUsuario 
{
    public static List<Usuario> obtener(){
        ArrayList<Usuario> lst= new ArrayList<>();
        String sql= "select codigo, nombre, email, clave, nick, genero from usuario";
        try {
            ConjuntoResultado cres= AccesoDatos.ejecutaQuery(sql);
            Usuario usu;
            while(cres.next()){
                usu= new Usuario();
                usu.setCodigo(cres.getInt(1));
                usu.setNombre(cres.getString(2));
                usu.setEmail(cres.getString(3));
                usu.setClave(cres.getString(4));
                usu.setNick(cres.getString(5));
                usu.setGenero(cres.getString(6));
                lst.add(usu);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lst;
    }
    public static boolean insertar(Usuario usu){
        boolean res=false;
        String sql= "insert into usuario values(?,?,?,?,?,?)";
        try {
            ArrayList<Parametro> lstPar= new ArrayList<>();
            lstPar.add(new Parametro(1,usu.getCodigo()));
            lstPar.add(new Parametro(2,usu.getNombre()));
            lstPar.add(new Parametro(3,usu.getEmail()));
            lstPar.add(new Parametro(4,usu.getClave()));
            lstPar.add(new Parametro(5,usu.getNick()));
            lstPar.add(new Parametro(6,usu.getGenero()));
            res= AccesoDatos.ejecutaComando1(sql, lstPar);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }        
        return res;
    }
    
     public static Usuario obtener(int codigo){
        Usuario usuario=null;
        String sql= "select codigo, nombre, email, clave, nick, genero from usuario where codigo=?";
        try {
             ArrayList<Parametro> lstPar= new ArrayList<>();
            lstPar.add(new Parametro(1,codigo));
            ConjuntoResultado cres= AccesoDatos.ejecutaQuery(sql,lstPar);           
            while(cres.next()){
                usuario= new Usuario();
                usuario.setCodigo(cres.getInt(1));
                usuario.setNombre(cres.getString(2));  
                usuario.setEmail(cres.getString(3));
                usuario.setClave(cres.getString(4));  
                usuario.setNick(cres.getString(5));
                usuario.setGenero(cres.getString(6));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return usuario;
    }
}
