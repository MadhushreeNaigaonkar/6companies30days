package Micorsoft;
public class BullsandCows {
    public String getHint(String secret, String guess) {
        int bulls=0;
        int cows=0;
        int[] data=new int[10];
        for(int i=0;i<secret.length();i++){
            if(secret.charAt(i)==guess.charAt(i)){
                bulls++;
            }
            else{
                if(data[guess.charAt(i)-'0']-- > 0){
                    cows++;
                }
                if(data[secret.charAt(i)-'0']++ <0){
                    cows++;
                }
    }

}
return bulls+"A"+cows+"B";
    }
}
