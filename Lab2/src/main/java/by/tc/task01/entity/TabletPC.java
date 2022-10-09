package main.java.by.tc.task01.entity;

import main.java.by.tc.task01.entity.criteria.SearchCriteria;

public class TabletPC extends Appliance{
    public int batteryCapacity;
    public int displayInches;
    public int memoryRom;
    public int flashMemoryCapacity;
    public String color;

    @Override
    public String toString() {
        return String.format("TabletPC : BATTERY_CAPACITY=%d, DISPLAY_INCHES=%d, MEMORY_ROM=%d, FLASH_MEMORY_CAPACITY=%d, COLOR=%s",
                batteryCapacity, displayInches, memoryRom, flashMemoryCapacity, color);
    }

    @Override
    public boolean isEqual(String key, Object value) {
        return switch (SearchCriteria.TabletPC.valueOf(key)){
            case BATTERY_CAPACITY -> batteryCapacity == (Integer) value;
            case DISPLAY_INCHES -> displayInches ==  (Integer) value;
            case MEMORY_ROM -> memoryRom == (Integer) value;
            case FLASH_MEMORY_CAPACITY -> flashMemoryCapacity == (Integer) value;
            case COLOR -> color.equals(value);
        };
    }
}
