package 栈与队列;

import java.io.CharArrayReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

//把后缀表达式转化为正常的计算表达式，也就是中缀表达式，把运算符号放在表达式子当中
//例子 5 * 8 + 3 = 5 8 * 3 +
//用栈来解决，遇到数字便压栈，并把结果放回栈中，遇到运算符号就把前两个出栈
class solution {

    public  int evalRPN(String[] tokens) {
        Deque<Integer> stack = new LinkedList();
        for (String s : tokens) {
            if ("+".equals(s)) {        // leetcode 内置jdk的问题，不能使用==判断字符串是否相等
                stack.push(stack.pop() + stack.pop());      // 注意 - 和/ 需要特殊处理
            } else if ("-".equals(s)) {
                stack.push(-stack.pop() + stack.pop());
            } else if ("*".equals(s)) {
                stack.push(stack.pop() * stack.pop());
            } else if ("/".equals(s)) {
                int temp1 = stack.pop();
                int temp2 = stack.pop();
                stack.push(temp2 / temp1);
            } else {
                stack.push(Integer.valueOf(s));
            }
        }
        return stack.pop();
    }


}
