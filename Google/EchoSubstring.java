package Google;

import java.util.HashSet;

class Solution {
    long BASE = 29L, MOD = 1000000007L;
    public int distinctEchoSubstrings(String str) {
        HashSet<Long> set = new HashSet<>();
        int n = str.length();
        long[] hash = new long[n + 1]; // hash[i] is hash value from str[0..i]
        long[] pow = new long[n + 1]; // pow[i] = BASE^i
        pow[0] = 1;
        for (int i = 1; i <= n; i++) {
            hash[i] = (hash[i - 1] * BASE + str.charAt(i - 1)) % MOD;
            pow[i] = pow[i - 1] * BASE % MOD;
        }
        for (int i = 0; i < n; i++) {
            for (int len = 2; i + len <= n; len += 2) {
                int mid = i + len / 2;
                long hash1 = getHash(i, mid, hash, pow);
                long hash2 = getHash(mid, i + len, hash, pow);
                if (hash1 == hash2) set.add(hash1);
            }
        }
        return set.size();
    }

    long getHash(int l, int r, long[] hash, long[] pow) {
        return (hash[r] - hash[l] * pow[r - l] % MOD + MOD) % MOD;
    }
}
