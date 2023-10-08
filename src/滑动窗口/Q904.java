package 滑动窗口;

import org.omg.CORBA.RepositoryIdHelper;
import org.testng.annotations.Test;
import sun.awt.datatransfer.DataTransferer;

import java.awt.font.NumericShaper;
import java.util.HashMap;
import java.util.Map;

//水果成篮
//臭波题

public class Q904 {
    @Test
    public void kk() {
        int[] fruits = {0, 1, 6, 6, 4, 4, 6};
        System.out.println(totalFruit(fruits));
    }

    public int totalFruit(int[] fruits) {
        int left = 0, right = 0, length = 0;
        int ln = fruits[left];
        int rn = fruits[right];
        while (right < fruits.length) {
            if (fruits[right] == ln || fruits[right] == rn) {
                length = Math.max(length, right - left + 1);
                right+=1;

            } else {
                left = right - 1;
                ln = fruits[left];
                while (left >= 1 && fruits[left - 1] == ln) {
                    left--;
                }
                rn = fruits[right];
                length = Math.max(length, right - left + 1);
            }
        }
        return length;
    }

}
