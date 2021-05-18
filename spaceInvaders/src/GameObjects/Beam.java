package GameObjects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author Brandon Neri
 */
public class Beam extends MovingGameObject{
    
    private int width;
    private int height;

    public Beam(int xPosition, int yPosition, int xVelocity, int yVelocity, int width, int height, Color color) {
        super(xPosition, yPosition, xVelocity, yVelocity, color);
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw(Graphics g) { // Draws fill rectangle based on parameters given
        g.fillRect(super.getXPosition(), super.getYPosition(), width, height);
    }
    
    @Override
    public Rectangle getBounds() { // Creates rectangle to encase graphic from draw method
        Rectangle beam = new Rectangle(super.getXPosition(), super.getYPosition(), width, height);
        return beam;
    }
}
