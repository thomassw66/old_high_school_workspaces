
public class RadixSort extends Sort{
	int radix = 31;
	
	public void setRadix(int nr){
		if(nr < 32 && nr > 0){
			radix = nr;
		}
	}
	public void setMax(int maxNumber){
		Integer.highestOneBit(maxNumber);
	}
	//very fast
	public void sort(int [] toSort){
		
		int  [][] pleases = new int[2][toSort.length];

		int [] count = {0,0};
		
		for(int i = 0; i < radix; i ++){
				
			for(int j = 0; j < toSort.length; j++){
				int which = (toSort[j] >> i) & 1;
				pleases[which][count[which]++] = toSort[j];
			}
			
			int index = toSort.length - 1;
			while(count[1] > 0)
				toSort [index--] = pleases[1][--count[1]];
			while(count[0] > 0)
				toSort [index--] = pleases[0][--count[0]];
		}
	}
}
