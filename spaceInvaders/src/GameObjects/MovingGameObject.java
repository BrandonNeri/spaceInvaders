package GameObjects;

import Interfaces.Moveable;
import java.awt.Color;

/**
 *
 * @author Brandon Neri
 */
public abstract class MovingGameObject extends GameObject implements Moveable{

    private int xVelocity;
    private int yVelocity;
    
    public MovingGameObject(int xPosition, int yPosition, int xVelocity, int yVelocity, Color color) {
        super(xPosition, yPosition, color);
        this.xVelocity = xVelocity;
        this.yVelocity = yVelocity;
    }
    
    public int getXVelocity() { // Returns XVelocity
        return xVelocity;
    }
    
    public void setXVelocity(int newXVelocity) { // Sets new XVelocity
        this.xVelocity = newXVelocity;
    }
    
    public int getYVelocity() { // Returns YVelocity
        return yVelocity;
    }
    
    public void setYVelocity(int newYVelocity) { // Sets new YVelocity
        this.yVelocity = newYVelocity;
    }

    /**
     * This method creates a bouncing effect for the enemies that causes a
     * horizontal movement from left to right. The xVelocity is modified to
     * slow down to 1/3 the original speed as the frame rate is much to 
     * fast to make the game playable.
     */
    @Override
    public void move() {
        if (super.getXPosition() >= 570) { // Right wall
            xVelocity = -xVelocity;
            super.setYPosition(super.getYPosition()+5);
        } 
        if (super.getXPosition() <= 0) { // Left wall
            xVelocity = -xVelocity;
            super.setYPosition(super.getYPosition()+5);
        } 
        super.setXPosition(super.getXPosition() + xVelocity/3);
        super.setYPosition(super.getYPosition() + yVelocity );
    }
}
