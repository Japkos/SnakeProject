package game.snake;

import basic.Direction;
import basic.Vector2i;
import game.board.FieldType;
import game.board.IBoard;

import java.util.ArrayList;
import java.util.List;

public class SnakeController implements ISnakeController{

    private List<Vector2i> body;
    private int color;
    private IBoard board;
    private ISnakeCallback deadCallback;
    private IMoveController moveController;
    private Vector2i fruit;

    private void randomFruit(){
        fruit = board.getRandomEmptyField();
        board.setField(fruit, FieldType.FRUIT, color);
        moveController.setFruit(fruit);
    }
    private Vector2i changeDirectionToVector(Direction direction){
        return switch (direction){
            case UP -> new Vector2i(0, -1);
            case LEFT -> new Vector2i(-1, 0);
            case DOWN -> new Vector2i(0, 1);
            case RIGHT -> new Vector2i(1, 0);
        };
    }

    @Override
    public void setBoard(IBoard board) {
        this.board = board;
    }

    @Override
    public void setColor(int color) {
        this.color = color;
    }

    @Override
    public void init() {
        randomFruit();
        Vector2i head = board.getRandomEmptyField();
        board.setField(head, FieldType.SNAKE, color);
        body = new ArrayList<>();
        body.add(head);
        moveController.setColor(color);
        moveController.setBoard(board);
    }

    @Override
    public void tick() {
        moveController.setTail(body.get(body.size() - 1));
        moveController.setHead(body.get(0));
        Direction direction = moveController.move();
        Vector2i newHead = body.get(0).add(changeDirectionToVector(direction));
        if(!board.isInArena(newHead)){
            deadCallback.run();
            return;
        }
        switch (board.getFieldType(newHead)){
            case EMPTY -> {
                body.add(0, newHead);
                board.setField(body.get(body.size() - 1), FieldType.EMPTY, color);
                body.remove(body.size() - 1);
                board.setField(newHead, FieldType.SNAKE, color);
            }
            case WALL, SNAKE -> {
                deadCallback.run();
            }
            case FRUIT -> {
                if(board.getColor(newHead) == color){
                    body.add(0, newHead);
                    board.setField(newHead, FieldType.SNAKE, color);
                    randomFruit(); // 👌
                }
                else
                    deadCallback.run();
            }
        }
    }

    @Override
    public void onDeadListener(ISnakeCallback callback) {
        deadCallback = callback;
    }

    @Override
    public int getScore() {
        return body.size();
    }

    @Override
    public void setMoveController(IMoveController moveController){
        this.moveController = moveController;
    }
}
