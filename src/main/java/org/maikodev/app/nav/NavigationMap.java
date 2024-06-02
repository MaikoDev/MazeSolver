package org.maikodev.nav;

import org.maikodev.interfaces.IObservable;

import java.awt.event.ActionListener;

public final class NavigationMap implements IObservable {
    public NavigationMap(int rowCount, int columnCount) {
        this.rowCount = rowCount;
        this.columnCount = columnCount;

        navTable = new NavigationNode[rowCount * columnCount];
    }

    @Override
    public void addActionListener(ActionListener listener) {

    }

    @Override
    public void removeActionListener(ActionListener listener) {

    }

    @Override
    public ActionListener[] getActionListeners() {

    }

    private int rowCount;
    private int columnCount;
    private NavigationNode[] navTable;


}
