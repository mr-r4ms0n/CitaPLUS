/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seguridad;

import RSMaterialComponent.RSPasswordIconOne;
import RSMaterialComponent.RSPasswordMaterialIcon;
import RSMaterialComponent.RSTextFieldMaterialIcon;
import RSMaterialComponent.RSTextFieldOne;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author Kevin
 */
public class EncoderA
{

    //Encriptacion por SHA-256
    private static final String KEY_STORE_FILE = "props.dat"; //nombre del archivo
    private static final String key = "08wR?!5!S6_WO&-v$f#0RUdrEfRoc1Th";
    private static final String salt = "huw1zO@a*&t8tr83e$16hiy#k+v1!0cr";
    private static SecretKey secretKeyTemp;

    private static Save s = new Save();

    private static boolean getAES(String data, String data2)
    {
        SecretKeyFactory secretKeyFactory;
        KeySpec keySpec;
        try
        {
            secretKeyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512");
            keySpec = new PBEKeySpec(key.toCharArray(), salt.getBytes(), 65536, 256);
            secretKeyTemp = secretKeyFactory.generateSecret(keySpec);
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e)
        {
            e.printStackTrace();
        }

        byte[] iv = new byte[16];
        String er;
        try
        {
            IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);
            SecretKeySpec secretKey = new SecretKeySpec(secretKeyTemp.getEncoded(), "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivParameterSpec);
            s.getRs().add("1", Base64.getEncoder().encodeToString(cipher.doFinal(data.getBytes("UTF-8"))));
            s.getRs().add("2", Base64.getEncoder().encodeToString(cipher.doFinal(data2.getBytes("UTF-8"))));
            s.getRs().add("sk", secretKeyTemp);
            makePr();
            return true;
        } catch (UnsupportedEncodingException | InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e)
        {
            e.printStackTrace();
        }
        return false;
    }

    private static String getAESDec(String data)
    {
        byte[] iv = new byte[16];
        try
        {
            IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);
            SecretKeySpec secretKey = new SecretKeySpec(secretKeyTemp.getEncoded(), "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, secretKey, ivParameterSpec);
            return new String(cipher.doFinal(Base64.getDecoder().decode(data)));
        } catch (InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    private static void makePr()
    {
        File f = new File(KEY_STORE_FILE);
        if (!f.exists())
        {
            try
            {
                ObjectOutputStream escribiendoFichero = new ObjectOutputStream(
                        new FileOutputStream(KEY_STORE_FILE));
                escribiendoFichero.writeObject(s);
                escribiendoFichero.close();
                hide(f);
            } catch (IOException ex)
            {
                Logger.getLogger(EncoderA.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else
        {
            try
            {
                ObjectInputStream leyendoFichero = null;
                leyendoFichero = new ObjectInputStream(
                        new FileInputStream("props.dat"));
                s = (Save) leyendoFichero.readObject();
                secretKeyTemp = (SecretKey) s.getRs().getValue("sk");
                leyendoFichero.close();

            } catch (IOException ex)
            {
                Logger.getLogger(EncoderA.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex)
            {
                Logger.getLogger(EncoderA.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * Método encargado de desplegar los valores del admin este método se
     * mantendra durante la fase de desarrollo nadamas.
     */
    public void desp()
    {
        System.out.println(s.getRs().getValue("1").toString());
        System.out.println(s.getRs().getValue("2").toString());
    }

    /**
     * Método que oculta un fichero y solo es accesible a el por esta clase.
     *
     * @param src
     */
    private static void hide(File src)
    {
        try
        {
            // win32 command line variant 
            Process p = Runtime.getRuntime().exec("attrib +h " + src.getPath());
            p.waitFor(); // p.waitFor() important, so that the file really appears as hidden immediately after function exit. 
        } catch (IOException | InterruptedException e)
        {
            System.out.println("Error al ocular fichero: " + e);
        }
    }

    /**
     * Método que verifica que el admin introduzca las credenciales correctas
     *
     * @param s1
     * @param s2
     * @return
     */
    public static boolean verificaAdm(String s1, String s2)
    {
        makePr();
        return ((s1.equals(getAESDec(s.getRs().getValue("1").toString()))) && (s2.equals(getAESDec(s.getRs().getValue("2").toString()))));
    }

    public static boolean creaAdm(String s1, String s2)
    {
        return getAES(s1, s2);
    }

    public static void recuperaCred(RSTextFieldMaterialIcon usuario, RSPasswordMaterialIcon contra)
    {
        usuario.setText(getAESDec(s.getRs().getValue("1").toString()));
        contra.setText(getAESDec(s.getRs().getValue("2").toString()));
    }
    
    public static String recuperaCred(String n)
    {
        return getAESDec(s.getRs().getValue(n).toString());
    }
    
    public static void reasignaCred(String usuario, String pass)
    {
        File f = new File(KEY_STORE_FILE);
        if (f.delete())
        {
            getAES(usuario, pass);
        }else
        {
            System.out.println("Error al reasignar credenciales");
        }
        
    }
}
