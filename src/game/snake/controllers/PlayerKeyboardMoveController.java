package game.snake.controllers;

import basic.Direction;
import basic.Vector2i;
import game.board.IBoard;
import game.snake.IMoveController;

public class PlayerKeyboardMoveController implements IMoveController {
    private Direction direction;
    @Override
    public Direction move() {
        return direction;
    }

    @Override
    public void setBoard(IBoard iBoard) {

    }

    @Override
    public void setColor(int color) {

    }

    @Override
    public void setHead(Vector2i head) {

    }

    @Override
    public void setFruit(Vector2i fruit) {

    }

    @Override
    public void setTail(Vector2i tail) {

    }

    public void setDirection(Direction direction){
        this.direction = direction;
    }
}
