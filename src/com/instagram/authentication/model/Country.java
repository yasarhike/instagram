package com.instagram.authentication.model;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

/**
 * <p>
 * Hold the location details of the user.
 * </p>
 *
 * @author Mohamed Yasar k
 * @version 1.0 6 Feb 2024
 */
public class Country {

    public static final Map<String, Country> country = new HashMap<>();

    static {
        loadCountry();
    }

    private final String name;
    private final List<String> states;
    private final String code;

    public Country(final String name, final List<String> states, final String regexCode) {
        this.name = name;
        this.states = states;
        this.code = regexCode;
    }

    private static void loadCountry() {
        country.put("91", new Country("india", new ArrayList<>(List.of("tamilnadu", "kerala", "maharashtra")),
                "[6-9][0-9]{9}"));
        country.put("61", new Country("australia", new ArrayList<>(List.of("orange", "sydney", "sunbury")),
                "[0-9]{8}"));
        country.put("213", new Country("algeria", new ArrayList<>(List.of("oran", "mila", "saida")),
                "[0-9]{9}"));
        country.put("india", country.get("91"));
        country.put("australia", country.get("61"));
        country.put("algeria", country.get("213"));
    }

    public String getName() {
        return this.name;
    }

    public String getCode() {
        return this.code;
    }

    public List<String> getState() {
        return this.states;
    }
}
