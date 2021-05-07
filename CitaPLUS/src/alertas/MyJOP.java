/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alertas;

import javax.swing.JFrame;

/**
 *
 * @author Kevin
 */
public class MyJOP
{
    public static int opc = 0;
    public static int myJOPShowConfirmDialog(JFrame parent, String mensaje)
    {
        new Confirm(parent, true, mensaje).setVisible(true);
        return opc;
    }
    
    public static void myJOPShowMessageDialog(JFrame parent, String mensaje)
    {
        new Mensajes(parent, true, mensaje).setVisible(true);
    }
}
