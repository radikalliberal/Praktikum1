/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg1;

import java.util.Random;

/**
 *
 * @author jan
 */
public class SomeSorts{
    public static int cnt = 0;
    
    public static void QuickSort(Comparable[] a) {
        shuffle(a);
        QuickSort(a, 0, a.length - 1);
    }
    
    protected static void QuickSort(Comparable a[], int L, int R) {
        if (R - L <= 0) {
            return; // less than 2 elements
        }
        int m = partition(a, L, R);
        QuickSort(a, L, m - 1);
        QuickSort(a, m + 1, R);
    }
    
    protected static int partition(Comparable a[], int L, int R){
        int i = L - 1;
        int j = R;
        while (true) {
            while (less(a[++i], a[R])) // find item on left
                if (i == R)   
                    break; // to swap
            while (less(a[R], a[--j])) // find item on right
                if (j == L)
                    break; // to swap
            if (i >= j) 
                break; // do pointers cross?
            exch(a, i, j); // otherwise do swap
        }
        exch(a, i, R); // final swap
        return i; // return index of cross point
    }

    
    protected static void shuffle(Comparable a[]) {
        Random rnd = new Random();
        for (int i = 0; i < a.length; i++) {
            exch(a, i, rnd.nextInt(a.length));
        }
    }
    
    public static void MergeSort(Comparable[] a) {
        Comparable[] aux = new Comparable[a.length];
        MergeSort(a, aux, 0, a.length);
    }

    private static void MergeSort(
            Comparable a[], Comparable aux[], int L, int R) {
        if (R - L <= 1) {
            return; // less than 2 elements
        }
        int m = L + (R - L) / 2;
        MergeSort(a, aux, L, m);
        MergeSort(a, aux, m, R);
        merge(a, aux, L, m, R);
    }
    private static void merge(
            Comparable a[], Comparable aux[], int L, int M, int R) {
        for (int i = L; i < M; i++) {
            aux[i] = a[i]; // copy
        }
        for (int j = M; j < R; j++) {
            aux[j] = a[M + R - 1 - j]; // copy
        }
        int i = L, j = R - 1;
        for (int k = L; k < R; k++) { // merge
            if (less(aux[j], aux[i])) {
                a[k] = aux[j--];
            } else {
                a[k] = aux[i++];
            }
        }
    }
    
    public static void ShellSort( Comparable [] a){
        int N = a. length ;
        int [] incs = {1391376 , 463792 , 198768 , 86961 , 33936 , 13776 ,
        4592 , 1968 , 861 , 336 , 112 , 48, 21, 7, 3, 1 };
        for (int k=0; k<incs. length ; k++){
            int h = incs[k];
            for (int i=h; i<N; i++)
                for (int j=i; j >=h; j -=h) // like insertion sort
                    if ( less(a[j],a[j-h]) )
                        exch(a,j,j-h);
                    else break ;
        }
    }
    
    public static void SelectionSort( Comparable [] a) {
        for (int i=0; i<a. length ; i++){
            int min = i;
            for (int j=i+1; j < a. length ; j++)
             if ( less(a[j],a[min ]) )
            min = j;
            exch(a,i,min);
        }
    }
    
    public static void insertionSort (Comparable[] a)    {
        int N = a. length ;
        for (int i=0; i<N; i++)
            for (int j=i; j >0; j--) {
                if ( a[j].compareTo(a[j-1]) < 0 )
                    exch(a,j,j-1);
                else break ;
            }  
    }
    private static void exch(Comparable[] a, int i, int j) {
        Comparable tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
    
    private static boolean less( Comparable v, Comparable w){ 
        cnt++;
        return (v. compareTo (w) <0); 
    }
    
    private static boolean less ( double v, double w){ 
        cnt++;
        return v<w; 
    }
    
    private static boolean less ( int v, int w){ 
        cnt++;
        return v<w; 
    }
    
    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) 
            if (less(a[i], a[i - 1])) {
                return false;
            }
        return true;
    }
}
