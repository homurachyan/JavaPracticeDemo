package com.seele.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class EncryptUtils {

	public static void main(String[] args){
		String str = "123456";
		
		System.out.println(encryptMd5WithSalt(str));
	}
	
	public static String encryptMd5WithSalt(String password) {  
        String salt = generateSalt();  
        return encryptMd5(password+salt);  
    }  
	
	public static String encryptMd5(String password) {
		if (password == null) {
			password = "";
		}
		MessageDigest md5 = null;
		try {
			md5 = MessageDigest.getInstance("MD5");
			md5.update(password.getBytes("utf-8"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return toHex(md5.digest());
	}
	
	 private static String generateSalt(){
		 return generateCode();
	 }
	 /** 
     * PBKDF2加密 
     * @param password 
     * @return 
     */
	 public static String encryptPBKDF2(String password) {  
	        try {  
	            int iterations = 1000;  
	            char[] chars = password.toCharArray();  
	            byte[] salt = generateSalt().getBytes();  
	               
	            PBEKeySpec spec = new PBEKeySpec(chars, salt, iterations, 64 * 8);  
	            SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");  
	            byte[] hash = skf.generateSecret(spec).getEncoded();  
	              
	            return iterations + toHex(salt) + toHex(hash);  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }   
	         
	        return null;  
	}  
	 
	 
	 /** 
     * 转化十六进制 
     * @param array 
     * @return 
     */  
     private static String toHex(byte[] array) {  
            BigInteger bi = new BigInteger(1, array);  
            String hex = bi.toString(16);  
            int paddingLength = (array.length * 2) - hex.length();  
            if(paddingLength > 0) {  
                return String.format("%0"  +paddingLength + "d", 0) + hex;  
            }else{  
                return hex;  
            }  
      }  
	 /** 
      * 转化十六进制 2
      * @param array 
      * @return 
      */       
 	  private static String toHex2(byte[] bytes) {
			StringBuffer str = new StringBuffer(32);
			for (byte b : bytes) {
				str.append(hexDigits[(b & 0xf0) >> 4]);
				str.append(hexDigits[(b & 0x0f)]);
			}
			return str.toString();
	  }
	
 		/***
 		 * 生成随机字符串（4位）
 		 * 
 		 * @param params
 		 * @return
 		 */	
 		private static String generateCode(){
 			 String[] beforeShuffle = new String[] {"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};  
 		     List list = Arrays.asList(beforeShuffle);  
 		     Collections.shuffle(list);  
 		     StringBuilder sb = new StringBuilder();  
 		     for (int i = 0; i < list.size(); i++) {  
 		         sb.append(list.get(i));  
 		     }  
 		     String afterShuffle = sb.toString();  
 		     return afterShuffle.substring(5, 9);  
/* 		     Random rand = new Random();//创建Random类的对象rand  
 		     String vcode = "";
 		     for(int i=0;i<4;i++){
 		    	 vcode += rand.nextInt(10);	    	 
 		     }
 		     return vcode;*/
 		}
 	  
	  private static final char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
	
}
