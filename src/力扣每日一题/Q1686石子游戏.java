package 力扣每日一题;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Comparator;

public  class Q1686石子游戏 {
    @Test
    public void kk()
    {
        System.out.println(stoneGame(new int[]{1,2}, new int[]{3,1}));
    }
    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        Integer[] vals = new Integer[aliceValues.length];
        for (int i = 0; i < vals.length; i++) {
            vals[i] = aliceValues[i] + bobValues[i];
        }
        Arrays.sort(vals, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }

        });
        long a = 0, b = 0;
        for (int i = 0; i < vals.length; i++) {
            if(i % 2 == 0) a += vals[i];
           else b += vals[i];
        }
        if(a > b) return 1;
        if(a == b) return 0;
        return -1;
    }
    public int stoneGame(int[] aliceValues, int[] bobValues) {
        int n = aliceValues.length;
        //这里是创建了n个空的数组
        int[][] vals = new int[n][0];
        for (int i = 0; i < n; ++i) {
            vals[i] = new int[] {aliceValues[i] + bobValues[i], i};
        }
        Arrays.sort(vals, (a, b) -> b[0] - a[0]);
        int a = 0, b = 0;
        for (int k = 0; k < n; ++k) {
            int i = vals[k][1];
            if (k % 2 == 0) {
                a += aliceValues[i];
            } else {
                b += bobValues[i];
            }
        }
        if (a == b) {
            return 0;
        }
        return a > b ? 1 : -1;
    }
    //这个要记录的是ai+bi的值，但是加上的值是ai，第一个方法就是最后的值加错了

}
