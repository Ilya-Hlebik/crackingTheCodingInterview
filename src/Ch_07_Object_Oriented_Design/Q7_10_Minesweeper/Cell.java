package Ch_07_Object_Oriented_Design.Q7_10_Minesweeper;

public class Cell {
    private int row;
    private int column;
    private CellType cellType;
    private boolean hidden = true;

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
}
