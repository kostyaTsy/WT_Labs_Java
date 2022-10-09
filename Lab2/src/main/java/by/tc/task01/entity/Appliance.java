package main.java.by.tc.task01.entity;

public abstract class Appliance {

    /**
     * Returns true if appliance isEqual the given search criteria.
     *
     * @param key field to match for
     * @param value value of field
     * @return boolean value that indicates if appliance is equal to creteria
     * Check if key is equal to object
     */
    // Checks if key equal with value
    public abstract boolean isEqual(String key, Object value);
}
