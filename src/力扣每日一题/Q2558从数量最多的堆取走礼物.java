package 力扣每日一题;
//实现堆的模板
/*int[] heap = new int[10010];
        int sz = 0;
        void swap(int a, int b) {
        int c = heap[a];
        heap[a] = heap[b];
        heap[b] = c;
        }
        void up(int u) {
        // 将「当前节点 i」与「父节点 i / 2」进行比较, 若父节点值更大, 则进行交换
        int fa = u / 2;
        if (fa != 0 && heap[fa] > heap[u]) {
        swap(fa, u);
        up(fa);
        }
        }
        void down(int u) {
        // 将当「前节点 cur」与「左节点 l」及「右节点 r」进行比较, 找出最小值, 若当前节点不是最小值, 则进行交换
        int cur = u;
        int l = u * 2, r = u * 2 + 1;
        if (l <= sz && heap[l] < heap[cur]) cur = l;
        if (r <= sz && heap[r] < heap[cur]) cur = r;
        if (cur != u) {
        swap(cur, u);
        down(cur);
        }
        }
        void add(int x) {
        heap[++sz] = x;
        up(sz);
        }
        int peek() {
        return heap[1];
        }
        int pop() {
        int ans = peek();
        heap[1] = heap[sz--];
        down(1);
        return ans;
        }*/

public class Q2558从数量最多的堆取走礼物 {
    //使用堆的数据结构可以从一堆数中快速找到最值
    //维护一些数的最大值，可以用最大值模拟
    //堆是数据实现的，但其形态为完全二叉树
    //堆的规定，在数组位置中 当前节点为index，左节点则为2*index，右节点为2*index+1
    int[]heap = new int[10010];
    int sz =0;

    public long pickGifts(int[] gifts, int k) {
        for (int x : gifts) add(-x);
        while (k-- > 0) add(-(int)Math.sqrt(-pop()));
        long ans = 0;
        while (sz != 0) ans += -heap[sz--];  // 没必要再维持堆的有序, 直接读取累加
        return ans;


    }

    void swap(int a, int b)
    {
        int c = heap[a];
        heap[a] = heap[b];
        heap[b] = c;
    }

    void up(int u)
    {
        //这是小根堆
        //将当前节点和父节点进行比较，如果父节点值更大，则进行交换
        int fa = u/2;
        if(fa != 0 && heap[fa] > heap[u])
        {
            swap(fa,u);
            up(fa);//一直递归上去变换数值
        }
    }

    void down(int u)
    {
        int cur = u;
        int l = 2 * u;
        int r = 2 * u + 1;
        if(l <= sz && heap[l]<heap[cur]) cur = l;
        if(r <= sz && heap[r] < heap[cur]) cur = r;
        if(cur != u)
        {
            swap(cur,u);
            down(cur);
        }
    }

    void add(int x)
    {
        heap[++sz] = x;
        up(sz);
    }

    int peek()
    {
        return heap[1];
    }

    int pop()
    {
        int ans  = peek();
        heap[1] = heap[sz--];
        down(1);
        return ans;
    }

}
