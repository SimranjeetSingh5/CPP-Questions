package com.kunal.array;

import java.util.Arrays;

public class DivisibleSumPairs {
    public static void main(String[] args) {
        int k = 3;
        int[] arr = {1,3,2,6,1,2};
        System.out.println(divisibleSumPairs(k, arr));
        System.out.println("a".compareTo("b"));
    }
    static int divisibleSumPairs(int k, int[] arr) {
        int[] freq = new int[k];
        for (int value : arr) {
            freq[value % k]++;
        }
        System.out.println(Arrays.toString(freq));
        int sum = 0;
        sum += (freq[0] * (freq[0] - 1)) / 2;
        for (int i = 1; i <= k/2 && i != k - i; i++) {
            sum += freq[i] * freq[k-i];
        }
        if(k % 2 == 0) {
            sum += (freq[k/2] * (freq[k/2]-1))/2;
        }
        return sum;
    }

}
