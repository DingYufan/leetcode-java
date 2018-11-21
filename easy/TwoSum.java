import java.util.HashMap;
import java.util.Map;

/**
 * Created by dingyufan on 2018/11/21.
 */
public class TwoSum {

    // 暴力法
    public int[] twoSumA(int[] nums, int target) {
        if(nums == null || nums.length < 2){
            return new int[]{};
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if(nums[i] + nums[j] == target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{};
    };

    // 两趟hash表
    public int[] twoSumB(int[] nums, int target) {
        if(nums == null || nums.length < 2){
            return new int[]{};
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(target - nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && map.get(nums[i]) != i){
                return new int[]{i,map.get(nums[i])};
            }
        }
        return new int[]{};
    }

    // 一趟hash表.其实相当于twoSumB()中两个for合并起来
    public int[] twoSumC(int[] nums, int target) {
        if(nums == null || nums.length < 2){
            return new int[]{};
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = target - nums[i];
            if(map.containsKey(num)){
                return new int[]{i, map.get(num)};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }
}
