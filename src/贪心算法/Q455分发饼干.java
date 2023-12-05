package 贪心算法;
import java.util.Arrays;
class Q455 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int ans = 0;
        for(int i =0,j=0;i<g.length && j <s.length; )
        {
            if(g[i] <= s[j]){
                ans ++;
                i++;
                j++;
            }
            else{
                j++;
            }
        }
        return ans;
    }

}
