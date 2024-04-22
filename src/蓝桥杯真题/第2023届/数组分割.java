package 蓝桥杯真题.第2023届;

import java.util.PriorityQueue;
import java.util.Scanner;

public class 数组分割 {
   static int INF=1000000007;

   private static long pim(long b) {
        if (b == -1) return 1;
        long t = 2, res = 1;
        while (b != 0) {
            if ((b & 1) == 1) res = res * t % INF;
            t = t * t % INF;
            b >>= 1;
        }
        return res % INF;
    }
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[]ans = new int[N];
        int index = 0;
        while(N>0){
            N--;
            int len = scanner.nextInt();
            //r为偶数，l为奇数
            int r = 0, l =0;

            for (int i = 0; i < len; i++) {
                if(scanner.nextInt() % 2 == 0) r++;
                else l++;
            }
            long res = 0;
            if(l%2 == 0){
               res = pim(r) * pim(l == 0 ? 0 : l - 1) % INF;
            }
            ans[index] = (int) res;
            index++;
        }
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
        }
    }
}
