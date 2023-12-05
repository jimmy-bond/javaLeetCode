package 力扣每日一题;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.TreeMap;

public class Q1904拼车 {
    @Test
    public void kk()
    {
       int[][] a = {{3,2,8},{4,4,6},{10,8,9}};
        System.out.println(carPooling(a, 11));
    }


        public boolean carPooling(int[][] trips, int capacity) {
        TreeMap<Integer,Integer> treeMap = new TreeMap<>();
        for(int[]t : trips)
        {
            treeMap.merge(t[1],-t[0],Integer::sum);
            treeMap.merge(t[2],t[0],Integer::sum);
        }
        int s = 0;
        for(int i : treeMap.values())
        {
            s +=i;
            if(s > capacity) return false;
        }
        return true;
    }
}
