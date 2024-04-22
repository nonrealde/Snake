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
    
        double rand = Math.random();
        appleX = (int) (rand * 30) * 10;
        rand = Math.random();
        appleY = (int) (rand * 30) * 10;
        System.out.println("Apple spawned at: " + appleX + "|" + appleY);
    }
}