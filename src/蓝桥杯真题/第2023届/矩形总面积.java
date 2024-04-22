package 蓝桥杯真题.第2023届;

import java.util.Scanner;

public class 矩形总面积 {
    public static void main(String[] args) {
        double a = 5.2314;
        System.out.printf("%.2f",a);
        Scanner scanner = new Scanner(System.in);
        int ay2 = 0;
        int ax2 = 0;
        int bx2 = 0;
        int ax1 = 0;
        int by2 = 0;
        int ay1 = 0;
        int by1 = 0;
        int bx1 = 0;
        while (scanner.hasNext()) {
             ax1 = scanner.nextInt();
             ay1 = scanner.nextInt();
             ax2 = scanner.nextInt();
             ay2 = scanner.nextInt();
             bx1 = scanner.nextInt();
             by1 = scanner.nextInt();
             bx2 = scanner.nextInt();
             by2 = scanner.nextInt();
        }
        int x = Math.max(0,(Math.min(ax2,bx2)-Math.max(ax1,bx1)));
        int y = Math.max(0,(Math.min(ay2,by2) - Math.max(ay1,by1)));
        System.out.println( ((long) (ax2 - ax1) * (ay2 - ay1)) +  ((long)(bx2-bx1) * (by2- by1)) -  ((long)x*y));
    }
}
