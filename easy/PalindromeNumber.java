/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * ---
 * 输入: 121
 * 输出: true
 * ---
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * ---
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 */
public class PalindromeNumber{

    public static void main(String[] args) {
        System.out.println(PalindromeNumber.isPalindrome(121));
    }

    // 未考虑溢出大小
    // 这道题其实和“整数翻转”(ReverseInteger)那题很像的
    public static boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }

        int backup = x;
        int rev = 0;
        while(x != 0){
            int num = x % 10;
            x = x / 10;
            rev = rev * 10 + num;
        }

        return ( backup == rev);
    }

    public static boolean isPalindromeB(int x) {
        // 负数、10的倍数，都不会是回文数
        if(x < 0 || (x % 10 == 0 && x!=0)){
            return false;
        }

        int rev = 0;
        int num = 0;
        while(x >= rev){
            num = x % 10;
            x = x / 10;
            rev = rev * 10 + num;
        }

        return ( x == rev || (x * 10 + num) == rev);
    }
}