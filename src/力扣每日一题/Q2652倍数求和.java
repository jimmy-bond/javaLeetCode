package 力扣每日一题;
//容斥原理
//A U B U C -(A ^ C)-(A ^ B) -(B ^ C) + A^B^C
 class Q2652 {
    public int sumOfMultiples(int n) {
        return f(n,3)+f(n,5)+f(n,7) - f(n,15) - f(n,21) - f(n,35) + f(n,3*5*7);
    }
    public int f(int n, int m)
    {
        return ((n/m)*(m +( n/m * m)))/2;
    }

}
