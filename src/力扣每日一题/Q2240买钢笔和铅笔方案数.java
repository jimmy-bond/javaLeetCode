package 力扣每日一题;

class Q2240 {
    public static void main(String[] args) {
        System.out.println(waysToBuyPensPencils(10, 99, 9));
    }
    public  static  long waysToBuyPensPencils(int total, int cost1, int cost2) {
        if(cost1 > total && cost2 > total) return 1;
        long count = 0;
        count = total/cost2 + 1;
        for(int i = 1; i <= total/cost1; i++)
        {
            int res = total - i *cost1;

            count += res/cost2 + 1;
        }
        return count;
    }


}
