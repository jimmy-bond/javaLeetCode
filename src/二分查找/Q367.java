package 二分查找;

public class Q367 {
    //二分查找法
    public boolean isPerfectSquare(int num) {
        boolean flag = false;
        int left = 0;
        int right = num;
        while (left <= right){
            int mid = (left + right)/ 2;
            if((long)mid * mid == num) {
                flag=true;
                return flag;
            }
            if((long)mid * mid <  num) left = mid + 1;
            if((long)mid * mid >  num) right = mid -1;
        }
        if((long)right * right == num) flag =true;
        return flag;
    }
}
