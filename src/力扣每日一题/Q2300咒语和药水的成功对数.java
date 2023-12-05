package 力扣每日一题;

import sun.java2d.pipe.AAShapePipe;

import java.util.Arrays;

public class Q2300咒语和药水的成功对数 {
    public static void main(String[] args) {
        successfulPairs(new int[]{3,1,2},new int[]{8,5,8},16);
    }
    public static int[] successfulPairs(int[] spells, int[] potions, long success) {
        int[]cnt = new int[spells.length];
      Arrays.sort(potions);
      for(int i = 0; i < spells.length; i++)
      {
          int l = 0; int r = potions.length - 1;
          while(l <= r){
              int m = (l+r)/2;
              if((long)spells[i] * potions[m] >= success){
                  r = m - 1;
              }
              else {
                  l = m+1 ;
              }
          }
        cnt[i] = potions.length - 1 - r;
      }

          return cnt;
    }
}
