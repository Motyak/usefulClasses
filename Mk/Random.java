package Mk;

public class Random {
	
	public static void main(String[] args) {
		System.out.println("Generating five integers between 1 and 5..");
		for(int i = 1 ; i <= 5 ; ++i)
			System.out.println(Random.genInt(1, 5));
		
		System.out.println("Generating two decimal numbers between 7 and 11..");
		for(int i = 1 ; i <= 2 ; ++i)
			System.out.println(Random.genDouble(7.0, 11.0));
	}
	
	/**
	 * Generate a random integer ranged from min to max (inclusive)
	 * @param min Minimum possible value
	 * @param max Maximum possible value
	 * @return A random integer between min and max (inclusive)
	 */
	public static int genInt(int min, int max)
	{
		java.util.Random rand = new java.util.Random();
		return rand.nextInt((max - min) + 1) + min;
	}
	
	/**
	 * Generate n random integers ranged from min to max (inclusive)
	 * @param n Number of integers to generate
	 * @param min Minimum possible value
	 * @param max Maximum possible value
	 * @return n random integers between min and max (inclusive)
	 */
	public static int[] genInts(int n, int min, int max)
	{
		int ints[] = new int[n];
		java.util.Random rand = new java.util.Random();
		for(int i = 1 ; i <= n ; ++i)
			ints[i] = rand.nextInt((max - min) + 1) + min;
		return ints;
	}
	
	/**
	 * Generate a random decimal ranged from min to max (inclusive)
	 * @param min Minimum possible value
	 * @param max Maximum possible value
	 * @return A random decimal decimal between min and max (inclusive)
	 */
	public static double genDouble(double min, double max)
	{
		java.util.Random rand = new java.util.Random();
		return rand.nextDouble() + (double)Random.genInt((int)min, (int)max - 1);
	}
	
	/**
	 * Generate n random decimals ranged from min to max (inclusive)
	 * @param n Number of decimals to generate
	 * @param min Minimum possible value
	 * @param max Maximum possible value
	 * @return n random decimals between min and max (inclusive)
	 */
	public static double[] genDoubles(int n, double min, double max)
	{
		double doubles[] = new double[n];
		java.util.Random rand = new java.util.Random();
		for(int i = 1 ; i <= n ; ++i)
			doubles[i] = rand.nextDouble() + (double)Random.genInt((int)min, (int)max - 1);
		return doubles;
	}
}
