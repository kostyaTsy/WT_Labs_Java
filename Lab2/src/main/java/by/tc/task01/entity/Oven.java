package main.java.by.tc.task01.entity;

import main.java.by.tc.task01.entity.criteria.SearchCriteria;

public class Oven extends Appliance{
    public int powerConsumption;
    public int weight;
    public int capacity;
    public int depth;
    public double height;
    public double width;

    @Override
    public String toString() {
        return String.format("Oven : POWER_CONSUMPTION=%d, WEIGHT=%d, CAPACITY=%d, DEPTH=%d, HEIGHT=%.1f, WIDTH=%.1f",
                powerConsumption, weight, capacity, depth, height, width);
    }

    @Override
    public boolean isEqual(String key, Object value) {
        return switch (SearchCriteria.Oven.valueOf(key)){
            case POWER_CONSUMPTION -> powerConsumption == (Integer) value;
            case WEIGHT -> weight ==  (Integer) value;
            case CAPACITY -> capacity == (Integer) value;
            case DEPTH -> depth == (Integer) value;
            case HEIGHT -> height == Double.parseDouble(String.valueOf(value));
            case WIDTH -> width == Double.parseDouble(String.valueOf(value));
        };
    }
}
