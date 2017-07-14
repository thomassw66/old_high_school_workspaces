
public class Snake {
	
	int direction; // 0,1,2 or 3 NESW
	SnakeNode first, last;
	SnakeNode[][] board;
	int snakesToAdd = 0;
	private Snake(int sx, int sy,SnakeNode [][] board){
		first = last = new SnakeNode();
		first.setPos(sx, sy);
		this.board = board;
		board[sx][sy] = first;
		int a = (int) (Math.random() * board.length);
		int b = (int) (Math.random()*board[0].length);
		board[a][b] = new SnakeNode(a,b);
	}
	
	public Snake(int sx, int sy, int length, int direction, SnakeNode[][] board){
		this(sx,sy,board);
		this.direction = direction;
		for(int i = 1; i < length; i++)
			addNode();
	}
	//adds a node to the end of the list
	public void addNode(){
		SnakeNode s = new SnakeNode();
		//set the location
		switch(direction){
		case 0: s.setPos(last.row - 1, last.col); break;//N
		case 1: s.setPos(last.row, last.col + 1); break;//E
		case 2: s.setPos(last.row + 1, last.col); break;//S
		case 3: s.setPos(last.row, last.col - 1); break;//W
		}
		last.next = s;
		last = s;
		
		if(board[last.row][last.col] != null){
			//System.out.println("OH SNAP");
			if(isInThis(board[last.row][last.col]))
				System.exit(0);
			else {
				//System.out.println("OMG");
				snakesToAdd += 8;

				int a = (int) (Math.random() * board.length);
				int b = (int) (Math.random()*board[0].length);
				board[a][b] = new SnakeNode(a,b);
			}
		}
		board[last.row][last.col] = last;
	}
	boolean isInThis(SnakeNode s){
		SnakeNode snakeNode = first;
		while(true){
			if(s == snakeNode)return true;
			if(snakeNode == last)break;
			snakeNode = snakeNode.next;
		}
		return false;
	}
	public void update(){
		if(snakesToAdd > 0){
			System.out.println(snakesToAdd);
			--snakesToAdd;
			
		}
		else 
			removeNode();
		addNode();
	}
	//removes the first node
	public void removeNode(){
		board[first.row][first.col] = null;
		first = first.next;
	}
	public void setDirection(int dir){
		if(dir != (direction+2) % 4)
		direction = dir;
	}
	public String toString(){
		SnakeNode n = first;
		String s = "[";
		while (n != last){
			s += "("+n.row +", " + n.col + "), ";
			n = n.next;
		}
		s += "("+last.row +", " + last.col + ")]";
		return s;
	}
}
