package Google;

class Solution {
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }
    public void quickSort(int[] arr,int i, int j){
       if (i < j) {
			int p = partition(arr, i, j); 
            
			quickSort(arr, i, p-1); 
			quickSort(arr, p+1, j); 
		}
    }
    public int partition(int[] arr,int low,int high) {
        int mid = (low + high) / 2;
		swapIntArray(arr, mid, high);
		for (int j = low; j < high; j++) {
			if (arr[j] < arr[high]) {
				swapIntArray(arr, j, low);
				low++;
			}
		}
		swapIntArray(arr, high, low);
		return low;
    }
    private void swapIntArray(int[] a, int i,int j){
        int temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }
}
