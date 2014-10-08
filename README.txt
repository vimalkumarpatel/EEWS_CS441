**Copy this folder to C:\ in windows machine**

Design documents and SRS are present in docs folder.
----------------------------------------------------------------------
There are three projects in respective folders:
EEWS_drools [Backend]
EEWS_weatherWebApp [Generates random weather data for different regions]
EEWS_Website [Frontend]

Please refer to docs\Setup Tools and Database to setup any tools and ide.

There will be errors in projects EEWS_weatherWebApp and EEWS_Website, please install new server and select Apache Tomcat v7.0 server
and for the installation directory, select C:\FinalProject\tomcat

If after the step above, errors exist in EEWS_Website, please add the external library servlet-api.jar
located in C:\FinalProject\tomcat\lib

For any errors in JRE, select default (JRE 1.7 recommended)
Run MySQL5 and MongoDB

[1]database\rdbms\dump.sql -> MySQL dump to be loaded before execution
[2]C:\FinalProject\EEWS_drools\src\main\java\cs441\eews\MySQLUtils.java
	-> set mysql connection parameters in the constructor
[3]C:\FinalProject\EEWS_drools\src\main\java\cs441\eews\NoSQLUtils.java
	-> set mongodb connection parameters in constructor
[4]Resolve any conflicts in libraries with those provided in library folder
[5]Testing file in testing folder

Run in the projects in the following order:
EEWS_weatherWebApp, EEWS_drools_original, EEWS_website

NOTE: Since there are more than 500,000 entries in many tables the DROOLS may take up considerable amount of time to complete the  calculations.
please try running the project for at least 20 mins.

