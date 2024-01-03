package 人工智能原理实验;

import javax.swing.*;
import java.util.Scanner;

public class animal {
   static String[] features = {"1.有毛", "2.产奶", "3.有羽毛", "4.会飞", "5.会下蛋", "6.吃肉", "7.有犬齿", "8 有爪", "9 眼睛盯前方", " 10 有蹄",
            "11反刍", "12黄褐色", "13有斑点", "14有黑色条纹", "15长脖", "16长腿", "17不会飞", "18会游泳", "19黑白两色", "20善飞"};
    private static String input = "";
    private static int[] conditions;
    private static RuleRepository ruleRepository;

     public static void parse() {
         input = "";
        System.out.println("输入动物特征，输入-1代表输入结束");
        for(String i : features)
        {
            System.out.print(i+" ");
        }
         System.out.println();
         Scanner sc = new Scanner(System.in);
         while (sc.hasNext()) {
            int a = sc.nextInt();
            if(a == -1) break;
            input += a;
            input += " ";
            }
                // 转化为数组，按空格分割
                String[] inputs = input.split("\\s+");
                conditions = new int[inputs.length];
                for(int i = 0; i < inputs.length; i++) {
                    conditions[i] = Integer.parseInt(inputs[i]);
                }
                ruleRepository = new RuleRepository(conditions);
                String res = ruleRepository.reasoning();
        System.out.println(res);
                String animalString = ruleRepository.getAnimals();
                String[] animals = animalString.split("\\s+");
                for(int i = 0; i < animals.length; i++){
                    if(animals[i].contentEquals("")) continue;
                    int pic = Integer.parseInt(animals[i]) - 24;

                }
            }


    public static void main(String[] args) {
       parse();
    }

}