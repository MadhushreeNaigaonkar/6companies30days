package Micorsoft;

import java.util.*;

public class CombinationSumIII {
    
        public List<List<Integer>> combinationSum3(int k, int n) {
            List<List<Integer>> result = new LinkedList<>();
            dfs(result, n, k, 0, new LinkedList<Integer>(), 1);
            return result;
        }
        private void dfs(List<List<Integer>> result, int n, int k, int sum, List<Integer> temp, int index){
            if(sum == n && temp.size() == k) result.add(new LinkedList<Integer>(temp));
            else if(sum < n && temp.size() < k){
                for(int i = index; i <= 9; i++){
                    if(i + sum > n) break;
                    temp.add(i);
                    dfs(result, n, k, sum + i, temp, i + 1);
                    temp.remove(temp.size() - 1);
                }
            }
        }
 }

