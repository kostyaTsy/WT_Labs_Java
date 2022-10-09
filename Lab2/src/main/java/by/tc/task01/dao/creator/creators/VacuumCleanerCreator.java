package main.java.by.tc.task01.dao.creator.creators;

import main.java.by.tc.task01.dao.creator.ApplianceCreator;
import main.java.by.tc.task01.entity.Appliance;
import main.java.by.tc.task01.entity.VacuumCleaner;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class VacuumCleanerCreator implements ApplianceCreator {
    private static final String POWER_CONSUMPTION = "powerConsumption";
    private static final String FILTER_TYPE = "filterType";
    private static final String BAG_TYPE = "bagType";
    private static final String WAND_TYPE = "wandType";
    private static final String MOTOR_SPEED_REGULATION = "motorSpeedRegulation";
    private static final String CLEANING_WIDTH = "cleaningWidth";

    @Override
    public Appliance create(NodeList nodes) {
        VacuumCleaner vacuumCleaner = new VacuumCleaner();

        for (int i = 0; i < nodes.getLength(); i++) {
            if (nodes.item(i).getNodeType() == Node.ELEMENT_NODE) {
                String text = nodes.item(i).getTextContent();
                switch (nodes.item(i).getNodeName()) {
                    case POWER_CONSUMPTION -> vacuumCleaner.powerConsumption = Integer.parseInt(text);
                    case FILTER_TYPE -> vacuumCleaner.filterType = text; //FilterType.valueOf(text.toUpperCase());
                    case BAG_TYPE -> vacuumCleaner.bagType = text;
                    case WAND_TYPE -> vacuumCleaner.wandType = text;
                    case MOTOR_SPEED_REGULATION -> vacuumCleaner.motorSpeedRegulation = Integer.parseInt(text);
                    case CLEANING_WIDTH -> vacuumCleaner.cleaningWidth = Integer.parseInt(text);
                    default -> throw new IllegalArgumentException("No such appliance exists");
                }
            }
        }
        return vacuumCleaner;
    }
}
