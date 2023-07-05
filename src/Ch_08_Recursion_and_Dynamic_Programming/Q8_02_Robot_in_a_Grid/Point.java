package Ch_08_Recursion_and_Dynamic_Programming.Q8_02_Robot_in_a_Grid;

import java.util.Objects;

public class Point {
    public int row, column;

    public Point(int row, int column) {
        this.row = row;
        this.column = column;
    }

    @Override
    public String toString() {
        return "(" +
                "row=" + row +
                ", column=" + column +
                ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return row == point.row &&
                column == point.column;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, column);
    }
}
