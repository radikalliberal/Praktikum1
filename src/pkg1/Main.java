/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg1;

/**
 *
 * @author jan
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Integer[] Array1 = MoreOrLessRandomArray.ArrayCreation(50000, 25000);
        
        Stopwatch watch = new Stopwatch();
        
        watch.tic();
        SomeSorts.insertionSort(Array1);
        System.out.println(Stopwatch.toc());
    }
    
}
