/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodosAux;

import RSMaterialComponent.RSTextFieldOne;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.KeyStroke;

/**
 *
 * @author Kevin
 */
public class Validaciones
{

    /**
     * Valida que una cadena cumpla con el formato de un correo electronico
     *
     * @param email
     * @return
     */
    public static boolean validaEmail(RSTextFieldOne email, JLabel error)
    {
        if (email.getText().matches("^([0-9a-zA-Z]+[-._+&])*[0-9a-zA-Z]+@([-0-9a-zA-Z]+[.])+[a-zA-Z]{2,6}$") || email.getText().isEmpty())
        {
            error.setText("Error en el campo");
            error.setForeground(SysConfigs.bg_white);
            return true;
        } else
        {
            error.setForeground(SysConfigs.bg_danger);
            error.setText("El correo es invalido");
        }
        return false;
    }

    /**
     * Valida que una cadena cumpla con el formato de un correo electronico
     *
     * @param curp
     * @return
     */
    public static boolean validaCurp(RSTextFieldOne curp, JLabel error)
    {
        if (curp.getText().matches("^[A-Z]{1}[AEIOU]{1}[A-Z]{2}[0-9]{2}(0[1-9]|1[0-2])(0[1-9]|1[0-9]|2[0-9]|3[0-1])[HM]{1}(AS|BC|BS|CC|CS|CH|CL|CM|DF|DG|GT|GR|HG|JC|MC|MN|MS|NT|NL|OC|PL|QT|QR|SP|SL|SR|TC|TS|TL|VZ|YN|ZS|NE)[B-DF-HJ-NP-TV-Z]{3}[0-9A-Z]{1}[0-9]{1}$") || curp.getText().isEmpty())
        {
            error.setText("Error en el campo");
            error.setForeground(SysConfigs.bg_white);
            return true;
        } else
        {
            error.setForeground(SysConfigs.bg_danger);
            error.setText("El CURP es invalido");
        }
        return false;
    }

    /**
     * Valida que una cadena solamente contenga numeros
     *
     * @param cadena
     * @return
     */
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
                if (!Character.isLetter(evt.getKeyChar()) && !Character.isWhitespace(evt.getKeyChar()))
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
            case 3:
                if (!Character.isDigit(evt.getKeyChar()) && (evt.getKeyCode() == KeyEvent.VK_SLASH))
                {
                    evt.consume();
                }
                break;
        }
    }

    /**
     * Método encargado de desactivar la opcion de copiar y pegar de un conjunto
     * de textfield
     *
     * @param txt arreglo de textfields a desactivar
     */
    public static void disableCP(RSTextFieldOne txt[])
    {
        for (RSTextFieldOne txt1 : txt)
        {
            txt1.getInputMap().put(KeyStroke.getKeyStroke("control C"), "none");
            txt1.getInputMap().put(KeyStroke.getKeyStroke("control V"), "none");
        }
    }

    public static boolean validarPass(RSTextFieldOne campo, JLabel error)
    {
        boolean ret = true;
        String resultado = "Muy Buena";    // Resultado de password valido

        int length = 0;                     // Almacenamos numero de caracteres en el pass
        int numCount = 0;                   // Variable usada para almacenar numeros en el password
        int capCount = 0;                   // Variable usada para almacenar mayusculas en el password
        int capSignos = 0;                  // Variable usada para almacenar los signos
        int Arroba = 0;                     // solo la arroba -.-!

        for (int x = 0; x < campo.getText().length(); x++)
        {
            if ((campo.getText().charAt(x) >= 47 && campo.getText().charAt(x) <= 58) //numeros
                    || (campo.getText().charAt(x) >= 64 && campo.getText().charAt(x) <= 91) //mayusculas
                    || (campo.getText().charAt(x) >= 63 && campo.getText().charAt(x) <= 65) //Arroba
                    || (campo.getText().charAt(x) >= 32 && campo.getText().charAt(x) <= 44) //signos
                    || (campo.getText().charAt(x) >= 97 && campo.getText().charAt(x) <= 122))
            {  //minusculas

            }
            if ((campo.getText().charAt(x) > 63 && campo.getText().charAt(x) < 65))
            { // Cuenta las arrobas
                Arroba++;

            }
            if ((campo.getText().charAt(x) > 32 && campo.getText().charAt(x) < 44))
            { // Cuenta la cantidad signos
                capSignos++;

            }
            if ((campo.getText().charAt(x) > 47 && campo.getText().charAt(x) < 58))
            { // Cuenta la cantidad de numero
                numCount++;

            }

            if ((campo.getText().charAt(x) > 64 && campo.getText().charAt(x) < 91))
            { // Cuenta la cantidad de mayuscula
                capCount++;
            }

            length = (x + 1); // Cuenta la longitud del password

        } // Final del bucle

        if (capSignos < 1)
        {                // Revisa la longitud minima de 8 caracteres del password
            resultado = ("no tiene caracteres especiales como ( ! # $ % & ' ( ) + - )");
            ret = false;
        }
        if (Arroba < 1)
        {                // Revisa la longitud minima de 8 caracteres del password
            resultado = ("Coloque un @ para mayor seguridad");
            ret = false;
        }
        if (numCount < 1)
        {              // Revisa que el password contenga minimo 1 numero
            resultado = ("Medio");
            ret = false;
        }

        if (capCount < 1)
        {                            // Revisa que el password contenga minimo 1 mayuscula
            resultado = ("Facil");
            ret = false;
        }

        if (length < 5)
        {                // Revisa la longitud minima de 8 caracteres del password
            resultado = ("Inutilizable: no cumple con el mínimo de caracteres!");
            ret = false;
        }

        error.setText(resultado);
        return ret;
    }

    public static boolean validarFecha(String entrada, JLabel error)
    {
        try
        {
            if (entrada.length() == 10)
            {
                DateFormat originalFormat = new SimpleDateFormat("yyyy/MM/d");
                DateFormat targetFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date d1 = originalFormat.parse(entrada);
                String d2 = targetFormat.format(d1);
                LocalDate fecha = LocalDate.parse(d2, DateTimeFormatter.ISO_LOCAL_DATE);
                System.out.println("Fecha correcta!!");
                System.out.println("Dia: " + fecha.getDayOfMonth());
                System.out.println("Mes: " + fecha.getMonthValue());
                System.out.println("Año: " + fecha.getYear());
                error.setForeground(SysConfigs.bg_white);
                if (MetodosAux.compararFechaActual(d2, error))
                {
                    return true;
                }
            }

        } catch (DateTimeParseException ex)
        {
            System.out.println("ERROR. No se pudo crear FECHA con esa entrada.");
        } catch (ParseException ex)
        {
            System.out.println("Error al parsear");
        }
        error.setForeground(SysConfigs.bg_danger);
        error.setText("Formato o fecha incorrecta");
        return false;
    }
}
