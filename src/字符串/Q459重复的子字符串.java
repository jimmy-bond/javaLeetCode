package 字符串;

public class Q459重复的子字符串 {
 /*   给定一个非空的字符串 s ，检查是否可以通过由它的一个子串重复多次构成。
    输入: s = "abab"
    输出: true
    解释: 可由子串 "ab" 重复两次构成。*/
 public boolean repeatedSubstringPattern(String s) {
//移动匹配算法 :一个s+s字符串中去除首尾字母，则可以判断是否字符串中出现过s，若有出现过则可以说明出现了重复字符串
/*  StringBuilder sb = new StringBuilder();
  sb.append(s);
  sb.append(s);
  sb.deleteCharAt(0);
  sb.deleteCharAt(sb.length()-1);
  if(sb.indexOf(s) == -1) {return false;}
  return true;*/
  //kmp算法实现：
  int[] next = new int[s.length()];
  Getnext(next, s);
  if (next[s.length()] > 0 && s.length() % (s.length() - next[s.length()]) == 0) {
   return true;
  }
  return false;
 }

 public void Getnext(int[] next, String s) {
  int j = 0;
  next[0] = 0;
  for (int i = 0; i < s.length(); i++) {
   while (j > 0 && s.charAt(j) != s.charAt(i)) {
    j = next[j - 1];
   }
   if (s.charAt(i) == s.charAt(j))
    j++;
   next[i] = j;
  }
 }
}
