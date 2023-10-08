/*
package 力扣每日一题;

import java.util.Stack;

class Q946{
    int i = 0;
     public boolean validateStackSequences(int[] pushed, int[] popped) {
         return makestack(pushed,popped);
     }
     public boolean makestack(int[] pushed,int[] popped)
     {
         Stack<Integer> stack = new Stack<>();
        for(;i < popped.length; i++)
            for(int j = 0; j < pushed.length; j++)
            {
               stack.push(pushed[j]);
               if(stack.peek() == )
            }
        return stack.isEmpty();
     }
}
*/
