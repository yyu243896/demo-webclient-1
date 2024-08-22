package com.example.demo.utils;

import com.google.common.base.Charsets;
import com.google.common.hash.Hashing;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.AlgorithmParameters;
import java.util.Arrays;

public class AesCryptUtil {

    private final static Logger log = LoggerFactory.getLogger(AesCryptUtil.class);

    public static void main(String[] args) throws Exception {
        String key = "key...변경";


        String abcd = AesCryptUtil.encryptAES("abcd", key);
        System.out.println("enc: " + abcd);
        System.out.println("dec: " + AesCryptUtil.decryptAES(abcd, key));
        System.out.println("javascript 암호화한 문자열 복호화 값 ==> " +
                AesCryptUtil.decryptAES("9bd962506e4c9607571563459abbd347318871f1247fe05d1ae18a487b3f133f", key)
        );

        System.out.println(
                AesCryptUtil.decryptAES(abcd, key)
                        .equals(AesCryptUtil.decryptAES("9bd962506e4c9607571563459abbd347318871f1247fe05d1ae18a487b3f133f", key))
        );
    }


    public static String encryptAES(String data, String secretKey) {

        try {
            byte[] secretKeys = Arrays.copyOfRange(Hashing.sha1().hashString(secretKey, Charsets.UTF_8).asBytes(), 0, 16);
            SecretKey secret = new SecretKeySpec(secretKeys, "AES");

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secret);

            AlgorithmParameters params = cipher.getParameters();

            byte[] iv = params.getParameterSpec(IvParameterSpec.class).getIV();
            byte[] cipherText = cipher.doFinal(data.getBytes(Charsets.UTF_8));

            return DatatypeConverter.printHexBinary(iv) + DatatypeConverter.printHexBinary(cipherText);
        } catch (Exception e) {
            log.error("Exception  ;::", e);
            throw new RuntimeException(e);
        }
    }


    public static String decryptAES(String data, String secretKey) {

        try {
            byte[] secretKeys = Arrays.copyOfRange(Hashing.sha1().hashString(secretKey, Charsets.UTF_8).asBytes(), 0, 16);

            String hexedIv = data.substring(0, 32);

            String hexedCipherText = data.substring(32);

            byte[] iv = DatatypeConverter.parseHexBinary(hexedIv);
            byte[] cipherText = DatatypeConverter.parseHexBinary(hexedCipherText);

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");

            cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(secretKeys, "AES"), new IvParameterSpec(iv));

            return new String(cipher.doFinal(cipherText), Charsets.UTF_8);
        } catch (Exception e) {
            log.error("===== exception", e);
            throw new RuntimeException(e);
        }
    }
}
