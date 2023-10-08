class s12 {
    public static void main(String[] args) {
  Solution12 s=new Solution12();
        System.out.println(s.intToRoman(9));
        int a=5;
        a-=5;
        System.out.println(a);
    }
}
class Solution12 {
    public String intToRoman(int num) {
        int[] a=new int[4];
        for (int i = 0; i < 4; i++) {
            a[i]=num%10;
            num/=10;//取得千，百，十，个 位
        }
        StringBuilder s=new StringBuilder();
        while (a[3]>0){
            s.append("M");
            a[3]--;
        }
        while (a[2]>=5){
            if(a[2]==9){
                s.append("CM");
                a[2]=0;
                break;
            }
            s.append("D");
         a[2]-=5;
        }
        while (a[2]>0){
            if(a[2]==4){
                s.append("CD");
                a[2]=0;
                break;
            }
            s.append("C");
            a[2]--;
        }
        while (a[1]>=5){
            if(a[1]==9) {
                s.append("XC");
                a[1]=0;
                break;
            }
            s.append("L");
            a[1]-=5;

        }
        while (a[1]>0){
            if(a[1]==4){
                s.append("XL");
                a[1]=0;
                break;
            }
            s.append("X");
            a[1]--;
        }
        while (a[0]>=5){
            if(a[0]==9){
                s.append("IX");
                a[0]=0;
                break;
            }
            s.append("V");
            a[0]-=5;
        }
        while (a[0]>0){
            if(a[0]==4){
                s.append("IV");
                a[0]=0;
                break;
            }
            s.append("I");
            a[0]--;
        }

return  s.toString();
    }
    public String intToRoman1(int num) {
        // 贪婪算法，类似于找零钱
        // 把阿拉伯数字与罗马数字可能出现的所有情况和对应关系，放在两个数组中
        // 并且按照阿拉伯数字的大小降序排列
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int index = 0;
        StringBuilder result = new StringBuilder();
        while (index < 13) {
            if (num >= nums[index]) {
                result.append(romans[index]);
                num -= nums[index];
            } else {
                index ++;
            }
        }
        return result.toString();
    }
}
