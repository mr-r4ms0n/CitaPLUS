/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodosBD;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Kevin
 */
public class ConectaBD
{

    static Connection con = null;
    static String usuario = "root";
    static String pass = "r4ms0n";

    /**
     * Método que realiza la conexion a la base de datos
     *
     * @return Connection
     */
    public static Connection ConectaBD()
    {
        try
        {
            //Cargamos el driver de mysql
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/citaplus", usuario, pass);
            //JOptionPane.showMessageDialog(null, "Conectado");

        } catch (HeadlessException | ClassNotFoundException | SQLException e)
        {
            System.out.println("La contraseña de mysql no es vacio, se reintentara");
        } finally
        {
            //Por si la contraseña no es la mia es la de david
            if (con == null)
            {
                pass = "";
                try
                {
                    con = DriverManager.getConnection("jdbc:mysql://localhost/citaplus", usuario, pass);
                } catch (SQLException ex)
                {
                    Logger.getLogger(ConectaBD.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return con;
    }
}
