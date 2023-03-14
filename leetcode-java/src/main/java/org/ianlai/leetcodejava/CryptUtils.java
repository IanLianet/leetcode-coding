package org.ianlai.leetcodejava;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import static java.nio.charset.StandardCharsets.UTF_8;
import static java.security.KeyFactory.getInstance;

/**
 * @author Bryan Wang
 * @date 2020/5/6-12:02
 * @Description
 */
public abstract class CryptUtils {

    /**
     * 私钥生产的解密器
     */
    public static Cipher newRsaDecrypt(String privateKey) throws IOException, NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, InvalidKeyException {
        //pkcs8私钥
        byte[] bytes = new BASE64Decoder().decodeBuffer(privateKey);
        RSAPrivateKey priKey = (RSAPrivateKey) getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(bytes));
        Cipher instance = Cipher.getInstance("RSA");
        instance.init(Cipher.DECRYPT_MODE, priKey);
        return instance;
    }

    /**
     * 公钥生成的解密器
     */
    public static Cipher newRsaEncrypt(String publicKey) throws IOException, NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, InvalidKeyException {
        //pkcs8私钥
        byte[] bytes = new BASE64Decoder().decodeBuffer(publicKey);
        RSAPublicKey priKey = (RSAPublicKey) getInstance("RSA").generatePublic(new X509EncodedKeySpec(bytes));
        Cipher instance = Cipher.getInstance("RSA");
        instance.init(Cipher.ENCRYPT_MODE, priKey);
        return instance;
    }

    /**
     * 使用私钥对已加密base64字符串解密
     */
    public static String rsaDecrypt(Cipher decryptCipher, String base64EncodedString) throws IOException, IllegalBlockSizeException, BadPaddingException {
        byte[] bytes = new BASE64Decoder().decodeBuffer(base64EncodedString);
        byte[] originBytes = decryptCipher.doFinal(bytes);
        return new String(originBytes, UTF_8);
    }

    /**
     * 使用公钥加密原始字符串，并使用base64进行编码
     */
    public static String rsaEncrypt(Cipher encryptCipher, String originString) throws IllegalBlockSizeException, BadPaddingException {
        byte[] bytes = originString.getBytes(UTF_8);
        byte[] encryptedBytes = encryptCipher.doFinal(bytes);
        return new BASE64Encoder().encode(encryptedBytes);
    }


}
