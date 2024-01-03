package 图的并查集;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class UnionFind {
    private final int[] p;
    private final int[] size;
    //初始化过程
    public UnionFind(int n) {
        p = new int[n];
        size = new int[n];
        for (int i = 0; i < n; ++i) {
            //每个数的根为自己
            p[i] = i;
            size[i] = 1;
        }
    }
    //查找根过程，这里还实现了压缩路径
    public int find(int x) {
        if (p[x] != x) {
            p[x] = find(p[x]);
        }
        return p[x];
    //类似于
        //return  x==p[x] ? x : p[x]=find(p[x]);
    }
    //连接过程
    public boolean union(int a, int b) {
        //根相同
        int pa = find(a), pb = find(b);

        if (pa == pb) {
            return false;
        }
      /*  //rank秩序合并
        if (size[pa] > size[pb]) {
            p[pb] = pa;
            size[pa] += size[pb];
        } else {
            p[pa] = pb;
            size[pb] += size[pa];
        }*/
        p[pb]  = pa;

        return true;
    }
    //判断是否在同一个集合里面
    public boolean connected(int a, int b) {
        return find(a) == find(b);
    }
}

 public class Q1631最小体力消耗路径 {


    public int minimumEffortPath(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        //共有m*n个点
        UnionFind uf = new UnionFind(m * n);

        List<int[]> edges = new ArrayList<>();
        int[] dirs = {1, 0, 1};
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                for (int k = 0; k < 2; ++k) {
                    int x = i + dirs[k], y = j + dirs[k + 1];
                    if (x >= 0 && x < m && y >= 0 && y < n) {
                        int d = Math.abs(heights[i][j] - heights[x][y]);
                        //这里就是第几行加第几个
                        edges.add(new int[] {d, i * n + j, x * n + y});
                    }
                }
            }
        }
        Collections.sort(edges, (a, b) -> a[0] - b[0]);
        for (int[] e : edges) {
            uf.union(e[1], e[2]);
            if (uf.connected(0, m * n - 1)) {
                return e[0];
            }
        }
        return 0;
    }
    @Test
    public void kk()
    {
        System.out.println(minimumEffortPath(new int[][]{{1, 2, 2}, {3, 6, 2}, {5, 3, 5}}));
    }
}


