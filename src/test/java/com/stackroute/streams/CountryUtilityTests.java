package com.stackroute.streams;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CountryUtilityTests {

    private static final String MSG_01 = "should return true if country exists in the list ignoring case, else should return false. Should return false, when the inputs are null";
    private static final String MSG_02 = "should return the a List of country names sorted in ascending order";
    private static final String MSG_03 = "should return empty optional when the input list of country is empty or null";
    private static final String MSG_04 = "should return a set of countries converted to uppercase and sorted by length";
    private static final String MSG_05 = "should return null when the inputs are null";
    private static final String MSG_06 = "should return the country name for the given capital ignoring the case";
    private static final String MSG_07 = "should throw an exception named CountryNotFoundException when searched capital does not exist";

    private CountryUtility countryUtility;
    private List<String> countryList;
    private List<String> emptyCountryList;
    private Optional<List<String>> sortedCountryList;
    private Set<String> distinctSortedCountryList;
    private Map<String, String> countryCapitalsMap;

    @BeforeEach
    public void setUp() {
        countryUtility = new CountryUtility();
        countryList = List.of("India", "SriLanka", "JAPAN", "CHINA", "CHINA", "Italy", "France");
        emptyCountryList = Collections.emptyList();
        sortedCountryList = Optional.of(List.of("CHINA", "CHINA", "France", "India", "Italy", "JAPAN", "SriLanka"));
        distinctSortedCountryList = Set.of("CHINA", "FRANCE", "INDIA", "ITALY", "JAPAN", "SRILANKA");
        countryCapitalsMap = Map.of("India", "Delhi", "France", "PARIS", "Japan", "tokyo");
    }

    @AfterEach
    public void tearDown() {
        countryUtility = null;
        countryList = null;
        emptyCountryList = null;
    }

    @Test
    public void givenListOfCountriesWhenSearchCountryPresentThenReturnTrue() {
        assertThat(MSG_01, countryUtility.searchCountry(countryList, "India"), is(true));
    }

    @Test
    public void givenListOfCountriesWhenSearchCountryNotPresentThenReturnFalse() {
        assertThat(MSG_01, countryUtility.searchCountry(countryList, "England"), is(false));
    }

    @Test
    public void givenListOfCountriesWhenSearchCountryPresentWithNonMatchingCaseThenReturnTrue() {
        assertThat(MSG_01, countryUtility.searchCountry(countryList, "INDIA"), is(true));
    }

    @Test
    public void givenListOfCountriesWhenNullOrSearchCountryNullThenReturnFalse() {
        assertThat(MSG_01, countryUtility.searchCountry(countryList, null), is(false));
        assertThat(MSG_01, countryUtility.searchCountry(null, "India"), is(false));
    }

    @Test
    public void givenListOfCountriesThenReturnSortedListInAscendingOrder() {
        assertThat(MSG_02, countryUtility.sortCountries(countryList), is(sortedCountryList));
    }

    @Test
    public void givenListOfCountriesWhenEmptyThenReturnEmptyOptional() {
        assertThat(MSG_03, countryUtility.sortCountries(emptyCountryList), is(Optional.empty()));
    }

    @Test
    public void givenListOfCountriesWhenNullThenReturnEmptyOptional() {
        assertThat(MSG_03, countryUtility.sortCountries(null), is(Optional.empty()));
    }

    @Test
    public void givenListOfCountriesThenReturnDistinctListOfCountriesInUpperCaseSortedByLength() {
        assertThat(MSG_04, countryUtility.getDistinctCountriesInUpperCaseSortedByLength(countryList), is(distinctSortedCountryList));
    }

    @Test
    public void givenListOfCountriesWhenNullOrEmptyThenReturnEmptySet() {
        assertThat(MSG_05, countryUtility.getDistinctCountriesInUpperCaseSortedByLength(null), is(Collections.emptySet()));
        assertThat(MSG_05, countryUtility.getDistinctCountriesInUpperCaseSortedByLength(emptyCountryList), is(Collections.emptySet()));
    }

    @Test
    public void givenMapOfCountryAndCapitalsWhenSearchedByCapitalThenReturnCountry() {
        assertThat(MSG_06, countryUtility.getCountryByCapital(countryCapitalsMap, "Delhi"), is("India"));
    }

    @Test
    public void givenMapOfCountryAndCapitalsWhenSearchedByCapitalIgnoringCaseThenReturnCountry() {
        assertThat(MSG_06, countryUtility.getCountryByCapital(countryCapitalsMap, "paris"), is("France"));
    }

    @Test
    public void givenMapOfCountryAndCapitalsWhenCountryDoesNotExistThenThrowCountryNotFoundException() {
        assertThrows(CountryNotFoundException.class, () -> countryUtility.getCountryByCapital(countryCapitalsMap, "test"), MSG_07);
    }

    @Test
    public void givenMapOfCountryAndCapitalsWhenNullThenReturnNull() {
        assertThat(MSG_05, countryUtility.getCountryByCapital(null, "test"), is(nullValue()));
        assertThat(MSG_05, countryUtility.getCountryByCapital(countryCapitalsMap, null), is(nullValue()));
    }
}
