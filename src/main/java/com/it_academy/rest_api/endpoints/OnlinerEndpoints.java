package com.it_academy.rest_api.endpoints;

import com.it_academy.framework.PropertiesReader;

public class OnlinerEndpoints {

    public static String getCatalogFacetEndpoint(){
        return PropertiesReader.getEndpointProperty("catalog.facets.sushivesla");
    }
}
