package Micorsoft;

import java.util.*;

public class LargestDivisibleSubset {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] count = new int[n], pre = new int[n];
        int max = 0, index = -1;
        for (int i = 0; i < n; i++) {
            count[i] = 1;
            pre[i] = -1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0 && 1 + count[j] > count[i]) {
                    count[i] = count[j] + 1;
                    pre[i] = j;
                }
            }
            if (count[i] > max) {
                max = count[i];
                index = i;
            }
        }
        LinkedList<Integer> list = new LinkedList<>();
        while (index != -1) {
            list.addFirst(nums[index]);
            index = pre[index];
        }
        return list;
    }
}
