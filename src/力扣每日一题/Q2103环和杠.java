package 力扣每日一题;

public class Q2103环和杠 {
    public int countPoints(String rings) {
        int ans = 0;
        int[] count = new int[10];
        for (int i = 0; i < rings.length(); i+=2) {
            char a = rings.charAt(i);
            char b = rings.charAt(i + 1);
            if(a - 'R' == 0) count[b - '0'] |= 1;
            if(a - 'G' == 0) count[b - '0'] |= 2;
            if(a -  'B' == 0) count[b - '0'] |= 4;
        }
        for( int i : count)
        {
            if( i == 7) ans++;
        }
        return ans;
    }
}
