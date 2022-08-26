package com.test;

import static org.junit.Assert.*;
import org.junit.Test;

public class Covid19UnitTest {

    public Covid19Test covidTest = new Covid19Test();
    private static String country = "France";

    @Test
    public void testServiceAvailability() throws Exception {
        //test stat data service
        assertNotNull( "Service to get stat data is not available", covidTest.executeDataRequest("/cases?country=" + country));

        // test vaccine data service
        assertNotNull( "Service to get vaccination data is not available", covidTest.executeDataRequest("/vaccines?country=" + country));

        // test history data service
        assertNotNull( "Service to get historical data is not available", covidTest.executeDataRequest("/history?status=confirmed&country==" + country));
    }

    @Test
    public void testCommonDataService() throws Exception {
        // test get common data
        assertNotNull( "Unable to get stat data from response", covidTest.executeCommonDataRequest("/cases?country=" + country));
    }

    @Test
    public void testVaccinatedDataService() throws Exception {
        // test vaccine data
        assertNotNull( "Unable to get vaccination data from response", covidTest.executeVaccinationDataRequest("/vaccines?country=" + country));
    }

    @Test
    public void testHistoricalDataService() throws Exception {
        // test vaccine data
        assertNotNull( "Unable to get historical data from response", covidTest.executeHistoricalDataRequest("/history?status=confirmed&country=" + country));
    }
}