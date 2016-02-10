package scanner;

import canvas.Canvas;
import scanner.graphics.LineEntry;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by darmanina on 10/02/2016.
 */
public class HorizontalLinePrintCommandScanner implements Scanner<LineEntry> {

    public List<LineEntry> scan(Canvas canvas) {
        List<LineEntry> entries = new ArrayList<>();
        for (int rowIdx = 0; rowIdx < canvas.rows; ++rowIdx) {
            for (int colIdx = 0; colIdx < canvas.columns; ++colIdx) {
                LineEntry lineEntry = searchForHorizontalLine(canvas, rowIdx, colIdx);
                if (lineEntry != null) {
                    entries.add(lineEntry);
                    colIdx = lineEntry.colEnd + 1;
                }
            }
        }
        return entries;
    }


    public HorizontalLinePrintCommandScanner() {
        super();
    }

    private LineEntry searchForHorizontalLine(Canvas canvas, int canvasRow, int canvasCol) {
        LineEntry lineEntry = null;
        int lineColStart = -1;
        int lineColStop = -1;

        for (int currentCanvasColIdx = canvasCol; currentCanvasColIdx < canvas.columns; ++currentCanvasColIdx) {
            if (canvas.buffer[canvasRow][currentCanvasColIdx] == '#') {
                if (lineColStart == -1) {
                    lineColStart = currentCanvasColIdx;
                }
                lineColStop = currentCanvasColIdx;
            } else {
                if (lineColStart > -1) {
                    break;
                }
            }
        }
        if (lineColStart > -1) {
            lineEntry = new LineEntry(canvasRow, lineColStart, canvasRow, lineColStop);
        }
        return lineEntry;
    }
}
