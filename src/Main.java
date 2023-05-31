import basic.Vector2i;
import game.board.IBoard;
import game.board.SingleBoard;
import game.snake.ISnakeCallback;
import game.snake.ISnakeController;
import game.snake.SnakeController;
import game.snake.controllers.EzBot1;
import window.Canvas;
import window.WindowForm;

import javax.swing.*;
import java.awt.*;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Main {
    public static void main(String[] args) {
        IBoard board = new SingleBoard();
        board.init(new Vector2i(20, 20));
        // snake
        List<ISnakeController> list = new ArrayList<>();
        ISnakeController iSnakeController = new SnakeController();
        iSnakeController.setColor(0);
        iSnakeController.setMoveController(new EzBot1());
        iSnakeController.setBoard(board);
        iSnakeController.init();
        list.add(iSnakeController);
        iSnakeController.onDeadListener(new ISnakeCallback() {
            @Override
            public void run() {
                list.remove(iSnakeController);
            }
        });
        // window
        JFrame jFrame = new JFrame("Snake ❤️");
        Dimension dimension = new Dimension();
        dimension.setSize(800, 800);
        jFrame.setSize(dimension);
        jFrame.setMinimumSize(dimension);
        jFrame.setMaximumSize(dimension);//👌
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Canvas canvas = new Canvas(board);
        jFrame.getContentPane().add(canvas);
        jFrame.pack();
        jFrame.setVisible(true);
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                for (int i = 0; i < list.size(); i++) {
                    list.get(i).tick();
                }
                canvas.repaint();//👌👌
            }
        },
                0, 150);
    }
}
