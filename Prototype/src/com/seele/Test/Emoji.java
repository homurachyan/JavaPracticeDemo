package com.seele.Test;

import java.io.UnsupportedEncodingException;

public class Emoji {
	private final static char[] mChars = "0123456789ABCDEF".toCharArray();  
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		char[] c = {0x21d4, 0x25b2, 0x25bc};
		char ct = (char) 0x2603;
        String s = c.toString();
        String str = "\ud800\udc00";//\u2603
	    System.out.println(str);
	}
	/**
	 * 检查的字符串是否包含emoji表情;
	 * */
	public static boolean containsEmoji(String source) {
		int len = source.length();
		for (int i = 0; i < len; i++) {
			char codePoint = source.charAt(i);
			if (isNotEmojiCharacter(codePoint)) {
				// do nothing，判断到了这里表明，确认有表情字符
				return true;
			}
		}
		return false;
	}

	private static boolean isNotEmojiCharacter(char codePoint) {
		return (codePoint == 0x0) || (codePoint == 0x9) || (codePoint == 0xA)
				|| (codePoint == 0xD)
				|| ((codePoint >= 0x20) && (codePoint <= 0xD7FF))
				|| ((codePoint >= 0xE000) && (codePoint <= 0xFFFD))
				|| ((codePoint >= 0x10000) && (codePoint <= 0x10FFFF));
	}
	
	/**  
     * 字符串转换成十六进制字符串 
     * @param str String 待转换的ASCII字符串 
     * @return String 每个Byte之间空格分隔，如: [61 6C 6B] 
     */    
    public static String str2HexStr(String str){    
        StringBuilder sb = new StringBuilder();  
        byte[] bs = str.getBytes();    
          
        for (int i = 0; i < bs.length; i++){    
            sb.append(mChars[(bs[i] & 0xFF) >> 4]);    
            sb.append(mChars[bs[i] & 0x0F]);  
            sb.append(' ');  
        }    
        return sb.toString().trim();    
    }  
    
    /** 
     * String的字符串转换成unicode的String 
     * @param strText String 全角字符串 
     * @return String 每个unicode之间无分隔符 
     * @throws Exception 
     */  
    public static String strToUnicode(String strText)  
        throws Exception  
    {  
        char c;  
        StringBuilder str = new StringBuilder();  
        int intAsc;  
        String strHex;  
        for (int i = 0; i < strText.length(); i++){  
            c = strText.charAt(i);  
            intAsc = (int) c;  
            strHex = Integer.toHexString(intAsc);  
            if (intAsc > 128)  
                str.append("\\u");  
            else // 低位在前面补00  
                str.append("\\u00");  
            str.append(strHex);  
        }  
        return str.toString();  
    }  
}
