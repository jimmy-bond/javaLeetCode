package 栈与队列;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
        示例 1:
        输入: nums = [1,1,1,2,2,3], k = 2
        输出: [1,2]
        示例 2:
        输入: nums = [1], k = 1
        输出: [1]*/
class Solution11{
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[k];
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // 构建小顶堆
        PriorityQueue<Map.Entry<Integer, Integer>> priorityQueue = new PriorityQueue<>((e1, e2) -> {
            return e1.getValue() - e2.getValue();
        });

        for (Map.Entry entry : map.entrySet()) {
            priorityQueue.offer(entry);
            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }

        for (int i = k - 1; i >= 0; i--) {
            res[i] = priorityQueue.poll().getKey();
        }

        return res;
    }
}