package 人工智能原理实验;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
//前期问题主要是对以创造数组的重复操作

public class 八数码dfs有限度实验 {
    static   int max;
    static HashSet<Integer> set = new HashSet<>();
    static List<int[][]> list = new ArrayList<>();
    static int[][]pos = {{-1,0},{1,0},{0,1},{0,-1}};//上， 下， 右，左
    //寻找空格的x位置和y位置
    public static int findspacex(int[][]puzzle){
        //找到空格位置
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++)
            {
                if(puzzle[i][j] == 0)
                {
                   return i;
                }
            }
        }
        return -1;
    }
    public static int findspacey(int[][]puzzle){
        //找到空格位置
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++)
            {
                if(puzzle[i][j] == 0)
                {
                    return j;
                }
            }
        }
        return -1;
    }

    public static int[][] copy(int[][]src){
        int[][]a = new int[3][3];
        for (int i = 0; i < 3; i++) {
            System.arraycopy(src[i], 0, a[i], 0, 3);
        }
        return a;
    }

    public static int dfs(int[][] puzzle, int[][] aim,int n)
    {
        int x = 0, y = 0;
        //到达最大层次,返回
        if(n == max  ) return -1;

        if( change(puzzle) == change(aim)  ) return 1; //拼图成功或者到达最大搜索层数

        //遍历四个方向
        for(int i =0 ; i < 4; i++)
        {
            int x0 = findspacex(puzzle), y0  =findspacey(puzzle);//空格位置
            x = x0+ pos[i][0];
            y = y0+ pos[i][1];
            if(x < 0 || x >= 3 || y <0 || y >= 3) continue;//遇到边界问题不探索

            //赋值给新数组，否则无法保存过程状态，这里是遍历过程中保存的必要性，否则可能重复修改同一个数组
            int[][] a = new int[3][3];
            a = copy(puzzle);
            int temp = a[x][y];
            a[x][y] = a[x0][y0];
            a[x0][y0] = temp;
            //原先只加puzzle，没有创建新的数组，导致结果一样
            if(set.contains(change(a))) continue;
            set.add(change(a));
            list.add(a);//加入队列
            if(dfs(a,aim,n+1) == 1) return 1 ;
            list.remove(list.size()-1);//回溯删除
            set.remove(change(a));

        }
        return -1;
    }
    public static int change(int[][] a)
    {

        int ans = 0;
        for(int i = 0; i < 3; i++)
            for(int j = 0; j < 3; j++)
            {
                ans += ans *10 + a[i][j];

            }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        Scanner sc = new Scanner(System.in);
        int[][] puzzle = new int[3][3];
        int[][] aim = new int[3][3];
        System.out.println("输入开始状态");
        for(int i = 0; i < 3; i++)
            for(int j = 0; j < 3; j++)
            {
                int a = sc.nextInt();
                puzzle[i][j] = a;
            }
        list.add(puzzle);
        System.out.println("输入目标状态");
        for(int i = 0; i < 3; i++)
            for(int j = 0; j < 3; j++)
            {
                aim[i][j] = sc.nextInt();
            }
        System.out.println("输入最大搜索层次");
        max = sc.nextInt();
        set.add(change(puzzle));
        int ans = dfs(puzzle, aim, 0);
        if(ans == 1){
            System.out.println("以下为解的过程，共有"+list.size()+"步");
            for (int i = 0; i < list.size(); i++) {
                System.out.println("===================");
                for(int i1 = 0; i1 < 3; i1++){
                    for(int j = 0; j < 3; j++)
                    {
                        System.out.print(list.get(i)[i1][j] + " ");
                    }
                    System.out.println();
                }
            }
        }
        else {
            System.out.println("无解");
        }
    }

}