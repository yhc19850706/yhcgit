package com.yhc.weixin.util;


import org.apache.commons.codec.binary.Base64;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.util.text.TextEncryptor;


/**
 * <p>
 * This class is <i>thread-safe</i>.
 * </p>
 */
public final class Encryptor implements TextEncryptor {


    private final StandardPBEStringEncryptor encryptor;
    
    public Encryptor() {
        super();
        this.encryptor = new StandardPBEStringEncryptor();
        this.encryptor.setAlgorithm("PBEWithMD5AndDES");
    }
    
    public void setPassword(final String password) {
        this.encryptor.setPassword(password);
    }

    public String encrypt(final String message) {
        return this.encryptor.encrypt(message);
    }
    
    public String encryptAndBase64(final String message) {
        String encryptMessage = this.encryptor.encrypt(message);
        return new String(Base64.encodeBase64(encryptMessage.getBytes()));
    }

    public String decrypt(final String encryptedMessage) {
        return this.encryptor.decrypt(encryptedMessage);
    }
    
    public String decryptWithBase64(final String message) {
    	String base64Text = new String(Base64.decodeBase64(message.getBytes()));
    	return this.encryptor.decrypt(base64Text);
    }
}
