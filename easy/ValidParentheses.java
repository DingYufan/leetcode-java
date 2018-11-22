import java.util.HashMap;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 有效字符串需满足：
 * 1.左括号必须用相同类型的右括号闭合。
 * 2.左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * ---
 * 输入: "()"
 * 输出: true
 * ---
 * 输入: "()[]{}"
 * 输出: true
 * ===
 * 输入: "(]"
 * 输出: false
 * ---
 * 输入: "([)]"
 * 输出: false
 * ---
 * 输入: "{[]}"
 * 输出: true
 */
public class ValidParentheses{

    public static void main(String[] args){
        String s = "()[]{}";
        String s2 = "";
        System.out.print(ValidParentheses.isValid(s2));

    }

    public static boolean isValid(String s) {
        if(s == null){
            return false;
        }
        if("".equals(s)){
            return true;
        }
        if(s.length() < 2){
            return false;
        }
    
        char[] arr = s.toCharArray();
        int ptr = 1;
        int[] myStack = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            int val = 0;
            switch(arr[i]){
                case '(':val = -1;break;
                case ')':val = 1;break;
                case '[':val = -2;break;
                case ']':val = 2;break;
                case '{':val = -3;break;
                case '}':val = 3;break;
                default:break;
            }
            if(val == 0){
                continue;
            }

            if(i == 0){
                myStack[ptr] = val;
                continue;
            }

            if(myStack[ptr] + val == 0){
                myStack[ptr--] = 0;
            }else{
                myStack[ptr++] = val;
            }
        }
        return myStack[1] == 0;// ptr == 1 也能判断
    }
}