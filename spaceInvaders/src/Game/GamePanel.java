package Game;

import Controller.KeyboardController;
import GameObjects.Beam;
import GameObjects.Bullet;
import GameObjects.Enemy;
import GameObjects.Shield;
import GameObjects.Ship;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Brandon Neri
 */
public class GamePanel extends JPanel implements Serializable {

    /*
     * These are for handling the frame rate of the game and player controls
     * You should pass the controller to any objects you create that will
     * be under keyboard control.
     */
    private Timer gameTimer;
    private KeyboardController controller;

    // Controls size of game window and framerate
    private final int gameWidth = 600;
    private final int gameHeight = 720;
    private final int framesPerSecond = 120;

    // Game variables
    int playerLives = 30;
    int playerScore = 0;
    int bulletSpeed = 0;
    boolean isBulletShot = false;
    int beamSpeed = 0;
    boolean isBeam1Shot = false;
    boolean isBeam2Shot = false;

    // Ship
    Ship playerShip;

    // Bullet
    Bullet bullet;

    // Beam
    Beam beam1;
    Beam beam2;

    // Shields
    Shield leftShield1, leftShield2, leftShield3, leftShield4, leftShield5; // Left shield
    Shield centerShield1, centerShield2, centerShield3, centerShield4, centerShield5; // Center shield
    Shield rightShield1, rightShield2, rightShield3, rightShield4, rightShield5; // Right shield
    ArrayList<Shield> shields;

    // Enemies 
    Enemy enemy1_1, enemy1_2, enemy1_3, enemy1_4, enemy1_5, enemy1_6, enemy1_7,
            enemy2_1, enemy2_2, enemy2_3, enemy2_4, enemy2_5, enemy2_6, enemy2_7,
            enemy3_1, enemy3_2, enemy3_3, enemy3_4, enemy3_5, enemy3_6, enemy3_7,
            enemy4_1, enemy4_2, enemy4_3, enemy4_4, enemy4_5, enemy4_6, enemy4_7;
    ArrayList<Enemy> enemies;

