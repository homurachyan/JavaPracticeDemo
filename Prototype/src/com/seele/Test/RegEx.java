package com.seele.Test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegEx {
	public final static String regInteger = "^\\d+$";
	
	private final static char[] mChars = "0123456789ABCDEF".toCharArray();  
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
/*		System.out.println("-0.11".matches(regInteger));
		
		String a="138444831232";
		String regEx="[^0-9]";   
		Pattern p = Pattern.compile(regEx);   
		Matcher m = p.matcher(a);   
		System.out.println( m.replaceAll("").trim());
		
		List<String> ss = new ArrayList<String>();
		System.out.println(a.replaceAll("[^0-9]", ","));
		for(String sss:a.replaceAll("[^0-9]", ",").split(",")){
		    if (sss.length()>0)
		        ss.add(sss);
		}
		System.out.print(ss);*/
		//String s = "\xF0\x9F\x98\x83";
/*        String s = "#春熙路惊险大妹子 大妹子#121231231#   ##春熙路惊险大妹子，大妹子##春熙路惊险大妹子，大妹子##春熙路惊险大妹子，大妹子##春熙路惊险大妹子，大妹子##春熙路惊险大妹子，大妹子##春熙路惊险大妹子，大妹子##春熙路惊险大妹子，大妹子##春熙路惊险大妹子，大妹子##春熙路惊险大妹子，大妹子#12312313";
		String regEx="#[^#]*#";   
		Pattern p = Pattern.compile(regEx);   
		Matcher m = p.matcher(s); 
		while(m.find()){
			System.out.println("".equals(m.group().replaceAll("#","").replaceAll(" ","").trim()));
		}*/
/*		List<String> str = new ArrayList<String>();//{"1","2","3","1","4","1"}; 
		str.add("1");
		str.add("2");
		str.add("3");
		str.add("1");
		str.add("4");
		str.add("1");
		List<String> list = new ArrayList<String>();
		for(int i=0;i<str.size();i++){
			String s = str.get(i);
			boolean flag = true;
			for(int j=str.size()-1;j>=0;j--){
				if(s.equals(str.get(j))&&i!=j){
					flag = false;
					break;
				}
			}
			if(!flag){
				str.remove(i);
			}					
		}
		for(String s : str){
			System.out.println(s);
		}
		String[] sex = {"0","1"};
		Map paramMap = new HashMap();//{platform=2, sex=1, username=法轮功, mobile=18862330842}
		paramMap.put("platform", "2");
		paramMap.put("sex", 1);
		paramMap.put("username", "法轮功");
		System.out.println(Arrays.asList(sex).contains(paramMap.get("sex").toString()));
		
		System.out.println("17708120128".matches("^1[3|4|5|7|8][0-9]{9}$"));*/
/*		String URL = "http://podemo.b0.upaiyun.com";
		String filename = "http://podemo.b0.upaiyun.com/dc4ebaba-4852-4781-8c34-2f4c8fde53aa1442476757.jpeg";
		System.out.println(filename.substring(URL.length(),filename.length()));*/
		
/*		String str = String.format("%09d", 1); 
		System.out.println(String.format("%09d", 1));
		String mobile = "08613709017780";
		System.out.println(exactMobile(mobile));
		System.out.println(mobile);*/
		String chinese = "\u4E25";
		String emoji = new String(Character.toChars(0x1f601));
		System.out.println(emoji);
		System.out.println(Character.isSurrogatePair(emoji.charAt(0),emoji.charAt(1)));
		System.out.println(chinese.matches("[^\\u0000-\\uFFFF]"));
		System.out.println(removeSurrogates(emoji));
		String regEx = "[0-9a-zA-Z\u4e00-\u9fa5_\\-|.。!！]+";
		Pattern p = Pattern.compile(regEx);   
		Matcher m = p.matcher(emoji);   
		StringBuffer sb = new StringBuffer();
		while(m.find()){
			sb.append(m.group().trim());
		}
		System.out.println(sb.toString());
		System.out.println(str2HexStr(emoji));
		char[] chars = chinese.toCharArray();
		System.out.println(Character.codePointAt(chars,0));
		
		byte[] bytes = emoji.getBytes();
		
		List<Map> userList = null;
		System.out.println(emoji.codePointCount(0, emoji.length()));
		
	    char[] chs = Character.toChars(0x10400);
        System.out.printf("U+10400 高代理字符: %04x%n", (int)chs[0]);
        System.out.printf("U+10400 低代理字符: %04x%n", (int)chs[1]);        
        String str = new String(chs);
        System.out.println("代码单元长度: " + str.length());
        System.out.println("代码点数量: " + str.codePointCount(0, str.length()));
        
        System.out.println("a".getBytes().length);
        System.out.println("你".getBytes().length);
        
        long interval = 901;
        System.out.println((int)Math.floor(901/60));
	}
	
	public static String exactMobile(String mobile){
		StringBuffer sb = new StringBuffer(mobile).reverse();
		mobile = sb.toString().substring(0,11);
		sb = new StringBuffer(mobile).reverse();
		mobile = sb.toString();
		return mobile;
	}
	public static String filterOffUtf8Mb4(String text) throws UnsupportedEncodingException {
        byte[] bytes = text.getBytes("utf-8");
        ByteBuffer buffer = ByteBuffer.allocate(bytes.length);
        int i = 0;
        while (i < bytes.length) {
            short b = bytes[i];
            if (b > 0) {
                buffer.put(bytes[i++]);
                continue;
            }
            b += 256;
            if ((b ^ 0xC0) >> 4 == 0) {
                buffer.put(bytes, i, 2);
                i += 2;
            }
            else if ((b ^ 0xE0) >> 4 == 0) {
                buffer.put(bytes, i, 3);
                i += 3;
            }
            else if ((b ^ 0xF0) >> 4 == 0) {
                i += 4;
            }
        }
        buffer.flip();
        return new String(buffer.array(), "utf-8");
    }

    public static String filter(String str){
        if(str == null ||str.length() == 0){
            return "";
        }
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<str.length()-1;i++){
            int ch = str.charAt(i);
            int min = Integer.parseInt("E001", 16);
            int max = Integer.parseInt("E537", 16);
            if(ch >= min && ch <= max){
                sb.append("");
            }else{
                sb.append((char)ch);
            }
        }
        return sb.toString();
    }	
	
	private static boolean isEmojiCharacter(char codePoint) {
		  return ((codePoint >= 0x10000) && (codePoint <= 0x10FFFF));
	}
	
	public static boolean containsEmoji(String source) {
		  
		  int len = source.length();
		  
		  for (int i = 0; i < len; i++) {
		      char codePoint = source.charAt(i);
		      System.out.println("codePoint=" +codePoint);
		      if (isEmojiCharacter(codePoint)) {
				  //do nothing，判断到了这里表明，确认有表情字符
				  return true;
			  }
		  }
		  
		  return false;
	}
	
	public static String md5_3(String arg) {
		if (arg == null) {
			arg = "";
		}
		MessageDigest md5 = null;
		try {
			md5 = MessageDigest.getInstance("MD5");
			byte[] a = md5.digest(arg.getBytes("UTF-8"));
			a = md5.digest(a);
			md5.update(a);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return toHex(md5.digest());
	}
	
	private static String toHex(byte[] bytes) {
		StringBuffer str = new StringBuffer(32);
		for (byte b : bytes) {
			str.append(hexDigits[(b & 0xf0) >> 4]);
			str.append(hexDigits[(b & 0x0f)]);
		}
		return str.toString();
	}
	
	private static final char hexDigits[] = { '0', '1', '2', '3', '4', '5',
			'6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
	
	public static String removeSurrogates(String query) {
	    StringBuffer sb = new StringBuffer();
	    for (int i = 0; i < query.length() - 1; i++) {
	        char firstChar = query.charAt(i);
	        char nextChar = query.charAt(i+1);
	        if (Character.isSurrogatePair(firstChar, nextChar) == false) {
	            sb.append(firstChar);
	        } else {
	            i++;
	        }
	    }
	    if (Character.isHighSurrogate(query.charAt(query.length() - 1)) == false
	            && Character.isLowSurrogate(query.charAt(query.length() - 1)) == false) {
	        sb.append(query.charAt(query.length() - 1));
	    }

	    return sb.toString();
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
