package GameObjects;

import Controller.KeyboardController;
import Interfaces.Moveable;
import java.awt.Color;

/**
 *
 * @author Brandon Neri
 */
public abstract class ControlledGameObject extends GameObject implements Moveable {
    
    KeyboardController control;

    public ControlledGameObject(int xPosition, int yPosition, Color color, KeyboardController control) { // Might be MovingGameObject
        super(xPosition, yPosition, color); // Inherit values from GameObject Class
        this.control = control; // Define new instance of KeyboardController Class
    }
}
