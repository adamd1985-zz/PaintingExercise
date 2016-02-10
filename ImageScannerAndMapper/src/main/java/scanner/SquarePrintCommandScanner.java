package scanner;

import canvas.Canvas;
import scanner.graphics.SquareEmptyEntry;
import scanner.graphics.SquareEntry;

import java.util.ArrayList;
import java.util.List;

/**
 * I would have liked to have this detect squares to optimize the drawing of lines.
 *
 * Created by darmanina on 10/02/2016.
 */
public class SquarePrintCommandScanner implements Scanner<SquareEntry> {

    private int MAX_MATRIX_RADUIS = 15;

    // ========================================================================


    public List<SquareEntry> scan(Canvas canvas) {
        List<SquareEntry> viableEntries = new ArrayList<>();
        for (int rowIdx = 0; rowIdx < canvas.rows; ++rowIdx) {
            for (int colIdx = 0; colIdx < canvas.columns; ++colIdx) {
                SquareEntry viableEntry = null;
                if (!inOtherSquare(viableEntries, rowIdx, colIdx)) {
                    for (int i = 0; i < MAX_MATRIX_RADUIS; ++i) {
                        int size = (2 * (i + 1) + 1);
                        if (size >= canvas.columns || size >= canvas.rows) {
                            break;
                        }
                        if ((rowIdx + size < canvas.rows) && (colIdx + size < canvas.columns)) {
                            SquareEntry potentialEntry = searchForSquare(size, canvas, rowIdx, colIdx, i + 1);
                            if (potentialEntry != null) {
                                viableEntry = compareAndGetViableEntries(viableEntry, potentialEntry);
                            }
                        }
                    }
                    if (viableEntry != null) {
                        colIdx = viableEntry.colTopLeftStart + viableEntry.size;
                        viableEntries.add(viableEntry);
                    }
                }
            }
        }
        return optimizeEntries(viableEntries);
    }

    private List<SquareEntry> optimizeEntries(List<SquareEntry> entries) {
        List<SquareEntry> optimizedEntries = new ArrayList<>();

        for (SquareEntry entry : entries) {
            boolean inSquare = false;
            for (SquareEntry otherEntry : entries) {
                if (!entry.equals(otherEntry)) {
                    if (inSquare(otherEntry, entry.rowTopLeftStart, entry.colTopLeftStart)) {
                        inSquare = true;
                        break;
                    }
                }
            }
            if (!inSquare) {
                optimizedEntries.add(entry);
            }
        }

        return optimizedEntries;
    }

    private boolean inOtherSquare(List<SquareEntry> squareEntries, int rowStart, int colStart) {
        boolean inSquare = false;
        for (SquareEntry squareEntry : squareEntries) {
            if (inSquare(squareEntry, rowStart, colStart)) {
                inSquare = true;
                break;
            }
        }
        return inSquare;
    }

    private boolean inSquare(SquareEntry squareEntry, int rowStart, int colStart) {
        return ((colStart > -squareEntry.colTopLeftStart) && (colStart < squareEntry.colTopLeftStart + squareEntry.size) ||
                (rowStart > -squareEntry.rowTopLeftStart) && (rowStart < squareEntry.rowTopLeftStart + squareEntry.size));
    }

    private SquareEntry compareAndGetViableEntries(SquareEntry currentEntry, SquareEntry potentialEntry) {
        SquareEntry squareEntry = potentialEntry;
        if (currentEntry != null) {
            if ((currentEntry.size - currentEntry.negatives) < (potentialEntry.size - potentialEntry.negatives)) {
                squareEntry = potentialEntry;
            }
        }
        return squareEntry;
    }


    private SquareEntry searchForSquare(int matrixSize, Canvas canvas, int canvasRow, int canvasCol, int threshold) {
        List<SquareEmptyEntry> squareEmptyEntries = new ArrayList<>();
        int negativesCount = 0;

        for (int currentCanvasRowIdx = 0; currentCanvasRowIdx < matrixSize; ++currentCanvasRowIdx) {
            for (int currentCanvasColIdx = 0; currentCanvasColIdx < matrixSize; ++currentCanvasColIdx) {
                if (canvas.buffer[canvasRow + currentCanvasRowIdx][canvasCol + currentCanvasColIdx] != '#') {
                    squareEmptyEntries.add(new SquareEmptyEntry((canvasRow + currentCanvasRowIdx), (canvasCol + currentCanvasColIdx)));
                    ++negativesCount;
                }
                if (negativesCount > threshold) {
                    return null;
                }
            }
        }
        return (negativesCount > threshold) ? null : new SquareEntry(canvasRow, canvasCol, matrixSize, negativesCount, squareEmptyEntries);
    }
}
