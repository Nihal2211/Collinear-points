import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

public class Brute {
    
    
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
       Brute brute = new Brute(); 
       String filename = args[0];
        In in = new In(filename);
        int N = in.readInt();
        Point[] a = new Point[N];
        Point[] aux1 = new Point[4];
        Point[] aux2 = new Point[4];
        for (int iterating = 0; iterating < N; iterating++) {
            int x = in.readInt();
            int y = in.readInt();
            Point p = new Point(x, y);
            a[iterating] = p;
            p.draw();
            
        
        }
        for (int i = 0; i < N; i++){
            for (int j = i + 1; j < N; j++) {
                 for (int k = j + 1; k < N; k++) {
                      for (int l = k + 1; l < N; l++) {
                          if ((a[i].slopeTo(a[j]) == a[i].slopeTo(a[k])) && 
                              (a[i].slopeTo(a[k])== a[i].slopeTo(a[l])) && 
                              (a[i].slopeTo(a[l])== a[i].slopeTo(a[k]))) {
                               aux1[0]=a[i]; aux1[1]=a[j];  aux1[2]=a[k];  aux1[3]=a[l];
                                brute.sort(aux1);
                                StdOut.println(aux1[0]+"->"+aux1[1]+"->"+aux1[2]+"->"+aux1[3]);
                               aux1[0].drawTo(aux1[3]);
                               
                             }
                        }
                 }
            }   
        }
        StdDraw.show(0);
        StdDraw.setPenRadius();  
   }
}
