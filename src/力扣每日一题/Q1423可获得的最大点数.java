package 力扣每日一题;

public class Q1423可获得的最大点数 {
    public int maxScore(int[] cardPoints, int k) {
        int ans = 0;
        int n = cardPoints.length;
        int m = n -k;
        for(int i= 0; i < m; i++)
        {
            ans += cardPoints[i];
        }
        int total = ans, min = ans;
        for(int i = m; i < cardPoints.length; i++)
        {
            total += cardPoints[i];
            ans += cardPoints[i] - cardPoints[i-m];
            min = Math.min(min,ans);
        }
        return total - min;
    }

}
