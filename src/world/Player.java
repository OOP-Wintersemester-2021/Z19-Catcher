package world;

import de.ur.mi.oop.colors.Colors;
import de.ur.mi.oop.graphics.Rectangle;
import game.Config;
import utils.Direction;

public class Player implements WorldObject {

    private float x;
    private float y;
    private final Rectangle shape;
    private Direction currentDirection;

    public Player(float x, float y) {
        this.x = x;
        this.y = y;
        this.shape = new Rectangle(0, 0, Config.PLAYER_WIDTH, Config.PLAYER_HEIGHT, Config.PLAYER_COLOR);
        this.currentDirection = Direction.NEUTRAL;
    }

    public void moveLeft() {
        currentDirection = Direction.LEFT;
    }

    public void moveRight() {
        currentDirection = Direction.RIGHT;
    }

    public void stop() {
        currentDirection = Direction.NEUTRAL;
    }

    public Rectangle getBoundingBox() {
        return new Rectangle(shape.getXPos(), shape.getYPos(), shape.getWidth(), shape.getHeight(), Colors.WHITE);
    }

    public void update(double delta) {
        x += (Config.PLAYER_MOVEMENT_SPEED / delta) * currentDirection.modificator;
        shape.setPosition(x, y - shape.getHeight());
    }

    public void draw() {
        shape.draw();
    }
}
