package org.algoinit;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author cgada
 */
public class FruitIntoBaskets {

    public static void main(String[] args) {
        System.out.println(totalFruitOptimized(new int[] {3,3,3,1,2,1,1,2,3,3,4}));

        System.out.println(totalFruitOptimized(new int[] {1,2,3,2,2}));

        System.out.println(totalFruitOptimized(new int[] {1,2,1,2,1,1,2,1,2,1,2}));
    }

    public static int totalFruitOptimized(int[] tree) {
        int frontPointer, rearPointer, numberOfBaskets, numberOfFruitsCollected, numberOfFruitsCollectedFinal;
        Set<Integer> baskets = new HashSet<>();
        numberOfFruitsCollectedFinal = 0;
        numberOfBaskets = 2;

        for(frontPointer = rearPointer = 0; (frontPointer < tree.length && rearPointer < tree.length);) {
            numberOfFruitsCollected = 0;
            baskets.clear();

            for(rearPointer = frontPointer; rearPointer < tree.length; rearPointer++) {
                if(baskets.isEmpty() ||
                        baskets.contains(tree[rearPointer]) ||
                        baskets.size() < numberOfBaskets) {
                    baskets.add(tree[rearPointer]);
                    numberOfFruitsCollected++;

                    if(tree[frontPointer] != tree[rearPointer]) {
                        frontPointer = rearPointer;
                    }
                } else {
                    break;
                }
            }

            numberOfFruitsCollectedFinal = Math.max(numberOfFruitsCollectedFinal, numberOfFruitsCollected);
        }

        return  numberOfFruitsCollectedFinal;
    }

    public static int totalFruitBruteForce(int[] tree) {
        int fruit1, fruit2, numberOfFruitsCollected;
        int [] numberOfFruits = new int[tree.length];
        int j;
        Arrays.fill(numberOfFruits, 0);

        for(int i=0; i < tree.length; i++) {
            fruit1 = fruit2 = -1;
            numberOfFruitsCollected = 0;

            for(j = i; j < tree.length; j++) {
                if(tree[j] == fruit1 || tree[j] == fruit2 || fruit1 == -1 || fruit2 == -1) {
                    numberOfFruitsCollected++;

                    if(fruit1 == -1 || fruit1 == tree[j]) {
                        fruit1 = tree[j];
                    } else if(fruit2 == -1 || fruit2 == tree[j]) {
                        fruit2 = tree[j];
                    }
                } else {
                    break;
                }
            }

            numberOfFruits[i] = numberOfFruitsCollected;

            if(j == tree.length) {
                break;
            }
        }

        Arrays.sort(numberOfFruits);
        return  numberOfFruits[tree.length-1];
    }
}
