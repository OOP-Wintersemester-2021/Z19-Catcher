package world;

import de.ur.mi.oop.colors.Color;
import de.ur.mi.oop.graphics.Circle;
import de.ur.mi.oop.graphics.Rectangle;
import game.Config;

import java.util.Random;

public class Target implements WorldObject, Collidable {

    private final float speed;
    private final Circle shape;

    public Target (float x, float y, float speed, Color color) {
        this.speed = speed;
        this.shape = new Circle(x, y, Config.TARGET_RADIUS, color);
    }

    public void update(double delta) {
        float yMovement = (float) (speed / delta );
        shape.move(0, yMovement);
    }

    public void draw() {
        shape.draw();
    }

    @Override
    public boolean checkCollision(Rectangle boundingBox) {
        return boundingBox.hitTest(shape.getXPos(), shape.getYPos());
    }

    public static Target createRandomTarget() {
        Random random = new Random();
        float x = random.nextFloat(Config.TARGET_OFFSET, Config.WINDOW_WIDTH - Config.TARGET_OFFSET);
        float y = -Config.TARGET_RADIUS;
        float speed = random.nextFloat(Config.MIN_TARGET_SPEED, Config.MAX_TARGET_SPEED);
        Color color = Config.TARGET_COLORS[random.nextInt(Config.TARGET_COLORS.length)];
        return new Target(x, y, speed, color);
    }
}
