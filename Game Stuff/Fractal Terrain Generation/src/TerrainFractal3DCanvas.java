import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class TerrainFractal3DCanvas extends JPanel{

	Random rand = new Random();
	
	public void paint(Graphics g){
		int [][] alt = new int [30][30];
		
		alt[0][0] = 125;
		alt[0][alt[0].length-1] = 125;

		alt[alt.length-1][0] = 125;
		alt[alt.length-1][alt[0].length-1] = 125;

		fractalFill3D(alt, 0, alt.length - 1, 0, alt[0].length - 1, 50);
		
		/*
		for(int i = 0; i < alt.length; i ++){
			for(int j = 0; j < alt[i].length; j++){
				alt[i][j] = (int)(Math.random() * 30);
			}
		}
		*/
		
		int x = 0;
		for(int i = 0; i < alt.length; i ++){
			
			x += (800 / alt.length) + 1;
			int y = 0;
			
			for(int j = 0; j < alt[i].length; j++){
				y += (600 / alt[i].length) + 1;

				//g.setColor(new Color(alt[i][j],alt[i][j],alt[i][j]));
				if(alt[i][j] < 125){
					g.setColor(Color.BLUE);
				}else{
					if (alt [i][j] > 170){
						g.setColor(Color.BLACK);
					}else {
						g.setColor(Color.GREEN);
					}
				}
				
				g.fillRect(x, y, 20	, 20);
			}
		}
	}
	public int randDiff(int range){
		return rand.nextInt(range) * (rand.nextBoolean() ? 1: -1);
	}
	void fractalFill3D(int alt [][], int l, int r, int u, int d, int range){
		
		int midX = (l + r) / 2;
		int midY = (u + d) / 2;
		
		System.out.println(l + " " + r + " "+u + " "+d + "  mid = "+  midX + ", " + midY);
		
		alt[midX][u] = (alt[l][u] + alt[r][u])/2 + randDiff(range);
		alt[midX][d] = (alt[l][d] + alt[r][d])/2 + randDiff(range);
		
		alt[l][midY] = (alt[l][u] + alt[l][d])/2 + randDiff(range);
		alt[r][midY] = (alt[r][d] + alt[r][d])/2 + randDiff(range);

		
		if(alt[midX][midY] == 0)
			alt[midX][midY] = ((alt[midX][u] + alt[midX][d] + alt[r][midY] + alt[l][midY]) / 4) + randDiff(range);
		else return;
		
		int  nRange = (range / 2) + 1;
		
		if(l < midX){
			if(u < midY){
				fractalFill3D(alt, l, midX, u, midY, nRange);
			}
			if(midY + 1 < d){
				fractalFill3D(alt, l, midX, midY, d, nRange);
			}
		}
		if(midX + 1 < r){
			if(u < midY){
				fractalFill3D(alt, midX, r, u, midY, nRange);
			}
			if(midY + 1 < d){
				fractalFill3D(alt, midX, r, midY, d, nRange);
			}
		}
	}
	public static void main(String [] args){
		JFrame f = new JFrame();
		
		f.setSize(900,700);
		f.add(new TerrainFractal3DCanvas());
		f.setVisible(true);
	}
}
