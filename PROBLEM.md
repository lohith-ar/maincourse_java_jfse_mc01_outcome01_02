## Problem Statement: List Operations

This exercise should be completed using Test Driven Development Technique

  - Write Test classes in TDD approach 
  - Functionality of methods should be completed, such that all the test cases pass 
  - Some requirements/hints are mentioned below
  
  ```
   In this problem, country names have to searched and sorted from the given input collections 
containing country names and capital names of countries 
        
   - Following functionality needs to be implemented in TDD approach
   
        - search a given country from the given list of countries
        - sort the given list of countries in ascending order
        - extract distinct countries from the given list of countries and sort them in ascending order of the number of characters in country name
        - search the country for a given capital from the given collection of country names and capital names
   
   - Empty and null inputs should be checked 
   ```
Class CountryUtility must be implemented using TDD for the following methods 

    + searchCountry(List<String> countries, String searchCountry):boolean
             - This method checks if the parameter `searchCountry` is present the list `countries`. The parameter `searchCountry` is case-insensitive.
             - return false if parameters are null or empty 
             - return false if the searchCountry is not found in the list countries
             - return true if the searchCountry is found in the list countries.
                                
    + sortCountries(List<String> countries):Optional<List<String>>
             - This method sorts the given list of countries in ascending order.
             - return empty Optional if parameters are null or empty else return optional of sorted list.
             
    + getDistinctCountriesInUpperCaseSortedByLength(List<String> countries) :Set<String> 
             - This method returns the distinct set of countries in uppercase sorted in the order of length(number of characters).
             - return emptySet if the parameter are null or empty 
             
    + getCountryByCapital(Map<String, String> countries, String searchCapital) :String
            - This methods returns the country name for the given capital name of country.
            - return null if parameters are null or empty.
            - Throw CountryNotFoundException if the country is not present.
              
Implement custom exception class CountryNotFoundException

    - This class extends RuntimeException.
    - Implement constructors
    
   
    
**NOTE: ALL THE METHODS SHOULD BE IMPLEMENTED USING STREAMS API ONLY** 
 
- Write the test cases in the class `CountryUtilityTests`.    
- Minimum test cases expected: 13
- Test cases should be written for positive and negative scenarios, wherever applicable
- Test methods should follow (given...ThenShould) naming convention.
    - For example: `givenTwoIntegersWhenAddedThenShouldReturnSum`. If the method name is very long,then you can skip `when` part.
- Test coverage should be 100%

## Instructions

- Take care of whitespace/trailing whitespace
- Do not change the provided class/method names unless instructed
- Follow best practices while coding

## Code coverage 

 - Run mvn test, the JaCoCo code coverage report will be generated at target/site/jacoco/*
 - Open the target/site/jacoco/index.html file, review the code coverage report 
 
            - Green – Code is tested or covered.
            - Red – Code is not tested or covered.
            - Yellow – Code is partially tested or covered.
 - Make sure lines coverage must meet the minimum 90%

