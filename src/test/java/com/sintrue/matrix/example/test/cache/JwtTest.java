package com.sintrue.matrix.example.test.cache;

import com.nimbusds.jwt.JWTClaimsSet;
import org.junit.jupiter.api.Test;
import wang.liangchen.matrix.framework.commons.encryption.KeyPairString;
import wang.liangchen.matrix.framework.commons.jwt.JwtUtil;

import java.util.Date;

/**
 * @author Liangchen.Wang 2022-07-16 10:50
 */
public class JwtTest {

    @Test
    public void jwtHmackTest() {
        String secretKey = JwtUtil.INSTANCE.generateKey(64);
        System.out.println("secretKey:" + secretKey);

        JWTClaimsSet claimsSet = new JWTClaimsSet.Builder()
                .subject("alice")
                .issuer("https://c2id.com")
                .expirationTime(new Date(new Date().getTime() + 60 * 1000))
                .build();

        String jwt = JwtUtil.INSTANCE.sign(secretKey, claimsSet);
        System.out.println("jwt:" + jwt);
        JWTClaimsSet verify = JwtUtil.INSTANCE.verify(secretKey, jwt);
        System.out.println("verify:" + verify);
    }

    @Test
    public void jwtRSATest() {
        JWTClaimsSet claimsSet = new JWTClaimsSet.Builder()
                .subject("alice")
                .issuer("https://c2id.com")
                .expirationTime(new Date(new Date().getTime() + 60 * 1000))
                .build();

        KeyPairString keyPairString = JwtUtil.INSTANCE.keyPair();
        String privateKey = keyPairString.getPrivateKeyString();
        System.out.println("privateKey:" + privateKey);
        String rsaSign = JwtUtil.INSTANCE.rsaSign(privateKey, claimsSet);
        System.out.println("rsaSign:" + rsaSign);
        String publicKey = keyPairString.getPublicKeyString();
        System.out.println("publicKey:" + publicKey);
        JWTClaimsSet rsaVerify = JwtUtil.INSTANCE.rsaVerify(publicKey, rsaSign);
        System.out.println("rsaVerify:" + rsaVerify);
    }


}
