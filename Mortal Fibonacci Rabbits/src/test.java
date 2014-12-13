
public class test {
	
	public static int m;
	public static int n;
	static long [] table;
	test(int n, int m){
		test.n = n;
		test.m = m;
		table = new long[m];
		table[0] = 1;
	}
	public static long fibo(){
		long ac=0;
		for (int i = 1; i < n; i ++){
			ac = 0;
			for(int j = 1; j <m ; j++)
				ac += table[j];
			for(int j = m-1; j>0; j--){
				table[j] = table[j-1];
			}
			table[0] = ac;
			
		}
		ac = 0;
		for(int j = 0; j < m ; j++)
			ac += table[j];
		return ac;
		
	}
	public static void main(String[] args){
		@SuppressWarnings("unused")
		test myfibo = new test(80,16);
		System.out.println(test.fibo());
	}
}
