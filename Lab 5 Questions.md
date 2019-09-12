# Lab 5 - HashMaps

### Question 1 Paint Colors

HashMap practice. 

Follow the instructions to add a new key-value pair to the HashMap.  
Finish the method to get the value for a key.  
Finish the method that counts the number of values with a specific value.


### Question 2 Lake Quality

In Minnesota, we have many lakes. The Minnesota Pollution Control Agency monitors water quality in lakes, as part of monitoring Minnesota's environment.

One of the measures of lake quality is clarity - how far can you see down into the water?
(If you are interested, more info https://www.pca.state.mn.us/water/what-water-clarity-tells-us
and https://www.minneapolisparks.org/park_care__improvements/water_resources/lake_water_resources/)

Clarity is measured in distance.  A higher distance usually means better water quality.

For swimming, going to the beach etc... it's better to have higher water quality.
A common recommendation is at least 4 feet or more, for swimming and other water recreation.

Finish this program to add and edit lake clarity measurements, and to search for lakes that have the recommended water clarity for swimming.


### Question 3 Country Codes

First: Create a HashMap of country codes and country names.

The 2-letter country codes will be keys
The country names will be values.
 
The array countryCodes and countryNames contain (most) of the codes and names for all the countries in the world. The data is a little old and may be missing some countries or have older names for some countries - please let me know if you see any out-of-date data so I can update.  

The first element in countryCodes (AF) is the code for the first element in countryNames (Afghanistan).  
The second element in countryCodes (AL) is the code for the second element in countryNames (Aland Islands).
 
Use a loop to add the data to a HashMap.
 
Next: Finish the method that searches for a country name for a country code.  
This method will search your new HashMap. If the user enters a valid country code, the method will return the country name for that code.  
If the user enters a code that is not found in the HashMap (is not one of the HashMap keys) your method should return the EXACT String "Code not found" 
 

### Question 4 Camping Reservations 

This program contains an example set of data about individual campsites for one day at a campground.  
People who want to stay at a campsite can make reservations. 
This program will search the campsite data and return a list of sites that match a user's search criteria, 
and are available.   

In this program, the user will enter information about the type of campsite they want, and 
your program will search for matching campsites, and return a list of campsites that are available. 

Each campsite has a unique number 
Each campsite has a type ("RV" or "TENT")  
Campsites may or may not have water at the site, stored under a "has_water" key with a value of "YES" or "NO"  
Campsites can be reserved, stored in a reserved key with a value of "RESERVED" or "AVAILABLE"  

Finish the getMatchingSites method.  
Search the siteInfo Map (the global variable) and return a List of campsites that match 
the search criteria AND are available.
  
  - For example, if the user wants an RV campsite and wants water, then campsite 1 and 2 and 8 and 10 match,
  but only 2 and 8 and 10 are available. Return a list of [2, 8, 10]
  
  - For example, if the user wants a TENT campsite and does not want water, then campsites 4, 5, 6 match,
  but only 4 and 5 are available. Return a list [4, 5]
  
  - For example, if the user wants a TENT campsite and does want water, then site 3 matches,
  but it is reserved. Return an empty list []


### Question 5 T-Shirt Sales Records

A t-shirt vendor works at week-long events.  Each event runs for 5 days, from Monday to Friday.

The vendor needs to store data about every event. For each event, they need to save the

 - Name of the event
 - Number of t-shirts sold on Monday at that event
 - Number of t-shirts sold on Tuesday at that event
 - Number of t-shirts sold on Wednesday at that event
 - Number of t-shirts sold on Thursday at that event
 - Number of t-shirts sold on Friday at that event

The vendor never works on Saturday or Sunday.

You may not know all of the data about an event when it
is created in the data store, but you will know the name and at least one day of sales.

Complete this program to gather, and analyse data, about t-shirt sales.
You'll need to decide what data structure to use to store the data.  
*Hint*: your data structure may need to contain other data structures. 

Your data structure should support these tasks:
 - Add a new event and sales for a day
 - Add another day sales for an existing event
 - Return an array of 5 days of sales for one event
 - Check if an event exists in the data structure
 - Calculate if a day of sales is above average for the week of sales

Use the exact strings "Monday", "Tuesday", "Wednesday", "Thursday" and "Friday"
to add and search for data in your data structure.  
Optional: you can add helper methods to validate and make user input easier.

Notes: 
- One of the tests will always fail. Part of your grade will be from human review of your code,
the data structure you choose, and how you implement the required methods.
- The tests don't know what data structure you will use so it's harder to check if your code is working. The 
way several tests work is by calling your addSalesForDay method to add example data, and then call your other 
method in sequence and checking that the expected data is returned.
- **So, almost all of the tests will fail until you create your data structure, and finish the addSalesForDay method.**  
