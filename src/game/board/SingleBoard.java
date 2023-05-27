package game.board;

import basic.Vector2i;

import java.util.Arrays;

public class SingleBoard implements IBoard{
    private BoardField[][] tab;
    private Vector2i size;

    @Override
    public void init(Vector2i size) {
        this.size = new Vector2i(size);
        tab = new BoardField[size.getX()][size.getY()];
        for (int x = 0; x < size.getX(); x++) {
            for (int y = 0; y < size.getY(); y++) {
                tab[x][y] = new BoardField();
            }
        }
    }

    @Override
    public void clear() {
        for (int x = 0; x < size.getX(); x++) {
            for (int y = 0; y < size.getY(); y++) {
                tab[x][y] = new BoardField();
            }
        }
    }

    @Override
    public FieldType getFieldType(Vector2i cords) {
        return tab[cords.getX()][cords.getY()].getType();
    }

    @Override
    public int getColor(Vector2i cords) {
        return tab[cords.getX()][cords.getY()].getColor();
    }

    @Override
    public void setField(Vector2i cords, FieldType type, int color){
        tab[cords.getX()][cords.getY()].setType(type);
        tab[cords.getX()][cords.getY()].setColor(color);
    }

    @Override
    public Vector2i getSize() {
        return new Vector2i(size);
    }

    @Override
    public boolean isInArena(Vector2i cords) {
        return cords.inArea(size);
    }
}
