package main.java.by.tc.task01.dao.creator.creators;

import main.java.by.tc.task01.entity.Appliance;
import main.java.by.tc.task01.entity.Speakers;
import main.java.by.tc.task01.dao.creator.ApplianceCreator;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class SpeakersCreator implements ApplianceCreator {
    private static final String POWER_CONSUMPTION = "powerConsumption";
    private static final String NUMBER_OF_SPEAKERS = "numberOfSpeakers";
    private static final String FREQUENCY_RANGE = "frequencyRange";
    private static final String CORD_LENGTH = "cordLength";

    @Override
    public Appliance create(NodeList nodes) {
        Speakers speakers = new Speakers();

        for (int i = 0; i < nodes.getLength(); i++) {
            if (nodes.item(i).getNodeType() == Node.ELEMENT_NODE) {
                String text = nodes.item(i).getTextContent();
                switch (nodes.item(i).getNodeName()) {
                    case POWER_CONSUMPTION -> speakers.powerConsumption = Integer.parseInt(text);
                    case NUMBER_OF_SPEAKERS -> speakers.numberOfSpeakers = Integer.parseInt(text);
                    case FREQUENCY_RANGE -> speakers.frequencyRange = text;
                    case CORD_LENGTH -> speakers.cordLength = Integer.parseInt(text);
                    default -> throw new IllegalArgumentException("No such appliance exists");
                }
            }
        }
        return speakers;
    }
}
