package game;

import de.ur.mi.oop.colors.Color;
import de.ur.mi.oop.graphics.Point;

public class Config {

    private static final Color RED = new Color(234, 49, 63); // "Selbstgemischter" RGB-Farbe (rot)
    private static final Color YELLOW = new Color(234, 182, 56); // "Selbstgemischter" RGB-Farbe (gelb)
    private static final Color GREEN = new Color(76, 149, 80); // "Selbstgemischter" RGB-Farbe (grün)
    private static final Color BLUE = new Color(53, 129, 184); // "Selbstgemischter" RGB-Farbe (blau)
    private static final Color TURQUOISE = new Color(9, 82, 86); // "Selbstgemischter" RGB-Farbe (türkis)
    private static final Color PURPLE = new Color(55, 39, 114); // "Selbstgemischter" RGB-Farbe (lila)
    private static final Color CREAM = new Color(241, 255, 250); // "Selbstgemischter" RGB-Farbe (creme)
    private static final Color GREY = new Color(47, 61, 76); // "Selbstgemischter" RGB-Farbe (grau)

    public static final int WINDOW_WIDTH = 1280;
    public static final int WINDOW_HEIGHT = 800;
    public static final int FLOOR_HEIGHT = 200;
    public static final Color BACKGROUND_COLOR = GREY;
    public static final Color FLOOR_COLOR = CREAM;

    public static final Point LABEL_POSITION = new Point(50, 50);
    public static final String LABEL_PREFIX = "Punkte: ";
    public static final String LABEL_FONT = "Arial Rounded MT Bold";
    public static final Color LABEL_COLOR = CREAM;
    public static final int LABEL_FONT_SIZE = 18;

    public static final float PLAYER_WIDTH = 20;
    public static final float PLAYER_HEIGHT = 100;
    public static final Color PLAYER_COLOR = RED;
    public static final float PLAYER_MOVEMENT_SPEED = 100; // Pixels per Second

    public static final int MAX_TARGETS = 10;
    public static final float TARGET_RADIUS = 10;
    public static final float TARGET_OFFSET = 50;
    public static final float MIN_TARGET_SPEED = 50; // Pixels per Second
    public static final float MAX_TARGET_SPEED = 75; // Pixels per Second
    public static final Color[] TARGET_COLORS = {YELLOW, GREEN, BLUE};

}
