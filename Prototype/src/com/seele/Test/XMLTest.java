package com.seele.Test;

import java.io.IOException;
import java.io.StringReader;

import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

public class XMLTest {

	public static void main(String[] args) throws Exception, Exception {
		// TODO Auto-generated method stub
		
		String emayCode = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><response><error>0</error><message>1.9</message></response>";
		
	    System.out.println(emayCode);
	    
	    StringReader sr = new StringReader(emayCode);   
	    
	    InputSource source = new InputSource(sr);   
	      
	    
	    //创建一个新的SAXBuilder
        SAXBuilder sb = new SAXBuilder();
        try
        {
           org.jdom2.Document doc = sb.build(source);
            //取的根元素
           Element root = doc.getRootElement();
           Element loginname=root.getChild("error");
           System.out.println(loginname.getName()+":"+loginname.getValue());//输出login_name元素 
        }
        catch (JDOMException e) {
            // TODO 自动生成 catch 块
            e.printStackTrace();
        } catch (IOException e) {
            // TODO 自动生成 catch 块
            e.printStackTrace();
        }
	}

}
