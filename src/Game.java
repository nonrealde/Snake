import javax.swing.Timer;

public class Game {
    enum Direction {
        LEFT,
        TOP,
        RIGHT,
        DOWN
    }
    public static void initGame() {
        spawnApple();
    }
    private final int ALLE = 900;
    private final int x[] = new int[ALLE];
    private final int y[] = new int[ALLE];
    public static int appleX;
    public static int appleY;

    private Timer t;

    public static void spawnApple() {
        appleX = (int) (Math.random() * Gui.GAME_HEIGHT / 10) * 10;
        appleY = (int) (Math.random() * Gui.GAME_WIDTH / 10) * 10;
        System.out.println("Apple spawned at: " + appleX + "|" + appleY);
        Gui.refreshFrame();
    }
    
}