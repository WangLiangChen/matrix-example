package com.sintrue.matrix.example.test.cache;

import org.junit.jupiter.api.Test;
import wang.liangchen.matrix.framework.commons.encryption.DigestUtil;
import wang.liangchen.matrix.framework.commons.encryption.KeyPairString;
import wang.liangchen.matrix.framework.commons.encryption.SecretKeyUtil;
import wang.liangchen.matrix.framework.commons.encryption.SignatureUtil;
import wang.liangchen.matrix.framework.commons.encryption.enums.*;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.NoSuchAlgorithmException;

/**
 * @author Liangchen.Wang 2022-08-27 19:18
 */
public class CommonTest {
    @Test
    public void testHmac() {
        String key = "matrix";
        String data = "matrix_matrix";
        for (HmacAligorithm aligorithm : HmacAligorithm.values()) {
            String hmac = DigestUtil.INSTANCE.hmac(aligorithm, key, data);
            System.out.println(aligorithm + ":" + hmac);
        }
    }

    @Test
    public void testDigest() {
        String data = "matrix_matrix";
        for (DigestAlgorithm aligorithm : DigestAlgorithm.values()) {
            String hmac = DigestUtil.INSTANCE.digest(aligorithm, data);
            System.out.println(aligorithm + ":" + hmac);
        }
    }

    @Test
    public void testSign() {
        String data = "Hello,I am matrix";
        for (SignatureAlgorithm signatureAlgorithm : SignatureAlgorithm.values()) {
            System.out.println("签名算法:" + signatureAlgorithm);
            KeyPairString keyPairString = SecretKeyUtil.INSTANCE.keyPair(signatureAlgorithm.getKeyPairAlgorithm());
            String privateKey = keyPairString.getPrivateKey();
            System.out.println("privateKey:" + privateKey);
            String sign = SignatureUtil.INSTANCE.sign(signatureAlgorithm, privateKey, data);
            System.out.println("sign:" + sign);
            String publicKey = keyPairString.getPublicKey();
            System.out.println("publicKey:" + publicKey);
            boolean verify = SignatureUtil.INSTANCE.verify(signatureAlgorithm, publicKey, data, sign);
            System.out.println("verify:" + verify);
        }
    }

    @Test
    public void testKey() {
        for (int i = 6; i < 65; i++) {
            SecretKeyUtil.INSTANCE.generateKey("DESede",i,"fffff");
        }
    }

}
