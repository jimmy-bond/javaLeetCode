package 力扣每日一题;

import java.util.Scanner;

 class 空汽水瓶换汽水 {
    static int ans = 0;
    static  int borrow = 1;
    public static void main(String[] args) {
        System.out.println(change(59));
        Scanner sc = new Scanner(System.in);
        System.out.println('a' );
    }
   public static int change(int num)
    {
        while(num >= 2) {
            if(num == 2)
            {
                num +=borrow;
                borrow = 0;
            }
            ans += num / 3;
            num = num / 3 + num % 3;
        }
        return  ans;
    }
    public  static  void delete(){

    }
    public static  void translate(String s)
    {
        int ans = 0;
        for (int i = 2; i < s.length(); i++)
        {

        }
    }

}
