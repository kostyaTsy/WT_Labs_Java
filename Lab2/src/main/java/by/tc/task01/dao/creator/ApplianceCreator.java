package main.java.by.tc.task01.dao.creator;

import main.java.by.tc.task01.entity.Appliance;
import org.w3c.dom.NodeList;

public interface ApplianceCreator {

    /**
     * Create an instance of Appliance with modes from xml file
     *
     * @param nodes part of xml file
     * @return instance that corresponds to nodes
     */
    Appliance create(NodeList nodes);
}
