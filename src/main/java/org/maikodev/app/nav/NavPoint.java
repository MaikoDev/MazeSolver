package org.maikodev.app.nav;

public class NavPoint {
    public NavPoint() {}

    public NavPoint(short row, short column) {
        this.row = row;
        this.column = column;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (!(o instanceof NavPoint otherPoint)) return false;

        return (this.row == otherPoint.row && this.column == otherPoint.column);
    }

    public short row;
    public short column;
}
