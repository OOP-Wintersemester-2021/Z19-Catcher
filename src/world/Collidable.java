package world;

import de.ur.mi.oop.graphics.Rectangle;

public interface Collidable {

    boolean checkCollision(Rectangle boundingBox);
}
