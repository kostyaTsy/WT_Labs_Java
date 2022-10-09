package main.java.by.tc.task01.main;

import main.java.by.tc.task01.entity.Appliance;
//import main.java.by.tc.task01.entity.Speakers;
import main.java.by.tc.task01.entity.criteria.Criteria;
import main.java.by.tc.task01.service.ApplianceService;
import main.java.by.tc.task01.service.ServiceFactory;

import static main.java.by.tc.task01.entity.criteria.SearchCriteria.Oven;
import static main.java.by.tc.task01.entity.criteria.SearchCriteria.TabletPC;
import static main.java.by.tc.task01.entity.criteria.SearchCriteria.Speakers;

public class Main {

	public static void main(String[] args) {
		Appliance appliance;

		ServiceFactory factory = ServiceFactory.getInstance();
		ApplianceService service = factory.getApplianceService();

		//////////////////////////////////////////////////////////////////

		Criteria criteriaOven = new Criteria(Oven.class.getSimpleName());//"Oven"
		criteriaOven.add(Oven.CAPACITY.toString(), 32);

		appliance = service.find(criteriaOven);

		PrintApplianceInfo.print(appliance);

		//////////////////////////////////////////////////////////////////

		criteriaOven = new Criteria(Oven.class.getSimpleName());
		criteriaOven.add(Oven.HEIGHT.toString(), 200);
		criteriaOven.add(Oven.DEPTH.toString(), 300);

		appliance = service.find(criteriaOven);

		PrintApplianceInfo.print(appliance);

		//////////////////////////////////////////////////////////////////
		
		Criteria criteriaTabletPC = new Criteria(TabletPC.class.getSimpleName());
		criteriaTabletPC.add(TabletPC.COLOR.toString(), "BLUE");
		criteriaTabletPC.add(TabletPC.DISPLAY_INCHES.toString(), 14);
		criteriaTabletPC.add(TabletPC.MEMORY_ROM.toString(), 4);

		appliance = service.find(criteriaTabletPC);// find(Object...obj)

		PrintApplianceInfo.print(appliance);

		//////////////////////////////////////////////////////////////////

		Criteria criteriaSpeaker = new Criteria(Speakers.class.getSimpleName());
		criteriaSpeaker.add(Speakers.POWER_CONSUMPTION.toString(), 20);

		appliance = service.find(criteriaSpeaker);

		PrintApplianceInfo.print(appliance);

	}

}
