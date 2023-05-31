package game.snake;

import basic.Direction;
import basic.Vector2i;
import game.board.IBoard;

public interface IMoveController {
    public Direction move();
    public void setBoard(IBoard iBoard);
    public void setColor(int color);
    public void setHead(Vector2i head);
    public void setFruit(Vector2i fruit);
    public void setTail(Vector2i tail);
}
