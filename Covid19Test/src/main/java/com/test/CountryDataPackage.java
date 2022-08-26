package com.test;

import com.fasterxml.jackson.annotation.JsonProperty;

/*
* Class to store statistical data information about single country
* */
public class CountryDataPackage extends BaseDataPackage{
    public final long confirmed;
    public final long recovered;
    public final long deaths;

    public CountryDataPackage(@JsonProperty("confirmed") long confirmed,
                              @JsonProperty("recovered") long recovered,
                              @JsonProperty("deaths") long deaths,
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
                              @JsonProperty("updated") String updated  ) {
        super(country, population, sq_km_area, life_expectancy, elevation_in_meters, continent, abbreviation, location, iso, capital_city, lattitude, longtitude, updated);

        this.confirmed = confirmed;
        this.recovered = recovered;
        this.deaths = deaths;
    }
}