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
public class Stopwatch {
    
    private static long start;

    public static void tic() {
        start = System.currentTimeMillis();
    }

    public static double toc() {
        long stop = System.currentTimeMillis();
        return (stop - start) / 1000.0;
    }

}
