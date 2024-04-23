import java.util.Random;

public class Game {
    public static int appleX;
    public static int appleY;

    static boolean gameRunning = true;
    static boolean gameOver = false;
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
        // Snake -> Wand
        if (Snake.headX < 0 || Snake.headX > Gui.GAME_WIDTH) {
            gameOver = true;
        }
        if (Snake.headY < 0 || Snake.headY > Gui.GAME_HEIGHT) {
            gameOver = true;
        }
        // Snake -> Snake
        if (Snake.headX == appleX && Snake.headY == appleY) {
            // temp array old snake state
            int tmp[][] = Snake.body.clone();
            // create new array -> new length
            Snake.body = new int[++Snake.length][2];

            Snake.body[0][0] = appleX;
            Snake.body[0][1] = appleY;

            // loop over tmp array to fill new array with old values
            for (int i = 0; i < tmp.length; i++) {
                Snake.body[i + 1][0] = tmp[i][0];
                Snake.body[i + 1][1] = tmp[i][1];
            }
            
            System.out.println(Snake.body[0][0] + "|" + Snake.body[0][1]);
            spawnApple();
        }
        // Snake -> APfel
        
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
                updateSnakeLocation();
                checkCollision();
                if (gameOver) {
                    //  gameOver();
                    break;
                }
                Gui.refreshFrame();
                // System.out.println(Snake.currentDirection + " " + Snake.headX + "|" + Snake.headY);
                // System.out.println(Snake.body.length);
                delta--;
            }
        }
    }
    
}