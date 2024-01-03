package 人工智能原理实验;

import com.sun.media.sound.SoftTuning;

import java.util.*;


public class bfs {
    static HashSet<Integer> set = new HashSet<>();
    static int[][]pos = {{-1,0},{1,0},{0,1},{0,-1}};//上， 下， 右，左
    //寻找空格的x位置和y位置
    //来匹配他们的父亲
    static Map<Integer,Integer> map = new HashMap<>();
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
    public static int change(int[][] a) {

        int ans = 0;
        for(int i = 0; i < 3; i++)
            for(int j = 0; j < 3; j++)
            {
                ans = ans *10 + a[i][j];

            }
        return ans;
    }
    public static int[][] copy(int[][]src){
        int[][]a = new int[3][3];
        for (int i = 0; i < 3; i++) {
            System.arraycopy(src[i], 0, a[i], 0, 3);
        }
        return a;
    }
    public static int bfs(int[][]puzzle, int[][]aim) {
        Queue<int[][]> queue = new ArrayDeque<>();
        queue.add(puzzle);
        int x =0,y = 0;
        while(!queue.isEmpty())
        {
            int[][]t= copy(queue.poll());
            if(change(t) == change(aim)) return 1;
            //遍历四个方向
            for(int i =0 ; i < 4; i++)
            {
                int x0 = findspacex(t), y0  =findspacey(t);//空格位置
                x = x0+ pos[i][0];
                y = y0+ pos[i][1];
                if(x < 0 || x >= 3 || y <0 || y >= 3) continue;//遇到边界问题不探索
                int[][] a = new int[3][3];
                a = copy(t);
                int temp = a[x][y];
                a[x][y] = a[x0][y0];
                a[x0][y0] = temp;
                if(set.contains(change(a))) continue;
                map.put(change(a),change(t));
                queue.add(a);
                set.add(change(a));
            }
        }
        return -1;
    }
    public static void back(int t){
        //还原数组
        int[][]a = new int[3][3];
       for(int i = 2; i >= 0; i--)
       {
           for(int j = 2; j >= 0; j--)
           {
               a[i][j] = t %10;
               t /= 10;
           }
       }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("================");
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

            set.add(change(puzzle));
        System.out.println("输入目标状态");
        for(int i = 0; i < 3; i++)
            for(int j = 0; j < 3; j++)
            {
                aim[i][j] = sc.nextInt();
            }

        int ans = bfs(puzzle, aim);
        if(ans == 1){
            System.out.println("有解");
            //这里用来还原bfs的father
            int t = change(aim);
            Stack<Integer> stack = new Stack<>();
            stack.add(t);
            while(map.containsKey(t)){
                t = map.get(t);
                stack.add(t);
            }
            while (!stack.isEmpty()){
                back(stack.pop());
            }

         /*   System.out.println("以下为解的过程，共有"+list.size()+"步");
            for (int i = 0; i < list.size(); i++) {
                System.out.println("===================");
                for(int i1 = 0; i1 < 3; i1++){
                    for(int j = 0; j < 3; j++)
                    {
                        System.out.print(list.get(i)[i1][j] + " ");
                    }
                    System.out.println();
                }
            }*/
        }
        else {
            System.out.println("无解");
        }
    }
}