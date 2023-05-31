package game.snake;

import game.board.IBoard;

public interface ISnakeController {
    public void setBoard(IBoard board);
    public void setColor(int color);
    public void init();
    public void tick();
    public void onDeadListener(ISnakeCallback callback);
    public int getScore();
    public void setMoveController(IMoveController moveController);
}
