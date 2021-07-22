package JAVA2.HW2.Exceptions;

public class MyArrayDataException extends NumberFormatException {
    private int row;
    private int col;

    public MyArrayDataException(int row, int col) {
        super(String.format("Ошибка в элементе массива с индексом [%d][%d]", row, col));
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}
