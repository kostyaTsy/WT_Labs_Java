package main.java.by.tc.task01.dao;

import main.java.by.tc.task01.entity.Appliance;
import main.java.by.tc.task01.entity.criteria.Criteria;

public interface ApplianceDAO {
	/**
	 * Find appliance by criteria
	 *
	 * @param criteria by appliance should be found
	 * @return find appliance or null
	 */
	// Find appliance by criteria if not mach returns null
	Appliance find(Criteria criteria);
}
