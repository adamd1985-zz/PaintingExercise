import canvas.Canvas;
import command.Command;
import command.PaintLineCommand;
import file.InstructionFilePrinter;
import file.RasterFileReader;
import scanner.HorizontalLinePrintCommandScanner;
import scanner.VerticalLinePrintCommandScanner;
import scanner.graphics.LineEntry;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @see https://github.com/adamd1985/PaintingExercise.git
 */
public class ScannerMain {
    /**
     * To run it takes an input file in the google ASCII art format and an output filename and path for the instructions output.
     *
     * @param args
     */
    public static void main(String[] args) {
        Canvas canvas = new RasterFileReader().loadImage(args[0]);

        // List<SquareEntry> squareEntries = new SquarePrintCommandScanner().scan(canvas);
        List<LineEntry> horzEntries = new HorizontalLinePrintCommandScanner().scan(canvas);
        List<LineEntry> vertEntries = new VerticalLinePrintCommandScanner().scan(canvas);

        PrintCommandsOptimizer commandsOptimizer = new PrintCommandsOptimizer(horzEntries, vertEntries, null);

        List<Command> commands = new ArrayList<>();
        commands.addAll(
                commandsOptimizer.getOptimalPrintCommands().stream()
                        .filter(lineEntry -> lineEntry instanceof LineEntry)
                        .map(lineEntry -> (LineEntry) lineEntry)
                        .map(lineEntry -> new PaintLineCommand(
                                lineEntry.rowStart,
                                lineEntry.colStart,
                                lineEntry.rowEnd,
                                lineEntry.colEnd))
                        .collect(Collectors.toList()));

        commands.stream().forEach(c -> System.out.println(c.getCommand()));

        new InstructionFilePrinter().print(commands, args[1]);
    }
}
