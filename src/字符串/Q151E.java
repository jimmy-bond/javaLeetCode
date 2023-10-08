package 字符串;
import org.testng.annotations.Test;
public class Q151E {
/*给你一个字符串 s ，请你反转字符串中 单词 的顺序。

单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。

返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。

注意：输入字符串 s中可能会存在前导空格、尾随空格或者单词间的多个空格。返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。*/
        // 输入：s = "the sky is blue"
        //  输出："blue is sky the"
        //1.先清除多余的空格
        //2. 将字符串反转
        //3.再将单词倒序相加

        public  static String reverseWords(String s)
        {
            //1. 消除多余空格
            //2.反转字符串
            //3.再将单词逐个反转便行
            StringBuilder sb = removespace(s);
            sb.reverse();
            return  sb.toString();
        }
        public static StringBuilder removespace(String s)
        {
            StringBuilder sb = new StringBuilder();
            int fastindex = 0;
            while (s.charAt(fastindex) == ' ') fastindex++;
            while (fastindex < s.length()){
                if(s.charAt(fastindex) == ' ' && s.charAt(fastindex) == s.charAt(fastindex - 1) ){
                    fastindex++;
                    continue;
                }
                sb.append(s.charAt(fastindex));
                fastindex++;
            }
            if(sb.charAt(sb.length()-1) == ' '){
                sb.deleteCharAt(sb.length() -1);
            }
            return  sb;
        }
        public  static  StringBuilder reverseword(StringBuilder sb){
            return null;
        }

    public static void main(String[] args) {
        String s = "    the  sky  is  blue   ";
        System.out.println(reverseWords(s));
    }
    }




