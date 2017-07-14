import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
ID: thomass1
LANG: JAVA
TASK: packrec
 */

public class packrec {
	static ArrayList<Integer> arlist;
	public static void main(String []args) throws Exception{
		BufferedReader in = new BufferedReader(new FileReader("ariprog.in"));
		PrintWriter out = new PrintWriter(new FileWriter("ariprog.out"));
		
		arlist = new ArrayList<Integer>();
		
		Collections.sort(arlist, new Comparator<Integer>(){
			public int compare(Integer arg0, Integer arg1) {
				return -((arg0/1000)*(arg0%1000) - (arg1/1000)*(arg0%1000));
			}
		});
		
		in.close();
		out.close();
		System.exit(0);
	}
	public void rotate(int ax, int ay, int bx, int by, int cx, int cy, int dx, int dy){
		perm(ax,ay,bx,by,cx,cy,dx,dy);
		perm(ax,ay,bx,by,cx,cy,dy,dx);
		perm(ax,ay,bx,by,cy,cx,dx,dy);
		perm(ax,ay,bx,by,cy,cx,dy,dx);
		perm(ax,ay,by,bx,cx,cy,dx,dy);
		perm(ax,ay,by,bx,cx,cy,dy,dx);
		perm(ax,ay,by,bx,cy,cx,dx,dy);
		perm(ax,ay,by,bx,cy,cx,dy,dx);
		perm(ay,ax,bx,by,cx,cy,dx,dy);
		perm(ay,ax,bx,by,cx,cy,dy,dx);
		perm(ay,ax,bx,by,cy,cx,dx,dy);
		perm(ay,ax,bx,by,cy,cx,dy,dx);
		perm(ay,ax,by,bx,cx,cy,dx,dy);
		perm(ay,ax,by,bx,cx,cy,dy,dx);
		perm(ay,ax,by,bx,cy,cx,dx,dy);
		perm(ay,ax,by,bx,cy,cx,dy,dx);
	}
	public void perm(int ax, int ay, int bx, int by, int cx, int cy, int dx, int dy){
		m(ax,ay,bx,by,cx,cy,dx,dy);
		m(ax,ay,bx,by,dx,dy,cx,cy);
	}
	public void m(int ax, int ay, int bx, int by, int cx, int cy, int dx, int dy){
		arlist.add((ax+bx+cx+dx)*1000+ max(ay,by,cy,dy));
		arlist.add(max(ax,bx+cx+dx)*1000 + (ay+max(by,cy,dy)));
		arlist.add((ax+max(bx,cx+dx))*1000+(max(ay,by+max(cy,dy))));
		arlist.add(ax+dx+max(bx,cx)*1000 + (max(ay,dy,cy+by)));
		arlist.add(max(ax+bx,cx+dx)*1000 +  max(ay+cy,by+dy));
	}
	public int max(int ... a){
		int m = a[0];
		for(int i = 1; i < a.length; i++){
			if(a[i] > m)
				m= a[i];
		}
		return m;
	}
	public int min(int ... a){
		int m = a[0];
		for(int i = 1; i < a.length; i++){
			if(a[i] < m)
				m= a[i];
		}
		return m;
	}
}
