package org.maikodev;

import org.junit.Assert;
import org.junit.Test;

import org.maikodev.app.nav.*;

public class NavigationMapTest extends NavigationMap {
    public NavigationMapTest() {
        super((short)10, (short)10);
    }

    @Test
    public void constructor_init_test() {
        Assert.assertEquals("Logical error setting rowCount!", 10, super.rowCount);
        Assert.assertEquals("Logical error setting columnCount!", 10, super.columnCount);
        Assert.assertEquals("Logical error setting NodeCount!", 10 * 10, super.nodeCount);

        Assert.assertNotNull("NodeState array is null!", super.nodeStates);
        Assert.assertNotNull("NodeHashes array is null!", super.nodeHashes);

        Assert.assertNotNull("gCost table is null!", super.gCostTable);
        Assert.assertNotNull("hCost table is null!", super.hCostTable);
        Assert.assertNotNull("fCost table is null!", super.fCostTable);

        Assert.assertNotNull("Origin table is null!", super.originTable);
        //Assert.assertNotNull("Neighbor max-heap array is null!", super.neighborsMaxHeap);
        Assert.assertNotNull("hashToHeapIndexMap is null!", super.hashToHeapIndexMap);

        for (short row = 0; row < rowCount; row++) {
            for (short column = 0; column < columnCount; column++) {
                NavPoint currentNode = originTable[getIndex(row, column, super.columnCount)];

                String nodeString = String.format("(%d, %d)", row, column);
                String entryInitError = String.format("%s entry is not properly initialized!", nodeString);

                Assert.assertNotNull(String.format("%s entry in originTable is null!", nodeString), currentNode);
                Assert.assertEquals(entryInitError, row, currentNode.row);
                Assert.assertEquals(entryInitError, column, currentNode.column);
            }
        }
    }
}
