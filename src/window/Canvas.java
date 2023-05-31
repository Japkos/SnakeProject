package window;

import basic.Vector2i;
import game.board.IBoard;

import javax.swing.*;
import java.awt.*;

public class Canvas extends JPanel {
    private IBoard iBoard;

    public Canvas(IBoard iBoard){
        this.iBoard = iBoard;
        this.setDoubleBuffered(true);
    }
    @Override
    public void paint(Graphics g){
        int width = this.getWidth();
        int height = this.getHeight();
        g.clearRect(0, 0, width, height);
        double widthField = width / (double)iBoard.getSize().getX();
        double heightField = height / (double)iBoard.getSize().getY();
        for (int x = 0; x < iBoard.getSize().getX(); x++) {
            for (int y = 0; y < iBoard.getSize().getY(); y++) {
                switch (iBoard.getFieldType(new Vector2i(x, y))){
                    case WALL -> {
                        g.setColor(Color.GRAY);
                        g.fillRect((int)Math.floor(x * widthField), (int)Math.floor(y * heightField), (int)Math.ceil(widthField), (int)Math.ceil(heightField));
                    }
                    case SNAKE -> {
                        g.setColor(transformColor(iBoard.getColor(new Vector2i(x, y))));
                        g.fillRect((int)Math.floor(x * widthField), (int)Math.floor(y * heightField), (int)Math.ceil(widthField), (int)Math.ceil(heightField));
                    }
                    case FRUIT -> {
                        Color c = transformColor(iBoard.getColor(new Vector2i(x, y)));
                        g.setColor(lighter(c));
                        g.fillRect((int)Math.floor(x * widthField), (int)Math.floor(y * heightField), (int)Math.ceil(widthField), (int)Math.ceil(heightField));
                    }
                }
            }
        }
        g.setColor(Color.black);
        for (int i = 0; i < iBoard.getSize().getX(); i++) {
            g.drawLine((int)(i * widthField), 0, (int)(i * widthField), height);
        }
        for (int i = 0; i < iBoard.getSize().getY(); i++) {
            g.drawLine(0, (int)(i * heightField), width, (int)(i * heightField));
        }
    }
    private Color transformColor(int index){
        return switch (index){
            case 0 -> new Color(20,150,0);
            case 1 -> Color.red;
            case 2 -> Color.blue;
            case 3 -> Color.yellow;
            case 4 -> new Color(130, 50, 240);

            default -> Color.magenta;
        };
    }
    private Color lighter(Color c){
        int r = c.getRed() + 30;
        int g = c.getGreen() + 30;
        int b = c.getBlue() + 30;
        return new Color(Math.min(r, 255), Math.min(g, 255), Math.min(b, 255));
    }
}
