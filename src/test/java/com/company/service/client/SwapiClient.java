package com.company.service.client;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.Response;

import java.util.*;
import java.util.logging.Logger;

import static io.restassured.RestAssured.when;

public class SwapiClient {
    private static Logger log = Logger.getLogger(SwapiClient.class.getName());

    public SwapiClient() {
        RestAssured.baseURI = "https://swapi.dev/api/";
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
    }

    public Set<String> getRoot() {
        Response response = when().get().
                then().extract().response();
        Map<String, String> map = response.jsonPath().getMap("$");
        Set<String> nodes = map.keySet();
        log.info(nodes.toString());
        return nodes;
    }

    public List<String> getFilms() {
        Response response = when().get("films").
                then().extract().response();
        List<String> films = response.jsonPath().getList("results.title");
        log.info(films.toString());
        return films;
    }

    public LinkedHashMap getFilmDetails(int id) {
        Response response = when().get("films/" + id).
                then().extract().response();
        LinkedHashMap films = response.jsonPath().get("");
        log.info(films.toString());
        return films;
    }

    public List<String> getPlanets() {
        Response response = when().get("planets").
                then().extract().response();
        List<String> planets = response.jsonPath().getList("results.name");
        log.info(planets.toString());
        return planets;
    }

    public LinkedHashMap getPlanet(int id) {
        Response response = when().get("planets/" + id).
                then().extract().response();
        LinkedHashMap planet = response.jsonPath().get("");
        log.info(planet.toString());
        return planet;
    }

    public Set<String> getSpeciesByPlanet(int id) {
        Set<String> result = new HashSet<>();
        Response response = when().get("planets/" + id).
                then().extract().response();
        List<String> residents = response.jsonPath().getList("residents");
        for (String resident : residents) {
            String[] split = resident.split("/");
            String residentId = split[split.length - 1];
            List<String> speciesByPeopleId = getSpeciesByPeopleId(residentId);
            result.addAll(speciesByPeopleId);
        }
        log.info(result.toString());
        return result;
    }

    private List<String> getSpeciesByPeopleId(String peopleId) {
        Response responsePeople = when().get("people/" + peopleId).
                then().extract().response();
        return responsePeople.jsonPath().getList("species");
    }

    public List<String> getPilotsByStarship(int id) {
        Response response = when().get("starships/" + id).
                then().extract().response();
        List<String> pilots = response.jsonPath().getList("pilots");
        log.info(pilots.toString());
        return pilots;
    }
}
