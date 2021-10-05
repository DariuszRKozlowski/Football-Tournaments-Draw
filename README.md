# Football-Tournaments-Draw
Project of the most popular football tournaments draw simulations as GUI application. 

## Table of contents
* [Introduction](#introduction)
* [Project details](#project-details)
* [Technologies](#technologies)
* [Setup](#setup)
* [Sources](#sources)
* [Screenshots](#screenshots)

## Introduction
Football-Tournaments-Draw is the project which allows to every football fan to simulate best football competitions groups draw.
Draws logic takes into account all procedures of every single draw (e.g. political conflicts) which makes results possible in reality.
Thanks to simple GUI application, results of draw are visible on the user screen.

## Project details
Project contains 3 main layers:
* Data - creates connection between application and database thanks to JDBC & Data Access Objects,
* Application - allows to create complete domain objects from queries results,
* Presentation - uses application layer objects to perform results on the screen.

Displaying informations about tournaments procedures are read from specific text files. Other details are directly (e.g. names, countries)
or indirectly (logos by paths) taken from database.

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
All clubs & tournaments logos and countries flags comes from [Flashscore.com](https://www.flashscore.com/).

## Screenshots

| ![](https://github.com/DariuszRKozlowski/images/blob/main/x11.PNG) |
|:--:|
| <b>Main menu</b>|

| ![](https://github.com/DariuszRKozlowski/images/blob/main/x12.PNG) |
|:--:|
| <b>Tournament draw start window</b>|

| ![](https://github.com/DariuszRKozlowski/images/blob/main/x13.PNG) |
|:--:|
| <b>Draw result</b>|
