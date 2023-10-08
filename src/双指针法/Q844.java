package 双指针法;

import org.testng.annotations.Test;
import org.yaml.snakeyaml.external.com.google.gdata.util.common.base.Escaper;
//比较含退格符号的字符串
public class Q844 {
        public boolean backspaceCompare(String s, String t) {
            int i = s.length() - 1;
            int j = t.length() - 1;
            int skipS = 0, skipT = 0;
            //从后面开始遍历数组
            while(i >= 0 || j >= 0){
                while (i >= 0){
                    if (s.charAt(i) == '#') {
                        skipS++;
                        i--;
                    }
                     else if(skipS > 0){
                        skipS--;
                        i--;
                    }
                  else{ break;}
                }
                while ((j >= 0)) {
                    if(t.charAt(j) == '#'){
                        skipT++;
                        j--;
                    }
                   else if( skipT > 0){
                        skipT--;
                        j--;
                    }
                   else{ break;}
                }
                //经典中的重点
                if (i >= 0 && j >= 0) {
                    if (s.charAt(i) != t.charAt(j)) {
                        return false;
                    }
                } else {
                    if (i >= 0 || j >= 0) {
                        return false;
                    }
                }
                i--;
                j--;
            }
            return true;

    }

    @Test
    public   void kk(){
        System.out.println(backspaceCompare("ab##", "c##"));

    }
}
