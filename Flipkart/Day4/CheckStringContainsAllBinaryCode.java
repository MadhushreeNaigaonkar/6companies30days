import java.util.HashSet;

class Solution {
    
    public boolean hasAllCodes(String s, int k) {
        HashSet<String> set=new HashSet<>();
        int pow=(int)Math.pow(2,k);
        for(int i=0;i<s.length()-k+1;i++){
			set.add(s.substring(i,i+k));
        }
        
        if(set.size()==pow){
            return true;
        }
        else{
            return false;
        }
    }
}