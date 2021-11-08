# Reporting functionality
1. A nephew of `SwitchToTheSun` already started initialising a database.
   Unfortunately he couldn't finish because he just received a ps4 for his birthday.
   Now `SwitchToTheSun` isn't sure what is in the database and what isn't.
   To make more clear what is in the database they want you to create a reporting functionality.
    1. `AttractionRepository` needs to return a list of all the attractions in the `attractions` table.
        1. Complete the implementation so that the repository returns a list of all the attractions
        1. Change the main method in `SwitchToTheSun` so that it prints out a list of all the attractions
    1. `SwitchToTheSun` also wants you to show a list of all the countries in their database.
        1. Create a new `CountryRepository` and `Country` class.
        1. Read out the `Country` table and show a list of all available countries
        1. Change the main method in `SwitchToTheSun` so that it prints out a list of all the attractions *AND* all the countries
1. The manager of `SwitchToTheSun` isn't sure if the reporting functionality will be used that often and wants to keep track of its use.
    1. Look at the `metadata` table. Every time you run the main method the `NUMBER_OF_VISITS` column needs to increase by 1.
    2. Print out after each report the number of times a report has been made.  
