package GolmanSachs;


    class Solution {
        public int trailingZeroes(int n) {
            // Negative Number Edge Case...
            if (n < 0)
                return -1;
            // Initialize the output result i.e., the number of trailing zeroes...
            int output = 0;
            // Count number of 5s in prime factors of n!
            for (long idx = 5; n/idx >= 1; idx *= 5) {
                output += n/idx;
            }
            // Return the number of trailing zeroes...
            return output;
        }
    }

