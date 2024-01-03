package 常用算法模板;

public class Q求最大公约数 {
    public static int gcd(int a, int b) {// 辗转相除法
        int c = a % b;   //先将a对b取余
        while (c != 0) {   //当余数不等于0时,一直进行循环,直到余数等于0,公约数就为b
            a = b;         //将a对b的余数再对b取余,直到循环结束
            b = c;
            c = a % b;
        }
        return b;
    }
    public static int gcd1(int a, int b)
    {
        return (a % b == 0) ? b : gcd(b, a%b );
    }
    public static void main(String[] args) {
        System.out.println(gcd1(45, 6));
    }
}
