package com.sintrue.example.commons.test;

import org.junit.jupiter.api.Test;
import wang.liangchen.matrix.framework.commons.encryption.*;
import wang.liangchen.matrix.framework.commons.encryption.enums.*;

/**
 * @author Liangchen.Wang 2023-05-06 17:44
 */
public class DigestAndCipherTest {

    @Test
    public void testDigest() {
        for (DigestAlgorithm algorithm : DigestAlgorithm.values()) {
            String data = "hello,I am liangchen.wang";
            String digest = DigestSignUtil.INSTANCE.digest(algorithm, data);
            System.out.println("algorithm: " + algorithm);
            System.out.println("digest: " + digest);
            System.out.println("==================================");
        }
    }

    @Test
    public void testHmac() {
        for (HmacAlgorithm algorithm : HmacAlgorithm.values()) {
            String secret = "salt!!";
            String data = "hello,I am liangchen.wang";
            String hmac = DigestSignUtil.INSTANCE.hmac(algorithm, secret, data);
            System.out.println("algorithm: " + algorithm);
            System.out.println("hmac: " + hmac);
            System.out.println("==================================");
        }
    }

    @Test
    public void testSignAndVerify() {
        for (SignatureAlgorithm algorithm : SignatureAlgorithm.values()) {
            String data = "hello,I am liangchen.wang";
            // 生成密钥
            KeyPairString keyPairString = SecretKeyUtil.INSTANCE.keyPair(algorithm.getKeyPairAlgorithm());
            String privateKey = keyPairString.getPrivateKeyString();
            String publicKey = keyPairString.getPublicKeyString();
            System.out.println("algorithm: " + algorithm);
            System.out.println("privateKey: " + privateKey);
            System.out.println("publicKey: " + publicKey);
            String sign = DigestSignUtil.INSTANCE.sign(algorithm, privateKey, data);
            System.out.println("sign: " + sign);
            boolean verify = DigestSignUtil.INSTANCE.verify(algorithm, publicKey, sign, data);
            System.out.println("verify: " + verify);
            System.out.println("==================================");
        }
    }

    @Test
    public void testSignAndVerifyHttpRequest() {
        SignatureClaim signatureClaim = SignatureClaim.instance4Sign("http://www.liangchen.wang", "{\"sex\":\"male\"}");
        for (SignatureAlgorithm algorithm : SignatureAlgorithm.values()) {
            // 生成密钥
            KeyPairString keyPairString = SecretKeyUtil.INSTANCE.keyPair(algorithm.getKeyPairAlgorithm());
            String privateKey = keyPairString.getPrivateKeyString();
            String publicKey = keyPairString.getPublicKeyString();
            System.out.println("algorithm: " + algorithm);
            System.out.println("privateKey: " + privateKey);
            String sign = signatureClaim.sign(algorithm, privateKey);
            System.out.println("sign: " + sign);
            boolean verify = signatureClaim.verify(publicKey);
            System.out.println("verify: " + verify);
            System.out.println("==================================");
        }
        for (HmacAlgorithm algorithm : HmacAlgorithm.values()) {
            System.out.println("algorithm: " + algorithm);
            String secret = "salt!!!!";
            String sign = signatureClaim.sign(algorithm, secret);
            System.out.println("sign: " + sign);
            boolean verify = signatureClaim.verify(secret);
            System.out.println("verify: " + verify);
            System.out.println("==================================");
        }
    }

    @Test
    public void testCipher() {
        String data = "hello,I am liangchen.wang";
        for (CipherAsymmetricAlgorithm algorithm : CipherAsymmetricAlgorithm.values()) {
            // 生成密钥
            KeyPairString keyPairString = SecretKeyUtil.INSTANCE.keyPair(algorithm.getKeyPairAlgorithm());
            String privateKey = keyPairString.getPrivateKeyString();
            String publicKey = keyPairString.getPublicKeyString();
            System.out.println("algorithm: " + algorithm);
            System.out.println("privateKey: " + privateKey);
            System.out.println("publicKey: " + publicKey);
            String encrypt = CipherUtil.INSTANCE.encrypt(algorithm, publicKey, data);
            System.out.println("encrypt: " + encrypt);
            String decrypt = CipherUtil.INSTANCE.decrypt(algorithm, privateKey, encrypt);
            System.out.println("decrypt: " + decrypt);
            System.out.println("==================================");
        }
        for (CipherSymmetricAlgorithm algorithm : CipherSymmetricAlgorithm.values()) {
            String secret = SecretKeyUtil.INSTANCE.keyGenerator(algorithm.getKeyAlgorithm(), 128, "salt!!");
            System.out.println("algorithm: " + algorithm);
            System.out.println("secret: " + secret);
            String encrypt = CipherUtil.INSTANCE.encrypt(algorithm, secret, data);
            System.out.println("encrypt: " + encrypt);
            String decrypt = CipherUtil.INSTANCE.decrypt(algorithm, secret, encrypt);
            System.out.println("decrypt: " + decrypt);
            System.out.println("==================================");
        }
    }

    @Test
    public void testLuhn() {
        String generate = LuhnUtil.INSTANCE.generate("15903199088", 2);
        System.out.println("number and checkbit:" + generate);
        boolean validate = LuhnUtil.INSTANCE.validate(generate, 2);
        System.out.println("validate:" + validate);
    }
}
