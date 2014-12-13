public class mendel {

	private static long binomial(int n, int k) {
		if (k > n - k)
			k = n - k;

		long b = 1;
		for (int i = 1, m = n; i <= k; i++, m--)
			b = b * m / i;
		return b;
	}

	public static double problem(int K, int N) {
		double sum = 0.0;
		for (int i = 0; i < N; i++) {
			sum += binomial((int) Math.pow(2, K),i) * Math.pow(0.25, i)
					* Math.pow(0.75, Math.pow(2, K)-i);
		}
		return sum;
	}

	public static void main(String[] args) {
		System.out.println(1-(double)Math.round(mendel.problem(6,16)*100000)/100000);
		//System.out.println(1-mendel.problem(6,15));
	}
}
