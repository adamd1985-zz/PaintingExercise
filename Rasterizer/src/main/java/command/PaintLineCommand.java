package command;

/**
 * Created by darmanina on 09/02/2016.
 */
public class PaintLineCommand extends Command {
    private int rowStart;
    private int colStart;
    private int rowStop;
    private int colStop;

    public PaintLineCommand(int rowStart, int colStart, int rowStop, int colStop) {

        this.rowStart = rowStart;
        this.colStart = colStart;
        this.rowStop = rowStop;
        this.colStop = colStop;
    }


    @Override
    public void execute(char[][] buffer) {
        if (this.colStart == this.colStop) {
            int row = Math.min(this.rowStart, this.rowStop);
            for (int i = 0; i <= Math.abs(this.rowStop - this.rowStart); ++i) {
                buffer[row + i][this.colStart] = '#';
            }
        } else {
            int col = Math.min(this.colStart, this.colStop);
            for (int i = 0; i <= Math.abs(this.colStop - this.colStart); ++i) {
                buffer[this.rowStop][col + i] = '#';
            }
        }
    }
}