    /**
     * This method is called by the GameFrame class when starting the game for the first time. It should be used like a constructor method where you initialize all of the instance variables. You can also use this method to reset a game after a player wins or loses and wants to play again.
     */
    public final void setupGame() {
        // Ship creation
        playerShip = new Ship(285, 650, Color.BLUE, controller);

        // Bullet creation
        bullet = new Bullet(playerShip.getXPosition() + 10, playerShip.getYPosition(), 5, Color.yellow);

        // Shield creation
        leftShield1 = new Shield(50, 600, 20, 9, Color.RED);
        leftShield2 = new Shield(70, 600, 20, 9, Color.RED);
        leftShield3 = new Shield(90, 600, 20, 9, Color.RED);
        leftShield4 = new Shield(110, 600, 20, 9, Color.RED);
        leftShield5 = new Shield(130, 600, 20, 9, Color.RED);

        centerShield1 = new Shield(255, 600, 20, 9, Color.RED);
        centerShield2 = new Shield(275, 600, 20, 9, Color.RED);
        centerShield3 = new Shield(295, 600, 20, 9, Color.RED);
        centerShield4 = new Shield(315, 600, 20, 9, Color.RED);
        centerShield5 = new Shield(335, 600, 20, 9, Color.RED);

        rightShield1 = new Shield(460, 600, 20, 9, Color.RED);
        rightShield2 = new Shield(480, 600, 20, 9, Color.RED);
        rightShield3 = new Shield(500, 600, 20, 9, Color.RED);
        rightShield4 = new Shield(520, 600, 20, 9, Color.RED);
        rightShield5 = new Shield(540, 600, 20, 9, Color.RED);

        shields = new ArrayList<>();
        shields.add(leftShield1);
        shields.add(leftShield2);
        shields.add(leftShield3);
        shields.add(leftShield4);
        shields.add(leftShield5);
        shields.add(centerShield1);
        shields.add(centerShield2);
        shields.add(centerShield3);
        shields.add(centerShield4);
        shields.add(centerShield5);
        shields.add(rightShield1);
        shields.add(rightShield2);
        shields.add(rightShield3);
        shields.add(rightShield4);
        shields.add(rightShield5);

        // Enemy creation
        enemy1_1 = new Enemy(165, 60, 5, 0, Color.CYAN);
        enemy1_2 = new Enemy(205, 60, 5, 0, Color.CYAN);
        enemy1_3 = new Enemy(245, 60, 5, 0, Color.CYAN);
        enemy1_4 = new Enemy(285, 60, 5, 0, Color.CYAN);
        enemy1_5 = new Enemy(325, 60, 5, 0, Color.CYAN);
        enemy1_6 = new Enemy(365, 60, 5, 0, Color.CYAN);
        enemy1_7 = new Enemy(405, 60, 5, 0, Color.CYAN);
        enemy2_1 = new Enemy(165, 100, 5, 0, Color.MAGENTA);
        enemy2_2 = new Enemy(205, 100, 5, 0, Color.MAGENTA);
        enemy2_3 = new Enemy(245, 100, 5, 0, Color.MAGENTA);
        enemy2_4 = new Enemy(285, 100, 5, 0, Color.MAGENTA);
        enemy2_5 = new Enemy(325, 100, 5, 0, Color.MAGENTA);
        enemy2_6 = new Enemy(365, 100, 5, 0, Color.MAGENTA);
        enemy2_7 = new Enemy(405, 100, 5, 0, Color.MAGENTA);
        enemy3_1 = new Enemy(165, 140, 5, 0, Color.WHITE);
        enemy3_2 = new Enemy(205, 140, 5, 0, Color.WHITE);
        enemy3_3 = new Enemy(245, 140, 5, 0, Color.WHITE);
        enemy3_4 = new Enemy(285, 140, 5, 0, Color.WHITE);
        enemy3_5 = new Enemy(325, 140, 5, 0, Color.WHITE);
        enemy3_6 = new Enemy(365, 140, 5, 0, Color.WHITE);
        enemy3_7 = new Enemy(405, 140, 5, 0, Color.WHITE);
        enemy4_1 = new Enemy(165, 180, 5, 0, Color.ORANGE);
        enemy4_2 = new Enemy(205, 180, 5, 0, Color.ORANGE);
        enemy4_3 = new Enemy(245, 180, 5, 0, Color.ORANGE);
        enemy4_4 = new Enemy(285, 180, 5, 0, Color.ORANGE);
        enemy4_5 = new Enemy(325, 180, 5, 0, Color.ORANGE);
        enemy4_6 = new Enemy(365, 180, 5, 0, Color.ORANGE);
        enemy4_7 = new Enemy(405, 180, 5, 0, Color.ORANGE);

        enemies = new ArrayList<>(7);
        enemies.add(enemy1_1);
        enemies.add(enemy1_2);
        enemies.add(enemy1_3);
        enemies.add(enemy1_4);
        enemies.add(enemy1_5);
        enemies.add(enemy1_6);
        enemies.add(enemy1_7);
        enemies.add(enemy2_1);
        enemies.add(enemy2_2);
        enemies.add(enemy2_3);
        enemies.add(enemy2_4);
        enemies.add(enemy2_5);
        enemies.add(enemy2_6);
        enemies.add(enemy2_7);
        enemies.add(enemy3_1);
        enemies.add(enemy3_2);
        enemies.add(enemy3_3);
        enemies.add(enemy3_4);
        enemies.add(enemy3_5);
        enemies.add(enemy3_6);
        enemies.add(enemy3_7);
        enemies.add(enemy4_1);
        enemies.add(enemy4_2);
        enemies.add(enemy4_3);
        enemies.add(enemy4_4);
        enemies.add(enemy4_5);
        enemies.add(enemy4_6);
        enemies.add(enemy4_7);

        // Beam Creation
        beam1 = new Beam(enemy1_1.getXPosition(), enemy1_1.getYPosition(), 0, 1, 3, 13, Color.GREEN);
        beam2 = new Beam(enemy1_3.getXPosition(), enemy1_3.getYPosition(), 0, 1, 3, 13, Color.GREEN);
    }

