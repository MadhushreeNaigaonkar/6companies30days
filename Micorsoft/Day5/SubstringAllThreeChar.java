package Micorsoft;

class Solution {
    public int numberOfSubstrings(String s) {
        int count=0;

    int[] arr=new int[3];

    int j=0;

    for(int i=0;i<s.length();i++){

    if(arr[0]>0&&arr[1]>0&&arr[2]>0){

    if(s.charAt(i)=='a')arr[0]--;
    if(s.charAt(i)=='b')arr[1]--;
    if(s.charAt(i)=='c')arr[2]--;
    count+=(s.length()-j+1);
    continue;

    }

    if(j==s.length())break;

    while(j<s.length()&&(arr[0]==0||arr[1]==0||arr[2]==0)){

    if(s.charAt(j)=='a')arr[0]++;
    if(s.charAt(j)=='b')arr[1]++;
    if(s.charAt(j)=='c')arr[2]++;
    
    j++;

    }

    if(arr[0]>0&&arr[1]>0&&arr[2]>0)
    count+=(s.length()-j+1);

    if(s.charAt(i)=='a')arr[0]--;
    if(s.charAt(i)=='b')arr[1]--;
    if(s.charAt(i)=='c')arr[2]--;

    }


    return count;

        
    }
}