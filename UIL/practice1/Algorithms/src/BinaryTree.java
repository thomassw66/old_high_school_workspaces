import java.util.Random;


public class BinaryTree {

	TreeNode root = null;
	public BinaryTree(int firstValue){
		root = new TreeNode(firstValue);
	}
	public static void main(String [] arfs){
		Random r = new Random();
		TreeNode top = new TreeNode(r.nextInt(1000));
		for(int i = 0; i < 1000000; i++){
			//System.out.println(top);
			top.insert(r.nextInt(1000));
		}
		System.out.println(top);
	}
}
class TreeNode{
	int val;
	public TreeNode left,right;
	public TreeNode(int v){
		this.val = v;
	}
	public void insert(int val){
		if(val > this.val){
			if(right == null){
				right = new TreeNode(val);
			}else {
				right.insert(val);
			}
		}else {
			if(left == null){
				left = new TreeNode(val);
			}else {
				left.insert(val);
			}
		}
	}
	public String toString(){
		String ret = ""+(this.val);
		if(left != null){
			ret = left.toString()+ " " + ret;
		}
		if(right != null){
			ret = ret + " " + right.toString();
		}
		return ret;
	}
}