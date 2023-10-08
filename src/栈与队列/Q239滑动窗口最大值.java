package 栈与队列;

import java.util.*;

//单调队列
/*给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
        返回 滑动窗口中的最大值 。*/
/*输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
        输出：[3,3,5,5,6,7]
        解释：
        滑动窗口的位置                最大值
        ---------------               -----
        [1  3  -1] -3  5  3  6  7       3
        1 [3  -1  -3] 5  3  6  7       3
        1  3 [-1  -3  5] 3  6  7       5
        1  3  -1 [-3  5  3] 6  7       5
        1  3  -1  -3 [5  3  6] 7       6
        1  3  -1  -3  5 [3  6  7]      7*/
class myqueue{
    Deque<Integer> deque = new LinkedList<>();
    void poll(int val)
    {
        if(!deque.isEmpty() && val== deque.peek())
        {
            deque.poll();
        }
    }
    void add(int val)
    {
        while(!deque.isEmpty() && val > deque.getLast())
        {
            deque.removeLast();
        }
        deque.add(val);

    }

    int peek(){
        return deque.peek();
    }

}
class biggest {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 1) {
            return nums;
        }
        int len = nums.length - k + 1;
        //存放结果元素的数组
        int[] res = new int[len];
        int num = 0;
        //自定义队列
        myqueue myQueue = new myqueue();
        //先将前k的元素放入队列
        for (int i = 0; i < k; i++) {
            myQueue.add(nums[i]);
        }
        res[num++] = myQueue.peek();
        for (int i = k; i < nums.length; i++) {
            //滑动窗口移除最前面的元素，移除是判断该元素是否放入队列
            myQueue.poll(nums[i - k]);
            //滑动窗口加入最后面的元素
            myQueue.add(nums[i]);
            //记录对应的最大值
            res[num++] = myQueue.peek();
        }
        return res;
    }
}