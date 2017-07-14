import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
public class LightAndTransparencies {


	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);
		int cases = Integer.parseInt(in.nextLine());
		
		for(int c = 0; c < cases;c ++){
			in.nextLine();
			if(c >= 1)System.out.println();
			int lines = Integer.parseInt(in.nextLine());
			
			int segmentPoints = 0;
			float [][] segs = new float[lines * 2][2];
			
			for(int i = 0; i < lines; i++){
				float x1 = in.nextFloat(); in.nextFloat();
				float x2 = in.nextFloat(); in.nextFloat();
				float val = in.nextFloat(); in.nextLine();
				
				//start of line
				segs[segmentPoints][0] = Math.min(x1, x2);
				segs[segmentPoints++][1] = val;
				//end of line
				segs[segmentPoints][0] = Math.max(x1, x2);
				segs[segmentPoints++][1] = (val == 0)? -1: 1.0f/val;
			}
			Arrays.sort(segs, new FloatComp());
			System.out.println(segs.length+1);
			float light = 1.0f;
			System.out.printf("-inf %.3f %.3f\n",segs[0][0],light);
			for(int i = 0; i < segs.length-1; i++){
				if(segs[i][1] == -1)
					light = 1;
				else
					light *= segs[i][1];
				System.out.printf("%.3f %.3f %.3f\n", segs[i][0],segs[i+1][0],light);
			}
			light *= segs[segs.length-1][1];
			System.out.printf("%.3f +inf %.3f\n",segs[segs.length-1][0],light);
		}
	}

}
class FloatComp implements Comparator<float[]>{
	public int compare(float[]f, float[]b){
		if(f[0] >= b[0])
			return 1;
		else
			return - 1;
	}
}