## Problem Statement: List Operations

This exercise should be completed using Test Driven Development Technique

  - Write Test classes in TDD approach 
  - Functionality of methods should be completed, such that all the test cases pass 
  - Some of the requirements/hints are mentioned below
  
  ```
   In this problem, country names have to searched and sorted from the given input collections 
containing country names and capital names of countries 
        
   - Following functionality needs to be implemented in TDD approach
   
        - search a given country from the given list of countries
        - sort the given list of countries in ascending oeder
        - extract distinct countries from the given list of countries and sort them in ascending order of the number of characters in country 			name
        - search the country for a given capital from the given collection of country names and capital names
   
   - Empty and null inputs should be checked 
   ```
Class CountryUtility must be implemented using TDD for the following methods 

    + searchCountry(List<String> countries, String searchCountry):boolean
             return false if parameters are null or empty                    
    + sortCountries(List<String> countries):Optional<List<String>>
             return empty Optional if parameters are null or empty 
    + getDistinctCountriesInUpperCaseSortedByLength(List<String> countries) :Set<String> 
             return emptySet if parameters are null or empty 
    + getCountryByCapital(Map<String, String> countries, String searchCapital) :String
              return null if parameters are null or empty 
Implement custom exception class CountryNotFoundException

    Throw CountryNotFoundException whenever country is not found
    
**NOTE: ALL THE METHODS SHOULD BE IMPLEMENTED USING STREAMS API ONLY** 
         
## Instructions
- Take care of whitespace/trailing whitespace
- Do not change the provided class/method names unless instructed
- Ensure your code compiles without any errors/warning/deprecations 
- Follow best practices while coding

