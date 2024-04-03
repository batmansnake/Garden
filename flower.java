import ecs100.*; // import ecs100 library
import java.awt.Color; // import colours
/**
 * Flower support class
 * Creates a flower of a size and colour, that can grow
 *
 * @author Creed
 * @version 0.4
 * 4.4.24
 */
public class flower
{
    // instance variables
    private double flowerX = -100;
    private double flowerY = -100; // location of flower
    
    private int flowerSize;
    private int flowerHeight; // proportions of flower
    
    private double left;
    private double top;
    private double bottom; // bounding box of the flower
    
     /**
     * Constructor for objects of class flower
     */
    public flower(double x, double y, int size, int stem)
    {
        // initialise instance variables
        this.flowerX = x;
        this.flowerY = y;
        this.flowerSize = size;
        this.flowerHeight = stem;
        
        // set top, left, and bottom
        this.setTop();
        this.setLeft();
        this.setBottom();
    }

    /**
     * Setter method for left
     */
    public void setLeft()
    {
        // put your code here
        this.left = flowerX - flowerSize/2.0;
    }
    
    /**
     * Set top
     */
    public void setTop(){
        this.top = flowerY - flowerSize/2.0;
    }
    
    /**
     * Set bottom
     */
    public void setBottom(){
        this.bottom = flowerY + flowerHeight;
    }
    
    /**
     * Draw the flower
     */
    public void draw(){
        // draw stem
        UI.setColor(Color.green);
        UI.setLineWidth(2);
        UI.drawLine(this.flowerX, this.flowerY, this.flowerX, this.bottom);
        
        //draw flower
        UI.setColor(Color.pink);
        UI.fillOval(this.left, this.top, this.flowerSize, this.flowerSize);
        UI.sleep(500);
    }
    
    /**
     * Erase the flower
     */
    public void erase(){
        final int BUFFER = 1;
        UI.eraseRect(left, top, flowerSize + 1, bottom + BUFFER);
    }
    
    /**
     * Grow the flower
     */
    public void grow(){
        this.erase();
        //change the x and y values
        this.flowerY -= 10;
        this.flowerX += 10;
        
        // set the new values
        this.setTop();
        this.setLeft();
        this.setBottom();
    }
    
    public static void main(String[] args){
        flower f1 = new flower(50,100, 20, 20);
        flower f2 = new flower(100, 100, 25, 25);
        flower f3 = new flower(150, 100, 15, 15);
        
        f1.draw();
        f2.draw();
        f3.draw();
        for (int i = 0; i < 10; i++){
            f1.grow();
            f2.grow();
            f3.grow();
        }
    }
}
