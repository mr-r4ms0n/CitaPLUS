/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodosBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import seguridad.Encoder;

/**
 *
 * @author Kevin
 */
public class MetodosBD
{
    private static Connection dbCon;
    private String sql = null;
    
    //Variable para usar consultas
    private static PreparedStatement sentencia;
    private static ResultSet resultado;

    /**
     * Metodo que retorna un arreglo de objetos con los valores que requerimos para ingresar al sistema
     * posteriormente se carga el usuario, nombre completo e imagen en el menu principal si es que se encontro
     * @param usr el usuario a buscar
     * @param pass la contraseña encriptada
     * @return objeto con 4 valores
     * [0] = true o false para saber si si existe el usuario y se le permite el acceso
     * [1] = nombre de usuario de la persona
     * [2] = nombre completo de la persona
     * [3] = foto de perfil de la persona
     */
    public static Object[] ingresoSys(String usr, String pass)
    {
        Object ret[] = new Object[4];
        try
        {
            dbCon = ConectaBD.ConectaBD();
            sentencia = dbCon.prepareStatement("SELECT * FROM usuarios WHERE usuario = BINARY ? AND contraseña = BINARY ?");
            sentencia.setString(1, usr);
            sentencia.setString(2, pass);
            resultado = sentencia.executeQuery();
            if (resultado.next())
            {
                if (resultado.getString("usuario").equals(usr) && resultado.getString("contraseña").equals(pass))
                {
                    ret[0] = true;
                    ret[1] = resultado.getString("usuario");
                    ret[2] = resultado.getString("nombre")+" "+resultado.getString("apellidoPaterno")+" "+resultado.getString("apellidoMaterno");
                    ret[3] = resultado.getString("foto");
                }
            }
        } catch (SQLException e)
        {
            System.out.println("Error de consulta en Inicio de sesion "+e);
        }
        return ret;
    }
    
}
