import java.util.Random;

public class Game {
    private final int ALLE = Gui.GAME_HEIGHT * Gui.GAME_WIDTH;
    private final int x[] = new int[ALLE];
    private final int y[] = new int[ALLE];
    public static int appleX;
    public static int appleY;

    static boolean gameRunning = true;
    static int FPS = 10;
    Random random = new Random();

    enum Direction {
        LEFT,
        UP,
        RIGHT,
        DOWN
    }

    public static void initGame() {
        startingLocation();
        spawnApple();
        gameLoop();
    }

    public static void spawnApple() {
        appleX = (int) (Math.random() * Gui.GAME_HEIGHT / 10) * 10;
        appleY = (int) (Math.random() * Gui.GAME_WIDTH / 10) * 10;

        // Check that apple doesnt spawn in snake
        // if(location != snake) {
        //     lets go
        // } else {
        //     neustart methode
        // }

        System.out.println("Apple spawned at: " + appleX + "|" + appleY);
        Gui.refreshFrame();
    }

    public static void startingLocation() {
        Snake.headX = (int) (Math.random() * (Gui.GAME_HEIGHT - 100) / 10) * 10 + 50;
        Snake.headY = (int) (Math.random() * (Gui.GAME_WIDTH - 100) / 10) * 10 + 50;

        System.out.println("Snake spawned at: " + Snake.headX + "|" + Snake.headY);
        Gui.refreshFrame();
    }

    public static void updateSnakeLocation() {
        if(Snake.currentDirection == Direction.UP) {

        }
        switch (Snake.currentDirection) {
            case Direction.UP:
                Snake.headY -= 10;
                break;
            case Direction.RIGHT:
                Snake.headX += 10;
                break;
            case Direction.DOWN:
                Snake.headY += 10;
                break;
            case Direction.LEFT:
                Snake.headX -= 10;
                break;
            
            default:
                break;
        }
    }

    public static void checkCollision() {
        
    }
    // Snake -> Wand
    // Snake -> Snake
    // Snake -> APfel

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
                updateSnakeLocation();
                Gui.refreshFrame();
                System.out.println(Snake.currentDirection);
                delta--;
            }
        }
    }
    
}