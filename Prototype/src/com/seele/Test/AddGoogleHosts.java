package com.seele.Test;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.swing.*;

public class AddGoogleHosts {
    public static String FILE_NAME = "C:/Windows/System32/drivers/etc/Hosts";

	public static String readInputStream(InputStream inputStream)
			throws IOException {
		byte[] buffer = new byte[1024];
		int len;
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		while ((len = inputStream.read(buffer)) != -1) {
			bos.write(buffer, 0, len);
		}
		bos.close();
        return new String(bos.toByteArray(), "UTF-8");
	}

	public static String fileSetContents(String filename, String content) throws IOException{
		File files = new File(filename);
		FileOutputStream out = new FileOutputStream(files);
		byte by[] = content.getBytes();
		out.write(by);
		out.close();
		return fileGetContents(filename);
	}

	public static String fileGetContents(String filename) throws IOException{
		File files = new File(filename);
		FileInputStream in = new FileInputStream(files);
		byte byt[] = new byte[32768];
		int length = in.read(byt);
		in.close();
		return new String(byt, 0, length);
	}

	public static String modifyHost() throws IOException {
		URL url = new URL("http://www.360kb.com/kb/2_122.html");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		InputStream inputStream = conn.getInputStream(); 
		String htmlString = readInputStream(inputStream);

		htmlString = htmlString.replaceAll("&nbsp;", "");
		htmlString = htmlString.replaceAll("<span>", "");
		htmlString = htmlString.replaceAll("</span>", "");
		htmlString = htmlString.replaceAll("<br />", "");

		htmlString = htmlString.substring(htmlString.indexOf("#base services"),
				htmlString.indexOf("#google hosts 2015 end"));

		return fileSetContents(FILE_NAME, fileGetContents(FILE_NAME) + htmlString);
	}

	public static void main(String[] args) throws Exception {
		myJFrame frame1 = new myJFrame();
		frame1.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame1.setVisible(true);
	}

}

class ButtonListen implements ActionListener {
	JTextArea ipJTextArea;
	public ButtonListen(JTextArea ipJTextArea){
		this.ipJTextArea = ipJTextArea;
	}
	
	public void actionPerformed(ActionEvent e) {
		ipJTextArea.setText("");
		try {
			String hostFileContent = AddGoogleHosts.modifyHost();
			ipJTextArea.append(hostFileContent);
		} catch (Exception e1) {
			ipJTextArea.append("Modify Failure!");
		}
	}
}

class myJFrame extends JFrame {
    public myJFrame() throws Exception {
        super();
        //init myframe
        this.setSize(600, 600);
        this.setLocation(100, 100);
        this.setTitle("Get Google New IP");
        //add button and scrollPanel to panel
        panel.add(button);
        panel.add(scrollPanel);
        add(panel);
        //add button event listener
        button.addActionListener(new ButtonListen(ipJTextArea));
        button.setLocation(290, 20);
        //set TextColor Red when selected
        ipJTextArea.setSelectedTextColor(Color.RED);
        //Auto appear
        scrollPanel.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPanel.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    }

    JButton button = new JButton("Add Google Host!");
    JPanel panel = new JPanel();
    JTextArea ipJTextArea = new JTextArea(AddGoogleHosts.fileGetContents(AddGoogleHosts.FILE_NAME), 30, 50);
    JScrollPane scrollPanel = new JScrollPane(ipJTextArea);
}

