package 力扣每日一题;
//位运算，
//用字母的第二十六位是否相等来判断字符串是否有相同的字母
public class Q318最大长度单词乘积
{
    public int maxProduct(String[] words)
    {
     int ans  = 0;
     int index = 0;
     int[]array = new int[words.length];
     for(String s : words)
     {
         int t = 0;
         for (int i = 0; i < s.length(); i++) {
             int a = s.charAt(i) - 'a';
             t |=(1<<a);
         }
         array[index++] = t;
     }

        for (int i = 0; i < array.length; i++) {
                for(int j = 0; j < i; j++)
                {
                    if((array[i] & array[j]) == 0) ans = Math.max(ans,words[i].length()*words[j].length());
                }
        }
        return ans;
    }
}
