package game.board;

import basic.Vector2i;

public interface IBoard {
    public void init(Vector2i size);
    public void clear();
    public FieldType getFieldType(Vector2i cords);
    public int getColor(Vector2i cords);
    public void setField(Vector2i cords, FieldType type, int color);
    public Vector2i getSize();
    public boolean isInArena(Vector2i cords);
    public Vector2i getRandomEmptyField();
}
