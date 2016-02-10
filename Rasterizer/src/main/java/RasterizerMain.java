import command.Command;
import file.InstructionFileParser;
import file.RasterFilePrinter;

import java.util.Arrays;
import java.util.List;

/**
 * @see https://github.com/adamd1985/PaintingExercise.git
 */
public class RasterizerMain {

    /**
     * This is used to verify the commands.
     * See readme file for input and outputs.
     *
     * @param args
     */
    public static void main(String[] args) {
        int rows = Integer.parseInt(args[0]);
        int columns = Integer.parseInt(args[1]);
        char[][] buffer = new char[rows][columns];

        for (char[] row : buffer) {
            Arrays.fill(row, '.');
        }


        List<Command> commands = new InstructionFileParser().parse(args[2]);

        commands.forEach(command -> command.execute(buffer));

        Arrays.stream(buffer).forEach(System.out::println);

        new RasterFilePrinter().print(buffer, args[3]);
    }
}
