package LeetCodeHot100.子串;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q239滑动窗口最大值 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length < 2) return nums;
        // 双向队列 保存当前窗口最大值的数组位置 保证队列中数组位置的数值按从大到小排序
        LinkedList<Integer> queue = new LinkedList();
        // 结果数组
        int[] result = new int[nums.length-k+1];
        // 遍历nums数组
        for(int i = 0;i < nums.length;i++){
            // 保证从大到小 如果前面数小则需要依次弹出，直至满足要求
            while(!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]){
                queue.pollLast();
            }
            // 添加当前值对应的数组下标
            queue.addLast(i);
            // 判断当前队列中队首的值是否有效
            if(queue.peek() <= i-k){
                queue.poll();
            }
            // 当窗口长度为k时 保存当前窗口中最大值
            if(i+1 >= k){
                result[i+1-k] = nums[queue.peek()];
            }
        }
        return result;
    }
    public int[] maxArray(int[] nums, int k)
    {
        //数组特殊长度
        if(nums == null || nums.length < 2) return nums;

        int[] ans = new int[nums.length - k  + 1];
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            while(!list.isEmpty() && nums[i] > nums[list.peekLast()]){
                list.pollLast();
            }
            list.addLast(i);
            if(list.peek() <= i - k) list.poll();
            if(i+1 >= k) ans[i+1-k] = nums[list.peek()];

        }

        return ans;
    }

}
