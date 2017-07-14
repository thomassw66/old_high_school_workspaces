import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.swing.*;


public class Reader extends JFrame{
	int [][] buffer;
	BufferedReader reader;
	public static void main(String [] asdf) throws FileNotFoundException{
		new Reader(new FileReader(new File("C:\\Users\\Thomas\\Downloads\\movies\\The Campaign (2012) 1080p BluRay x264 + Subtitles [GlowGaze]\\test.tif")),400,600);
	}
	public Reader(FileReader picts,int width, int height){
		reader = new BufferedReader(picts);
		buffer = new int [width][height];
		this.setSize(width, height);
		this.setVisible(true);
		run();
	}
	void skip(int num) throws IOException{
		for(int i = 1; i <= num; i++)
			reader.read();
	}
	public void run(){
		while(true){
			try{
				boolean a = updateBuffer();
				repaint();
				break;
				//Thread.sleep(50);
			}catch(Exception e){
				if (e instanceof IOException)break;
				System.out.println(e);
			}
		}
	}
	public boolean updateBuffer() throws IOException{
	
		for(int i = 0; i < buffer.length; i++){
			for(int j = 0; j < buffer[i].length; j++){
				buffer[i][j] = reader.read() << 16;
				buffer[i][j] += reader.read() << 8;
				buffer[i][j] += reader.read();
			}
		}
		return buffer[buffer.length-1][buffer[0].length-1] >= 0;
	}
	public void paint(Graphics g){
		for(int i = 0; i < buffer.length; i++){
			for(int j = 0; j < buffer[i].length; j++){
				g.setColor(new Color(buffer[i][j]));
				g.drawRect(i, j, 1, 1);
			}
		}
	}
}
