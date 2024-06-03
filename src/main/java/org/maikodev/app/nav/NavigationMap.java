package org.maikodev.app.nav;

import org.maikodev.app.interfaces.IObservable;
import org.maikodev.app.enums.NodeState;

import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
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
        //neighborsMinHeap = new NodeValueCost[nodeCount];

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

    protected void selectStart(short row, short column) {
        if (!(startPoint == null)) return;
    }

    protected void selectEnd(short row, short column) {

    }

    protected void addNeighbor(short row, short column, short originRow, short originColumn) {

    }

    protected void resetNode(short row, short column) {
        int contiguousIndex = getIndex(row, column, columnCount);

        nodeStates[contiguousIndex] = NodeState.Unblocked;
        gCostTable[contiguousIndex] = 0;
        hCostTable[contiguousIndex] = 0;
        fCostTable[contiguousIndex] = 0;

        NavPoint originNode = redirectionTable[contiguousIndex];

        originNode.row = row;
        originNode.column = column;
    }

    protected void addNeighborToHeap(int traversalCost, NavPoint neighborPoint) {

    }

    protected void addNeighborToHeap(int traversalCost, int neighborRow, int neighborColumn) {
        //NodeValueCost
    }

    protected static int getIndex(short row, short column, short maxColumns) {
        return row * maxColumns + column;
    }

    protected short rowCount;
    protected short columnCount;
    protected int nodeCount;
    protected int neighborsCount;

    protected NavPoint startPoint;
    protected NavPoint endPoint;

    /* Contiguous arrays for node state */
    protected NodeState[] nodeStates;

    protected int[] nodeHashes;
    protected int[] gCostTable;
    protected int[] hCostTable;
    protected int[] fCostTable;

    protected NavPoint[] redirectionTable;

    /* Binary Heap for lowest fCost Neighbor */
    protected int[] fCostMinHeap;
    //protected NodeValueCost[] neighborsMinHeap;

    protected HashMap<Integer, List<NodeValueCost>> neighborsMap;
    protected HashMap<Integer, Integer> hashToHeapIndexMap;
    //protected HashMap<>
}
