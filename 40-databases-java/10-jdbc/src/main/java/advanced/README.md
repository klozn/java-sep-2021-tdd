# Basic JDBC Connection

We're going to use JdbcTemplate to get data from the database

## Setup
1. Go to `resources\database.properties` and change to datasource properties so that they match your own.
    - Datasource URL: `jdbc:postgresql://database-2.cuvv0osxzgmi.eu-west-3.rds.amazonaws.com:5432/<yourdatabase>`
    - Datasource username: student
    - Datasource password: spidermanismyhero
2. Run `AttractionRepositoryTest ` to make sure that everything is configured correctly.
3. Execute `tour-operator.sql` to initialise your database.

## Exercise
`SwitchToTheSun` is a local tour operator that is just starting to automate their business.
 They come to you for setting up their web application.

## Exercises
* [Reporting](exercises/codelab01.md)
* [Editing](exercises/codelab02.md)
* [Querying](exercises/codelab03.md)
* [Joining](exercises/codelab04.md)
* [Extra's](exercises/codelab05.md)
