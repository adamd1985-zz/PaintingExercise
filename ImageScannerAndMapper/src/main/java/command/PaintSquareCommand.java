package command;

import canvas.Canvas;

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
    public void execute(Canvas canvas) {
        final int squareSize = (this.size * 2 + 1);
        int rowsStartIdx = this.rows - (squareSize / 2);
        int colsStartIdx = this.columns - (squareSize / 2);

        for (int rowIdx = 0; rowIdx < squareSize; ++rowIdx) {
            for (int colIdx = 0; colIdx < squareSize; ++colIdx) {
                canvas.buffer[rowsStartIdx + rowIdx][colsStartIdx + colIdx] = '#';
            }
        }
    }

    @Override
    public String getCommand() {
        return new StringBuilder()
                .append(CommandsEnum.PAINT_SQUARE).append(" ")
                .append(this.rows).append(" ")
                .append(this.columns).append(" ")
                .append(this.size).toString();
    }
}
