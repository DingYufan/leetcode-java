import java.util.HashMap;
import java.util.Stack;

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
        System.out.print(ValidParentheses.isValid(s));

    }

    // 没有另外一种快
    public static boolean isValidB(String s){
       if(s == null || s.length() == 1){
           return false;
       }
       if(s.length() == 0){
           return true;
       }
       Stack<Character> stack = new Stack<>();
       for (char c : s.toCharArray()) {
           if(stack.empty()){
               stack.push(c);
               continue;
           }

           char top = stack.peek();
           if(top == '(' && c == ')' || top == ')' && c == '(' 
                || top == '[' && c == ']' || top == ']' && c == '[' 
                || top == '{' && c == '}' || top == '}' && c == '{' ){
               stack.pop();
               continue;
           }
           stack.push(c);
       }
        return stack.empty();
    }

    public static boolean isValid(String s) {
        if(s == null || s.length() == 1){
            return false;
        }
        if(s.length() == 0){
            return true;
        }
    
        char[] arr = s.toCharArray();
        int ptr = 1;// int变量作指针
        int[] myStack = new int[arr.length + 1];// 数组作栈,myStack[0]防止栈pop最后一个元素时IndexOutOfBoundsException
        for (int i = 0; i < arr.length; i++) {
            int val = 0;
            switch(arr[i]){// 用数字代替各符号
                case '(':val = -1;break;
                case ')':val = 1;break;
                case '[':val = -2;break;
                case ']':val = 2;break;
                case '{':val = -3;break;
                case '}':val = 3;break;
                default:break;
            }

            if(i == 0){
                myStack[ptr] = val;
                continue;
            }

            if(myStack[ptr] + val == 0){
                myStack[ptr--] = 0;
            }else{
                myStack[++ptr] = val;
            }
        }
        return myStack[1] == 0;
    }
}