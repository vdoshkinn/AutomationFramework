package com.company.service.tests;

import com.company.service.client.SwapiClient;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class SwapiTest {
    SwapiClient swapiClient = new SwapiClient();

    @Test
    public void test1() {
        Set<String> rootNodes = swapiClient.getRoot();
        assertThat(rootNodes, hasItems("people", "planets", "films", "species", "vehicles", "starships"));
    }

    @Test
    public void test2() {
        List<String> films = swapiClient.getFilms();
        assertThat(films.size(), equalTo(6));

        LinkedHashMap filmDetails = swapiClient.getFilmDetails(3);
        assertThat(filmDetails.get("opening_crawl").toString(), startsWith("Luke Skywalker has returned to"));
    }

    @Test
    public void test3() {
        List<String> planets = swapiClient.getPlanets();
        assertThat(planets, hasItems("Tatooine"));

        LinkedHashMap planet = swapiClient.getPlanet(1);
        assertThat(planet.get("name").toString(), equalTo("Tatooine"));
    }

    @Test
    public void test4() {
        Set<String> species = swapiClient.getSpeciesByPlanet(1);
        assertThat(species.size(), not(0));
    }

    @Test
    public void test5() {
        Set<String> species = swapiClient.getSpeciesByPlanet(1);
        assertThat(species.size(), not(0));
    }

    @Test
    public void test6() {
        List<String> pilots = swapiClient.getPilotsByStarship(10);
        assertThat(pilots.size(), equalTo(4));
    }
}
