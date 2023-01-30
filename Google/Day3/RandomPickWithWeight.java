package Google;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Solution {

    int[] w;
    int totalWeight = 0;
    List<Integer> wieghtSumList = new ArrayList<>();
    
    public Solution(int[] w) {
        this.w = w;
        int counter = 0;
        for (int j : w) {
            wieghtSumList.add(counter);
            counter = counter + j;
        }
        wieghtSumList.add(counter);
        totalWeight = counter;
    }
    
    public int pickIndex() {
        Random random = new Random();
        return binarySearch(wieghtSumList, random.nextInt(totalWeight), 0, wieghtSumList.size()-1);
    }
    
    public static int binarySearch(List<Integer> wieghtSumList, int input, int start, int end){
        if (end - start == 1){
            return start;
        }
        if (end - start == 0){
            return start;
        }
        int mid = ((end-start)/2) + start;
        if (wieghtSumList.get(mid) == input){
            return mid;
        }
        else if (wieghtSumList.get(mid) < input){
            return binarySearch(wieghtSumList, input, mid, end);
        }
        else{
            return binarySearch(wieghtSumList, input, start, mid);
        }
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
