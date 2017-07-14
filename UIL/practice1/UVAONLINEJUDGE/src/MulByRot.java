
public class MulByRot {

	public static void main(String[] args) {
		// 179487 
		int [][] digs = new int [nBase][nBase];
		for(int i = 1; i < nBase; i++){
			for(int j = 1; j < nBase; j++){
				nOneLow = i;
				nTwo = j;
				digs[i][j] = GetMin(nOneLow,0,1);
			}
		}
		printGrid(digs);
	}
	static void printGrid(int [][] a){
		System.out.print(" ");
		for(int i = 1; i < a.length; i++)System.out.print(i+" ");
	}
	static int nOneLow,nBase = 10,nTwo;
	//			nLow : least significant	nNum : counter
	static int GetMin(int nLow, int nCarry, int nNum)
	{
	    int nTemp = nCarry + nLow * nTwo;
	    //System.out.println(nTemp);
	    if (nTemp == nOneLow)
	    {
	        return nNum;
	    }

	    return GetMin(nTemp % nBase, nTemp / nBase, nNum + 1);
	}
}
