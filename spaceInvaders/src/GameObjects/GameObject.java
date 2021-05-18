package GameObjects;

import Interfaces.Drawable;
import java.awt.Color;
import java.awt.Rectangle;

/**
 *
 * @author Brandon Neri
 */
public abstract class GameObject implements Drawable {

    private int xPosition;
    private int yPosition;
    private Color color;

    public GameObject(int xPosition, int yPosition, Color color) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.color = color;
    }

    public abstract Rectangle getBounds();

    public int getXPosition() { // Returns X position
        return xPosition;
    }

    public void setXPosition(int xPosition) { // Sets X position
        this.xPosition = xPosition;
    }

    public int getYPosition() { // Returns Y position
        return yPosition;
    }

    public void setYPosition(int yPosition) { // Sets Y position
        this.yPosition = yPosition;
    }

    public Color getColor() { // Returns color
        return color;
    }

    public void setColor(Color color) { // Sets color
        this.color = color;
    }

    public boolean isColliding(GameObject other) { // Check to see if two rectangles are colliding
        return this.getBounds().intersects(other.getBounds());
    }
}
