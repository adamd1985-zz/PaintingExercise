import scanner.graphics.GraphicEntry;
import scanner.graphics.LineEntry;
import scanner.graphics.SquareEntry;

import java.util.List;

/**
 * I wanted this optimizer to discover what is the best between a combination of horizontal, vertical lines, squares and whitespaces.
 * Sadly I could only have a brute-force optimizer. No heuristics to discover the best set of instructions.
 * <p>
 * Created by darmanina on 10/02/2016.
 */
public class PrintCommandsOptimizer {
    public List<LineEntry> horizontalLines;
    public List<LineEntry> verticalLines;
    public List<SquareEntry> squaresLines;

    public PrintCommandsOptimizer(List<LineEntry> horizontalLines, List<LineEntry> verticalLines, List<SquareEntry> squaresLines) {
        this.horizontalLines = horizontalLines;
        this.verticalLines = verticalLines;
        this.squaresLines = squaresLines;
    }

    public List<? extends GraphicEntry> getOptimalPrintCommands() {
        return ((horizontalLines.size() > verticalLines.size()) ? verticalLines : horizontalLines);
    }
}
