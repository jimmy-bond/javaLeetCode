package 贪心算法;
import java.util.Arrays;
import java.util.Comparator;



//自定义sort的比较器,好像对一维int数组没有比较器的设定
/* String[] s = {"111","222","333"};
         Arrays.sort(s, new Comparator<String>() {
             @Override
             public int compare(String o1, String o2) {
                 return o1.length() - o2.length();
             }
         });*/
class Q1005 {
     public int largestSumAfterKNegations(int[] nums, int k) {



      Arrays.sort(nums);
       int sum = 0;
       for(int i = 0; i < nums.length; i++)
       {
           while(k > 0 && i <nums.length&& nums[i] < 0)
           {
               nums[i] = -nums[i];
               sum += nums[i];
               i++;
               k--;
           }
           sum += nums[i];
       }
       if(k > 0 && k%2 !=0 )
       {
           Arrays.sort(nums);
           sum -= 2*nums[0];
       }

       return sum;
     }
}
