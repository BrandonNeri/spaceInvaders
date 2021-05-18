package GameObjects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author Brandon Neri
 */
public class Enemy extends MovingGameObject {

    public Enemy(int xPosition, int yPosition, int xVelocity, int yVelocity, Color color) {
        super(xPosition, yPosition, xVelocity, yVelocity, color);
    }

    @Override
    public void draw(Graphics g) { // Draws fill oval based on parameters given
        g.setColor(Color.CYAN);
        g.fillOval(super.getXPosition(), super.getYPosition(), 30, 30);
        g.fillRect(super.getXPosition(), super.getYPosition() + 15, 30, 15);
        g.setColor(Color.BLACK);
        g.fillOval(super.getXPosition()+5, super.getYPosition()+8, 8, 8);
        g.fillOval(super.getXPosition()+17, super.getYPosition()+8, 8, 8);
        g.fillRect(super.getXPosition()+5, super.getYPosition()+20, 20, 3);        
    }
    
    @Override
    public Rectangle getBounds() { // Creates rectangle to encase graphic from draw method
        Rectangle enemy = new Rectangle(super.getXPosition(), super.getYPosition(), 30, 30);
        return enemy;
    }
}
