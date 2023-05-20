package com.it_academy.test.api;

import com.it_academy.rest_api.service.SushiveslaService;
import org.testng.annotations.Test;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;


public class RestAssuredTest {

    @Test
    public void checkSushiveslaFacetNames() {

        new SushiveslaService().getSushiveslaFacets()
                .stream().forEach(System.out::println);

        List<String> facetNames = new SushiveslaService()
                .getSushiveslaFacets().stream()
                .map(el -> el.getName())
                .collect(Collectors.toList());

        assertThat(facetNames, is(not(empty())));

    }

    @Test
    public void checkSushiveslaRollsFilter() {

        List<String> namePrefix = new SushiveslaService().getSushiveslaNamePrefix();
        assertThat(namePrefix.stream()
                .allMatch(el -> el.contains("Роллы")))
                .as("name_prefix is not containing 'Роллы'")
                .isTrue();

    }

}
