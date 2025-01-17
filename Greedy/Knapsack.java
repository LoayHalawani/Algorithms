import java.util.*;

public class Knapsack {
	private int n, m;
	private List<int[]> objects;
	private double[] ratios, profits;

	public Knapsack(int n, int m) {
		this.n = n;
		this.m = m;
		objects = new ArrayList<>(n);
	}

	private void addProfitWeight(int profit, int weight) {
		objects.add(new int[]{profit, weight});
	}

	private void calculateRatios() {
		ratios = new double[n];
		for(int i = 0; i < n; i ++) {
			ratios[i] = ((double) objects.get(i)[0] / objects.get(i)[1]);
		}
	}

	private void calculateProfits() {
		profits = new double[n];
		int maxIndex = 0;
		while(m > 0) {
			for(int i = 0; i < n; i ++) {
				if(ratios[i] > ratios[maxIndex]) {
					maxIndex = i;
				}
			}
			if(m >= objects.get(maxIndex)[1]) {
				profits[maxIndex] = objects.get(maxIndex)[0];
				m -= objects.get(maxIndex)[1];
			}
			else {
				profits[maxIndex] = ratios[maxIndex] * m;
                m = 0;
			}
			ratios[maxIndex] = 0;
		}
	}

	private void calculateMaxProfit() {
		calculateRatios();

		calculateProfits();

		double maxProfit = 0;
		for(double profit : profits) {
			maxProfit += profit;
		}

		System.out.printf("Max profit is: %.2f\n", maxProfit);
	}

	public static void main(String[] args) {
		Knapsack ks = new Knapsack(7, 15);

		ks.addProfitWeight(10, 2);
		ks.addProfitWeight(5, 3);
		ks.addProfitWeight(15, 5);
		ks.addProfitWeight(7, 7);
		ks.addProfitWeight(6, 1);
		ks.addProfitWeight(18, 4);
		ks.addProfitWeight(3, 1);

		ks.calculateMaxProfit();
	}
}
