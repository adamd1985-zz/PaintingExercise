package command;

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
    public void execute(char[][] buffer) {
        buffer[this.rows][this.columns] = '.';
    }
}
