/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodosAux;

import RSMaterialComponent.RSTextFieldOne;
import java.awt.Component;
import java.awt.Event;
import java.awt.TextField;
import java.awt.event.KeyEvent;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

/**
 *
 * @author Kevin
 */
public class Validaciones
{

    public static boolean validaEmail(String email)
    {
        if (email.matches("\"[-\\\\w\\\\.]+@\\\\w+\\\\.\\\\w+\""))
        {
            return true;
        }
        return false;
    }

    public static boolean validaNumericos(String cadena)
    {
        if (cadena.matches("[+-]?\\\\d*(\\\\.\\\\d+)?"))
        {
            return true;
        }
        return false;
    }

    /*
    public static boolean validaLetras(String cadena)
    {

    }*/
    /**
     * Método que deshabilita el evento evt para que no se puedan ingresar
     * letras o numeros
     *
     * @param evt evento del teclado
     * @param type tipo de entrada, 1 = letras, 2 = numeros
     */
    public static void entradaLetrasNum(KeyEvent evt, int type)
    {
        switch (type)
        {
            case 1:
                if (!Character.isLetter(evt.getKeyChar()))
                {
                    evt.consume();
                }
                break;
            case 2:
                if (!Character.isDigit(evt.getKeyChar()))
                {
                    evt.consume();
                }
                break;
        }
    }

    public static void disableCP(RSTextFieldOne txt[])
    {
        for (RSTextFieldOne txt1 : txt)
        {
            txt1.getInputMap().put(KeyStroke.getKeyStroke("control C"), "none");
            txt1.getInputMap().put(KeyStroke.getKeyStroke("control V"), "none");
        }
        
    }

}
