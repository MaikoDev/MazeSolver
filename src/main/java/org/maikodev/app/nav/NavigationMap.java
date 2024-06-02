package org.maikodev.app.nav;

import org.maikodev.app.interfaces.IObservable;
import org.maikodev.app.enums.NodeState;

import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Objects;

public class NavigationMap implements IObservable {
    public NavigationMap(short rowCount, short columnCount) {
        this.rowCount = rowCount;
        this.columnCount = columnCount;

        nodeCount = (int)rowCount * columnCount;

        nodeStates = new NodeState[nodeCount];
        nodeHashes = new int[nodeCount];

        gCostTable = new int[nodeCount];
        hCostTable = new int[nodeCount];
        fCostTable = new int[nodeCount];

        redirectionTable = new NavPoint[nodeCount];
        neighborsMaxHeap = new NodeCostPair[nodeCount];

        hashToHeapIndexMap = new HashMap<>();

        // Setup Redirection table //
        for (short row = 0; row < rowCount; row++) {
            for (short column = 0; column < columnCount; column++) {
                int currentIndex = getIndex(row, column, columnCount);

                nodeHashes[currentIndex] = Objects.hash(row, column);
                redirectionTable[currentIndex] = new NavPoint(row, column);
            }
        }
    }

    @Override
    public void addActionListener(ActionListener listener) {

    }

    @Override
    public void removeActionListener(ActionListener listener) {

    }

    @Override
    public ActionListener[] getActionListeners() {
        return null;
    }

    protected static int getIndex(short row, short column, short maxColumns) {
        return row * maxColumns + column;
    }

    protected short rowCount;
    protected short columnCount;
    protected int nodeCount;
    protected int neighborsCount;

    /* Contiguous arrays for node state */
    protected NodeState[] nodeStates;
    protected int[] nodeHashes;
    protected int[] gCostTable;
    protected int[] hCostTable;
    protected int[] fCostTable;
    protected NavPoint[] redirectionTable;

    /* Binary Heap for lowest fCost Neighbor */
    protected NodeCostPair[] neighborsMaxHeap;

    /* Look-up */
    protected HashMap<Integer, Integer> hashToHeapIndexMap;
}
