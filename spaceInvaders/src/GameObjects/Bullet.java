package GameObjects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author Brandon Neri
 */
public class Bullet extends MovingGameObject{
    
    private int diameter;
    
    public Bullet(int xPosition, int yPosition, int diameter, Color color) {
        super(xPosition, yPosition, 0, 9, color); // check x and y velocity
        this.diameter = diameter;
    }

    public int getDiameter() { // Returns diameter of bullet
        return diameter;
    }
    
    @Override
    public void draw(Graphics g) { // Draws fill rectangle based on parameters given
        g.fillRect(super.getXPosition(), super.getYPosition(), diameter, diameter);
    }
    
    @Override
    public Rectangle getBounds() { // Creates rectangle to encase graphic from draw method
        Rectangle bullet = new Rectangle(super.getXPosition(), super.getYPosition(), diameter, diameter);
        return bullet;
    }
}
