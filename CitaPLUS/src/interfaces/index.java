/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import metodosBD.MetodosBD;
import seguridad.EncoderA;

/**
 *
 * @author Kevin
 */
public class index
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        EncoderA.fixKeyLength();
        MetodosBD.cancelaCitasAuto();
        new InicioSesion().setVisible(true);
    }
    
}
