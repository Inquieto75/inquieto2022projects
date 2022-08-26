package com.test;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Covid19Test {

    private static final String BASE_DATA_URL = "https://covid-api.mmediagroup.fr/v1/";

    public static void main(String[] args) throws Exception {

        // container for comman data
        CountryDataPackage cdp = null;

        //container for vaccination data
        VaccinatedDataPackage vdp = null;

        // container to store historical data
        HistoricalDataPackage hdp = null;

        if(args.length == 1){
            String countryData = args[0];
            String request = "";
            if(countryData.length() == 2){
                // abbreviation data
                request = "ab="+countryData.toUpperCase();
            }
            else{
                request = "country="+countryData;
            }


            cdp = executeCommonDataRequest("cases?" + request);
            vdp = executeVaccinationDataRequest("vaccines?" + request);
            hdp = executeHistoricalDataRequest("history?status=confirmed&" + request);
            printOutputData(cdp, vdp, hdp, countryData);
        }
        else{
            System.out.println("Incorrect arg length");
        }

    }

    /*
    * Method to execute rest service call and return response as string for future processing
    * */
    public static String executeDataRequest(String requestParam) throws Exception{
        // create a http client
        var client = HttpClient.newHttpClient();

        // create a request
        var request = HttpRequest.newBuilder(
                URI.create(BASE_DATA_URL + requestParam ))
                .timeout(Duration.ofSeconds(10))
                .header("accept", "application/json")
                .build();
        String responseBody = null;

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            responseBody = response.body();
        }
        catch (Exception ex) {
            System.err.println("[-] There was an issue getting the common data at " + BASE_DATA_URL + requestParam);
            ex.printStackTrace();
        }
        return responseBody;
    }

    /*
    * Method to get common data
    * */
    public static CountryDataPackage executeCommonDataRequest(String requestParam) throws Exception{
        String responseBody = executeDataRequest( requestParam);

        if(responseBody!= null){
            ObjectMapper mapper = new ObjectMapper();
            TypeReference<HashMap<String, CountryDataPackage>> typeRef
                    = new TypeReference<HashMap<String, CountryDataPackage>>() {};
            Map<String, CountryDataPackage> map = mapper.readValue(responseBody, typeRef);

            // get total info of country
            return map.get("All");
        }
        else{
            return null;
        }
    }

    /*
     * Method to get vaccination data
     * */
    public static VaccinatedDataPackage executeVaccinationDataRequest(String requestParam) throws Exception{
        String responseBody = executeDataRequest(requestParam);

        if(responseBody!= null){
            ObjectMapper mapper = new ObjectMapper();
            TypeReference<HashMap<String, VaccinatedDataPackage>> typeRef
                    = new TypeReference<HashMap<String, VaccinatedDataPackage>>() {};
            Map<String, VaccinatedDataPackage> map = mapper.readValue(responseBody, typeRef);

            // get total info of country
            return map.get("All");
        }
        else{
            return null;
        }
    }

    /*
     * Method to get historical data
     * */
    public static HistoricalDataPackage executeHistoricalDataRequest(String requestParam) throws Exception{
        String responseBody = executeDataRequest(requestParam);

        if(responseBody!= null){
            ObjectMapper mapper = new ObjectMapper();
            TypeReference<HashMap<String, HistoricalDataPackage>> typeRef
                    = new TypeReference<HashMap<String, HistoricalDataPackage>>() {};
            Map<String, HistoricalDataPackage> map = mapper.readValue(responseBody, typeRef);

            // get historical info of country
            return map.get("All");
        }
        else{
            return null;
        }
    }


    public static void printOutputData( CountryDataPackage cdp, VaccinatedDataPackage vdp, HistoricalDataPackage hdp, String country){
        if(cdp!=null) {
            System.out.println("confirmed : " + cdp.confirmed);
            System.out.println("recovered : " + cdp.recovered);
            System.out.println("deaths : " + cdp.deaths);
        }
        else{
            System.out.println("There is no statistical data for country " + country);
        }

        if (vdp != null) {
            System.out.println("vaccinated level in % of total population : " + String.format("%.2f", 100.0 * vdp.people_vaccinated / vdp.administered) + "%");
        }
        else{
            System.out.println("There is no data about vaccination for country " + country);
        }

        if(hdp!= null){
            System.out.println("new confirmed cases since "+hdp.getLastDateInfoAsString()+" : " + hdp.getLastCasesInfo());
        }
        else{
            System.out.println("There is no historical data for country " + country);
        }
    }
}
