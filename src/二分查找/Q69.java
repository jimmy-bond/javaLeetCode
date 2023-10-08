package 二分查找;

import org.testng.annotations.Test;

public class Q69 {
    //算术平方根
    @Test
    public  void  test(){
        System.out.println(mySqrt(2147395599));
    }
    public int mySqrt(int x) {
      //二分查找法
        int left = 0;
        int right = x;
        while (left <= right){
            int mid = (left + right)/ 2;
            if((long)mid * mid == x) return mid;
            if((long)mid * mid <x) left = mid + 1;
            if((long)mid * mid > x) right = mid -1;
        }
        return right;
    }
}
