import java.security.*;
import java.io.*;
import java.math.BigInteger;

public class Hash
{
    public Hash(){
        
    }
    
    public String generateMD5(String input){
        try{
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger number = new BigInteger(1, messageDigest);
            String hash = number.toString(16);
            // adding missing zeros
            while(hash.length() < 32){
                hash = "0".concat(hash);
            }
            return hash;
        } catch(NoSuchAlgorithmException e){
            String message = "NoSuchAlgorithmException: " + e.getMessage();
            System.out.println(message);
            return message;
        }
    }
}
