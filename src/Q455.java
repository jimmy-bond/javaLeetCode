import java.util.Arrays;

public class Q455 {
    //分饼干
    public static void main(String[] args) {
      int[]  g =
              {1,2,3};
       int [] s =
               {1,1};
        System.out.println(findContentChildren(g, s));
    }
    public static int findContentChildren(int[] g, int[] s) {
        int count=0;
        if(s.length==0) return 0;
        Arrays.sort(g);
        Arrays.sort(s);
        for (int i=0, j=0; i < g.length&&j<s.length; i++,j++) {
            while (j<s.length&&g[i]>s[j]){
                j++;
            }//一定要先判断j是否超出范围，否则会出现s[j]访问越界的问题。
            if(j<s.length){
                count++;
            }
        }
        return count;
    }

}
