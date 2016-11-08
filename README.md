# Darwin
A collection of APIs specifically regarding plugin development to help you along.  
These are personally used by me, and I needed a new project to work on.
##Ground Rules
There are just some ground rules that I would like to mention. Mainly it is about the styling of the code
There are just a couple rules that I follow mainly relating to the naming of variables:
 - The player object unless there are more than one, must be called `player`
 - The event object must be called `event`  
 - The main class of each packages will always be called `[PACKAGE]Main`
  
##The Way This Works
The API is split up into different sections, each containing sub classes with all the methods you may need,  
Instead of accessing the classes individually (be my guest) you access the main class which then directs you to the separate ones.
