package com.it_academy.rest_api.service;

import com.google.common.collect.ImmutableMap;
import com.it_academy.rest_api.model.SushiveslaFacet;

import java.util.List;
import java.util.Map;

import static com.it_academy.rest_api.endpoints.OnlinerEndpoints.getCatalogFacetEndpoint;
import static com.it_academy.rest_api.utils.getRequestUtils.makeGetRequestAndGetResponseBody;


public class SushiveslaService {

    public List<SushiveslaFacet> getSushiveslaFacets() {
        return makeGetRequestAndGetResponseBody(getCatalogFacetEndpoint(), configureHeaders(), null)
                .jsonPath()
                .getList("products", SushiveslaFacet.class);
    }

    public List<String> getSushiveslaNamePrefix() {
        return makeGetRequestAndGetResponseBody(getCatalogFacetEndpoint(), configureHeaders(), configureParams())
                .jsonPath()
                .getList("products.name_prefix");
    }

    private Map<String, Object> configureHeaders() {
        return ImmutableMap.of("Host", "catalog.onliner.by");
    }

    private Map<String, Object> configureParams() {
        return ImmutableMap.of("sushi_typ[0]", "roll", "sushi_typ[operation]", "union");
    }
}
