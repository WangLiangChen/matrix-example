package com.sintrue.matrix.example.test.cache;

import org.junit.jupiter.api.Test;
import org.springframework.util.AntPathMatcher;
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
        for (HmacAlgorithm aligorithm : HmacAlgorithm.values()) {
            String hmac = DigestSignUtil.INSTANCE.hmac(aligorithm, key, data);
            System.out.println(aligorithm + ":" + hmac);
        }
    }

    @Test
    public void testDigest() {
        String data = "matrix_matrix";
        for (DigestAlgorithm aligorithm : DigestAlgorithm.values()) {
            String hmac = DigestSignUtil.INSTANCE.digest(aligorithm, data);
            System.out.println(aligorithm + ":" + hmac);
        }
    }

    @Test
    public void testSign() {
        String data = "Hello,I am matrix";
        for (SignatureAlgorithm signatureAlgorithm : SignatureAlgorithm.values()) {
            System.out.println("签名算法:" + signatureAlgorithm);
            // 生成密钥对
            KeyPairString keyPairString = SecretKeyUtil.INSTANCE.keyPair(signatureAlgorithm.getKeyPairAlgorithm());
            String privateKey = keyPairString.getPrivateKeyString();
            System.out.println("privateKey:" + privateKey);
            String sign = DigestSignUtil.INSTANCE.sign(signatureAlgorithm, privateKey, data);
            System.out.println("sign:" + sign);

            String publicKey = keyPairString.getPublicKeyString();
            System.out.println("publicKey:" + publicKey);
            boolean verify = DigestSignUtil.INSTANCE.verify(signatureAlgorithm, publicKey, sign,data);
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
            String publicKey = keyPairString.getPublicKeyString();
            System.out.println("publicKey:" + publicKey);
            String encrypt = CipherUtil.INSTANCE.encrypt(algorithm, publicKey, data);
            System.out.println("encrypt:" + encrypt);
            String privateKey = keyPairString.getPrivateKeyString();
            System.out.println("privateKey:" + privateKey);
            String decrypt = CipherUtil.INSTANCE.decrypt(algorithm, privateKey, encrypt);
            System.out.println("decrypt:" + decrypt);
        }
    }

    @Test
    public void testBuildSign() {
        String uri = "http://api.open.com/staff/111222";
        String body = "{\"name\":\"wanglc\"}";

        String hmacKey = "jkfdljsakfdjkjgd";

        SignatureClaim signatureClaim = SignatureClaim.instance4Sign(uri, body);
        System.out.println("-payload:");
        System.out.println(signatureClaim.getPayload());

        String signString = signatureClaim.sign(HmacAlgorithm.HmacSHA256, hmacKey);
        System.out.println("-signString:");
        System.out.println(signString);

        System.out.println("===================verify=============");
        signatureClaim = SignatureClaim.instance4Verify(uri, body, signString);
        System.out.println("-payload:");
        System.out.println(signatureClaim.getPayload());
        System.out.println("-algorithm:");
        System.out.println(signatureClaim.getAlgorithm());
        System.out.println("-signature:");
        System.out.println(signatureClaim.getSignature());

        System.out.println("-verify:");
        System.out.println(signatureClaim.verify(hmacKey));
    }
    @Test
    public void testAntPath(){
        AntPathMatcher antPathMatcher = new AntPathMatcher();
        boolean match = antPathMatcher.match("/tenant/{id}", "/tenant/88888");
        System.out.println(match);
    }

}
