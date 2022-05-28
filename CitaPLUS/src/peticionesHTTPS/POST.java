package peticionesHTTPS;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author leand
 */
public class POST
{
    /**
     * 
     * @param accion : agendar , cancelar , modificar
     * @param paciente
     * @param fecha
     * @param hora
     * @param servicio
     * @param correo 
     */

    public static void mEnviarCorreoCita(String accion,String paciente,String fecha, String hora,String servicio,String correo)
    {
        Unirest.setTimeouts(0, 0);
        HttpResponse<String> response;
        try
        {
            response = Unirest.post("https://apis.tecnologinc.com/citasPlus/api/FormEnviarCorreo/"+accion+"Cita.php")
                    .field("paciente", paciente)
                    .field("fecha", fecha)
                    .field("hora", hora)
                    .field("servicio", servicio)
                    .field("correo", correo)
                    .asString();
        } catch (UnirestException ex)
        {
            Logger.getLogger(POST.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
