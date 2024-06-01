package org.maikodev;

public class NavigationMap {
    public NavigationMap(int rowCount, int columnCount) {
        this.rowCount = rowCount;
        this.columnCount = columnCount;

        navTable = new NavigationNode[rowCount * columnCount];
    }

    private int rowCount;
    private int columnCount;
    private NavigationNode[] navTable;
}
