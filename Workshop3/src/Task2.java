// Workshop 3 - Task 1
// Ilias Halemi
// 062 111 133

import java.util.Scanner;

public class Task2 {
	/* Class Properties */
	static final int ID = 0;
	static final int LOAN = 1;
	static double[][][] mBanks;
	
	/* Main Method */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = 0; int limit = 0;
		
		System.out.print("Enter the number of banks: ");
		if(sc.hasNextInt()) 
			n = sc.nextInt();
		
		System.out.println("Enter the minimum asset limit: ");
		if(sc.hasNextInt())
			limit = sc.nextInt();
		
		mBanks = new double[n][][];
		
		for(int i = 0; i < mBanks.length; i++) {
			System.out.println("Bank # " +i);
			System.out.print("Balance: ");
			double balance = sc.nextDouble();
			System.out.print("Number of banks loaned: ");
			int numBanks = sc.nextInt();
			mBanks[i] = new double[++numBanks][2];
			// bank balance
			mBanks[i][0][0] = balance;
			
			for (int j = 1; j < mBanks[i].length; j++) {
				System.out.print("Bank ID: ");
				mBanks[i][j][ID] = sc.nextDouble();
				
				System.out.print("Amount: ");
				mBanks[i][j][LOAN] = sc.nextDouble();
			}
		}
		
		boolean[] unsafeIndex = scanBanks(mBanks, limit);
		
		for(int i = 0; i < unsafeIndex.length; i++) {
			System.out.println("Unsafe banks are ");
			if (unsafeIndex[i] == true) {
				System.out.print(+i+ " ");
			}
		}

	}
	
	/* Class Methods */
	public static boolean[] scanBanks(double[][][] m, int limit) {
		boolean[] indexUnsafeBanks = new boolean[m.length];
		double total;
		boolean isSafe = false;
		
		// keep looping until indexUnsafe isn't modified 
		while(!isSafe) {
			isSafe = true; // gets set to false if indexUnsafeBanks is changed
			for(int i = 0; i < m.length; i++) {
				total = m[i][0][0];
				for(int j = 1; j < m[i].length; j++) {
					int index = (int)m[i][j][ID];
					if(!indexUnsafeBanks[index]) {
						total += m[i][j][LOAN];
					}
				}
				// update indexUnsafeBanks if bank is under limit (201)
				if (total < limit && !indexUnsafeBanks[i]) {
					indexUnsafeBanks[i] = true;
					isSafe = false;
				}
			}
		}
		return indexUnsafeBanks;
	}
	
}
