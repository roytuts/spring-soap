package com.jeejava.soap.config;

import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.TrustManagerFactory;

public class SoapClientConfig {

	public KeyManagerFactory getKeyManagerFactory() {
		InputStream inputStream = null;
		KeyStore ts = null;
		KeyManagerFactory keyManagerFactory = null;
		try {
			ts = KeyStore.getInstance("JKS");
			inputStream = this.getClass().getClassLoader().getResourceAsStream("javaclient.jks");
			ts.load(inputStream, "changeit".toCharArray());
			keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
			keyManagerFactory.init(ts, "changeit".toCharArray());
		} catch (NoSuchAlgorithmException | CertificateException | KeyStoreException | IOException
				| UnrecoverableKeyException e) {
			e.printStackTrace();
		} finally {
			try {
				inputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return keyManagerFactory;
	}

	public TrustManagerFactory getTrustManagerFactory() {
		InputStream inputStream = null;
		KeyStore ts = null;
		TrustManagerFactory trustManagerFactory = null;
		try {
			ts = KeyStore.getInstance("JKS");
			inputStream = this.getClass().getClassLoader().getResourceAsStream("keystore.jks");
			ts.load(inputStream, "changeit".toCharArray());
			trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
			trustManagerFactory.init(ts);
		} catch (NoSuchAlgorithmException | CertificateException | KeyStoreException | IOException e) {
			e.printStackTrace();
		} finally {
			try {
				inputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return trustManagerFactory;
	}
}