    /**
     * This method is automatically called by the game timer every frame. As typical, you should use it to draw all of your game objects.
     *
     * @param g The Graphics object used for drawing the GameObject instances.
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);

        // Lives
        g.setColor(Color.red);
        g.setFont(new Font("Arial", 1, 20));
        g.drawString("Lives: " + playerLives / 10, 520, 25);
        g.drawString("Score: " + playerScore, 5, 25);

        // Bullet
        g.setColor(bullet.getColor());
        bullet.draw(g);

        // Beam
        g.setColor(beam1.getColor());
        beam1.draw(g);
        beam2.draw(g);

        // Ship
        g.setColor(playerShip.getColor());
        playerShip.draw(g);

        // Shields
        g.setColor(leftShield1.getColor());
        shields.forEach(s -> {
            s.draw(g);
        });

        // Enemies: Draws Rows 1-4
        //g.setColor(enemy1_1.getColor());
        enemies.forEach(e -> {
            e.draw(g);
        });

        // Ends game if player wins
        boolean endGameCheck = false;
        if (playerScore == 2800) { // Win
            endGameCheck = true;
            super.paint(g);
            g.setColor(Color.red);
            g.setFont(new Font("Arial", 1, 20));
            g.drawString("GAME OVER! YOU WIN!", 190, 200);
            g.drawString("PRESS ENTER FOR A NEW GAME", 140, 230);
            g.drawString("CREDITS", 260, 300);
            g.drawString("GAME MADE BY BRANDON NERI", 140, 330);
            g.drawString("DESIGNED FOR COURSE CSCI 160", 135, 360);
            g.drawString("NDSU 2020", 250, 390);
            g.drawString("PRESS ENTER FOR A NEW GAME", 140, 480);
            // Call new game
            if (controller.getKeyStatus(KeyEvent.VK_ENTER)) {
                playerLives = 30;
                playerScore = 0;
                gameTimer.start();
                this.setupGame();
            }
        }

        // Ends game if player dies
        if (playerLives == 0 && endGameCheck == false) { // Lose
            g.setColor(Color.red);
            g.drawString("GAME OVER! YOU LOSE!", 180, 300);
            g.drawString("PRESS ENTER FOR A NEW GAME", 140, 330);

            for (Enemy e : enemies) {
                e.setXPosition(3000);
                e.setYPosition(3000);
            }

            // Call new game
            if (controller.getKeyStatus(KeyEvent.VK_ENTER)) {
                playerLives = 30;
                playerScore = 0;
                gameTimer.start();
                this.setupGame();
            }
        }
    }

    /**
     * This method is automatically called by the game timer every frame. Any of your code for moving game objects or handling collisions, etc. should be done by this method. The method has a single parameter which represents the current frame number, which is incremented by the Timer each time before the method is called. You can assume that it will always increase, but it will eventually overflow if the game runs long enough (something like 1 year)
     *
     * @param frameNumber The number of the current frame.
     */
    public void updateGameState(int frameNumber) {

        // Move player ship
        playerShip.move();

        // Move enemies
        enemies.forEach(e -> {
            e.move();
            Graphics g = getGraphics();
            g.setColor(Color.CYAN);
            g.fillOval(e.getXPosition(), e.getYPosition(), 30, 30);
            g.fillRect(e.getXPosition(), e.getYPosition() + 15, 30, 15);
            g.setColor(Color.BLACK);
            g.fillOval(e.getXPosition() + 5, e.getYPosition() + 8, 8, 8);
            g.fillOval(e.getXPosition() + 17, e.getYPosition() + 8, 8, 8);
            g.fillRect(e.getXPosition() + 5, e.getYPosition() + 20, 20, 8);

        });

        // Returns beam to enemy
        if (beam1.getYPosition() >= 720) {
            isBeam1Shot = false;
            beamSpeed = 0;
            beam1.setYPosition(enemy1_1.getYPosition());
        }
        if (beam2.getYPosition() >= 720) {
            isBeam2Shot = false;
            beamSpeed = 0;
            beam2.setYPosition(enemy1_3.getYPosition());
        }

        // Checks if beam is shot
        if (!isBeam1Shot) {
            beam1.setXPosition(enemy1_1.getXPosition() + 15);
        }
        if (!isBeam2Shot) {
            beam2.setXPosition(enemy1_3.getXPosition() + 15);
        }

        // Shoots beams
        if (true) {
            beamSpeed = 9;
            beam1.setXPosition(beam1.getXPosition());
            isBeam1Shot = true;
        }
        beam1.setYPosition(beam1.getYPosition() + beamSpeed - 4);
        if (true) {
            beamSpeed = 9;
            beam2.setXPosition(beam2.getXPosition());
            isBeam2Shot = true;
        }
        beam2.setYPosition(beam2.getYPosition() + beamSpeed - 3);

        // Returns bullet to playerShip
        if (bullet.getYPosition() <= 0) {
            isBulletShot = false;
            bulletSpeed = 0;
            bullet.setYPosition(playerShip.getYPosition());
        }

        // Returns bullet to playerShip
        if (bullet.getYPosition() <= 0) {
            isBulletShot = false;
            bulletSpeed = 0;
            bullet.setYPosition(playerShip.getYPosition());
        }

        // Checks if bullet is shot
        if (!isBulletShot) {
            bullet.setXPosition(playerShip.getXPosition() + 15);
        }

        // Checks if space key is pressed to shoot bullet
        if (controller.getSpaceKeyStatus()) {
            bulletSpeed = 12;
            bullet.setXPosition(bullet.getXPosition());
            isBulletShot = true;
        }
        bullet.setYPosition(bullet.getYPosition() - bulletSpeed);

        // Checks if bullet has made contact with a shield
        shields.forEach(s -> {
            this.shieldCollision(s);
        });

        // Checks if bullet has made contact with an enemy
        enemies.forEach(e -> {
            this.enemyCollision(e);
        });

        // Check if beam has made contact with player's ship
        this.shipCollision(beam1);
        this.shipCollision(beam2);
    }

