import java.util.Random;

public class Snake {
    public static Game.Direction currentDirection = generateStartingDirection();
    public static Game.Direction lastTickDirection = currentDirection;
    public static int headX;
    public static int headY;
    public static int length = 0;
    public static int[][] body = new int[length][2];
    public static int score = 0;

    public static Game.Direction generateStartingDirection() {
        return Game.Direction.values()[new Random().nextInt(Game.Direction.values().length)];
    }
    public static void startingLocation() {
        Snake.headX = (int) Math.round((Gui.GAME_WIDTH * 0.5) / 10) * 10;
        Snake.headY = (int) Math.round((Gui.GAME_HEIGHT * 0.5) / 10) * 10;
        // System.out.println("Snake spawned at: " + Snake.headX + "|" + Snake.headY);
    }
    
    public static void reset() {
        currentDirection = generateStartingDirection();
        lastTickDirection = currentDirection;
        Snake.body = new int[0][2];
        Snake.length = 0;
        Snake.score = 0;
        Snake.headX = 0;
        Snake.headY = 0;
    }
}
