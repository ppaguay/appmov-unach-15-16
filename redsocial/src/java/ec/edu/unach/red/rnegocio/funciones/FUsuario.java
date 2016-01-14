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
 * @author Marlon
 */
public class FUsuario {
    public static List<Usuario> obtener(){
        ArrayList<Usuario> lsta=new ArrayList<Usuario>();
        String sql="SELECT codigo, nombres, email, clave, nick, genero FROM usuario";        
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql);
            Usuario user;
        while(cres.next()){
            user=new Usuario();
            user.setCodigo(cres.getInt(1));
            user.setNombres(cres.getString(2));
            user.setEmail(cres.getString(3));
            user.setClave(cres.getString(4));
            user.setNick(cres.getString(5));
            user.setGenero(cres.getString(6));
            lsta.add(user);
        }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }         
    return lsta;
    }
    
    public static Usuario obtener(int codigo){
        Usuario usuario=null;
        String sql="SELECT codigo, nombres, email, clave, nick, genero FROM usuario WHERE codigo=?";                           
        try {
            ArrayList<Parametro> lstPar= new ArrayList<>();
            lstPar.add(new Parametro(1,codigo));  
            ConjuntoResultado cres=AccesoDatos.ejecutaQuery(sql,lstPar);
            while(cres.next()){
            usuario=new Usuario();
            usuario.setCodigo(cres.getInt(1));
            usuario.setNombres(cres.getString(2));
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
    
    public static boolean insertar(Usuario user){
        boolean res=false;
        String sql= "INSERT INTO usuario(codigo, nombres, email, clave, nick, genero) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            ArrayList<Parametro> lstPar= new ArrayList();
            lstPar.add(new Parametro(1,user.getCodigo()));
            lstPar.add(new Parametro(2,user.getNombres()));
            lstPar.add(new Parametro(3,user.getEmail()));
            lstPar.add(new Parametro(4,user.getClave()));   
            lstPar.add(new Parametro(5,user.getNick()));
            lstPar.add(new Parametro(6,user.getGenero()));
            res= AccesoDatos.ejecutaComando1(sql, lstPar);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }        
        return res;
    }
    
    public static boolean actualizar(Usuario user){
        boolean res=false;
        String sql= "UPDATE usuario SET codigo=?, nombres=?, email=?, clave=?, nick=?, genero=? WHERE codigo="+user.getCodigo();         
        try {
            ArrayList<Parametro> lstPar= new ArrayList();
            lstPar.add(new Parametro(1,user.getCodigo()));
            lstPar.add(new Parametro(2,user.getNombres()));
            lstPar.add(new Parametro(3,user.getEmail()));
            lstPar.add(new Parametro(4,user.getClave()));   
            lstPar.add(new Parametro(5,user.getNick()));
            lstPar.add(new Parametro(6,user.getGenero()));
            res= AccesoDatos.ejecutaComando1(sql, lstPar);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }        
        return res;
    }
}
