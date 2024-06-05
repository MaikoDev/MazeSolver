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

        originTable = new NavPoint[nodeCount];

        fCostMinHeap = new int[nodeCount];
        hCostMinHeap = new int[nodeCount][];

        neighborsMap = new HashMap<>();
        hashToFCostIndexMap = new HashMap<>();
        hashToHCostIndexMap = new HashMap<>();

        // Setup Redirection table //
        for (short row = 0; row < rowCount; row++) {
            for (short column = 0; column < columnCount; column++) {
                int currentIndex = getIndex(row, column, columnCount);

                nodeHashes[currentIndex] = Objects.hash(row, column);
                originTable[currentIndex] = new NavPoint(row, column);
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

    /* We must reprocess all hCost once a end point has been placed */
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

        NavPoint originNode = originTable[contiguousIndex];

        originNode.row = row;
        originNode.column = column;


    }

    /* Used primarily when a node transitions into a Visited node */
    protected void modifyNode(short nodeRow, short nodeColumn, NodeState nodeState) {
        int nodeIndex = getIndex(nodeRow, nodeColumn, columnCount);
        nodeStates[nodeIndex] = nodeState;
    }

    /* Used primarily when updating a neighbor to a shorter gCost route */
    protected void modifyNode(short nodeRow, short nodeColumn, int gCost, short originRow, short originColumn) {
        int nodeIndex = getIndex(nodeRow, nodeColumn, columnCount);

        gCostTable[nodeIndex] = gCost;

        NavPoint nodeOrigin = originTable[nodeIndex];
        nodeOrigin.row = originRow;
        nodeOrigin.column = originColumn;

        fCostTable[nodeIndex] = updateFCost(nodeHashes[nodeIndex], gCost + hCostTable[nodeIndex]);
    }

    /* Used primarily when first discovering a new a neighbor node */
    protected void modifyNode(short nodeRow, short nodeColumn, NodeState nodeState, int gCost, short originRow, short originColumn) {
        int nodeIndex = getIndex(nodeRow, nodeColumn, columnCount);

        nodeStates[nodeIndex] = nodeState;
        gCostTable[nodeIndex] = gCost;

        NavPoint nodeOrigin = originTable[nodeIndex];
        nodeOrigin.row = originRow;
        nodeOrigin.column = originColumn;

        fCostTable[nodeIndex] = updateFCost(nodeHashes[nodeIndex], gCost + hCostTable[nodeIndex]);
    }

    protected int updateFCost(int nodeHash, int fCost) {
        int fCostMinHeapIndex = hashToFCostIndexMap.get(nodeHash);
        int currentFCost = fCostMinHeap[fCostMinHeapIndex];

        if (currentFCost == fCost) return currentFCost;

        int numOfSimilarCostNeighbors = neighborsMap.get(currentFCost).size();

        /* Determine if we need to re-balance fCostMinHeap */
        if (numOfSimilarCostNeighbors == 1) {


        }

        neighborsMap.remove(fCostMinHeapIndex);
        return -1;
    }

    protected void balanceHeapUp(int parentIndex) {

    }

    protected void balanceHeapDown(int[] minHeap, int heapSize, int parentIndex) {
        int selectedIndex = parentIndex;

        boolean isLeftChildInRange = parentIndex + (parentIndex + 1) < heapSize;
        boolean isRightChildInRange = parentIndex + (parentIndex + 2) < heapSize;

        if (isLeftChildInRange && isRightChildInRange) {
            int leftChildIndex = parentIndex + (parentIndex + 1);
            int rightChildIndex = parentIndex + (parentIndex + 2);

            selectedIndex = (minHeap[leftChildIndex] < minHeap[selectedIndex]) ? leftChildIndex : selectedIndex;
            selectedIndex = (minHeap[rightChildIndex] < minHeap[selectedIndex]) ? rightChildIndex : selectedIndex;
        } else if (isLeftChildInRange) {
            selectedIndex = parentIndex + (parentIndex + 1);
        } else {
            return;
        }

        int previous = minHeap[parentIndex];
        minHeap[parentIndex] = minHeap[selectedIndex];
        minHeap[selectedIndex] = previous;

        balanceHeapDown(minHeap, heapSize, selectedIndex);
    }

    protected static int getIndex(short row, short column, short maxColumns) {
        return row * maxColumns + column;
    }

    protected short rowCount;
    protected short columnCount;
    protected int nodeCount;

    protected int fCostHeapSize;
    protected int hCostHeapSize;

    protected NavPoint startPoint;
    protected NavPoint endPoint;

    /* Contiguous arrays for node state */
    protected NodeState[] nodeStates;

    protected int[] nodeHashes;
    protected int[] gCostTable;
    protected int[] hCostTable;
    protected int[] fCostTable;

    protected NavPoint[] originTable;

    /* Binary Heap for lowest f & h cost Neighbor */
    protected int[] fCostMinHeap;
    protected int[][] hCostMinHeap;

    // neighborsMap<fCost, HashMap<hCost, NavPoint>> neighborsMap;
    protected HashMap<Integer, HashMap<Integer, List<NavPoint>>> neighborsMap;

    /* Look ups */
    protected HashMap<Integer, Integer> hashToFCostIndexMap;
    protected HashMap<Integer, Integer> hashToHCostIndexMap;
    //protected HashMap<>
}
