package 字符串;
/*编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。

不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。*/

public class 反转字符串 {
    public static void main(String[] args) {

    }
    public void reverseString(char[] s) {
        int head =0;
        int tail = s.length -1;
        while(tail > head)
        {
            char temp = ' ';
            temp = s[head];
            s[head] = s[tail];
            s[tail] = temp;
            tail--;
            head++;

        }

    }
}