    /**
     * This method checks to see if a bullet is colliding with a shield and responds by resetting the isBulletShot Boolean and removes the shield.
     */
    public void shieldCollision(Shield s) {
        if (s.isColliding(bullet)) {
            s.setXPosition(600);
            s.setYPosition(720);
            isBulletShot = false;
            bulletSpeed = 0;
            bullet.setYPosition(playerShip.getYPosition());
        }
        if (s.isColliding(beam1)) {
            s.setXPosition(600);
            s.setYPosition(720);
            isBeam1Shot = false;
            beamSpeed = 0;
            beam1.setYPosition(enemy1_1.getYPosition());
        }
        if (s.isColliding(beam2)) {
            s.setXPosition(600);
            s.setYPosition(720);
            isBeam2Shot = false;
            beamSpeed = 0;
            beam2.setYPosition(enemy1_6.getYPosition());
        }
    }

    /**
     * This method checks to see if a bullet is colliding with a enemy and responds by resetting the isBulletShot Boolean and removes the enemy.
     */
    public void enemyCollision(Enemy e) {
        if (e.isColliding(bullet)) {
            e.setXPosition(600);
            e.setYPosition(720);
            isBulletShot = false;
            bulletSpeed = 0;
            playerScore += 100;
            bullet.setYPosition(playerShip.getYPosition());
        }
    }

    /**
     * This method checks to see if a beam is colliding with a player's ship and responds by decreasing the playerLives value to one less than the current value.
     */
    public void shipCollision(Beam b) {
        if (b.isColliding(playerShip)) {
            playerLives -= 3;
            System.out.println(playerLives);
        }
        if (playerLives < 10) {
            playerLives = 0;
        }
    }

    /**
     * Constructor method for GamePanel class. It is not necessary for you to modify this code at all
     */
    public GamePanel() {

        // Set the size of the Panel
        this.setSize(gameWidth, gameHeight);
        this.setPreferredSize(new Dimension(gameWidth, gameHeight));
        this.setBackground(Color.BLACK);

        // Register KeyboardController as KeyListener
        controller = new KeyboardController();
        this.addKeyListener(controller);

        // Call setupGame to initialize fields
        this.setupGame();
        this.setFocusable(true);
        this.requestFocusInWindow();
    }

    /**
     * Method to start the Timer that drives the animation for the game. It is not necessary for you to modify this code unless you need to in order to add some functionality.
     */
    public void start() {
        // Set up a new Timer to repeat based on the set framesPerSecond
        gameTimer = new Timer(1000 / framesPerSecond, new ActionListener() {

            // Tracks the number of frames that have been produced.
            // May be useful for limiting action rates
            private int frameNumber = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                // Update the game's state and repaint the screen
                updateGameState(frameNumber++);
                repaint();

            }
        });
        gameTimer.setRepeats(true);
        gameTimer.start();
    }
}
