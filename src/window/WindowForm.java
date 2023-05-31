package window;

import game.board.IBoard;

import javax.swing.*;

public class WindowForm {
    public JPanel mainPanel;
    private Canvas canvas;
    public WindowForm(IBoard iBoard){
        canvas = new Canvas(iBoard);
        mainPanel.add(canvas);
    }
    public void rePaintCanvas(){
        canvas.repaint();
    }

}
