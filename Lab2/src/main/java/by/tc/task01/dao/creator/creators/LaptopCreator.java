package main.java.by.tc.task01.dao.creator.creators;

import main.java.by.tc.task01.entity.Appliance;
import main.java.by.tc.task01.entity.Laptop;
import main.java.by.tc.task01.dao.creator.ApplianceCreator;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class LaptopCreator implements ApplianceCreator {

    private static final String BATTERY_CAPACITY = "batteryCapacity";
    private static final String OS = "os";
    private static final String MEMORY_ROM = "memoryRom";
    private static final String SYSTEM_MEMORY = "systemMemory";
    private static final String CPU = "cpu";
    private static final String DISPLAY_INCHS = "displayInchs";

    @Override
    public Appliance create(NodeList nodes) {
        Laptop laptop = new Laptop();

        for (int i = 0; i < nodes.getLength(); i++) {
            if (nodes.item(i).getNodeType() == Node.ELEMENT_NODE) {
                String text = nodes.item(i).getTextContent();
                switch (nodes.item(i).getNodeName()) {
                    case BATTERY_CAPACITY -> laptop.batteryCapacity = Double.parseDouble(text);
                    case OS -> laptop.os = text;
                    case MEMORY_ROM -> laptop.memoryRom = Integer.parseInt(text);
                    case SYSTEM_MEMORY -> laptop.systemMemory = Integer.parseInt(text);
                    case CPU -> laptop.cpu = Double.parseDouble(text);
                    case DISPLAY_INCHS -> laptop.displayInchs = Integer.parseInt(text);
                    default -> throw new IllegalArgumentException("No such appliance exists");
                }
            }
        }
        return laptop;
    }
}
