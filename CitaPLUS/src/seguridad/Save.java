/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seguridad;

import java.io.Serializable;
import java.util.ArrayList;
import metodosAux.RSObjectArray;

/**
 *
 * @author Kevin
 */
public class Save implements Serializable
{
    private RSObjectArray rs = new RSObjectArray();

    public RSObjectArray getRs()
    {
        return rs;
    }

    public void setRs(RSObjectArray rs)
    {
        this.rs = rs;
    }

    
}
