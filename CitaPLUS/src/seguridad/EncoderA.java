/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seguridad;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.KeyStore;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import org.apache.commons.codec.binary.Base64;

/**
 *
 * @author Kevin
 */
public class EncoderA
{

    private static final String KEY_STORE_FILE = "propk.r4m"; //nombre del archivo
    private static final String FILE_PASSWORD = "filePassword"; //password del archivo
    private static final String KEY = "key"; //llave del entry a ingresar
    //private static final String KEY_PASSWORD = "keyPassword"; //password del entry a ingresar
    private static final String ALGORITHM = "AES"; //password del entry a ingresar
    private static final Integer KEY_SIZE = 128; // 64, 128, 256

    private static KeyStore createKeyStore(String fileName, String pw) throws Exception
    {
        File file = new File(fileName);

        final KeyStore keyStore = KeyStore.getInstance("JCEKS");
        if (file.exists())
        {
            // .keystore file already exists => load it
            keyStore.load(new FileInputStream(file), pw.toCharArray());
        } else
        {
            // .keystore file not created yet => create it
            keyStore.load(null, null);
            keyStore.store(new FileOutputStream(fileName), pw.toCharArray());
        }

        return keyStore;
    }

    public static void EncK(String key) throws Exception
    {
        KeyStore keyStore = createKeyStore(KEY_STORE_FILE, FILE_PASSWORD);

        // generate a secret key for AES encryption
        KeyGenerator keyGen = KeyGenerator.getInstance(ALGORITHM);
        keyGen.init(KEY_SIZE); // for example
        SecretKey secretKey = keyGen.generateKey();
        System.out.println("Stored Key: " + secretKey);

        // store the secret key
        KeyStore.SecretKeyEntry keyStoreEntry = new KeyStore.SecretKeyEntry(secretKey);
        KeyStore.PasswordProtection keyPassword = new KeyStore.PasswordProtection(key.toCharArray());
        keyStore.setEntry(KEY, keyStoreEntry, keyPassword);
        keyStore.store(new FileOutputStream(KEY_STORE_FILE), FILE_PASSWORD.toCharArray());

        // retrieve the stored key back
        KeyStore.Entry entry = keyStore.getEntry(KEY, keyPassword);
        SecretKey keyFound = ((KeyStore.SecretKeyEntry) entry).getSecretKey();
        System.out.println("Found Key: " + keyFound.toString());
        System.out.println(new Base64().encodeToString(keyFound.getEncoded()));
    }

}
