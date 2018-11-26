/**
 * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 * ---
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 * -I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * -X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
 * -C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * ---
 * 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
 * 输入: "III"      输出: 3
 * 输入: "IV"       输出: 4
 * 输入: "IX"       输出: 9
 * 输入: "LVIII"    输出: 58    解释: L = 50, V= 5, III = 3.
 * 输入: "MCMXCIV"  输出: 1994  解释: M = 1000, CM = 900, XC = 90, IV = 4.
 * 2018.11.26 DINGYUFAN
 */
public class RomanToInt{

    // 比另一个方法，快了一倍
    public int  romanToInt(){
        if(s == null || s.length() == 0){
            return -1;
        }

        int result = 0;
        char[] cArr = s.toCharArray();
        int[] iArr = new int[2];
        int len = cArr.length - 1;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < 2; j++) {
                switch (cArr[i + j]){
                    case 'I': iArr[j] = 1;break;
                    case 'V': iArr[j] = 5;break;
                    case 'X': iArr[j] = 10;break;
                    case 'L': iArr[j] = 50;break;
                    case 'C': iArr[j] = 100;break;
                    case 'D': iArr[j] = 500;break;
                    case 'M': iArr[j] = 1000;break;
                }
            }
            result = (iArr[0] < iArr[1]) ? (result - iArr[0]) : (result + iArr[0]);
        }
        switch (cArr[len]){
            case 'I': result += 1;break;
            case 'V': result += 5;break;
            case 'X': result += 10;break;
            case 'L': result += 50;break;
            case 'C': result += 100;break;
            case 'D': result += 500;break;
            case 'M': result += 1000;break;
        }
        return result;
    }

    // 如果这个数比左右边的数小，减去这个数；
    // 如果比右边的数大，加上这个数
    public int romanToIntB(String s){
        if(s == null || s.length() == 0){
            return -1;
        }
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int result = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            int now = map.get(s.charAt(i));
            int next = map.get(s.charAt(i + 1));
            result = (now < next) ? (result - now) : (result + now);
        }
        return result + map.get(s.charAt(s.length() - 1));
    }
}