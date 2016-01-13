/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.unach.red.rnegocio.funciones;
import ec.edu.unach.red.rnegocio.clases.Estudiante;
import ec.edu.unach.red.accesodatos.ConjuntoResultado;
import ec.edu.unach.red.accesodatos.Parametro;
import ec.edu.unach.red.accesodatos.AccesoDatos;
import java.util.*;
/**
 *
 * @author PAUL
 */
public class FEstudiante {
    public static List<Estudiante> obtener(){
        ArrayList<Estudiante> lst= new ArrayList<Estudiante>();
        String sql= "select codigo, nombre, cod_nivel from estudiante";
        try {
            ConjuntoResultado cres= AccesoDatos.ejecutaQuery(sql);
            Estudiante est;
            while(cres.next()){
                est= new Estudiante();
                est.setCodigo(cres.getInt(1));
                est.setNombre(cres.getString(2));
                est.setNivel(FNivel.obtener(cres.getInt(3)));
                lst.add(est);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lst;
    }
    public static boolean insertar(Estudiante est){
        boolean res=false;
        String sql= "insert into estudiante values(?,?,?)";
        try {
            ArrayList<Parametro> lstPar= new ArrayList();
            lstPar.add(new Parametro(1,est.getCodigo()));
            lstPar.add(new Parametro(2,est.getNombre()));
            lstPar.add(new Parametro(3,est.getNivel().getCodigo()));
            res= AccesoDatos.ejecutaComando1(sql, lstPar);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }        
        return res;
    }
}
