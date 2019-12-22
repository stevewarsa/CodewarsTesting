package com.steve.warsa;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueCalculatorTest {

    @Test
    void solveSuperMarketQueue() {
        assertEquals(12, QueueCalculator.solveSuperMarketQueue(new int[]{5,3,4}, 1));
        assertEquals(12, QueueCalculator.solveSuperMarketQueue(new int[]{2,3,10}, 2));
        assertEquals(10, QueueCalculator.solveSuperMarketQueue(new int[]{10,2,3,3}, 2));
        assertEquals(9, QueueCalculator.solveSuperMarketQueue(new int[] { 2, 2, 3, 3, 4, 4 }, 2));
        assertEquals(0, QueueCalculator.solveSuperMarketQueue(new int[] {}, 1));
        assertEquals(15, QueueCalculator.solveSuperMarketQueue(new int[] { 1, 2, 3, 4, 5 }, 1));
        assertEquals(19, QueueCalculator.solveSuperMarketQueue(new int[] { 5,6,3,3,2,7,7,3,5,3,3,7,2,4,2,1,5,4,7 }, 5));
        //assertEquals(113, QueueCalculator.solveSuperMarketQueue(new int[] { 5,6,3,3,2,7,7,3,5,3,3,7,2,4,2,1,5,4,7 }, 5));
    }
}