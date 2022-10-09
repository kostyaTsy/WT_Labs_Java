package main.java.by.tc.task01.dao.impl;

import main.java.by.tc.task01.dao.ApplianceDAO;
import main.java.by.tc.task01.dao.creator.ApplianceCreator;
import main.java.by.tc.task01.dao.creator.ApplianceCreatorFactory;
import main.java.by.tc.task01.entity.Appliance;
import main.java.by.tc.task01.entity.criteria.Criteria;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ApplianceDAOImpl implements ApplianceDAO{

	@Override
	public Appliance find(Criteria criteria) {
		List<Appliance> matches = new ArrayList<>();
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

		// Parse appliance from xml file than try to find appliance that matches to criteria
		try {
			DocumentBuilder db = dbf.newDocumentBuilder();
			String pathToXml = "./src/main/resources/appliancesDB.xml";

			Document doc = db.parse(new File(pathToXml));
			doc.getDocumentElement().normalize();
			NodeList nodes = doc.getDocumentElement().getChildNodes();

			for (int i = 0; i < nodes.getLength(); i++) {
				Node node = nodes.item(i);
				if (node.getNodeType() == Node.ELEMENT_NODE) {

					if (!node.getNodeName().equalsIgnoreCase(criteria.getGroupSearchName()))
						continue;

					ApplianceCreator ac = ApplianceCreatorFactory.getInstance().getCreator(node.getNodeName());
					Appliance appliance = ac.create(node.getChildNodes());

					Map<String, Object> criterias = criteria.getSearchCriteria();

					boolean isValid = true;

					for (Map.Entry<String, Object> entry : criterias.entrySet()) {
						String key = entry.getKey();
						Object value = entry.getValue();

						if (!appliance.isEqual(key, value)) {
							isValid = false;
							break;
						}
					}

					if (isValid) {
						matches.add(appliance);
					}
				}
			}
		} catch (Exception e) {
			return null;
		}

		if (matches.size() != 0)
			return matches.get(0);
		else
			return null;
	}

}