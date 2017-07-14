
public class PythagTrips {

	public static void main(String [] args){
		System.out.println(gcd(10,5));
		long s = System.currentTimeMillis();
		for(long u = 1; u < 100; u+=2){
			for(long v = u+2; v < 100; v+=2){
					long x = u*v;
					long y = (v*v - u*u) / 2;
					long z = (u*u + v*v) / 2;
					if(x + y + z < 1000 && x < y && gcd(x,y) == 1)
					System.out.printf("(%5d,%5d,%5d)   %10d + %10d = %10d ;  s = %d\n",x,y,z,x*x,y*y,z*z,x+y+z);
			}
		}
		System.out.println(System.currentTimeMillis() - s);
	}
	static long gcd(long u, long v){
		if(v == 0)return u;
		if(u % v == 0)return v;
		else return gcd(v,u%v);
	}
}
