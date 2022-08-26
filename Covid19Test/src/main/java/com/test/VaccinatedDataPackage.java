package com.test;

import com.fasterxml.jackson.annotation.JsonProperty;

/*
* Class to store vaccination information about single country
* */
public class VaccinatedDataPackage extends BaseDataPackage{
    public final long administered;
    public final long people_vaccinated;
    public final long people_partially_vaccinated;

    public VaccinatedDataPackage(@JsonProperty("administered") long administered,
                                 @JsonProperty("people_vaccinated") long people_vaccinated,
                                 @JsonProperty("people_partially_vaccinated") long people_partially_vaccinated,
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
        this.administered = administered;
        this.people_vaccinated = people_vaccinated;
        this.people_partially_vaccinated = people_partially_vaccinated;
    }
}