package command;

/**
 * Created by darmanina on 09/02/2016.
 */
public class PaintSquareCommand extends Command {
    private int rows;
    private int columns;
    private int size;

    public PaintSquareCommand(int rows, int columns, int size) {
        this.rows = rows;
        this.columns = columns;
        this.size = size;
    }

    @Override
    public void execute(char[][] buffer) {
        final int squareSize = (this.size * 2 + 1);
        int rowsStartIdx = this.rows - (squareSize / 2);
        int colsStartIdx = this.columns - (squareSize / 2);

        for (int rowIdx = 0; rowIdx < squareSize; ++rowIdx) {
            for (int colIdx = 0; colIdx < squareSize; ++colIdx) {
                buffer[rowsStartIdx + rowIdx][colsStartIdx + colIdx] = '#';
            }
        }
    }
}
