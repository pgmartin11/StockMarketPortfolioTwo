Title
-----
Stock Market PortfolioTwo

Summary
-------
This project comprises an application that permits users to obtain stock quotes for a stock 
symbol. The functionality will permit entering a stock market symbol in a search field, and 
the latest stock price and other information will be displayed for that stock. Note that the 
quote value will be delayed by 20 minutes as we will be using free services which contain an 
intentional latency.

Peter Martin is the sole contributor on this project.

GUI
---
JSP pages will be employed for displaying program output. The J2EE environment needed to 
support this will be supplied using the Tomcat application server.

Business Logic
--------------
The application will contain the following features and functionality:

o authenticated login based on supplied username and password
o stock quote search based on stock symbol entered
o ability to add frequently searched stock to list of favorites
o deletion of stock symbols from list of favorites
o refresh quote for stock symbol currently selected
o configure information presented in stock quote display

Persistence
-----------
Stocks added to the users favorites list will be stored for retrieval in future sessions. 
The current design implements this with flat files but this may change.


Notes
-----
The methods within the persistence and business logic classes implementall the features described 
in this project proposal. 

The presentation layer is incomplete but contains the JSPs listed below and associated servlets 
which demonstrate how the persistence and business logic methods are used:

	web/main.jsp
	web/login.jsp
	web/allquotes.jsp

The web application WAR file included is configured for the Tomcat servlet container. After 
the WAR is deployed any of the above JSPs can be referenced as 
http://localhost:8080/StockMarketPortfolioTwo/<JSP name> e.g.

		http://localhost:8080/StockMarketPortfolioTwo/main.jsp

Below is a description of relevant ant tasks:

- run jUnit tests

  $ ant test

- run jUnit with emma coverage (results placed in ./build/coverage/coverage.html)

  $ ant with.emma test

- create the WAR file

  $ ant war

- deploy the application to a local Tomcat installation

  $ ant deploy


Exclusions from Unit Testing
----------------------------
edu.uml.project90308.businesslogic.Authenticate

	-processLogout	Because this method takes an HttpSession object as its argument it can 
					only be executed within a java servlet
										
edu.uml.project90308.businesslogic.StockQuote
 			
	-getQuote		Both methods communicate with Yahoo stock service and the return results
	-getQuotes		change over time
