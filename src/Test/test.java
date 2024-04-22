package Test;


import javafx.scene.transform.Rotate;

import java.util.*;
  class TreeNode {
    int val = 0;
   TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
      this.val = val;
    }
  }
  class ListNode {
   int val;
    ListNode next = null;
    public ListNode(int val) {
     this.val = val;
    }
  }
public class test {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
       Scanner sc = new Scanner(System.in);
       int n = sc.nextInt();
       long ans = 0;
       ans += sc.nextInt();
        System.out.println(ans);

    }
    public TreeNode create (int n) {
        // write code here
        int max = (int) Math.pow(2,n-1);
        int[][]a = new int[n][max];
        if(n == 1) {
            return new TreeNode(1);
        }
        TreeNode root = new TreeNode(0);
        return root;
    }
    public TreeNode dfs(int n,TreeNode root,int top,int max){
        //先判断层数

       return root;
    }

    public static int getMethod (ListNode head, String colors) {
        if(head == null) return 0;
        int ans = 0;
        // write code here
        //判断现在红色节点权值是偶数还是奇数
        long b = 0;
        int len = 0;
        ListNode tmp = head;
        int idx = 0;
        int[]a = new int[100000];
        while(tmp != null){
            int t = tmp.val;
            tmp = tmp.next;
            if(colors.charAt(idx) == 'R'){
                b += t;
                continue;
            }
            a[len++] =t;
        }
        //判断现在数组里面可以凑成奇数或者偶数的组合
        if(b%2 == 0)
        {   ans++;

        }
        else{

        }
        return  ans;


    }
    public static int maxLen (String s, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b)->{return b.compareTo(a);});
        // write code here

        int len = 0;
        char[] chars = s.toCharArray();
        for(char c : chars){
            if(c == '1') len++;
            else {
                if(len != 0) queue.add(len);
                len = 0;
            }
        }
        while(k > 0 && !queue.isEmpty()){
            k--;
            int val = queue.poll();
            val--;
            if(val < 0) return 0;
            queue.add(val);
        }
        if(queue.isEmpty()){
            return 0;
        }
      return queue.poll();
    }
}