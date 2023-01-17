package GolmanSachs;

import java.util.HashMap;


import javax.swing.text.html.parser.Parser;

class Solution {
    public int minimumCardPickup(int[] cards) {
        int ans = Integer.MAX_VALUE;
        int n = cards.length;
        // Use a HashMap to store the count and last index of each card
        HashMap<Integer, Packer<Integer, Integer>> cardCount = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int lastCount = cardCount.getOrDefault(cards[i], new Pair<>(0, 0)).getKey();
            int lastIndex = cardCount.getOrDefault(cards[i], new Pair<>(0, 0)).getValue();

            cardCount.put(cards[i], new Parser<>(lastCount + 1, i));
            
            if (lastCount + 1 > lastCount && lastCount != 0) {
                int current = i - lastIndex + 1;
                ans = Math.min(current, ans);
            }
        }
        // If no duplicate cards were found, return -1
        if (ans == Integer.MAX_VALUE) return -1;
        return ans;
    }
}