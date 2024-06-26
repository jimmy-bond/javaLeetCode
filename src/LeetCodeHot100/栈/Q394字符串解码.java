package LeetCodeHot100.栈;

import java.util.LinkedList;
import java.util.Stack;

public class Q394字符串解码 {

        public String decodeString(String s) {
            int k = 0;
            StringBuilder res = new StringBuilder();
            Stack<Integer> kstack = new Stack<>();
            Stack<StringBuilder> restack = new Stack<>();

            for(char c : s.toCharArray()){
                if(c == '['){
                    //碰到括号，记录K和当前res，归零。
                    kstack.push(k);
                    restack.push(res);
                    k = 0;
                    res = new StringBuilder();
                }
                else if(c ==']'){
                    //出最近的一个左括号入的k,当前res进行计算不入栈
                    int curk = kstack.pop();
                    StringBuilder temp = new StringBuilder();
                    for(int i = 0; i < curk; i++){
                        temp.append(res);
                    }
                    //与括号外合并
                    res = restack.pop().append(temp);

                }
                else if(c >= '0' && c <= '9'){
                    k = c - '0' + k * 10;
                    //如果k是多位数需要x10
                }
                else{
                    res.append(c);
                    //如果是字母则缓慢添加
                }
            }
            return res.toString();
        }

}
