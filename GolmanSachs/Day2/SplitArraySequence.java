package GolmanSachs;

import java.util.HashMap;

class Solution {
    public boolean isPossible(int[] nums) {
        // Use a HashMap to count the frequency of each number
        HashMap<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        for (int num : nums) {
            // If the current number doesn't have any remaining occurrences, continue
            if (!countMap.containsKey(num) || countMap.get(num) == 0) {
                continue;
            }

            // Initialize variables to track the frequency of the current sequence
            int currNum = num;
            int sequenceFreq = countMap.get(num);
            int sequenceCount = 0;

            // Iterate through the sequence and decrement the count of each number
            while (countMap.containsKey(currNum) && countMap.get(currNum) >= sequenceFreq) {
                sequenceFreq = Math.max(sequenceFreq, countMap.get(currNum));
                countMap.put(currNum, countMap.get(currNum) - 1);
                sequenceCount++;
                currNum++;
            }

            // If the sequence is less than 3 numbers long, return false
            if (sequenceCount < 3) {
                return false;
            }
        }
        // If all sequences are at least 3 numbers long, return true
        return true;
    }
}