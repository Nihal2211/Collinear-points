import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import java.util.Comparator;
import edu.princeton.cs.algs4.StdOut;
import java.util.*;

public class Fast {
 private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi){
       if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
         sort(a, aux, lo, mid);
         sort(a, aux, mid+1, hi);
         merge(a, aux, lo, mid, hi);
    } 
    private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi){
        for (int k = lo; k <= hi; k++)
          aux[k] = a[k];
          int i = lo, j = mid+1;
         for (int k = lo; k <= hi; k++)
             {
              if (i > mid) a[k] = aux[j++];
              else if (j > hi) a[k] = aux[i++];
              else if (less(aux[j], aux[i])) a[k] = aux[j++];
              else a[k] = aux[i++];
          }  
      }
    private static boolean less(Comparable a, Comparable b){
      if (a.compareTo(b)==1) return false;
      else return true;
    }
    private static void sort(Comparable[] a)
      {
        Comparable[] aux = new Comparable[a.length];
        sort(a, aux, 0, a.length - 1);
        }
    
   public static void main(String[] args)
   {
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        StdDraw.show(0);
        StdDraw.setPenRadius(0.01); 
       Fast fast = new Fast(); 
       String filename = args[0];
        In in = new In(filename);
        int N = in.readInt();
        Point[] a = new Point[N];
       
        for (int iterating = 0; iterating < N; iterating++) {
            int x = in.readInt();
            int y = in.readInt();
            Point p = new Point(x, y);
            a[iterating] = p;
            p.draw();
        }
        Point[] aux1;
        Point[] aux2;
        //Arrays.sort(a);
        
        for (int i = 0; i < N; i++){
            aux1 = new Point[a.length-i];
            System.arraycopy( a, i, aux1, 0, a.length-i);
            Arrays.sort(aux1, 0, aux1.length, a[i].SLOPE_ORDER);// How do I sort a subarray? Arrays.sort(a, lo, hi) sorts 
             //the subarray from a[lo] to a[hi-1] according to the natural order of a[].
             //You can use a Comparator as the fourth argument to sort according to an alternate order.
             //Solution to sort using an array.sort is given in the checklist
             //fast.sort(aux1,a[i].SLOPE_ORDER); //sorting by mergersort is given in the lecture notes. the method
             // sorting by mergesort gives the solution as failing in correctness, doesn't actually sort properly

                 int k = 0 ;
                 int linesegment =0 ;
                 int initial = 0 ;
                 Point[] collinearPoints;
                  double firstone = a[i].slopeTo(aux1[k]);
                 Point last = aux1[0];
                 while( k < aux1.length) {
                     
                    double current = a[i].slopeTo(aux1[k]);
                
                if (current == firstone) {
                    linesegment++;
                } else {
                    if (linesegment- initial >= 2 && aux1[linesegment] != last) {
                        collinearPoints = new Point [linesegment- initial+2];
                               //   StdOut.print(" ->hihi " + collinearPoints.length);
                        //StdOut.print(" oho " + collinearPoints[0]);
                        //collinearPoints = Arrays.copyOfRange(aux1, initial, linesegment+1); 
                        System.arraycopy(aux1, initial, collinearPoints, 1, linesegment- initial+1);
                        //System.arraycopy( aux1, initial, collinearPoints,linesegment- initial+1);
                        collinearPoints[0] = a[i];
                       /* StdOut.print(" ->hihi " + collinearPoints.length);
                        StdOut.print(" ->last " + aux1[linesegment]);
                         StdOut.print(" ->The thing " + collinearPoints[0]);
                        StdOut.print(" -> " + collinearPoints[1]);
                        StdOut.print(" -> " + collinearPoints[2]);
                         StdOut.print(" -> " + collinearPoints[3]);*/
                        //StdOut.print(" ->stop " + collinearPoints[3]);
                        fast.sort(collinearPoints);
                        last = aux1[linesegment];
                      
                        //StdOut.print(a[i]);
                        StdOut.print(collinearPoints[0]);
                        
                        for (int f = 1; f < collinearPoints.length; f++)
                        {  //collinearPoints.add(aux1[f]);
                            //fast.sort(collinearPoints);
                            StdOut.print(" -> " + collinearPoints[f]);}
                            
                        StdOut.println();
                      
                        collinearPoints[0].drawTo(collinearPoints[collinearPoints.length-1]);
                    }
                    
                    initial = k;
                    linesegment = k;
                    firstone = current;
                }
                k++;
                 }
                  if (linesegment- initial >= 2 && aux1[linesegment] != last) {
                        collinearPoints = new Point [linesegment- initial+2];
                              //    StdOut.print(" ->hihi " + collinearPoints.length);
                        //StdOut.print(" oho " + collinearPoints[0]);
                        //collinearPoints = Arrays.copyOfRange(aux1, initial, linesegment+1); 
                        System.arraycopy(aux1, initial, collinearPoints, 1, linesegment- initial+1);
                        //System.arraycopy( aux1, initial, collinearPoints,linesegment- initial+1);
                        collinearPoints[0] = a[i];
                       
                        //StdOut.print(" ->stop " + collinearPoints[3]);
                        fast.sort(collinearPoints);
                        last = aux1[linesegment];
                      
                        //StdOut.print(a[i]);
                        StdOut.print(collinearPoints[0]);
                        
                        for (int f = 1; f < collinearPoints.length; f++)
                        {  //collinearPoints.add(aux1[f]);
                            //fast.sort(collinearPoints);
                            StdOut.print(" -> " + collinearPoints[f]);}
                            
                        StdOut.println();
                         
                        collinearPoints[0].drawTo(collinearPoints[collinearPoints.length-1]);
                    }
                    
               }
        StdDraw.show(0);
        StdDraw.setPenRadius();  
   }
}