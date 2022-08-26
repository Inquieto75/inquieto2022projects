package com.test;

import com.fasterxml.jackson.annotation.JsonProperty;

/*
* Class to store common data information about single country
* */
public class BaseDataPackage {
    public final String country;
    public final long population;
    public final long sq_km_area;
    public final String life_expectancy;

    public final long elevation_in_meters;
    public final String continent;

    public final String abbreviation;
    public final String location;
    public final long iso;
    public final String capital_city;


    public final String lattitude;
    public final String longtitude;
    public final String updated;


    public BaseDataPackage(@JsonProperty("country") String country,
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
        this.country = country;
        this.population = population;
        this.sq_km_area = sq_km_area;
        this.life_expectancy = life_expectancy;
        this.elevation_in_meters = elevation_in_meters;
        this.continent = continent;
        this.abbreviation = abbreviation;
        this.location = location;
        this.iso = iso;
        this.capital_city = capital_city;
        this.lattitude = lattitude;
        this.longtitude = longtitude;
        this.updated = updated;
    }
}