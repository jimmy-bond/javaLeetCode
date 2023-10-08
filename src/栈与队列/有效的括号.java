package 栈与队列;

import java.util.Stack;

/*给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。

        有效字符串需满足：

        左括号必须用相同类型的右括号闭合。
        左括号必须以正确的顺序闭合。
        每个右括号都有一个对应的相同类型的左括号。

        输入：s = "()"
        输出：true

        输入：s = "()[]{}"
        输出：true

        输入：s = "(]"
        输出：false*/
//解题思路：
//用一个栈来存储判断后面的符号是否对应
public class 有效的括号
{
    public boolean isValid(String s)
    {

        Stack<Character>stack = new Stack<Character>();
        for(char c: s.toCharArray()){
            if(c=='(')stack.push(')');
            else if(c=='[')stack.push(']');
            else if(c=='{')stack.push('}');
            else if(stack.isEmpty()||c!=stack.pop())return false;//c !=stack.pop是精点，不对应就返回错误，对应就顺便弹出了
        }
        return stack.isEmpty();
    }
}
