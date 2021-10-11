# Stock Exchange

We're going to create an multi-module Maven stock exchange application.
- Note: this is an advanced codelab...

1. Create 1 parent project and 4 modules:
    - `api`
    - `service`
    - `domain`
    - `interfaces`
2. Think about the base-package each module should have.
3. Make sure that in the end (after implementing all the requirements), 
command `mvn clean package` executes successfully.
    - It should compile your code
    - It should compile **and run your tests**
        - Run tests using the Maven Surefire plugin: https://maven.apache.org/surefire/maven-surefire-plugin/
    - It should package your code into an (executable) JAR.
    
## A Breakdown of the modules (Requirements)

### Module: api
- Has a `StockExchangeController` class
    - has method `StockDto getStock(String stockId)`
        - calls the StockService method `Stock getStock(String stockId)`
        - transforms Stock to StockDto which it returns
            - *What is a Dto? Why do we use it?*
    - *(For the sake of this exercise, just imagine that this method can get called outside of this application, by other applications. 
    It's an entry point to our application, to get information about a stock)*

### Module: service
- Has a `StockService` class
    - Has method `public Stock getStock(String stockId)`
        - calls the StockRepository method `Stock getStockInformation(String stockId)`
            - *What if no Stock could be found for the given stockId? 
            The method needs to return a Stock, so what will we return?*
        - enriches the Stock with Price information, 
        retrieved by calling the ExternalStockInformationService method `BigDecimal getPriceInEuroForStock(String stockId)`
        - returns the enriched Stock

### Module: domain
- Has a `Stock` class
    - Has the following state:
        - `id` (String)
        - `name` (String)
        - `price` (StockPrice)
    - Allow to set the price after construction (service has to enrich with price)
- Has a `StockPrice` class
    - Has the following state:
        - `price` (BigDecimal)
            - *Why BigDecimal and not float or double?*
        - `currency` (StockCurrency)
- Has a `StockCurrency` enum
    - Has enum-values EUR, USD & GBP
    - We should also provide a label (E.g.: "Euro") and symbol (E.g.: "€")
- Has a `StockRepository`
    - It holds a map (our fake Database) 
        - Contains <String, Stock> key-value pairs, where String is the stockId
            - Populate it with some fake data, e.g.: `("AA", new Stock("AA", "Ambro AN"))`
    - Has method `Stock getStockInformation(String stockId)`
        - Returns the corresponding Stock, based on stockId
        - throws an exception when no Stock was found in the database (map) for the specified stockId

### Module: interfaces
- Has a `ExternalStockInformationService` class
    - Has method `BigDecimal getPriceInEuroForStock(String stockId)`
        - Simply returns a random BigDecimal between 10 and 100, whatever the stockId is.
    - *(For the sake of this exercise, just imagine that this method calls an external service that has live data on the price of a stock. 
    This class and method function as the interface / access-point to that external service / system.)*         

## Extra Requirements (Not optional)
1. For building your Database (map), use the `ImmutableMap.builder` methods of library `Guava`
2. For generating a random number in `ExternalStockInformationService`, use the `RandomUtils` class from library `Commons-lang3`

## Extra Requirements (Optional, although recommended)
1. Command line interface
    1. Create a new module, name it `cli`
    2. Inside, create a class `MyCLI` that has a main method
        - The main method can have 0 or 1 arguments (located in String[] args), which should be a stockId
        - The main method calls the `StockDto getStock(String stockId)` method from `StockExchangeController` (api) 
        if it has 1 argument
        - The main method prints the answer (StockDto)
    3. Create a JAR that packages module cli and all its dependencies
        - Use the assembly plugin
        - Specify the MyCLI main method as thé main method of the JAR
    4. Run the jar, providing it a stockId as an argument

## Tips    
- If you think it is helpful, use UML (class diagram(s), sequence diagram(s)) to make things more clear.
- Create multiple folders at once using the `mkdir` command. E.g.: `mkdir src\main\java`
- Explore what the "Maven Wrapper" is, use it if you like
    - *What are the benefits of the Maven Wrapper?*
    
## Finished?

Think you're finished? Ask for some feedback first, only then checkout the solution.
**Do yourself a favor and do not look at the solution beforehand!**
 
The `maven-stock-exchange` project on our GitHub project contains a solution for this codelab.
- Clone (or Fork, then Clone) the project: https://github.com/switchfully/maven-stock-exchange
- Explore the project
- Run the build: `mvn clean package`
    - Which module gets compiled first? Why?
    - Inspect the target folders, what do you notice?
    - Inspect the generated jars.
- You're free to experiment, make changes, extend,... the code
