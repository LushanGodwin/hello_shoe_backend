package lk.ijse.helloshoesbackend.util;

import java.util.Base64;
import java.util.UUID;

public class UtilMatters {
    public static String generateId(){
        return UUID.randomUUID().toString();
    }

    public static String convertToBase64(String data){
        return Base64.getEncoder().encodeToString(data.getBytes());
    }

    public static String productActivationCode(){return "H7G8K9L2M1N4P6Q3";}
}
