package game.board;

public class BoardField {
    private FieldType type;
    private int color;

    public BoardField(){
        type = FieldType.EMPTY;
        color = 0;
    }

    public FieldType getType() {
        return type;
    }

    public void setType(FieldType type) {
        this.type = type;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}
