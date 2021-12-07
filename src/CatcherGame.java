import de.ur.mi.oop.app.GraphicsApp;
import de.ur.mi.oop.events.KeyPressedEvent;
import de.ur.mi.oop.events.KeyReleasedEvent;
import de.ur.mi.oop.graphics.Label;
import de.ur.mi.oop.launcher.GraphicsAppLauncher;
import game.Config;
import world.Collidable;
import world.Player;
import world.Target;
import world.WorldObject;

public class CatcherGame extends GraphicsApp {

    private Player player;
    private WorldObject[] worldObjects;
    private Label scoreLabel;
    private int score = 0;

    @Override
    public void initialize() {
        initWorld();
        Target[] targets = createTargets();
        worldObjects = collectObjects(player, targets);
    }

    private void initWorld() {
        setCanvasSize(Config.WINDOW_WIDTH, Config.WINDOW_HEIGHT);
        player = new Player(0, getHeight());
        scoreLabel = createScoreLabel();
    }

    private Target[] createTargets() {
        Target[] targets = new Target[Config.MAX_TARGETS];
        for (int i = 0; i < targets.length; i++) {
            targets[i] = Target.createRandomTarget();
        }
        return targets;
    }

    private Label createScoreLabel() {
        Label label = new Label(Config.LABEL_POSITION.getXPos(), Config.LABEL_POSITION.getYPos(), Config.LABEL_PREFIX + score);
        label.setFont(Config.LABEL_FONT);
        label.setFontSize(Config.LABEL_FONT_SIZE);
        label.setColor(Config.LABEL_COLOR);
        return label;
    }

    private WorldObject[] collectObjects(Player player, Target[] targets) {
        WorldObject[] worldObjects = new WorldObject[targets.length + 1];
        worldObjects[0] = player;
        System.arraycopy(targets, 0, worldObjects, 1, targets.length);
        return worldObjects;
    }

    @Override
    public void draw() {
        updateWorld();
        drawWorld();
    }

    private void updateWorld() {
        double delta = getCurrentDeltaTime();
        for (int i = 0; i < worldObjects.length; i++) {
            worldObjects[i].update(delta);
            if (worldObjects[i] instanceof Collidable) {
                boolean wasCaughtByPlayer = ((Collidable) worldObjects[i]).checkCollision(player.getBoundingBox());
                if (wasCaughtByPlayer) {
                    worldObjects[i] = Target.createRandomTarget();
                    incrementScore();
                }
            }
        }
    }

    private void incrementScore() {
        score++;
        scoreLabel.setText(Config.LABEL_PREFIX + score);
    }

    private void drawWorld() {
        drawBackground(Config.BACKGROUND_COLOR);
        for (WorldObject object : worldObjects) {
            object.draw();
        }
        scoreLabel.draw();
    }

    public static void main(String[] args) {
        GraphicsAppLauncher.launch("CatcherGame");
    }

    @Override
    public void onKeyPressed(KeyPressedEvent event) {
        switch (event.getKeyCode()) {
            case KeyPressedEvent.VK_LEFT -> player.moveLeft();
            case KeyPressedEvent.VK_RIGHT -> player.moveRight();
        }
    }

    @Override
    public void onKeyReleased(KeyReleasedEvent event) {
        player.stop();
    }
}
