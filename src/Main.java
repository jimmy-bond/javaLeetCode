import org.testng.annotations.Test;

import java.lang.reflect.Field;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
public class Main {
  static   int max;
  static HashSet<int[][]> set = new HashSet<>();
  static   List<int[][]> list = new ArrayList<>();
   static int[][]pos = {{-1,0},{1,0},{0,1},{0,-1}};//上， 下， 右，左
    public static int dfs(int[][] puzzle, int[][] aim,int n)
    {
        int x = 0, y = 0;
        //到达最大层次,返回
        if(n == max || set.contains(change(puzzle)) ) return -1;

        if( change(puzzle) == change(aim)  ) return 1; //拼图成功或者到达最大搜索层数

        //找到空格位置
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++)
            {
                if(puzzle[i][j] == 0)
                {
                    x = i;
                    y = j;
                }
            }
        }
//赋值给新数组，否则无法保存过程状态
        int[][] a = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                a[i][j] = puzzle[i][j];
            }
        }
        //遍历四个方向
            for(int i =0 ; i < 4; i++)
            {
                int x0 = x, y0  = y;//空格位置
                x += pos[i][0];
                y += pos[i][1];
                if(x < 0 || x >= 3 || y <0 || y >= 3) {
                    //把x，y恢复原样
                    x  = x0;
                  y = y0;
                    continue;//遇到边界问题不探索
                }

                int temp = a[x][y];
               a[x][y] = a[x0][y0];
               a[x0][y0] = temp;
                //原先只加puzzle，没有创建新的数组，导致结果一样
                list.add(a);//加入队列
               if(dfs(a,aim,n+1) == 1) return 1 ;
                list.remove(list.size()-1);//回溯删除
                //回归原始状态，把原先打乱的状态恢复到正常
                int t= a[x0][y0];
                a[x0][y0] = a[x][y];
                a[x][y] = t;

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
  /*  @Test
    public  void kk() {

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
        System.out.println("输入目标状态");
        for(int i = 0; i < 3; i++)
            for(int j = 0; j < 3; j++)
            {
                aim[i][j] = sc.nextInt();
            }
        System.out.println("输入最大搜索层次");
        max = sc.nextInt();
        dfs(puzzle,aim,0);
        if(!list.isEmpty()){
            System.out.println(1);
        }
        else {
            System.out.println("无解");
        }
    }*/
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
      int ans = dfs(puzzle, aim, 0);

      if(ans == 1){
          System.out.println("以下为解的过程");
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