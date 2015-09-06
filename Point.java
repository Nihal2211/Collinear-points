import java.util.Comparator;
import edu.princeton.cs.algs4.StdDraw;

public class Point implements Comparable<Point> {

    // compare points by slope
    public final Comparator<Point> SLOPE_ORDER = new SLOPE_ORDER();;       // YOUR DEFINITION HERE

    private final int x;                              // x coordinate
    private final int y;                              // y coordinate

    // create the point (x, y)
    public Point(int x, int y) {
        
        this.x = x;
        this.y = y;
    }

    // plot this point to standard drawing
    public void draw() {
    
        StdDraw.point(x, y);
    }

    // draw line between this point and that point to standard drawing
    public void drawTo(Point that) {

        StdDraw.line(this.x, this.y, that.x, that.y);
    }

    private class SLOPE_ORDER implements Comparator<Point> {
        
       public int compare (Point a, Point b){ 
          
           double slope1 = slopeTo(a);
            double slope2 = slopeTo(b);
            if (slope1 == slope2) {
                return 0;
            }
            if (slope1 < slope2) {
                return -1;
            }
            return 1;
        }     
    }
    
     public double slopeTo(Point that) {

         if (this.x == that.x && this.y == that.y){

              return Double.NEGATIVE_INFINITY;
         }
         else  if (that.y==this.y){  
            return (double)((that.x-that.x)/1.0);  
            
         }
         else if (that.x==this.x){
           return Double.POSITIVE_INFINITY;
             
         }
       
         double l ;
         l=((that.y -this.y) / (double)(that.x -this.x));
         
         return l;
    }
     
    public int compareTo(Point that) {
            if (this.y < that.y ) {
                 return -1;
        
             }
             else if (this.y == that.y && this.x < that.x){
                     return -1; }
             else if (this.y == that.y && this.x ==that.x){
                 return 0;
             }
             else { return 1; }
        
    }  
    
    public String toString() {
     
        return "(" + x + ", " + y + ")";
    }

    public static void main(String[] args) {
        Point grid = new Point(22000, 16500);
        Point grid2 = new Point(16000,  16000);
        Point grid3 = new Point(10000 ,  10000);
        
       System.out.println(grid.slopeTo(grid2));
       System.out.println(grid.slopeTo(grid3));
       //System.out.println(grid.SLOPE_ORDER.compare(grid3,grid2));
         //System.out.println("infinity" + (0.0/1.0)); 
         // System.out.println("infinity"); 
    }
}
