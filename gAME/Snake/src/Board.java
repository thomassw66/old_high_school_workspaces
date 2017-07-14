import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;


public class Board extends JFrame{

	SnakeNode [][] board;
	Snake mySnake;
	public Board(){ 
		board = new SnakeNode[60][80];
		mySnake = new Snake(10,10,10,2,board);
		setSize(board[0].length * 10 + 50, board.length * 10 + 70);
		setBackground(Color.white);
		repaint();
		setVisible(true);
		addKeyListener(new KeyListener(){

			public void keyPressed(KeyEvent arg0) {
				u(arg0.getKeyCode());
			}
			public void keyReleased(KeyEvent arg0) {}
			public void keyTyped(KeyEvent arg0) {}
			
			void u(int keyCode){
				switch(keyCode){
				case KeyEvent.VK_UP:
					mySnake.setDirection(0); 
					break;
				case KeyEvent.VK_RIGHT:
					mySnake.setDirection(1); 
					break;
				case KeyEvent.VK_DOWN:
					mySnake.setDirection(2); 
					break;
				case KeyEvent.VK_LEFT:
					mySnake.setDirection(3); 
					break;
				}
			}
			
		});
		Thread t = new Thread(new Runnable(){
			public void run(){
				while(true){
					try {
						mySnake.update();
						repaint();
						Thread.sleep(50);
					}catch(ArrayIndexOutOfBoundsException e){
						System.exit(0);
					}catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			} 
		});
		t.start();
	}
	public void paint(Graphics g){
		//System.out.println("p");
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 1000, 1000);


		g.setColor(Color.black);
		
		for(int x = 0; x <= board.length; x+=board.length){
			g.drawLine(30, x * 10 + 50,  (board[0].length) * 10 + 30, x * 10 + 50);
		}
		for(int x = 0; x <= board[0].length; x+=board[0].length){
			g.drawLine( x * 10 + 30, 50, x * 10 + 30, (board.length) * 10 + 50);
		}
		
		for (int i = 0; i < board.length; ++i){
			for(int j = 0; j < board[i].length; ++j){
				if(board[i][j] != null){
					paintNode(g,board[i][j]);
				}

			}
		}
	}
	public void paintNode(Graphics g, SnakeNode n){
		g.setColor(Color.red);
		g.fillOval(n.col*10 + 30, n.row*10+50, 10, 10);
		g.setColor(Color.black);
	}
	public static void main(String []a ){
		new Board();
	}
	
}
