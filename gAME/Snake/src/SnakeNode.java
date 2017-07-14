
public class SnakeNode {

	int row, col;
	SnakeNode next;
	
	public SnakeNode(){}
	public SnakeNode(int r, int c){setPos(r,c);}
	public void setPos(int r, int c){
		row = r;
		col = c;
	}
}
