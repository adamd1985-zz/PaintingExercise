package scanner;

import canvas.Canvas;
import scanner.graphics.LineEntry;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by darmanina on 10/02/2016.
 */
public class VerticalLinePrintCommandScanner implements Scanner<LineEntry> {

    public List<LineEntry> scan(Canvas canvas) {
        List<LineEntry> entries = new ArrayList<>();

        for (int colIdx = 0; colIdx < canvas.columns; ++colIdx) {
            for (int rowIdx = 0; rowIdx < canvas.rows; ++rowIdx) {
                LineEntry lineEntry = searchForVerticalLine(canvas, rowIdx, colIdx);
                if (lineEntry != null) {
                    entries.add(lineEntry);
                    rowIdx = lineEntry.rowEnd + 1;
                }
            }
        }
        return entries;
    }


    private LineEntry searchForVerticalLine(Canvas canvas, int canvasRow, int canvasCol) {
        LineEntry lineEntry = null;
        int lineRowStart = -1;
        int lineRowStop = -1;

        for (int currentCanvasRowIdx = canvasRow; currentCanvasRowIdx < canvas.rows; ++currentCanvasRowIdx) {
            if (canvas.buffer[currentCanvasRowIdx][canvasCol] == '#') {
                if (lineRowStart == -1) {
                    lineRowStart = currentCanvasRowIdx;
                }
                lineRowStop = currentCanvasRowIdx;
            } else {
                if (lineRowStart > -1) {
                    break;
                }
            }
        }
        if (lineRowStart > -1) {
            lineEntry = new LineEntry(lineRowStart, canvasCol, lineRowStop, canvasCol);
        }
        return lineEntry;
    }
}
