package command;

import canvas.Canvas;

/**
 * Created by darmanina on 09/02/2016.
 */
public class EraseCommand extends Command {
    private int rows;
    private int columns;

    public EraseCommand(int rows, int columns) {
        this.rows = rows;

        this.columns = columns;
    }

    @Override
    public void execute(Canvas canvas) {
        canvas.buffer[this.rows][this.columns] = '.';
    }

    @Override
    public String getCommand() {
        return new StringBuilder()
                .append(CommandsEnum.ERASE_CELL).append(" ")
                .append(this.rows).append(" ")
                .append(this.columns).toString();
    }
}
