class solution13 {
    public static void main(String[] args) {
     /*   I             1
        V             5
        X             10
        L             50
        C             100
        D             500
        M             1000
*/
        Solution s=new Solution();
        System.out.println(s.romanToInt("MCMXCIV"));
    }
}
class Solution {
    public int romanToInt(String s) {
       int sum=0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='I') {
                if(i<s.length()-1){
                    if(s.charAt(i+1)=='V') {sum+=4; i++;continue;}
                    if(s.charAt(i+1)=='X') {sum+=9; i++;continue;}
                }
                sum+=1;
            }
            if(s.charAt(i)=='V'){
                sum+=5;
            }
            if(s.charAt(i)=='X') {
                if(i<s.length()-1){
                    if(s.charAt(i+1)=='L') {sum+=40; i++;continue;}
                    if(s.charAt(i+1)=='C') {sum+=90; i++;continue;}
                }
                sum+=10;
            }
            if(s.charAt(i)=='L'){
                sum+=50;
            }
            if(s.charAt(i)=='C') {
                if(i<s.length()-1){
                    if(s.charAt(i+1)=='D') {sum+=500; i++;continue;}
                    if(s.charAt(i+1)=='M') {sum+=900; i++;continue;}
                }
                sum+=100;
            }
            if(s.charAt(i)=='D'){
                sum+=500;
            }
            if(s.charAt(i)=='M'){
                sum+=1000;
            }

        }

return sum;
    }

}
