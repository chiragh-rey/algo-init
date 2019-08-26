package org.algoinit;

import java.util.Arrays;

/**
 * @author cgada
 */
public class CoinChangeProblem {
    public static void main(String[] args) {
        System.out.println(coinChange(new int[] {1,2,5}, 11));

        System.out.println(coinChange(new int[] {2}, 3));

        System.out.println(coinChange(new int[] {2, 4, 6, 10}, 7));
    }

    public static int coinChange(int[] coins, int amount) {
        int[] dpArray = new int[amount+1];
        Arrays.fill(dpArray, amount+1);
        dpArray[0] = 0;

        for(int i=0; i<=amount; i++) {
            for(int j=0; j<coins.length; j++){
                if(coins[j] <= i) {
                    dpArray[i] = Math.min(dpArray[i], dpArray[i - coins[j]]);
                }
            }
        }

        return dpArray[amount] > amount ? -1 : dpArray[amount];
    }
}
