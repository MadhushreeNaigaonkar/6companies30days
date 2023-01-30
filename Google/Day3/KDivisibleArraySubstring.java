package Google;
import java.util.*;
class Solution {
	 
	
    private static final int P = 229; 
    private static final long M = (long)(1e15 + 7);
    private static final long[] PP;
    private static final int MAX_LENGTH = 2 * 1_00;

    static {
        PP = new long[MAX_LENGTH + 1];
        PP[0] = P;
        for(int i = 1; i <= MAX_LENGTH; i += 1) {
            PP[i] = (PP[i - 1] % M * P % M) % M;
        }
    }

    private void computeHashesForAllSubarrays(int[] nums, long[][] hashes, int n) {
		// hashes[i][j] = is the unique hash value for subarray nums[i:j]
        for(int i = 0; i < n; i += 1) {
            long subHash = 0;
            for(int j = i; j < n; j += 1) {
                int ele = nums[j];
                subHash += (PP[j - i] * ele) % M;
                hashes[i][j] = subHash;
            }
        }
    }
    
    private void buildDivisibleCountForAllSubarrays(int[] nums, int[][] count, int n, int p) {
        // count[i][j] = returns how many elements are there in the subarray
        // nums[i:j], divisible by p. -> Helps to check (count_of_divisibles <= k) in O(1) time
        for(int i = 0; i < n; i += 1) {
            for(int j = i; j < n; j += 1) {
                int rem = nums[j] % p;
                count[i][j] = rem == 0 ? 1 : 0;
                // Computing prefix count array
                if(j > 0) {
                    count[i][j] = rem == 0 ? count[i][j - 1] + 1 : count[i][j - 1];
                }
                // Actual computation where storing(at count[i][j]) how many elements
                // are divisible by p in the sub-array (i, j)
                count[i][j] = (count[i][j] - count[i][i]) + (nums[i] % p == 0 ? 1 : 0);
            }
        }
    }
    
    public int countDistinct(int[] nums, int k, int p) {
        int n = nums.length, countSubarrays = 0;
        int[][] count = new int[n][n];
        long[][] hashes = new long[n][n];
        
        buildDivisibleCountForAllSubarrays(nums, count, n, p);
        computeHashesForAllSubarrays(nums, hashes, n);
        
        Set<Long> subarrayHash = new HashSet<>();
        
        for(int i = 0; i < n; i += 1) {
            for(int j = i; j < n; j += 1) {
                if(count[i][j] <= k) {
                    if(!subarrayHash.contains(hashes[i][j])) {
                        countSubarrays += 1;
                        subarrayHash.add(hashes[i][j]);
                    }
                }
            }
        }
        
        return countSubarrays;
    }
}