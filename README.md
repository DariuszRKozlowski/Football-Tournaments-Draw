# Football-Tournaments-Draw
Project of the most popular football tournaments draw simulations with GUI application. 

## Table of contents
* [Introduction](#introduction)
* [Technologies](#technologies)
* [Setup](#setup)
* [Sources](#sources)
* [Screenshots](#screenshots)


## Introduction
Football-Tournaments-Draw is the Maven project made for better communication between user and database. Project is dividing into data, application and presentation layers. 
Thanks to JDBC interface and Data Access Objects program is connecting with database by specific queries. Application layer allows to create suitable
objects from received data. Presentation layer classes display results on screen.

## Technologies
To create this project is used:
* Maven,
* Java 16,
* JDBC interface,
* SQL,
* Swing library.

## Setup
For communication between Java application and database is necessary to install JDBC driver dedicated to database server. In this case [JDBC for SQL Server](https://docs.microsoft.com/en-us/sql/connect/jdbc/download-microsoft-jdbc-driver-for-sql-server?view=sql-server-ver15) is used.

To create the right database of tournaments, clubs and countries follow: [SQL script](https://github.com/DariuszRKozlowski/Football-Tournaments-Draw/blob/master/src/main/resources/sql-script/SQL-script.sql).

For successfully connection between application and database is necessary to configure `database.properties` file by own data about database path, username and password.

## Sources
All clubs & tournaments logos and countries flags comes from [Flashscore.com](https://www.flashscore.com/)

## Screenshots

| ![]() |
|:--:|
| <b>Main menu</b>|

| ![](https://github.com/DariuszRKozlowski/images/blob/main/x12.PNG) |
|:--:|
| <b>Tournament draw start window</b>|

| ![](https://github.com/DariuszRKozlowski/images/blob/main/x13.PNG) |
|:--:|
| <b>Draw result</b>|
