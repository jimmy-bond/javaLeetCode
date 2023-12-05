package 贪心算法;
import java.util.Arrays;
import java.util.LinkedList;
class Q406 {
    //这种问题有两个维度要思考，所以对这个的解决方法应该是确定一个维度再根据另一个维度来规划
    //否则可能会顾此失彼，两个变量都无法照顾到
    //先排好身高，然后再根据int[][1]的值来选择插入的顺序
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people,(a,b)->{
            if(a[0] == b[0]) return a[1] - b[1];
            return b[0] - a[0];
        });
        LinkedList<int[]> list = new LinkedList<>();

        for(int[] ans : people)
        {
            list.add(ans[1],ans);
        }
        return list.toArray(new int[list.size()][]);


    }
}
