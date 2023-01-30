package GolmanSachs;

import java.util.HashSet;
import java.util.PriorityQueue;

class Solution {
    int rows;
    int cols;
    int[][] grid;
    
    HashSet<Integer> set;
    PriorityQueue<Integer> minHeap;
    
    public int[] getBiggestThree(int[][] grid) {
        this.grid = grid;
        rows = grid.length;
        cols = grid[0].length;
        
        set = new HashSet();
        minHeap = new PriorityQueue<Integer>((a, b) -> (a - b));
        
        
        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                //find all the rhombus of center (r, c)
                findRhombusWithCenter(r, c);
            }
        }
        
        //get the largest 3 rhombus 
        int[] result = new int[minHeap.size()];
        int i = result.length - 1;
        while(!minHeap.isEmpty()){
            result[i--] = minHeap.remove();
        }
        
        return result;
    }
    
    
    
    private void findRhombusWithCenter(int r, int c){
        int sum = grid[r][c];
        
        if(!set.contains(sum)){
            minHeap.add(sum);
            if(minHeap.size() > 3) minHeap.remove();
            set.add(sum);
        }
        
        int size = 1;
        
        while(true){
            
            if(!insideGrid(r + size, c)) break;
            if(!insideGrid(r - size, c)) break;
            if(!insideGrid(r, c + size)) break;
            if(!insideGrid(r, c - size)) break;
            
            sum = 0;
            for(int i = 0; i <= size; i++){
                sum += grid[r - size + i][c + i];
                sum += grid[r - size + i][c - i];
                
                sum += grid[r + size - i][c + i];
                sum += grid[r + size - i][c - i];
            }

            
            sum -= grid[r + size][c];
            sum -= grid[r - size][c];
            sum -= grid[r][c + size];
            sum -= grid[r][c - size];
            
            
            if(!set.contains(sum)){
                minHeap.add(sum);
                
                if(minHeap.size() > 3) minHeap.remove();
                
                set.add(sum);
            }
            
            size++;
        }
    }
    
    private boolean insideGrid(int i, int j){
        return i >= 0 && i < rows && j >= 0 && j < cols;
    }
}
