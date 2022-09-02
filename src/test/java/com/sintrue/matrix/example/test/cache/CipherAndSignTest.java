package com.sintrue.matrix.example.test.cache;

import org.junit.jupiter.api.Test;
import wang.liangchen.matrix.framework.commons.encryption.*;
import wang.liangchen.matrix.framework.commons.encryption.enums.*;

/**
 * @author Liangchen.Wang 2022-08-27 19:18
 */
public class CipherAndSignTest {
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
        // AES 128, 192 or 256
        // DES 56
        // DESede 112 168
        for (CipherSymmetricAlgorithm algorithm : CipherSymmetricAlgorithm.values()) {
            System.out.println(algorithm);
            try {
                String hello = SecretKeyUtil.INSTANCE.keyGenerator(algorithm.getKeyAlgorithm(), 56, "hello");
                System.out.println(hello);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testCipher() {
        String key = "000000000000000000000000";
        String data = "matrix";
        for (CipherSymmetricAlgorithm algorithm : CipherSymmetricAlgorithm.values()) {
            System.out.println(algorithm);
            try {
                String encrypt = CipherUtil.INSTANCE.encrypt(algorithm, key, data);
                System.out.println("encrypt:" + encrypt);
                String decrypt = CipherUtil.INSTANCE.decrypt(algorithm, key, encrypt);
                System.out.println("decrypt:" + decrypt);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testCipherRSA() {
        String data = "matrix";
        for (CipherAsymmetricAlgorithm algorithm : CipherAsymmetricAlgorithm.values()) {
            System.out.println("签名算法:" + algorithm);
            KeyPairString keyPairString = SecretKeyUtil.INSTANCE.keyPair(algorithm.getKeyPairAlgorithm());
            String publicKey = keyPairString.getPublicKey();
            System.out.println("publicKey:" + publicKey);
            String encrypt = CipherUtil.INSTANCE.encrypt(algorithm, publicKey, data);
            System.out.println("encrypt:" + encrypt);
            String privateKey = keyPairString.getPrivateKey();
            System.out.println("privateKey:" + privateKey);
            String decrypt = CipherUtil.INSTANCE.decrypt(algorithm, privateKey, encrypt);
            System.out.println("decrypt:" + decrypt);
        }
    }

}
