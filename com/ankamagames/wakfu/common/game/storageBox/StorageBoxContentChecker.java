package com.ankamagames.wakfu.common.game.storageBox;

import com.ankamagames.wakfu.common.game.item.*;
import java.util.*;
import com.ankamagames.baseImpl.common.clientAndServer.game.inventory.*;
import com.ankamagames.wakfu.common.rawData.*;
import com.ankamagames.baseImpl.common.clientAndServer.game.effect.*;

public class StorageBoxContentChecker implements InventoryContentChecker<Item>
{
    public static final StorageBoxContentChecker INSTANCE;
    
    @Override
    public int canAddItem(final Inventory inventory, final Item item) {
        final ArrayList<Item> items = inventory.getAllWithReferenceId(item.getReferenceId());
        short qty = item.getQuantity();
        Item stack;
        for (int i = 0; i < items.size() && qty > 0; qty -= (short)(stack.canStackWith(item) ? stack.getStackFreePlace() : 0), ++i) {
            stack = items.get(i);
        }
        return (qty <= 0 || !inventory.isFull()) ? 0 : -1;
    }
    
    @Override
    public int canAddItem(final Inventory inventory, final Item item, final short position) {
        if (position < 0) {
            return -5;
        }
        final ArrayInventory<Item, RawInventoryItem> inv = (ArrayInventory<Item, RawInventoryItem>)inventory;
        final Item targetItem = inv.getFromPosition(position);
        if (targetItem == null) {
            return 0;
        }
        if (!item.canStackWith(targetItem)) {
            return -1;
        }
        return (item.getQuantity() <= targetItem.getStackFreePlace()) ? 1 : -1;
    }
    
    @Override
    public int canReplaceItem(final Inventory inventory, final Item oldItem, final Item newItem) {
        throw new UnsupportedOperationException("Pas de remplacement");
    }
    
    @Override
    public int canRemoveItem(final Inventory inventory, final Item item) {
        return inventory.contains(item) ? 0 : -1;
    }
    
    @Override
    public boolean checkCriterion(final Item item, final EffectUser player, final EffectContext context) {
        throw new UnsupportedOperationException("Pas de v\u00e9rification de crit\u00e8re");
    }
    
    @Override
    public boolean checkCriterion(final Inventory<Item> inventory, final EffectUser player, final EffectContext context) {
        throw new UnsupportedOperationException("Pas de v\u00e9rification de crit\u00e8re");
    }
    
    static {
        INSTANCE = new StorageBoxContentChecker();
    }
}
