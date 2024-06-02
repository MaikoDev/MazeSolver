package org.maikodev.app.nav;

public final class NodeValueCost {
    public NodeValueCost() {}

    public NodeValueCost(int cost, NavPoint point) {
        this.cost = cost;
        this.row = point.row;
        this.column = point.column;
    }

    public NodeValueCost(int cost, int row, int column) {
        this.cost = cost;
        this.row = row;
        this.column = column;
    }

    public int cost;
    public int row;
    public int column;
}
