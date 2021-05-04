/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seguridad;

/**
 *
 * @author Kevin
 */
public class NewMain
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
       EncoderA enc = new EncoderA();
       //Primero creamos al admin y su password, se hace un fichero encriptado con los valores
        //enc.getAES("Ramon","12345");
       //Posteriormente no se vuelve a tocar mas ya que ya esta guardado, al menos que se deseen modificar los valores lo cual se implementara despues
       //Cargamos a nuestro programa al usuario, la password y la secretkey
        //enc.makePr();
       //Mostramos para ver que nos despliega
        enc.desp();
       //Esto se usa para descifrar los valores que nos da el desp de arriba
        ///System.out.println(EncoderA.getAESDec("Fyk9IvQmvLIpocn4/gRQcQ=="));
        //System.out.println(EncoderA.getAESDec("yWWnRngEHeuaDVkJSNctWw=="));
        
        //En CitaPlus haremos esto por si a algun gustavito se le ocurre borrar el archivo que almacena los datos del admin , ya que al arrancar verifica que haya admin, de lo contrario
        //es como si nunca hubiese uno y solicita las nuevas credenciales de acceso, pero está la vulnerabilidad de que si el usuario borra el .dat y ejecuta de nuevo el programa este detectara
        //que no hay como tal admin y podra ingresar como juan por su casa a editar usuarios
        //enc.makePr();
        //Supongamos que borro el .dat, antes de cerrar el programa
        
    }
    
}
