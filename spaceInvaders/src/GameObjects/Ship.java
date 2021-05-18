package GameObjects;

import Controller.KeyboardController;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author Brandon Neri
 */
public class Ship extends ControlledGameObject {

    public Ship(int xPosition, int yPosition, Color color, KeyboardController control) {
        super(xPosition, yPosition, color, control);
    }

    @Override
    public void draw(Graphics g) { // Draws fill rectangle based on parameters given
        g.fillRect(super.getXPosition()+10, super.getYPosition(), 10, 10);
        g.fillRect(super.getXPosition()+5, super.getYPosition()+10, 20, 10);
        g.fillRect(super.getXPosition(), super.getYPosition()+20, 30, 10);
        g.fillRect(super.getXPosition()-5, super.getYPosition()+30, 40, 10);
    }

    @Override
    public Rectangle getBounds() { // Creates rectangle to encase graphic from draw method
        Rectangle ship = new Rectangle(super.getXPosition(), super.getYPosition(), 30, 30);
        return ship;
    }

    
    /**
     * This method creates a moving effect for the ship that causes a
     * horizontal movement from left to right by the use of arrow key keyboard
     * input. The xPosition is modified by the pressing of the left and right
     * arrow keys to change only the horizontal positions of the ship.
     */
    @Override
    public void move() {
        if(super.getXPosition() >= 600) {
            super.setXPosition(0);
        } 
        if(super.getXPosition() <= -30) {
            super.setXPosition(600);
        } 
  
        if (super.control.getRightKeyStatus()){
            super.setXPosition(super.getXPosition() + 3);
        }
        if (super.control.getLeftKeyStatus()){
            super.setXPosition(super.getXPosition() - 3);
        }
    }
}
