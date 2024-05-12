import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import javax.swing.Action;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

public class Inputs extends KeyAdapter {
    public static void keyBindings() {

        Action upAction = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                //    System.out.println("UP!"); 
                if (Snake.currentDirection != Game.Direction.DOWN && Snake.lastTickDirection != Game.Direction.DOWN) {
                    Snake.currentDirection = Game.Direction.UP;
                }
            }
        };

        Action downAction = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                //    System.out.println("DOWN!"); 
                if (Snake.currentDirection != Game.Direction.UP && Snake.lastTickDirection != Game.Direction.UP) {
                    Snake.currentDirection = Game.Direction.DOWN;
                }
            }
        };

        Action rightAction = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                //    System.out.println("RIGHT!"); 
                if (Snake.currentDirection != Game.Direction.LEFT && Snake.lastTickDirection != Game.Direction.LEFT) {
                    Snake.currentDirection = Game.Direction.RIGHT;
                }
            }
        };

        Action leftAction = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                //    System.out.println("LEFT!"); 
                if (Snake.currentDirection != Game.Direction.RIGHT && Snake.lastTickDirection != Game.Direction.RIGHT) {
                    Snake.currentDirection = Game.Direction.LEFT;
                }
            }
        };

        Action pauseAction = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("space detected");
                
                if (Game.paused == false && Game.running == true) {
                    System.out.println("pause");
                    Game.pauseGame();
                } else if (Game.running == false && Game.paused == true) {
                    System.out.println("resume");
                    Game.resumeGame();
                }
            }
        };

        InputMap inputMap = Gui.gameboard.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW);
        ActionMap actionMap = Gui.gameboard.getActionMap();

        inputMap.put(KeyStroke.getKeyStroke(87, 0), "upAction");
        inputMap.put(KeyStroke.getKeyStroke(38, 0), "upAction");
        actionMap.put("upAction", upAction);

        inputMap.put(KeyStroke.getKeyStroke(83, 0), "downAction");
        inputMap.put(KeyStroke.getKeyStroke(40, 0), "downAction");
        actionMap.put("downAction", downAction);

        inputMap.put(KeyStroke.getKeyStroke(68, 0), "rightAction");
        inputMap.put(KeyStroke.getKeyStroke(39, 0), "rightAction");
        actionMap.put("rightAction", rightAction);

        inputMap.put(KeyStroke.getKeyStroke(65, 0), "leftAction");
        inputMap.put(KeyStroke.getKeyStroke(37, 0), "leftAction");
        actionMap.put("leftAction", leftAction);

        inputMap.put(KeyStroke.getKeyStroke(32, 0), "pauseAction");
        actionMap.put("pauseAction", pauseAction);
    }
}