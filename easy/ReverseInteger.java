/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * ---
 * 输入: 123
 * 输出: 321
 * ---
 * 输入: -123
 * 输出: -321
 * ---
 * 输入: 120
 * 输出: 21
 * ---
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31,  2^31 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 * 
 */
public class ReverseInteger{


    // 本题的区别，就在于reverseNoOverflow(int)方法中TODO部分的内容，即对溢出进行检查
    public int reverse(int x) {
        int result = 0;
        while(x != 0){
            int num = x % 10;
            x = x / 10;
            // 正数溢出
            if(result > Integer.MAX_VALUE / 10 || (result ==Integer.MAX_VALUE / 10 && num > 7)){
                return 0;
            }
            // 负数溢出
            if(result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && num < -8)){
                return 0;
            }
            result = result * 10 + num;
        }
        return result;
    }

    // 先写简单的不存在溢出的情况
    public int reverseNoOverflow(int x) {
        int result = 0;
        while(x != 0){
            int num = x % 10;
            x = x / 10;
            //TODO 
            result = result * 10 + num;
        }
        return result;
    }
}