package scanner.graphics;

import java.util.List;

/**
 * Created by darmanina on 10/02/2016.
 */
public class SquareEntry extends GraphicEntry {
    public final int rowTopLeftStart;
    public final int colTopLeftStart;
    public final int size;
    public final int negatives;
    public final List<SquareEmptyEntry> squareEmptyEntries;

    public SquareEntry(int rowStart, int colStart, int size, int negatives, List<SquareEmptyEntry> squareEmptyEntries) {
        this.rowTopLeftStart = rowStart;
        this.colTopLeftStart = colStart;
        this.size = size;
        this.negatives = negatives;
        this.squareEmptyEntries = squareEmptyEntries;
    }

    public int getCenterRow() {
        return (rowTopLeftStart + size / 2);
    }

    public int getCenterColumn() {
        return (colTopLeftStart + size / 2);
    }
}
