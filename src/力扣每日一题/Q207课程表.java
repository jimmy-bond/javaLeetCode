package 力扣每日一题;

import javax.swing.*;
import java.awt.geom.FlatteningPathIterator;
import java.net.Inet4Address;
import java.util.*;

/*你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
        在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表示如果要学习课程 ai 则 必须 先学习课程  bi 。
        例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
        请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
        示例 1：
        输入：numCourses = 2, prerequisites = [[1,0]]
        输出：true
        解释：总共有 2 门课程。学习课程 1 之前，你需要完成课程 0 。这是可能的。
        示例 2：
        输入：numCourses = 2, prerequisites = [[1,0],[0,1]]
        输出：false
        解释：总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0 ；并且学习课程 0 之前，你还应先完成课程 1 。这是不可能的。
        看能否构建一个有向无环图
        拓扑排序判断是否是有向无环图
        图的存储结构可以表示为邻接表或者邻接矩阵
        */
class Q207 {

     public boolean canFinish(int numCourses, int[][] prerequisites)
     {
         int[] flags = new int[numCourses];
         Arrays.fill(flags,0);
         //邻接表
         List<List<Integer>> list = new ArrayList<>();
         //这里每个邻接表都添加一个空的头节点，防止后续的遍历越界
         for(int i =0; i < numCourses; i++)
             list.add(new ArrayList<>());
         //这里是给邻接表赋值
         for(int[] a : prerequisites)
         {
             list.get(a[1]).add(a[0]);
         }
         //遍历邻接表
         for(int i = 0; i< numCourses; i++)
             if(!dfs(list,flags,i)) return false;
         return true;
     }
    public boolean dfs(List<List<Integer>> list,int[]flags,int index)
    {
        if(flags[index] == 1) return false;
        if(flags[index] == -1) return true;
        flags[index] = 1;
        for(Integer  a : list.get(index))
        {
            if(!dfs(list,flags,a)) return false;
        }
        flags[index] = -1;
        //全部遍历完则返回true值
        return true;
    }
     }

