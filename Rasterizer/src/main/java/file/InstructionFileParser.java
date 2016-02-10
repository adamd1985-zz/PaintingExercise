package file;

import command.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by darmanina on 09/02/2016.
 */
public class InstructionFileParser {
    public List<Command> parse(String filenameAndPath) {
        List<Command> commands = new ArrayList<>();
        boolean numberOfCommandsLoaded = false;

        try (BufferedReader reader = Files.newBufferedReader(Paths.get(filenameAndPath))) {
            while (reader.ready()) {
                if (!numberOfCommandsLoaded) {
                    numberOfCommandsLoaded = true;
                    String numberOfCommands = reader.readLine();
                    // Unneeded
                } else {
                    commands.add(mapLineToCommand(reader.readLine()));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return commands;
    }

    private Command mapLineToCommand(String commandLine) {
        final String[] args = commandLine.split(" ");
        final String name = args[0];

        Command command = null;

        switch (CommandsEnum.valueOf(name)) {
            case ERASE_CELL:
                command = new EraseCommand(Integer.parseInt(args[1]), Integer.parseInt(args[2]));
                break;

            case PAINT_LINE:
                command = new PaintLineCommand(Integer.parseInt(args[1]), Integer.parseInt(args[2]), Integer.parseInt(args[3]), Integer.parseInt(args[4]));
                break;

            case PAINT_SQUARE:
                command = new PaintSquareCommand(Integer.parseInt(args[1]), Integer.parseInt(args[2]), Integer.parseInt(args[3]));
                break;
        }

        return command;
    }
}
