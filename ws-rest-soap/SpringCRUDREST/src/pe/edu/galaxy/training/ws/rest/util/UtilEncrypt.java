package pe.edu.galaxy.training.ws.rest.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import org.apache.commons.codec.binary.Base64;

public class UtilEncrypt
{
	private static char[] psw;
    private static final byte[] SALT = {
        (byte) 0xde, (byte) 0x33, (byte) 0x10, (byte) 0x12,
        (byte) 0xde, (byte) 0x33, (byte) 0x10, (byte) 0x12,
    };
    
    public static void init(String str){
    	psw=str.toCharArray();
    }
    
    private static String base64Encode(byte[] bytes) {
    	Base64 ed=new Base64();
		String encoded=new String(ed.encode(bytes));
        return encoded;
    }

    private static byte[] base64Decode(String property) throws IOException {
        return new Base64().decode(property);
    }
    
    public static String encrypt(String property) 
    		throws GeneralSecurityException, UnsupportedEncodingException {
        
    	SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("PBEWithMD5AndDES");
        
    	SecretKey key = keyFactory.generateSecret(new PBEKeySpec(psw));
        
    	Cipher pbeCipher = Cipher.getInstance("PBEWithMD5AndDES");
        
    	pbeCipher.init(Cipher.ENCRYPT_MODE, key, new PBEParameterSpec(SALT, 20));
        
    	return base64Encode(pbeCipher.doFinal(property.getBytes("UTF-8")));
    }

    public static String decrypt(String property) throws GeneralSecurityException, IOException {
        
    	SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("PBEWithMD5AndDES");
        
    	SecretKey key = keyFactory.generateSecret(new PBEKeySpec(psw));
        
    	Cipher pbeCipher = Cipher.getInstance("PBEWithMD5AndDES");
        
    	pbeCipher.init(Cipher.DECRYPT_MODE, key, new PBEParameterSpec(SALT, 20));
        
    	return new String(pbeCipher.doFinal(base64Decode(property)), "UTF-8");
    }
    
}
