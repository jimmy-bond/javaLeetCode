package 力扣每日一题;

import org.testng.annotations.Test;

import java.util.*;

public class Q1466重新规划路线 {
    @Test
    public void kk()
    {
        minReorder(6,new int[][]{{1,0},{1,2},{3,2},{3,4}});
    }
    public int minReorder(int n, int[][] connections) {
        // 生成树结构，tree[i]中的每个元素表示{节点i的邻节点，是否由节点i指向邻节点}
        List<List<int[]>> tree = new ArrayList<>();
        for(int i = 0; i < n; i++){
            tree.add(new ArrayList<>());
        }
        for(int[] con: connections){
            tree.get(con[0]).add(new int[]{con[1], 1});    // con[0] 指向 con[1]，标记为1
            tree.get(con[1]).add(new int[]{con[0], 0});    // con[1] 不指向 con[0]，标记为0
        }
        // 广度优先搜索
        boolean[] visited = new boolean[n];    // visited[i] 表示节点i 是否已经处理
        Queue<Integer> queue = new LinkedList<>();          // BFS使用的队列
        queue.offer(0);          // 从0节点开始遍历
        visited[0] = true;
        int res = 0;
        while (!queue.isEmpty())
        {
            int node = queue.poll();      // 获取队首节点
            for(int[] neighbor: tree.get(node)){
                // 枚举节点node的所有邻节点
                if(visited[neighbor[0]])continue;    // 跳过处理过的节点
                visited[neighbor[0]] = true;         // 标记邻节点已处理
                queue.offer(neighbor[0]);         // 邻节点入队
                if(neighbor[1] == 1)res += 1;            // 如果由当前节点指向邻节点，需要反向
            }
        }
        return res;
    }


}
