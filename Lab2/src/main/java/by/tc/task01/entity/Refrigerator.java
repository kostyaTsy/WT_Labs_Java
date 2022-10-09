package main.java.by.tc.task01.entity;

import main.java.by.tc.task01.entity.criteria.SearchCriteria;

public class Refrigerator extends Appliance{
    public int powerConsumption;
    public int weight;
    public int freezerCapacity;
    public double overallCapacity;
    public double height;
    public double width;

    @Override
    public String toString() {
        return String.format("Refrigerator : POWER_CONSUMPTION=%d, WEIGHT=%d, FREEZER_CAPACITY=%d, OVERALL_CAPACITY=%.1f, HEIGHT=%.1f, WIDTH=%.1f",
                powerConsumption, weight, freezerCapacity, overallCapacity, height, width);
    }

    @Override
    public boolean isEqual(String key, Object value) {
        return switch (SearchCriteria.Refrigerator.valueOf(key)){
            case POWER_CONSUMPTION -> powerConsumption == (Integer) value;
            case WEIGHT -> weight ==  (Integer) value;
            case FREEZER_CAPACITY -> freezerCapacity == (Integer) value;
            case OVERALL_CAPACITY -> overallCapacity == Double.parseDouble(String.valueOf(value));
            case HEIGHT -> height == Double.parseDouble(String.valueOf(value));
            case WIDTH -> width == Double.parseDouble(String.valueOf(value));
        };
    }
}
