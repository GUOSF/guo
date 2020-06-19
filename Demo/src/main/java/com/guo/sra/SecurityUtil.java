package com.guo.sra;

import org.apache.commons.codec.binary.Base64;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import sun.misc.BASE64Decoder;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public class SecurityUtil {
	private static String ALGORITHM = "RSA";

	private static int KEYSIZE = 1024;
	public static final String DEFAULT_PUBLIC_KEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDDI2bvVLVYrb4B0raZgFP60VXY\ncvRmk9q56QiTmEm9HXlSPq1zyhyPQHGti5FokYJMzNcKm0bwL1q6ioJuD4EFI56D\na+70XdRz1CjQPQE3yXrXXVvOsmq9LsdxTFWsVBTehdCmrapKZVVx6PKl7myh0cfX\nQmyveT/eqyZK1gYjvQIDAQAB";

	private RSAPublicKey publicKey;
	private static final char[] HEX_CHAR = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e',
			'f' };


	public RSAPublicKey getPublicKey() {
		return this.publicKey;
	}

	public void genKeyPair() {
		KeyPairGenerator keyPairGen = null;
		try {
			keyPairGen = KeyPairGenerator.getInstance(ALGORITHM);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		keyPairGen.initialize(KEYSIZE, new SecureRandom());
		KeyPair keyPair = keyPairGen.generateKeyPair();
		this.publicKey = ((RSAPublicKey) keyPair.getPublic());
	}

	public void loadPublicKey(InputStream in) throws Exception {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String readLine = null;
			StringBuilder sb = new StringBuilder();
			while ((readLine = br.readLine()) != null) {
				if (readLine.charAt(0) == '-') {
					continue;
				}
				sb.append(readLine);
				sb.append('\r');
			}

			loadPublicKey(sb.toString());
		} catch (IOException e) {
			throw new Exception("公钥数据流读取错误");
		} catch (NullPointerException e) {
			throw new Exception("公钥输入流为空");
		}
	}

	public void loadPublicKey(String publicKeyStr) throws Exception {
		try {
			BASE64Decoder base64Decoder = new BASE64Decoder();
			byte[] buffer = base64Decoder.decodeBuffer(publicKeyStr);
			KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM);
			X509EncodedKeySpec keySpec = new X509EncodedKeySpec(buffer);
			this.publicKey = ((RSAPublicKey) keyFactory.generatePublic(keySpec));
		} catch (NoSuchAlgorithmException e) {
			throw new Exception("无此算法");
		} catch (InvalidKeySpecException e) {
			throw new Exception("公钥非法");
		} catch (IOException e) {
			throw new Exception("公钥数据内容读取错误");
		} catch (NullPointerException e) {
			throw new Exception("公钥数据为空");
		}
	}

	public static RSAPublicKey getPublicKey(String publicKeyStr) throws Exception {
		try {
			BASE64Decoder base64Decoder = new BASE64Decoder();
			byte[] buffer = base64Decoder.decodeBuffer(publicKeyStr);
			KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM);
			X509EncodedKeySpec keySpec = new X509EncodedKeySpec(buffer);
			return (RSAPublicKey) keyFactory.generatePublic(keySpec);
		} catch (NoSuchAlgorithmException e) {
			throw new Exception("无此算法");
		} catch (InvalidKeySpecException e) {
			throw new Exception("公钥非法");
		} catch (IOException e) {
			throw new Exception("公钥数据内容读取错误");
		} catch (NullPointerException e) {
		}
		throw new Exception("公钥数据为空");
	}

	


	public static RSAPrivateKey getPrivateKey(String privateKeyStr) throws Exception {
		try {
			BASE64Decoder base64Decoder = new BASE64Decoder();
			byte[] buffer = base64Decoder.decodeBuffer(privateKeyStr);
			PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(buffer);
			KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM);
			return (RSAPrivateKey) keyFactory.generatePrivate(keySpec);
		} catch (NoSuchAlgorithmException e) {
			throw new Exception("无此算法");
		} catch (InvalidKeySpecException e) {
			throw new Exception("私钥非法");
		} catch (IOException e) {
			throw new Exception("私钥数据内容读取错误");
		} catch (NullPointerException e) {
		}
		throw new Exception("私钥数据为空");
	}

	public byte[] encrypt(RSAPublicKey publicKey, byte[] plainTextData) throws Exception {
		if (publicKey == null) {
			throw new Exception("加密公钥为空, 请设置");
		}
		Cipher cipher = null;
		try {
			cipher = Cipher.getInstance(ALGORITHM, new BouncyCastleProvider());
			cipher.init(1, publicKey);
			byte[] output = cipher.doFinal(plainTextData);
			return output;
		} catch (NoSuchAlgorithmException e) {
			throw new Exception("无此加密算法");
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
			return null;
		} catch (InvalidKeyException e) {
			throw new Exception("加密公钥非法,请检查");
		} catch (IllegalBlockSizeException e) {
			throw new Exception("明文长度非法");
		} catch (BadPaddingException e) {
		}
		throw new Exception("明文数据已损坏");
	}

	public static String encrypt(RSAPublicKey publicKey, String plainTextData) throws Exception {
		if (publicKey == null) {
			throw new Exception("加密公钥为空, 请设置");
		}
		Cipher cipher = null;
		try {
			cipher = Cipher.getInstance(ALGORITHM, new BouncyCastleProvider());
			cipher.init(1, publicKey);
			byte[] output = cipher.doFinal(plainTextData.getBytes("UTF-8"));

			return Base64.encodeBase64String(output);
		} catch (NoSuchAlgorithmException e) {
			throw new Exception("无此加密算法");
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
			return null;
		} catch (InvalidKeyException e) {
			throw new Exception("加密公钥非法,请检查");
		} catch (IllegalBlockSizeException e) {
			throw new Exception("明文长度非法");
		} catch (BadPaddingException e) {
		}
		throw new Exception("明文数据已损坏");
	}

	public byte[] decrypt(RSAPrivateKey privateKey, byte[] cipherData) throws Exception {
		if (privateKey == null) {
			throw new Exception("解密私钥为空, 请设置");
		}
		Cipher cipher = null;
		try {
			cipher = Cipher.getInstance(ALGORITHM, new BouncyCastleProvider());
			cipher.init(2, privateKey);
			int inputLen = cipherData.length;
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			int offSet = 0;

			int i = 0;

			while (inputLen - offSet > 0) {
				byte[] cache;
				// byte[] cache;
				if (inputLen - offSet > 128)
					cache = cipher.doFinal(cipherData, offSet, 128);
				else {
					cache = cipher.doFinal(cipherData, offSet, inputLen - offSet);
				}
				out.write(cache, 0, cache.length);
				i++;
				offSet = i * 128;
			}
			byte[] output = out.toByteArray();
			out.close();
			return output;
		} catch (NoSuchAlgorithmException e) {
			throw new Exception("无此解密算法");
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
			return null;
		} catch (InvalidKeyException e) {
			throw new Exception("解密私钥非法,请检查");
		} catch (IllegalBlockSizeException e) {
			throw new Exception("密文长度非法");
		} catch (BadPaddingException e) {
		}
		throw new Exception("密文数据已损坏");
	}

	public static String decrypt(RSAPrivateKey privateKey, String base64Data) throws Exception {
		byte[] cipherData = Base64.decodeBase64(base64Data);
		if (privateKey == null) {
			throw new Exception("解密私钥为空, 请设置");
		}
		Cipher cipher = null;
		try {
			cipher = Cipher.getInstance(ALGORITHM, new BouncyCastleProvider());
			cipher.init(2, privateKey);
			int inputLen = cipherData.length;
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			int offSet = 0;

			int i = 0;

			while (inputLen - offSet > 0) {
				byte[] cache;
				// byte[] cache;
				if (inputLen - offSet > 128)
					cache = cipher.doFinal(cipherData, offSet, 128);
				else {
					cache = cipher.doFinal(cipherData, offSet, inputLen - offSet);
				}
				out.write(cache, 0, cache.length);
				i++;
				offSet = i * 128;
			}
			byte[] output = out.toByteArray();
			out.close();

			return new String(output);
		} catch (NoSuchAlgorithmException e) {
			throw new Exception("无此解密算法");
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
			return null;
		} catch (InvalidKeyException e) {
			throw new Exception("解密私钥非法,请检查");
		} catch (IllegalBlockSizeException e) {
			throw new Exception("密文长度非法");
		} catch (BadPaddingException e) {
		}
		throw new Exception("密文数据已损坏");
	}

	public static String byteArrayToString(byte[] data) {
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < data.length; i++) {
			stringBuilder.append(HEX_CHAR[((data[i] & 0xF0) >>> 4)]);

			stringBuilder.append(HEX_CHAR[(data[i] & 0xF)]);
		}
		return stringBuilder.toString();
	}

	private static byte toByte(char c) {
		byte b = (byte) "0123456789abcdef".indexOf(c);
		return b;
	}

	public static byte[] hexStringToByte(String hex) {
		int len = hex.length() / 2;
		byte[] result = new byte[len];
		char[] achar = hex.toCharArray();
		for (int i = 0; i < len; i++) {
			int pos = i * 2;
			result[i] = (byte) (toByte(achar[pos]) << 4 | toByte(achar[(pos + 1)]));
		}
		return result;
	}

	public static String md5(String str) {
		String digest = null;
		StringBuffer buffer = new StringBuffer();
		try {
			MessageDigest digester = MessageDigest.getInstance("md5");
			byte[] digestArray = digester.digest(str.getBytes());
			for (int i = 0; i < digestArray.length; i++) {
				buffer.append(String.format("%02x", new Object[] { Byte.valueOf(digestArray[i]) }));
			}
			digest = buffer.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return digest;
	}

	public static byte[] encryptByPrivateKey(byte[] privKeyInByte, byte[] data) {
		try {
			PKCS8EncodedKeySpec priv_spec = new PKCS8EncodedKeySpec(privKeyInByte);
			KeyFactory mykeyFactory = KeyFactory.getInstance("RSA");
			PrivateKey privKey = mykeyFactory.generatePrivate(priv_spec);
			Cipher cipher = Cipher.getInstance(mykeyFactory.getAlgorithm());
			cipher.init(1, privKey);
			return cipher.doFinal(data);
		} catch (Exception e) {
		}
		return null;
	}

	public static String encryptByPrivateKeyToBase64(byte[] privKeyInByte, String source_text) {
		try {
			PKCS8EncodedKeySpec priv_spec = new PKCS8EncodedKeySpec(privKeyInByte);
			KeyFactory mykeyFactory = KeyFactory.getInstance("RSA");
			PrivateKey privKey = mykeyFactory.generatePrivate(priv_spec);
			Cipher cipher = Cipher.getInstance(mykeyFactory.getAlgorithm());
			cipher.init(1, privKey);

			return new String(Base64.encodeBase64(cipher.doFinal(source_text.getBytes("UTF-8"))));
		} catch (Exception e) {
		}
		return null;
	}

	public static byte[] decryptByPublicKey(byte[] pubKeyInByte, byte[] data) {
		try {
			KeyFactory mykeyFactory = KeyFactory.getInstance("RSA");
			X509EncodedKeySpec pub_spec = new X509EncodedKeySpec(pubKeyInByte);
			PublicKey pubKey = mykeyFactory.generatePublic(pub_spec);
			Cipher cipher = Cipher.getInstance(mykeyFactory.getAlgorithm());
			cipher.init(2, pubKey);
			return cipher.doFinal(data);
		} catch (Exception e) {
		}
		return null;
	}

	public static String MD5To32(String str) {
		String result = "";
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			md5.update(str.getBytes("UTF-8"));
			byte[] b = md5.digest();

			StringBuffer buf = new StringBuffer("");
			for (int offset = 0; offset < b.length; offset++) {
				int i = b[offset];
				if (i < 0) {
					i += 256;
				}
				if (i < 16) {
					buf.append("0");
				}
				buf.append(Integer.toHexString(i));
			}
			result = buf.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public static String decryptByPublicKeyToBase64(byte[] pubKeyInByte, String base64Data) {
		byte[] data = Base64.decodeBase64(base64Data);
		try {
			KeyFactory mykeyFactory = KeyFactory.getInstance("RSA");
			X509EncodedKeySpec pub_spec = new X509EncodedKeySpec(pubKeyInByte);
			PublicKey pubKey = mykeyFactory.generatePublic(pub_spec);
			Cipher cipher = Cipher.getInstance(mykeyFactory.getAlgorithm());
			cipher.init(2, pubKey);

			return new String(cipher.doFinal(data), "UTF-8");
		} catch (Exception e) {
		}
		return null;
	}

	
}
