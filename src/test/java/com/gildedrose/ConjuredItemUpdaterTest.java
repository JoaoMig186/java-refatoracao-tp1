package com.gildedrose;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ConjuredItemUpdaterTest {

    @Test
    public void qualityDecreasesTwiceAsFast() {
        Item conjured = new Item("Conjured", 5, 10);
        ItemUpdater updater = new ConjuredItemUpdater();

        updater.update(conjured);

        assertEquals(8, conjured.quality);
        assertEquals(4, conjured.sellIn);
    }

    @Test
    public void qualityDecreasesFourAfterSellIn() {
        Item conjured = new Item("Conjured", 0, 10);
        ItemUpdater updater = new ConjuredItemUpdater();

        updater.update(conjured);

        assertEquals(6, conjured.quality);
        assertEquals(-1, conjured.sellIn);
    }

    @Test
    public void qualityNeverGoesBelowZero() {
        Item conjured = new Item("Conjured", 5, 1);
        ItemUpdater updater = new ConjuredItemUpdater();

        updater.update(conjured);

        assertEquals(0, conjured.quality);
        assertEquals(4, conjured.sellIn);
    }

    @Test
    public void factoryReturnsConjuredUpdater() {
        Item conjured = new Item("Conjured", 3, 10);
        ItemUpdater updater = ItemUpdaterFactory.getUpdater(conjured);
        assertTrue(updater instanceof ConjuredItemUpdater);
    }
}
