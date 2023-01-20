import java.util.HashMap;
import java.util.Map;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class RemoveZeroSum {
        int val;
     RemoveZeroSum next;
         RemoveZeroSum(int x) { val = x; }
     }
class Solution {
    public RemoveZeroSum removeZeroSumSublists(RemoveZeroSum head){
        
        Map<Integer, RemoveZeroSum> sumToFarthestNodeMap = new HashMap<>();
        RemoveZeroSum preHead = new RemoveZeroSum(0);
        preHead.next = head;
        int sum = 0;
        for (RemoveZeroSum p = preHead; p != null; p = p.next) {
            sum += p.val;
            sumToFarthestNodeMap.put(sum, p);
        }
        sum = 0;
        for (RemoveZeroSum p = preHead; p != null; p = p.next) {
            sum += p.val;
            p.next = sumToFarthestNodeMap.get(sum).next;
        }
        
        return preHead.next;
    }
}
