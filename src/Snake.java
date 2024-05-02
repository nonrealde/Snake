public class Snake {
    public static Game.Direction currentDirection = Game.Direction.RIGHT;
    public static Game.Direction lastTickDirection = Game.Direction.RIGHT;
    public static int headX;
    public static int headY;
    public static int length = 0;
    public static int[][] body = new int[length][2];
    public static int score = 0;
}
