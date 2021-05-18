package GameObjects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author Brandon Neri
 */
public class Shield extends GameObject{

    private int width;
    private int height;
    
    public Shield(int xPosition, int yPosition, int width, int height, Color color) {
        super(xPosition, yPosition, color);
        this.width = width;
        this.height = height;
    }
    
    public int getWidth() { // Returns width of shield
        return width;
    }
    
    public void setWidth(int width) { // Sets width of shield
        this.width = width;
    }
    
    public int getHeight() { // Returns height of shield
        return height;
    }
    
    public void setHeight(int height) { // Sets height of shield
        this.height = height;
    }

    @Override
    public void draw(Graphics g) { // Draws fill rectangle based on parameters given
        g.fillRect(super.getXPosition(), super.getYPosition(), width, height);
    }
    
    @Override
    public Rectangle getBounds() { // Creates rectangle to encase graphic from draw method
        Rectangle sheild = new Rectangle(super.getXPosition(), super.getYPosition(), width, height);
        return sheild;
    }
}
