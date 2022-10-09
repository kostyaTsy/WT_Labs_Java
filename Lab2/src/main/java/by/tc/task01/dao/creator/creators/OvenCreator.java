package main.java.by.tc.task01.dao.creator.creators;

import main.java.by.tc.task01.entity.Appliance;
import main.java.by.tc.task01.entity.Oven;
import main.java.by.tc.task01.dao.creator.ApplianceCreator;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class OvenCreator implements ApplianceCreator {
    private static final String POWER_CONSUMPTION = "powerConsumption";
    private static final String WEIGHT = "weight";
    private static final String CAPACITY = "capacity";
    private static final String DEPTH = "depth";
    private static final String HEIGHT = "height";
    private static final String WIDTH = "width";

    @Override
    public Appliance create(NodeList nodes) {
        Oven oven = new Oven();

        for (int i = 0; i < nodes.getLength(); i++) {
            if (nodes.item(i).getNodeType() == Node.ELEMENT_NODE) {
                String text = nodes.item(i).getTextContent();
                switch (nodes.item(i).getNodeName()) {
                    case POWER_CONSUMPTION -> oven.powerConsumption = Integer.parseInt(text);
                    case WEIGHT -> oven.weight = Integer.parseInt(text);
                    case CAPACITY -> oven.capacity = Integer.parseInt(text);
                    case DEPTH -> oven.depth = Integer.parseInt(text);
                    case HEIGHT -> oven.height = Double.parseDouble(text);
                    case WIDTH -> oven.width = Double.parseDouble(text);
                    default -> throw new IllegalArgumentException("No such appliance exists");
                }
            }
        }
        return oven;
    }
}
