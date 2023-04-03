package br.edu.ifsp.dmos5.view.MD5;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Criptografia {

    public static String criptografarSenha(String senha) {
        try {
            // Cria uma instância do algoritmo de criptografia MD5
            MessageDigest md = MessageDigest.getInstance("MD5");

            // Converte a senha em bytes e aplica a criptografia
            byte[] bytesCriptografados = md.digest(senha.getBytes());

            // Converte o resultado da criptografia em uma string hexadecimal
            StringBuilder sb = new StringBuilder();
            for (byte b : bytesCriptografados) {
                sb.append(String.format("%02x", b));
            }

            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            // Caso o algoritmo não seja suportado pela plataforma
            throw new RuntimeException("Erro ao criptografar senha", e);
        }
    }
}
