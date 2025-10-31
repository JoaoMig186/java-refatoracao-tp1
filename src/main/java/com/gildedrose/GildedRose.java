package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            Item item = items[i];

            if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
                continue;
            }
            if (item.name.equals("Aged Brie")) {
                updateAgedBrie(item);
            } else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                updateBackstagePass(item);
            } else {
                updateNormalItem(item);
            }
        }
    }

    private void updateAgedBrie(Item item) {
        if (item.quality < 50) {
            item.quality++;
        }
        item.sellIn--;

        if (item.sellIn < 0 && item.quality < 50) {
            item.quality++;
        }
    }

    private void updateBackstagePass(Item item) {
        if (item.quality < 50) {
            item.quality++;
            if (item.sellIn < 11 && item.quality < 50) {
                item.quality++;
            }
            if (item.sellIn < 6 && item.quality < 50) {
                item.quality++;
            }
        }
        item.sellIn--;
        if (item.sellIn < 0) {
            item.quality = 0;
        }
    }

    private void updateNormalItem(Item item) {
        if (item.quality > 0) {
            item.quality--;
        }
        item.sellIn--;
        if (item.sellIn < 0 && item.quality > 0) {
            item.quality--;
        }
    }
}
