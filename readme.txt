Title
-----
Stock Market Portfolio

Summary
-------
This project comprises an application that permits users to obtain stock quotes for a stock symbol. The functionality will permit entering a stock market symbol in a search field, and the latest stock price and other information will be displayed for that stock. Note that the quote value will be delayed by 20 minutes as we will be using free services which contain an intentional latency.

Project team members are Alan Derrick and Peter Martin.

GUI
---
JSP pages will be employed for displaying program output. The J2EE environment needed to support this will be supplied using the Tomcat application server.

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
Stocks added to the users favorites list will be stored for retrieval in future sessions. The current design implements this with flat files but this may change.
