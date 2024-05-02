public class Game {
    public static int appleX;
    public static int appleY;

    static boolean gameRunning = true;
    static boolean gameOver = false;
    static int FPS = 10;
    static double drawInterval = 1000000000/FPS;
    static double delta = 0;
    static long lastTime = System.nanoTime();
    static long currentTime;
    static int x = 0;

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

    public static void newGame() {
        // Snake.body = new int[0][2];
        // Snake.length = 0;
        // gameRunning = true;
        // gameOver = false;
        // initGame();
        System.out.println("work in progress");
    }


    public static void spawnApple() {
        appleX = (int) (Math.random() * (Gui.GAME_HEIGHT - 100) / 10) * 10 + 50;
        appleY = (int) (Math.random() * (Gui.GAME_WIDTH  - 100) / 10) * 10 + 50;

        // Check that apple doesnt spawn in snake
        for (int i = 0; i < Snake.body.length; i++) {
            if (appleX == Snake.body[i][0] && appleY == Snake.body[i][1]) {
                // Apple spawned in Snake
                // System.out.println("regenerate!");
                spawnApple();
                return;
            }
            
        }

        System.out.println("Apple spawned at: " + appleX + "|" + appleY);
        Gui.gameboard.repaint();
    }

    public static void startingLocation() {
        Snake.headX = (int) (Math.random() * (Gui.GAME_HEIGHT - 100) / 10) * 10 + 50;
        Snake.headY = (int) (Math.random() * (Gui.GAME_WIDTH - 100) / 10) * 10 + 50;

        System.out.println("Snake spawned at: " + Snake.headX + "|" + Snake.headY);
        
    }

    public static void updateSnakeLocation() {
        int oldSnakeHeadX = Snake.headX;
        int oldSnakeHeadY = Snake.headY;
        Snake.lastTickDirection = Snake.currentDirection;

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
    
        for (int i = Snake.body.length - 1; i > 0; i--) {
            Snake.body[i][0] = Snake.body[i - 1][0];
            Snake.body[i][1] = Snake.body[i - 1][1];
        }
        if (Snake.body.length > 0) {
        Snake.body[0][0] = oldSnakeHeadX;
        Snake.body[0][1] = oldSnakeHeadY;
        }
    }
    
    public static void checkCollision() {
        // Snake -> Wand
        if (Snake.headX < 0 || Snake.headX > Gui.GAME_WIDTH) {
            gameOver = true;
            gameRunning = false;
            // System.out.println("hit wall at " + Snake.headX);
        }
        if (Snake.headY < 0 || Snake.headY > Gui.GAME_HEIGHT) {
            gameOver = true;
            gameRunning = false;
            // System.out.println("hit wall at " + Snake.headY);
        }
        
        // Snake -> APfel
        if (Snake.headX == appleX && Snake.headY == appleY) {
            System.out.println("ate apple");
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
            
            // System.out.println(Snake.body[0][0] + "|" + Snake.body[0][1]);
            Snake.score++;
            Gui.scoreText.setText("Score: " + Snake.score);
            spawnApple();
        }

        // Snake -> Snake
        for (int i = 1; i < Snake.body.length; i++) {
            // System.out.println("check snake self hit for loop");
            if (Snake.headX == Snake.body[i][0] && Snake.headY == Snake.body[i][1]) {
                gameOver = true;
                gameRunning = false;
                // System.out.println("hit self");
            }
        }

        
    }

    public static void gameLoop() {
        drawInterval = 1000000000/FPS;
        delta = 0;
        lastTime = System.nanoTime();
        currentTime = 0;

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
                    // System.out.println("gameover");
                    break;
                }
                // System.out.println("right before repaint");
                Gui.gameboard.repaint();
                // System.out.println(Gui.GAME_HEIGHT + " " + Gui.GAME_WIDTH);
                // System.out.println(Snake.currentDirection + " " + Snake.headX + "|" + Snake.headY);
                // System.out.println(Snake.body.length);
                // for (int i = 0; i < Snake.body.length; i++) {
                //     System.out.println(Snake.body[i][0] + "|" + Snake.body[i][1]);
                // }
                delta--;
            }
        }
    }
    
}