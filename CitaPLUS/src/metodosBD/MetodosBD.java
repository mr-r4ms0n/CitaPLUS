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

    public static boolean ingresoSys(String usr, String pass)
    {
        try
        {
            dbCon = ConectaBD.ConectaBD();
            sentencia = dbCon.prepareStatement("SELECT * FROM usuarios WHERE usuario = BINARY ? AND contraseña = BINARY ?");
            sentencia.setString(1, usr);
            sentencia.setString(2, pass);
            resultado = sentencia.executeQuery();
            if (resultado.next())
            {
                return true;
            }
        } catch (SQLException e)
        {
            System.out.println("Error de consulta en Inicio de sesion "+e);
        }
        return false;
    }
    
    
    
}
