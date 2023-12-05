package 贪心算法;

import java.lang.management.ManagementFactory;
import java.util.Arrays;

class Q452 {
     public int findMinArrowShots(int[][] points) {
          /* Arrays.sort(points,(o1,o2)->{
             if(o1[0] == o2[0]) return o1[1] - o2[1];
             return o1[0] - o2[0];
         });*/
         //使用integer的内置方法，防止溢出，为什么呢？
         //因为Integer.compare（x,y)
         //x , y 不用做加减，只是比较大小，上面的比较
         //x 大 返回1 x小 返回 -1 x相等 返回 0
         Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));
         int count = 1;
         for(int i = 1; i < points.length; i++)
         {
             if(points[i][0] > points[i - 1][1])
                 count ++;
             else{
                 points[i][1] = Math.min(points[i][1],points[i-1][1]);
             }
         }
         return count;
     }
}
