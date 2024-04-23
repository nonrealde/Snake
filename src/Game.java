import javax.swing.Timer;

public class Game {
    private final int ALLE = Gui.GAME_HEIGHT * Gui.GAME_WIDTH;
    private final int x[] = new int[ALLE];
    private final int y[] = new int[ALLE];
    public static int appleX;
    public static int appleY;
    static boolean gameRunning = true;
    static int FPS = 60;
    enum Direction {
        LEFT,
        UP,
        RIGHT,
        DOWN
    }

    public static void initGame() {
        spawnApple();
        gameLoop();
    }

    private Timer t;

    public static void spawnApple() {
        appleX = (int) (Math.random() * Gui.GAME_HEIGHT / 10) * 10;
        appleY = (int) (Math.random() * Gui.GAME_WIDTH / 10) * 10;
        System.out.println("Apple spawned at: " + appleX + "|" + appleY);
        Gui.refreshFrame();
    }
    public static void gameLoop() {
        double drawInterval = 1000000000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        while (gameRunning) {
            // System.out.println(delta);
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;

            if(delta >= 1) {
            System.out.println(Snake.currentDirection);
            delta--;
            }
        }
    }
    
}