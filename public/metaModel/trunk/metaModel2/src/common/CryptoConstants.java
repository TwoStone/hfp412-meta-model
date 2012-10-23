package common;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.EncodedKeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

//import java.io.DataOutputStream;
//import java.io.FileOutputStream;
//import java.security.AlgorithmParameters;

public class CryptoConstants {

	private static final String RSAAlgorithmName = "RSA";
	private static final String DESAlgorithmName = "DES";

	private static final String ConnectTransformation = RSAAlgorithmName;
	private static final String CommunicationTransformation = DESAlgorithmName + "/CBC/PKCS5Padding";

	private static Key privateKey;
	private static Key publicKey;
	
	private static KeyGenerator generator;
	
	private static final String PrivateKeyFileName = "PrivateKey";
	private static final String PublicKeyFileName = "PublicKey";

	public static final int SaltLength = 8;
	
	private static Cipher encode = createEncodeCipher();
	private static Cipher decode = createDecodeCipher();

	public static Cipher getConnectEncodeCipher () {
		return encode;
	}
	public static Cipher getConnectDecodeCipher () {
		return decode;
	}
	public static SecretKey getCommunicationKey(){
		if (generator == null)
			try {
				generator = KeyGenerator.getInstance(DESAlgorithmName);
				generator.init(new SecureRandom());
			} catch (Exception e) {
				throw new Error(e.getMessage());
			}
		return generator.generateKey();
	}
	private static AlgorithmParameterSpec getParameterSpec(){
		byte[] iv = {0,1,2,3,4,5,6,7};
		return new IvParameterSpec(iv);
	}
	public static Cipher getCommunicationDecodeCipher(SecretKey communicationKey) {
		try {
			Cipher result = Cipher.getInstance(CommunicationTransformation);
			result.init(Cipher.DECRYPT_MODE, communicationKey, getParameterSpec());
			return result;
		} catch (Exception e) {
			throw new Error(e.getMessage());
		}
	}
	public static Cipher getCommunicationEncodeCipher(SecretKey communicationKey) {
		try {
			Cipher result = Cipher.getInstance(CommunicationTransformation);
			result.init(Cipher.ENCRYPT_MODE, communicationKey, getParameterSpec());
			return result;
		} catch (Exception e) {
			throw new Error(e.getMessage());
		}
	}
	private static void initialize() {
		try {
			File privateKeyFile = new File(PrivateKeyFileName);
			File publicKeyFile = new File(PublicKeyFileName);
			KeyFactory keyFactory = KeyFactory.getInstance(RSAAlgorithmName);
			if(privateKeyFile.exists()){
				byte[] privateKeyEncoded = read(privateKeyFile);
	            EncodedKeySpec privateKeySpec = new PKCS8EncodedKeySpec(privateKeyEncoded);
	            privateKey = keyFactory.generatePrivate(privateKeySpec);
			}
			if (publicKeyFile.exists()){
				byte[] publicKeyEncoded = read(publicKeyFile);
				EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(publicKeyEncoded);
	            publicKey = keyFactory.generatePublic(publicKeySpec);
			}
		} catch (Exception e){
			throw new Error(e.getMessage());
		}
	}
	private static byte[] read(File file) throws IOException {
		FileInputStream stream = new FileInputStream(file);
		DataInputStream dataSteam = new DataInputStream(stream);
		int length = (int) file.length();
		byte[] result = new byte[length];
		dataSteam.readFully(result);
		dataSteam.close();
		stream.close();
		return result;
	}
//	private static void save (File file, byte[] contents) throws IOException{
//		FileOutputStream stream = new FileOutputStream(file);
//		DataOutputStream dataStream = new DataOutputStream(stream);
//		dataStream.write(contents);
//		dataStream.close();
//		stream.close();
//	}	
	
	private static Cipher createEncodeCipher() {
		if (publicKey == null) initialize();
		if (publicKey != null){
			try {
				Cipher cipher = Cipher.getInstance(ConnectTransformation);
				cipher.init(Cipher.ENCRYPT_MODE, publicKey);
				return cipher;
			} catch (Exception e) {
				throw new Error(e.getMessage());
			} 
		}
		return null;
	}
	private static Cipher createDecodeCipher() {
		if (privateKey == null) initialize();
		if (privateKey != null){
			try {
				Cipher cipher = Cipher.getInstance(ConnectTransformation);
				cipher.init(Cipher.DECRYPT_MODE, privateKey);
				return cipher;
			} catch (Exception e) {
				throw new Error(e.getMessage());
			} 
		}
		return null;
	}
	private CryptoConstants(){}
	public static SecretKey reproduceCommunicationKey(byte[] key) {
		return new SecretKeySpec(key, "DES");
	}
}
