package Ch_07_Object_Oriented_Design.Q7_10_Minesweeper;

public class Cell {
    private int row;
    private int column;
    private CellType cellType;
    private boolean hidden = true;
    private int number;

    public Cell(int row, int column, CellType cellType) {
        this.row = row;
        this.column = column;
        this.cellType = cellType;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public CellType getCellType() {
        return cellType;
    }

    public void setCellType(CellType cellType) {
        this.cellType = cellType;
    }

    public boolean isHidden() {
        return hidden;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    public boolean isBomb() {
        return cellType == CellType.BOMB;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getUndersideState() {
        if (isBomb()) {
            return "* ";
        } else if (number > 0) {
            return number + " ";
        } else {
            return "  ";
        }
    }

    public String getSurfaceState() {
        if (!isHidden()) {
            return getUndersideState();
        } else {
            return "? ";
        }
    }
    public boolean isBlank(){
        return cellType.equals(CellType.BLANK);
    }
}
