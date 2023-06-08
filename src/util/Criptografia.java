package util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Criptografia {
    public static String calcularHash(String senha) {
        try {
            // Crie uma instância do algoritmo de hash (por exemplo, MD5, SHA-256)
            MessageDigest md = MessageDigest.getInstance("SHA-256");

            // Converta a senha em um array de bytes
            byte[] bytes = senha.getBytes();

            // Calcule o hash dos bytes da senha
            byte[] hashBytes = md.digest(bytes);

            // Converta o hash em uma representação legível como String (hexadecimal)
            StringBuilder sb = new StringBuilder();
            for (byte b : hashBytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}
