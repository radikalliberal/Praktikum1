/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg1;

import java.util.function.DoubleToIntFunction;

/**
 *
 * @author jan
 */
public class MoreOrLessRandomArray {
    
    
    public static Integer[] ArrayCreation(int N,int K){
        Integer[] Array = new Integer[N];
        int temp; 
        int randIndex;
        
        if(K > N) 
            K = N;
        
        for(int i = 0; i < N; i++){
            Array[i]=i;
        }
        
        for(int l = 0; l < K; l++) {
            randIndex = (int) (Math.random()* (N - l));
            temp = Array[randIndex];
            
            for(int g = randIndex; g < (N - 1); g++){
                Array[g]=Array[g+1];
            }
            Array[N - 1] = temp;
        }
        return Array;        
    }
}
