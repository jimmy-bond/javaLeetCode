package 字符串;
/*给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。

如果剩余字符少于 k 个，则将剩余字符全部反转。
如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。*/
//每隔k个反转k个，后面不够k个的话就全部反转
public class Q541 {
    public String reverseStr(String s, int k) {
        int len = s.length();
        int start ,end;
        char [] c = s.toCharArray();
        for (int i = 0; i < len; i+= 2 * k) {
            start = i;
            end = Math.min(len -1,start + k -1);
            while (end > start){
                char temp = ' ';
                temp = c[start];
                c[start] = c[end];
                c[end] = temp;
                start++;
                end--;
            }
        }
        return new String(c);
    }
}
