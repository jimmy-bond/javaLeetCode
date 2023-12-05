package 贪心算法;

import java.util.*;

class Q860 {

    public  boolean lemonadeChange(int[] bills) {
        //更加简洁，不一定每次要用数组去存储我们的数据
        int five = 0;
        int ten = 0;

        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                five++;
            } else if (bills[i] == 10) {
                five--;
                ten++;
            } else if (bills[i] == 20) {
                if (ten > 0) {
                    ten--;
                    five--;
                } else {
                    five -= 3;
                }
            }
            if (five < 0 || ten < 0) return false;
        }

        return true;
    }
}
