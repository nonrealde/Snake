public class Game {
    public static int appleX;
    public static int appleY;
    static boolean paused = false;
    static boolean running = true;
    static boolean over = false;
    static int FPS = 10;
    static double drawInterval = 1000000000/FPS;
    static double delta = 0;
    static long lastTime = System.nanoTime();
    static long currentTime;
    static int x = 0;
    static int step = 10;

    enum Direction {
        LEFT,
        UP,
        RIGHT,
        DOWN
    }

    public static void initGame() {
        Snake.startingLocation();
        Game.spawnApple();
        Gui.showSelectDifficultyPanel();
    }

    public static void newGame() {
        // reset buttons
        Gui.btnDifficulty.setVisible(false);
        Gui.btnReset.setVisible(false);
        Gui.btnPause.setVisible(true);
        System.out.println("Restart Game");
        // Reset Snake Body
        Snake.reset();
        // Reset visible Score
        Gui.scoreText.setText("  Score: " + Snake.score);
        // Reset Game Variables
        Game.running = true;
        Game.over = false;
        Snake.startingLocation();
        Game.spawnApple();
        Game.loop();
    }


    public static void spawnApple() {
        appleX = (int) (Math.random() * (Gui.GAME_HEIGHT - 100) / 10) * 10 + 50;
        appleY = (int) (Math.random() * (Gui.GAME_WIDTH  - 100) / 10) * 10 + 50;

        // Check that apple doesnt spawn in snake
        for (int i = 0; i < Snake.body.length; i++) {
            if (appleX == Snake.body[i][0] && appleY == Snake.body[i][1]) {
                spawnApple();
                return;
            }
            
        }

        System.out.println("Apple spawned at: " + appleX + "|" + appleY);
        Gui.gameboard.repaint();
    }

    public static void updateSnakeLocation() {
        int oldSnakeHeadX = Snake.headX;
        int oldSnakeHeadY = Snake.headY;
        Snake.lastTickDirection = Snake.currentDirection;

        switch (Snake.currentDirection) {
            case Direction.UP:
            Snake.headY -= step;
            break;
            case Direction.RIGHT:
            Snake.headX += step;
            break;
            case Direction.DOWN:
            Snake.headY += step;
            break;
            case Direction.LEFT:
            Snake.headX -= step;
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
            Game.over = true;
            Game.running = false;
        }
        if (Snake.headY < 0 || Snake.headY > Gui.GAME_HEIGHT) {
            Game.over = true;
            Game.running = false;
        }
        
        // Snake -> Apfel
        if (Snake.headX == appleX && Snake.headY == appleY) {
            System.out.println("ate apple");
            // temp array old snake state
            int tmp[][] = Snake.body.clone();
            // create new array -> new length
            Snake.length += 1;
            Snake.body = new int[Snake.length][2];

            Snake.body[0][0] = appleX;
            Snake.body[0][1] = appleY;

            // loop over tmp array to fill new array with old values
            for (int i = 0; i < tmp.length; i++) {
                Snake.body[i + 1][0] = tmp[i][0];
                Snake.body[i + 1][1] = tmp[i][1];
            }
            
            Snake.score++;
            Gui.scoreText.setText("  Score: " + Snake.score);
            Game.spawnApple();
        }

        // Snake -> Snake
        for (int i = 1; i < Snake.body.length; i++) {
            if (Snake.headX == Snake.body[i][0] && Snake.headY == Snake.body[i][1]) {
                Game.over = true;
                Game.running = false;
            }
        }
    }

    public static void pauseGame() {
        Game.paused = true;
        Game.running = false;
        Gui.btnPause.setVisible(false);
        Gui.btnResume.setVisible(true);
    }

    public static void resumeGame() {
        Game.paused = false;
        Game.running = true;
        Gui.btnPause.setVisible(true);
        Gui.btnResume.setVisible(false);
        new Thread() {
            public void run() {
                Game.loop();
            }
        }.start();
    }

    public static void loop() {
        drawInterval = 1000000000/FPS;
        delta = 0;
        lastTime = System.nanoTime();
        currentTime = 0;

        while (running) {
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;

            if(delta >= 1) {               
                updateSnakeLocation();
                checkCollision();
                if (over) {
                    Gui.gameOverScreen();
                    break;
                }
                Gui.gameboard.repaint();
                delta--;
            }
        }
    }
    
}