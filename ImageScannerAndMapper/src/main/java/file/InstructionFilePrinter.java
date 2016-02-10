package file;

import command.Command;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

/**
 * Created by darmanina on 09/02/2016.
 */
public class InstructionFilePrinter {
    public void print(List<Command> commands, String filenameAndPath) {
        Path path = Paths.get(filenameAndPath);
        try (BufferedWriter writer = Files.newBufferedWriter(path, StandardOpenOption.CREATE, StandardOpenOption.CREATE)) {
            for (Command command : commands) {
                writer.write(command.getCommand());
                writer.write("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
