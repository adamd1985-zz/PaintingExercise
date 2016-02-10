package command;

/**
 * Created by darmanina on 09/02/2016.
 */
public enum CommandsEnum {
    PAINT_SQUARE("PAINT_SQUARE"),
    PAINT_LINE("PAINT_LINE"),
    ERASE_CELL("ERASE_CELL");

    private String commandString;

    CommandsEnum(String commandString) {
        this.commandString = commandString;
    }
}
