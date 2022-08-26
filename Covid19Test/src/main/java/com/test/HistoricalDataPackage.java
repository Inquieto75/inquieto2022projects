package com.test;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/*
* Class to store historical data information about single country
* */
public class HistoricalDataPackage extends BaseDataPackage{
    public TreeMap<Date, Long> innerDates = new TreeMap<>();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public HistoricalDataPackage(
                                 @JsonProperty("country") String country,
                                 @JsonProperty("population") long population,
                                 @JsonProperty("sq_km_area") long sq_km_area,
                                 @JsonProperty("life_expectancy") String life_expectancy,
                                 @JsonProperty("elevation_in_meters") long elevation_in_meters,
                                 @JsonProperty("continent") String continent,
                                 @JsonProperty("abbreviation") String abbreviation,
                                 @JsonProperty("location") String location,
                                 @JsonProperty("iso") long iso,
                                 @JsonProperty("capital_city") String capital_city,
                                 @JsonProperty("lat") String lattitude,
                                 @JsonProperty("long") String longtitude,
                                 @JsonProperty("updated") String updated,
                                 @JsonProperty("dates") Map<String, Long> dates ) throws ParseException {
        super(country, population, sq_km_area, life_expectancy, elevation_in_meters, continent, abbreviation, location, iso, capital_city, lattitude, longtitude, updated);

        for (Map.Entry<String,Long> entry : dates.entrySet()){
            innerDates.put(sdf.parse(entry.getKey()), entry.getValue());
        }
    }

    public Date getLastDateInfo(){
        if(innerDates.size() > 0)
            return innerDates.lastEntry().getKey();
        else
            return new Date();
    }

    public String getLastDateInfoAsString(){
        if(innerDates.size() > 0)
            return sdf.format(getLastDateInfo());
        else
            return "";
    }

    public Long getLastCasesInfo(){
        if(innerDates.size() > 0)
            return innerDates.lastEntry().getValue();
        else
            return 0l;
    }
}