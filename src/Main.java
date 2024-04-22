
public class Main {
    public static void main(String[] args) {
        Game.initGame();
        Gui.loadGui();
        while (true) {
            Game.spawnApple();
        }
    }
}
