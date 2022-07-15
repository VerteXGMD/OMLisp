package org.vertex.omlisp.token;

public class CodeLocation {
    private int line, column;
    private int index;

    public CodeLocation(int line, int column, int index) {
        this.line = line;
        this.column = column;
        this.index = index;
    }

    public int getLine() {
        return line;
    }

    public int getColumn() {
        return column;
    }

    public int getIndex() {
        return index;
    }

    public void advance(boolean newLine) {
        index++;

        if (newLine) {
            column = 0;
            line++;
        } else {
            column++;
        }
    }

    public CodeLocation getAdvanced() {
        return new CodeLocation(line, column + 1, index + 1);
    }

    public CodeLocation clone() {
        try {
            return (CodeLocation) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return this;
        }
    }
}
