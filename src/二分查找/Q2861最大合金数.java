package 二分查找;

import java.util.Collections;
import java.util.List;

public class Q2861最大合金数 {
    public int maxNumberOfAlloys(int n, int k, int budget, List<List<Integer>> composition, List<Integer> Stock, List<Integer> Cost) {
        int ans = 0;//下界
        int mx = Collections.min(Stock) + budget;//上界
        int[] stock = Stock.stream().mapToInt(i -> i).toArray();
        int[] cost = Cost.stream().mapToInt( i -> i).toArray();
        for(List<Integer> Comp : composition){
            int[] comp = Comp.stream().mapToInt(i -> i).toArray();
            int left = ans, right = mx + 1; // 上界加一
            while(left + 1 < right){//开区间
                int mid = left + (right - left) / 2;
                boolean ok = true;
                long money = 0;
                for (int i = 0; i < n; i++) {
                    if (stock[i] < (long) comp[i] * mid) {
                        money += ((long) comp[i] * mid - stock[i]) * cost[i];
                        if (money > budget) {
                            ok = false;
                            break;
                        }
                    }
                    if (ok) {
                        left = mid;
                    } else {
                        right = mid;
                    }
                }
                ans = left;

                }
            }
        return ans;
        }
        }

