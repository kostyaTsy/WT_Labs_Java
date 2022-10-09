package main.java.by.tc.task01.dao.creator.creators;

import main.java.by.tc.task01.entity.Appliance;
import main.java.by.tc.task01.entity.Refrigerator;
import main.java.by.tc.task01.dao.creator.ApplianceCreator;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class RefrigeratorCreator implements ApplianceCreator {
    private static final String POWER_CONSUMPTION = "powerConsumption";
    private static final String WEIGHT = "weight";
    private static final String FREEZER_CAPACITY = "freezerCapacity";
    private static final String OVERALL_CAPACITY = "overallCapacity";
    private static final String HEIGHT = "height";
    private static final String WIDTH = "width";

    @Override
    public Appliance create(NodeList nodes) {
        Refrigerator refrigerator = new Refrigerator();

        for (int i = 0; i < nodes.getLength(); i++) {
            if (nodes.item(i).getNodeType() == Node.ELEMENT_NODE) {
                String text = nodes.item(i).getTextContent();
                switch (nodes.item(i).getNodeName()) {
                    case POWER_CONSUMPTION -> refrigerator.powerConsumption = Integer.parseInt(text);
                    case WEIGHT -> refrigerator.weight = Integer.parseInt(text);
                    case FREEZER_CAPACITY -> refrigerator.freezerCapacity = Integer.parseInt(text);
                    case OVERALL_CAPACITY -> refrigerator.overallCapacity = Integer.parseInt(text);
                    case HEIGHT -> refrigerator.height = Double.parseDouble(text);
                    case WIDTH -> refrigerator.width = Double.parseDouble(text);
                    default -> throw new IllegalArgumentException("No such appliance exists");
                }
            }
        }
        return refrigerator;
    }
}
