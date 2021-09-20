# Self evaluation 1 

This self evaluation is created for the purpose of self reflection and to match your current level 
of programming against our expectations. 

You will have 2 dedicated days to complete it. 
Should that not be enough, we expect you to finish it after-hours / over the weekend.

This self evaluation is in no means a 'classic' test in which the received grades are the most important aspect.
Therefore, the self evaluation will not be graded in a numerical way. However, you will receive extensive feedback 
on your solutions which you should review in-depth!

You should be able to correctly complete the theoretical questions and the codelabs, 
although some looking-up and tinkering might be necessary. 

It is our expectation that you should understand most of the questions and should be able to solve all the codelabs.
Should you feel like you're struggling heavily with every codelab, make sure to address this. We will be more than happy 
to see how - and help you - to get you back on track as soon as possible!

**The process is more important than the goal**, don't simply copy/paste (theoretical) answers or solutions from the internet. 
Make sure you truly understand what you're doing! Try to work as autonomous as possible.

## Theoretical questions

Do always (try to) come-up and formulate an answer first, 
only then search for additional information, should you be unsure of your answer, to improve your knowledge.

Answer the questions inline, like the example below:

1. **If this is the question**
    - Then this should be your answer (don't forget to tab and prefix with `-` or `*`)

In **this file**, please replace every :x: with a check mark :heavy_check_mark: `:heavy_check_mark:` when you have created a solution for it.
Please do this after each finished codelab. It will help us in keeping track of your progress.

### Questions Basic
1. [:heavy_check_mark:] **What kind of types are there in Java?**
   - primitive (numerical, char, boolean) and reference types
2. [:heavy_check_mark:] **What does 'declaring and initializing a variable' mean?**
   - creating a new variable and assigning a value to it. You declare the type of the variable, then give a name for it,
   and you assign the value which could be whatever as long as the type fits.
3. [:heavy_check_mark:] **What is a statement? What is an expression? What is an operator?**
   - a statement is (a) line(s) of code ending in a semi-colon. 
   - an expression is ... a smaller part of a statement that returns a value.
   - an operator is a character or combination of characters that have meaning to the compiler and that allow you to
   'perform operations' on variables and primitive values. Assigning a value, conditional statements, calculations, ... 
   all rely on operands/operators.
4. [:heavy_check_mark:] **What is `casting`? E.g. "I'm casting the value to an `int`"**
   - changing the type of a value / variable. This is safe when upcasting (going from a type that holds less information
   to one that holds more information), but the opposite, downcasting can be dangerous for losing data and unpredictable.
5. [:heavy_check_mark:] **What is the signature of a method?**
   - The name of the method paired with the parameters' types and exact amount.
6. [:heavy_check_mark:] **What is method overloading?**
   - creating a method with the same name, but different parameters. The JRE will know what method to use based on the
   arguments given.
7. [:heavy_check_mark:] **What is method overriding (OOP)?**
   - creating a method in a subclass with the same signature as a method in its parent class. When called on an object
   of the subclass, the parent method will be 'hidden' for the JRE.
8. [:heavy_check_mark:] **What is meant with "arguments are passed-by-value"?**
   - for primitive types, the value of the argument is passed as a copy to a methods parameter. All operations done 
   on the parameter within the method have no consequences outside of the method. For reference types, the reference to
   the object in memory is copied to the parameter, so operations on that reference variable will have consequences for 
   the object, e.g. changing its state.
9. [:heavy_check_mark:] **Of what types can we create an array?**
   - All of 'em.
10. [:heavy_check_mark:] **Can the size of an array change after instantiation?**
    - No.
11. [:heavy_check_mark:] **What is the main difference (in use-case, not structure) of an If/Else statement and a Switch statement?**
    - If/else needs a boolean expression for its logic while switch looks at possible values (cases) of a variable. You
    can't switch on a boolean expression.
12. [:heavy_check_mark:] **What is the main difference between primitive data types and reference types in Java?**
    - primitive data types hold their values within, while reference types only hold the reference to an object in
    memory.
13. [:heavy_check_mark:] **What is the main difference between a While and Do-While loop (in execution, not structure)?**
    - if the boolean expression of a while loop is not met then the code within will not be executed, while the code in 
    a do-while loop is always executed once.
14. [:heavy_check_mark:] **What is the main difference between a For and Foreach loop (in use-case, not structure)?**
    - A regular for-loop lets you take advantage of the index variable. Especially when working with Arrays this comes
    in handy. The for-each is better when you want to do the same thing to/with every object or value in a collection or 
    Array.
15. [:heavy_check_mark:] **A variable declared within the opening and closing parenthesis of a method is called a ____ variable?**
    - Parameter
16. [:heavy_check_mark:] **Why would you choose `long` over `int`?**
    - when 32 bits won't be enough to hold the possible value range, you'll want to use long (64 bits) so you don't lose
    data/ have bugs. Because once it goes over the max value an int can hold (or any numerical type), it will restart at
    its lowest possible value and keep counting up from there.
17. [:heavy_check_mark:] **What's the difference between `long` and `float`?**
    - long is 64 bit, I believe float is 32. But the bigger difference is that float can have floating point numerical
    values, while long can only hold whole numbers (very big ones though).
18. [:heavy_check_mark:] **What value (`1/2` or `0.5` or `0`) will be printed for the following code? `System.out.println(1/2);`? Explain why?**
    - 0.5 : the integers are automatically cast to a double.
19. [:heavy_check_mark:] **What is the difference between `.java` and `.class` files?**
    - .java files are the files written and read by programmers. The compiler turns these into .class files, which can 
    the JVM can understand. Compiling is translating high level code to machine level code.
20. [:heavy_check_mark:] **What is the output of following code?**
    - "It is true""It is false" (second part on a new line)
```java
boolean isTrue = true;
if(isTrue != false){
    System.out.println("It is true");
}
System.out.println("It is false");
```

### Questions OOP
1. [:heavy_check_mark:] **The term "instance variable" is another name for ___ ? And, what is it exactly?**
   - object variable. It's part of the state of an object.
2. [:heavy_check_mark:] **The term "class variable" is another name for ___ ?**
   - static variable. It's part of the state of a class of objects.
3. [:heavy_check_mark:] **What are parameters?**
   - input variables for a method.
4. [:heavy_check_mark:] **What are arguments?**
   - values or variables given to the method call.
5. [:heavy_check_mark:] **What is the return type void?**
   - void indicates a method will not return any value or object.
6. [:heavy_check_mark:] **What's an object? What's a class?**
   - An object is an instantiation of a class. A class is a blueprint for the creation of an object of that class.
7. [:heavy_check_mark:] **What's state? What's behavior?**
   - The state of an object are the combined values of its instance variables => the state of an object.
   An object's behavior are the methods/functions the object provides.
8. [:heavy_check_mark:] **What is an instance?**
   - An instance of a class is a single object in memory of that class. Every call on the constructor of a class returns
   a new instance of that class.
9. [:heavy_check_mark:] **How do we create an object from a class?**
   - calling the constructor of that class.
10. [:heavy_check_mark:] **What is the value `null`? What types can hold `null`?**
    - the absence of an object. Only reference types can hold null. A variable of a reference type can point to nothing 
    at all. Then its value will be null. 
11. [:heavy_check_mark:] **What is an object reference?**
    - a description of the location of an object in memory.
12. [:heavy_check_mark:] **What is data encapsulation? What role do the access modifiers play in it? Provide all access modifiers.**
    - ensuring that outside classes can't reach the state of an object directly. Access modifiers describe which classes
    in your project structure can reach this state directly. From more to less restrictive: private, protected, package 
    and public.
13. [:heavy_check_mark:] **What is a constructor?**
    - a method in a class that returns an instance of that class via the 'new' keyword.
14. [:heavy_check_mark:] **What is the default constructor?**
    - In absence of an explicit constructor, Java will provide a default constructor without parameters.
15. [:heavy_check_mark:] **What is a package? Why do we use them?**
    - a folder containing classes, other packages. We use them to structure our code base.
16. [:heavy_check_mark:] **What is an enum and when should you use one?**
    - an enum is a class which holds a set of constants. We use them to represent naturally finite data set, e.g. days in a week.
17. [:heavy_check_mark:] **What's the difference between a static method and an instance method?**
    - you can call a static method directly on the class name; you don't need an object of that class. Instance methods 
    can only be called on an instance/ object of a class.
18. [:heavy_check_mark:] **What is a constant?**
    - a variable inside a class that is static and final. It's value can never be altered after initialization.
19. [:heavy_check_mark:] **What is inheritance? Why is it useful? Give an example.**
    - A parent-child (super-sub) relationship between classes. The subclass inherits all state and behavior of its super 
    class. It's useful when they are essentially related: the subclass 'is a' superclass. Through the inheritance we avoid 
    a lot of code duplication and because of polymorphism we can have a reference type of the superclass point to an 
    object type of the subclass. This allows us to collect different subtypes into a collection of the common super type.
    Example: a XC-40 is a Volvo, a Volvo is a Car, a Car is a Vehicle.
20. [:heavy_check_mark:] **What is composition? Why is it useful? Give an example.**
    - having an object as part of the state of another class. This is useful when there is an ownership relationship
    between two classes. Example: a car has an engine, a car has seats,...
21. [:heavy_check_mark:] **What is polymorphism? Why is it useful? Give an example.**
    - You can approach any object as if it's an object of its superclass or implemented interface. It has many uses
      (loose coupling of objects is one). The main idea is that if a class only cares about certain aspects and behavior
    of another class to do something with it, you should parameterize the reference type of that common superclass/interface.
    Thus, you can pass any object type that extends or implements that class. Example: A driver has a car that 
    it can drive. The car is driveable. The driver does not care which car he has to drive, as long as it's a driveable 
    car he'll be happy.
22. [:heavy_check_mark:] **What is meant with the sentence 'Class A extends / inherits from Class B'?**
    - class B is the super class of class A. A will inherit all state and behavior of class B.
23. [:heavy_check_mark:] **What is the difference between a (parent) class and an (abstract) parent class?**
    - abstract classes can't be instantiated. All classes can be inherited from. Abstract classes can have abstract 
    methods, which have no implementation. All subclasses must provide an implementation for all abstract methods defined
    in the abstract parent class.
24. [:heavy_check_mark:] **What's the difference between an abstract class and an interface?**
    - while both can define abstract methods and can't be instantiated, an interface is more of a contract. Assuring the 
    implementing class provides certain functionality. A class can implement multiple interfaces and can extend only one 
    other (abstract) class. Classes implementing the same interface are not naturally related to one another. They just 
    provide the same methods/behavior (though implementations can vary infinitely).
25. [:heavy_check_mark:] **What is meant with the sentence 'Class A implements (interface) A'?**
    - Class A provides an implementation for all behavior described by interface A. Class A can do anything that is
    expected through the contract provided as interface A.
26. [:heavy_check_mark:] **How does an object gets 'destroyed' and thrown out of the memory?**
    - The garbage collector of the JRE is in charge of collecting all data objects that will not be used again. At the 
    end of a code block all local variables will be ready for garbage collection. Objects are ready for garbage collection 
    once the program will not reference them again. The JRE will garbage collect whenever it sees fit.
27. [:heavy_check_mark:] **What is the `Object` class?**
    - the super class all other classes inherit from.
28. [:heavy_check_mark:] **To invert the value of a boolean, which operator would you use?**
    - '!boolean'
29. [:heavy_check_mark:] **What is casting? explain widening/upcast and narrowing/downcast.**
    - changing the reference type of an object. upcast is going from a more specific (sub) type to a less specific (super)
    type. Downcasting is the opposite, which is dangerous because you could try to jam an object into the wrong sub type,
    resulting in typeCast exceptions. 
30. [:heavy_check_mark:] **What does the `final` keyword do?**
    - declaring a variable or class to be immutable/unchangable after instatiation/ initialization.
31. [:heavy_check_mark:] **What is the difference between `==` and `equals`?**
    - for reference types, '==' will check if both variables point to the same object in memory, while 'a.equals(b)' 
    will call the equals method (provided by the Object class, preferably overridden because otherwise it will do the 
    same as '==' and as a programmer you want to define in which case two objects, though they are separate instances, 
    are equal to one another).

## Hands-on

For every codelab, a package `codelab{n}` has been created.
It's your starting location for implementing the assignment.

The assignments themselves are written down in this file, in the following sections. 

Sometimes, tests have been written to validate your solution. Use (run) them.  

### Codelab 01
1. [:heavy_check_mark:] Create a method that prints the string "Hello World!"
2. [:heavy_check_mark:] Create a method (`printAny`) that prints any string you give it.
3. [:heavy_check_mark:] Using method overloading, create two methods with the same name (`printNumber`).
    - Both have one parameter.
    - Both should print a message, although the message differs based on the type (int or double):  
        - `I'm an int: {parameter}` in case of the actual argument being of type `int`.
        - `I'm a double: {parameter}` in case of the actual argument being of type `double`.
4. [:heavy_check_mark::x:] Create a method that returns the number it receives plus 1
    - E.g. 4 is provided as an argument, then value 5 is returned

### Codelab 02
1. [:heavy_check_mark:] Create a method that returns an array with all the letters of the alphabet.
    - Check the test to see what is required exactly.
        - E.g. is it required to include both lower and upper-casing characters?
    - Run the tests (before and after having implemented your solution) 
2. [:heavy_check_mark:] Create a method that replaces the 3th element of a String[] array by "do".
    - Run the tests (before and after having implemented your solution) 
    - Think about edge cases: empty array, null,... 
        - Test scenario's:
          - `["we", "can", "work", "it"]` --> `["we", "can", "do", "it"]`
          - `["you", "should", "work", "it"]` --> `["you", "should", "do", "it"]`


### Codelab 03
1. [:heavy_check_mark:] Create a method that generates a 2D pattern (as a 2D array) based on a provided size (parameter).
2. [:heavy_check_mark:] Call the method and loop over the 2D array to print its contents to the console.
3. [:heavy_check_mark:] Based on the examples below, the pattern should be clear.
4. [:heavy_check_mark:] Run the tests (before and after having implemented your solution)

Some examples (size = 2), printed to the console
```
@@
@@
```

Some examples (size = 3), printed to the console
``` 
@@@
@ @
@@@
```
 
Some examples (size = 4), printed to the console
```    
@@@@
@  @
@  @
@@@@
```

Some examples (size = 5), printed to the console
```    
@@@@@
@   @
@   @
@   @
@@@@@
```

### Codelab 04
1. [:heavy_check_mark:] Create a method that returns the month in English by its number.
    - Run the tests (before and after having implemented your solution.
        - The tests will also show what the exact requirements are!
2. [:heavy_check_mark:] Create a method that takes in a number of elements and calculates a price based on the following rules:
    - The first 10 elements costs 5 euro each.
    - The following 5 elements costs 4 euro each.
    - Every next element costs 3 euro each.
    - A negative amount of elements will return 0
    - Run the tests (before and after having implemented your solution
        - Test scenario's:
                - amountOfItems == 1, then price == 5
                - amountOfItems == 0, then price == 0
                - amountOfItems == 9, then price == 45
                - amountOfItems == 10, then price == 50
                - amountOfItems == 11, then price == 54
                - amountOfItems == 15, then price == 70
                - amountOfItems == 16, then price == 73
                - amountOfItems == 20, then price == 85
                - amountOfItems == -1, then price == 0
3. [:heavy_check_mark:] Create a method that returns the following:
    - When the input is 1: "It's something"
    - When the input is 2: "That's more like it"
    - When the input is 3: "Way to go"
    - Other input: "That's a fail whale"
    - Run the tests (before and after having implemented your solution   

### Codelab 05

1. [:heavy_check_mark:] Create an `Alarm`.
2. [:heavy_check_mark:] Make sure we can use a no-arg constructor and an single argument (the sound to make) constructor. By default, 
the sound to make is "BEEP". 
3. [:heavy_check_mark:] The `makeSound` method(s) should return an array containing x-times the sound to make.
    - We should be able to provide x, although it should not be required.
    - If x is not provided, the returned value should contain the 'sound to make' 3 times.
        - 3 is the default amount of times to make a sound.

### Codelab 06

We're going to program a (French) deck of cards.

French decks come in a variety of patterns and deck sizes. We're going for the most popular 52-card deck. 
It includes 13 ranks of each suit. There are four suits: hearts, spades, diamonds and clubs. 
Each suit includes an ace, a king, queen, and jack, and numbers two through ten. 

Commercial packs often include between one and six jokers, most often two. 
But we will not include them in our solution!

1. [:heavy_check_mark:] Create a class that represents a single playing card.
2. [:heavy_check_mark:] Create a class that represents a deck of (52) cards.
    - After creating a deck of cards object, it should hold 52 cards.
    - However, it should also be possible to create a deck of cards object for which 
    we provided (as an argument) the cards (possible not 52 cards).
    - It should be possible to check whether a certain card (argument) is part of the deck of cards.
    - It should be possible to get a textual representation of the entire deck of cards.
3. [:heavy_check_mark:] Write a small executable program in which you create a deck of cards and check whether a certain card is part of it. 

### Codelab 07

- [:heavy_check_mark:] Write a `Dog`, `Labrador` and `Chihuahua` class.
- [:heavy_check_mark:] All dogs have a name and can bark
    - The actual barking sound is specific to the breed of dog.
        - A labrador has as its barking sound value "WOOF WOOF!"
        - A chihuahua has as its barking sound value "Kefkefkef!"
    - The name is specific to the actual instance of a dog.
- [:heavy_check_mark:] All dogs also have an average breed weight
    - The actual value for the average breed weight is specific to the breed of dog.
        - A labrador has as its average breed weight, value 35 (Kg).
        - A chihuahua has as its average breed weight, value 2 (Kg).
    - We should be able to let every dog bark
    - We should be able to **get** the average breed weight for every dog
    - (It should not be possible to create instances of `Dog` itself)

- [:heavy_check_mark:] Chihuahuas also have a color field, it can be either Brown, Black or White.
- [:heavy_check_mark:] Override the `toString` method, it should contain the entire state of every dog.
    - For a labrador: "Labrador: (name = Labby, sound = WOOF WOOF!, average breed weight = 35)"
    - For a chihuahua: "Chihuahua: (name = Darling, sound = Kefkefkef!!, average breed weight = 2, color = Brown)"
- [:heavy_check_mark:] Override the `equals` method: two dogs are equal if they have the same name and make the same sound.

### Codelab 08

- [:heavy_check_mark:] All birds have a beak size, it can be small, medium or large. Furthermore, it should be possible to **get** this beak size.
    - Eagle is a specific type of bird, an eagle has a large beak size.
    - Pigeon is a specific type of bird, a pigeon has a medium beak size.
    - Dodo is a specific type of bird, a dodo has a large beak size.
    - (any future new specific types of bird will also have a beak size)
    - (creating an instance of a (non-specific) bird should not be possible)

- [:heavy_check_mark:] Most birds can **fly**, but not all! Eagle and Pigeon can fly, a Dodo can not.
    - When we let an eagle fly, it should return textual value "I'm soaring through the sky!"
    - When we let a pigeon fly, it should return textual value "Flap flap... oeh, look, breadcrumbs!"
    - It should be impossible to let a dodo fly (they're fly-less birds!)

- [:heavy_check_mark:] For all the specific birds that can fly (eagle and pigeon), we should also be able to get the maximum altitude it can fly.
    - The maximum altitude is specific to a single instance (so 2 eagle birds can have a different maximum altitude). However, 
    there is a range per bird type.
        - Eagles should have a maximum altitude between 4.000 and 5.000 meters (both including). 
        - Pigeons should have a maximum altitude between 500 and 750 meters (both including).
        - Dodo's do not have the concept of a maximum altitude (as they don't fly...) 

- [:heavy_check_mark:] Finally, create a `Sky` class. It should have a class - not instance - method 
that accepts (as an argument) an array of birds that can fly (only!).
    - Let this method loop over the array and let it call, each bird's fly method.
    - Each time, print the value returned by the fly method to the console.

### Codelab 09

Let's design - in code - a Laptop.

- [:heavy_check_mark:] Our `Laptop` class consists of a screen, a storage device, RAM, a processor and peripheral devices (keyboard, mouse,...)
    - Make sure that each of these components are represented by some obvious state and have some useful behavior.

- [:heavy_check_mark:] A screen can be either an LCD screen or LED screen (and in the future, who knows what else...)
    - Possible state: resolution, color, brightness,...
    - Possible behavior: dim (brightness),...

- [:heavy_check_mark:] A storage device can be either HDD or SSD (and in the future, who knows what else...)
    - Possible state: speed, size,...
    - Possible behavior: storeData,...

- [:heavy_check_mark:] A processor can have 3 different modes: energy-saving, normal and overclocked. 
    - It should be possible to let a processor switch from its mode (during runtime)
        - E.g. from energy-saving to normal
    - Possible behavior: processInstructions,...

- [:heavy_check_mark:] It should be possible to **get** both the active and idle energy consumption of all screens, storage devices and processors.
    - Energy consumption can be written in kilowatt hour (kWh).

- [:heavy_check_mark:] keyboard and mouse are both peripheral devices. A laptop can have up to 5 peripheral devices.
    - All peripheral devices should have a method to use them. But based on the specific peripheral, using it means something else.

- [:x:] Finally, create an instance from `Laptop` and interact with it (maybe also print it to the console?).

Think about your design (simply think about these questions):
- When and where do we need (or can use) inheritance?
- When and where do we need (or can use) abstraction?
- When and where do we need (or can use) composition?
- When and where do we need (or can use) interfaces?
- When and where do we need to create additional concepts (classes, enums,...)
    - E.g. is resolution a concept which we can or should create?
    
## Finished? 
1. Ask feedback on your solutions
2. Review the solutions from the `solutions` branch
3. Complete all uncompleted codelabs from modules `10-basics` and `20-oop`.
4. Start / continue with Rowdy Racers
