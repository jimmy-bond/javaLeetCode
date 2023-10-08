package 字符串;

public class Q58左旋转字符串 {
    /*字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。
    比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。

    输入: s = "abcdefg", k = 2
输出: "cdefgab"

进阶版：应该在本字符串上操作不应该申请额外空间。
//可以采用局部反转再整部反转也可达到效果
    */
    public String reverseLeftWords(String s, int n)
    {
        //懒狗版本：
       /* StringBuilder sb = new StringBuilder();
        sb.append(s.substring(n,s.length()));
        sb.append(s.substring(0,n));
        return  sb.toString();*/

            char[] chars = s.toCharArray();
            reverse(chars, 0, chars.length - 1);
            reverse(chars, 0, chars.length - 1 - n);
            reverse(chars, chars.length - n, chars.length - 1);
            return new String(chars);


    }

    public void reverse(char[] chars, int left, int right) {
        while (left < right) {
            chars[left] ^= chars[right];
            chars[right] ^= chars[left];
            chars[left] ^= chars[right];
            left++;
            right--;
        }

    }
}
