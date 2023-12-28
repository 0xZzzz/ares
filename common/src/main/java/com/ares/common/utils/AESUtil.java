package com.ares.common.utils;

import org.apache.commons.codec.binary.Hex;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;

public class AESUtil {
 
	private static final String AES = "AES";
	private static final String UTF8 = "UTF-8";
	private static final String CIPHERALGORITHM = "AES/CBC/PKCS5Padding";
	private static final String Key = "ascp_dc_data_service";

	public static void main(String[] args) {
		System.out.println(encrypt("plan_biz"));
	}
 
	/**
	 * AES加密
	 * 
	 * @param content
	 * @return
	 * @throws Exception
	 */
	public static String encrypt(String content) {
		try {
			byte[] encodeFormat = Key.getBytes();
			SecretKeySpec key = new SecretKeySpec(encodeFormat, AES);
			// Cipher对象实际完成加密操作
			Cipher cipher = Cipher.getInstance(CIPHERALGORITHM);
			// 加密内容进行编码
			byte[] byteContent = content.getBytes(StandardCharsets.UTF_8);
			// 用密匙初始化Cipher对象
			cipher.init(Cipher.ENCRYPT_MODE, key);
			// 正式执行加密操作
			byte[] result = cipher.doFinal(byteContent);
			return Hex.encodeHexString(result);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
 
	/**
	 * AES解密
	 */
	public static String decrypt(String content) {
		try {
			// 密文使用Hex解码
			byte[] byteContent = Hex.decodeHex(content.toCharArray());
			byte[] encodeFormat = Key.getBytes();
			SecretKeySpec key = new SecretKeySpec(encodeFormat, AES);
			// Cipher对象实际完成加密操作
			Cipher cipher = Cipher.getInstance(AES);
			// 用密匙初始化Cipher对象
			cipher.init(Cipher.DECRYPT_MODE, key);
			// 正式执行解密操作
			byte[] result = cipher.doFinal(byteContent);
			return new String(result, UTF8);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}