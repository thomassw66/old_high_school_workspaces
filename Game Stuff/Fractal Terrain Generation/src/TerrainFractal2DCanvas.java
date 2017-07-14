import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class TerrainFractal2DCanvas extends JPanel{

	public void paint(Graphics g){
		int [] y = new int [1000];
		y[0] = 300;
		y[y.length-1] = 300;
		
		fractalFill2D(y,0,y.length-1, 500);
		
		int pos = 0;
		for(int i = 0; i < y.length; i ++){
			g.fillRect(pos+= (800/y.length)+1, y[i], 20, 10);
		}
	}
	void fractalFill2D(int y [], int l, int r, int range){
		
		int mid = (l + r) / 2;
		int midY = (( y[l] + y[r] ) / 2)- (range / 2);
		
		y[mid] = midY + (int)(Math.random() * range);
				
		if(mid > l)
			fractalFill2D(y, l, mid, range/2);
		if(mid+1 < r)
			fractalFill2D(y, mid, r, range/2);
		
	}
	public static void main(String [] args){
		JFrame f = new JFrame();
		
		f.setSize(800,600);
		f.add(new TerrainFractal2DCanvas());
		f.setVisible(true);
	}
}
