CREATE DATABASE FootballTeams;

USE FootballTeams;

CREATE TABLE ChampionsLeagueTeams (
	id int IDENTITY(1,1) PRIMARY KEY,
	name varchar(35) NOT NULL,
	country varchar(35) NOT NULL,
	uefa_coefficient int NOT NULL,
	is_country_champion bit NOT NULL,
	is_previous_winner bit NOT NULL,
	logo image
);

CREATE TABLE EuropaLeagueTeams (
	id int IDENTITY(1,1) PRIMARY KEY,
	name varchar(35) NOT NULL,
	country varchar(35) NOT NULL,
	uefa_coefficient int NOT NULL,
	logo image
);

CREATE TABLE ConferenceLeagueTeams (
	id int IDENTITY(1,1) PRIMARY KEY,
	name varchar(35) NOT NULL,
	country varchar(35) NOT NULL,
	uefa_coefficient int NOT NULL,
	logo image
);

CREATE TABLE EuropeanChampionshipTeams (
	id int IDENTITY(1,1) PRIMARY KEY,
	country varchar(35) NOT NULL,
	uefa_coefficient int NOT NULL,
	is_host_country bit NOT NULL,
	logo image
);

CREATE TABLE Federations (
	id int IDENTITY(1,1) PRIMARY KEY,
	federation_name varchar(35) NOT NULL
);

CREATE TABLE WorldCupTeams (
	id int IDENTITY(1,1) PRIMARY KEY,
	country varchar(35) NOT NULL,
	federation int FOREIGN KEY REFERENCES Federations(id),
	fifa_rank int NOT NULL,
	is_host_country bit NOT NULL,
	logo image
);

CREATE TABLE Countries 
(
	id int IDENTITY(1,1) PRIMARY KEY,
	country_name varchar(35) NOT NULL
);

INSERT INTO Countries VALUES
('Netherlands'),
('Italy'),
('Spain'),
('Germany'),
('Portugal'),
('Turkey'),
('Belgium'),
('England'),
('Ukraine'),
('France'),
('Sweden'),
('Austria'),
('Moldova'),
('Switzerland'),
('Russia');

INSERT INTO Federations VALUES
('AFC'),
('CAF'),
('CONCACAF'),
('CONMBEOL'),
('OFC'),
('UEFA');

INSERT INTO WorldCupTeams VALUES
('Russia', (SELECT id FROM Federations WHERE federation_name = 'UEFA'), 65, 1, 'src\\main\\resources\\img\\FIFA World Cup 2018\\Russia.png'),
('Brazil', (SELECT id FROM Federations WHERE federation_name = 'CONMEBOL'), 2, 0, 'src\\main\\resources\\img\\FIFA World Cup 2018\\Brazil.png'),
('Belgium', (SELECT id FROM Federations WHERE federation_name = 'UEFA'), 5, 0, 'src\\main\\resources\\img\\FIFA World Cup 2018\\Belgium.png'),
('Argentina', (SELECT id FROM Federations WHERE federation_name = 'CONMEBOL'), 4, 0, 'src\\main\\resources\\img\\FIFA World Cup 2018\\Argentina.png'),
('France', (SELECT id FROM Federations WHERE federation_name = 'UEFA'), 7, 0, 'src\\main\\resources\\img\\FIFA World Cup 2018\\France.png'),
('Portugal', (SELECT id FROM Federations WHERE federation_name = 'UEFA'), 3, 0, 'src\\main\\resources\\img\\FIFA World Cup 2018\\Portugal.png'),
('Germany', (SELECT id FROM Federations WHERE federation_name = 'UEFA'), 1, 0, 'src\\main\\resources\\img\\FIFA World Cup 2018\\Germany.png'),
('Poland', (SELECT id FROM Federations WHERE federation_name = 'UEFA'), 6, 0, 'src\\main\\resources\\img\\FIFA World Cup 2018\\Poland.png'),
('Serbia', (SELECT id FROM Federations WHERE federation_name = 'UEFA'), 38, 0, 'src\\main\\resources\\img\\FIFA World Cup 2018\\Serbia.png'),
('Saudi Arabia', (SELECT id FROM Federations WHERE federation_name = 'AFC'), 63, 0, 'src\\main\\resources\\img\\FIFA World Cup 2018\\Serbia.png'),
('Panama', (SELECT id FROM Federations WHERE federation_name = 'CONCACAF'), 49, 0, 'src\\main\\resources\\img\\FIFA World Cup 2018\\Arabia.png'),
('Japan', (SELECT id FROM Federations WHERE federation_name = 'AFC'), 44, 0, 'src\\main\\resources\\img\\FIFA World Cup 2018\\Panama.png'),
('Morocco', (SELECT id FROM Federations WHERE federation_name = 'CAF'), 48, 0, 'src\\main\\resources\\img\\FIFA World Cup 2018\\Morocco.png'),
('South Korea', (SELECT id FROM Federations WHERE federation_name = 'AFC'), 62, 0, 'src\\main\\resources\\img\\FIFA World Cup 2018\\Korea.png'),
('Nigeria', (SELECT id FROM Federations WHERE federation_name = 'CAF'), 41, 0, 'src\\main\\resources\\img\\FIFA World Cup 2018\\Nigeria.png'),
('Australia', (SELECT id FROM Federations WHERE federation_name = 'AFC'), 43, 0, 'src\\main\\resources\\img\\FIFA World Cup 2018\\Australia.png'),
('Egypt', (SELECT id FROM Federations WHERE federation_name = 'CAF'), 30, 0, 'src\\main\\resources\\img\\FIFA World Cup 2018\\Egypt.png'),
('Costarica', (SELECT id FROM Federations WHERE federation_name = 'CONCACAF'), 22, 0, 'src\\main\\resources\\img\\FIFA World Cup 2018\\Costarica.png'),
('Denmark', (SELECT id FROM Federations WHERE federation_name = 'UEFA'), 19, 0, 'src\\main\\resources\\img\\FIFA World Cup 2018\\Denmark.png'),
('Iran', (SELECT id FROM Federations WHERE federation_name = 'AFC'), 34, 0, 'src\\main\\resources\\img\\FIFA World Cup 2018\\Iran.png'),
('Iceland', (SELECT id FROM Federations WHERE federation_name = 'UEFA'), 21, 0, 'src\\main\\resources\\img\\FIFA World Cup 2018\\Iceland.png'),
('Senegal', (SELECT id FROM Federations WHERE federation_name = 'CAF'), 32, 0, 'src\\main\\resources\\img\\FIFA World Cup 2018\\Senegal.png'),
('Sweden', (SELECT id FROM Federations WHERE federation_name = 'UEFA'), 25, 0, 'src\\main\\resources\\img\\FIFA World Cup 2018\\Sweden.png'),
('Tunisia', (SELECT id FROM Federations WHERE federation_name = 'CAF'), 28, 0, 'src\\main\\resources\\img\\FIFA World Cup 2018\\Tunisia.png'),
('Croatia', (SELECT id FROM Federations WHERE federation_name = 'UEFA'), 18, 0, 'src\\main\\resources\\img\\FIFA World Cup 2018\\Croatia.png'),
('Colombia', (SELECT id FROM Federations WHERE federation_name = 'CONMEBOL'), 13, 0, 'src\\main\\resources\\img\\FIFA World Cup 2018\\Colombia.png'),
('Peru', (SELECT id FROM Federations WHERE federation_name = 'CONMEBOL'), 10, 0, 'src\\main\\resources\\img\\FIFA World Cup 2018\\Peru.png'),
('Switzerland', (SELECT id FROM Federations WHERE federation_name = 'UEFA'), 11, 0, 'src\\main\\resources\\img\\FIFA World Cup 2018\\Switzerland.png'),
('Spain', (SELECT id FROM Federations WHERE federation_name = 'UEFA'), 8, 0, 'src\\main\\resources\\img\\FIFA World Cup 2018\\Spain.png'),
('England', (SELECT id FROM Federations WHERE federation_name = 'UEFA'), 12, 0, 'src\\main\\resources\\img\\FIFA World Cup 2018\\England.png'),
('Mexico', (SELECT id FROM Federations WHERE federation_name = 'CONCACAF'), 16, 0, 'src\\main\\resources\\img\\FIFA World Cup 2018\\Mexico.png'),
('Uruguay', (SELECT id FROM Federations WHERE federation_name = 'CONMEBOL'), 17, 0, 'src\\main\\resources\\img\\FIFA World Cup 2018\\Uruguay.png');

INSERT INTO EuropeanChampionshipTeams VALUES
('Albania', 23216, 0, 'src\\main\\resources\\img\\UEFA Euro 2020\\Albania.png'),
('Austria', 30932, 0, 'src\\main\\resources\\img\\UEFA Euro 2020\\Austria.png'),
('Belgium', 34442, 0, 'src\\main\\resources\\img\\UEFA Euro 2020\\Belgium.png'),
('Croatia', 30642, 0, 'src\\main\\resources\\img\\UEFA Euro 2020\\Croatia.png'),
('Czech Republic', 29403, 0, 'src\\main\\resources\\img\\UEFA Euro 2020\\Czech.png'),
('England', 35963, 0, 'src\\main\\resources\\img\\UEFA Euro 2020\\England.png'),
('France', 33599, 1, 'src\\main\\resources\\img\\UEFA Euro 2020\\France.png'),
('Germany', 40236, 0, 'src\\main\\resources\\img\\UEFA Euro 2020\\Germany.png'),
('Hungary', 27142, 0, 'src\\main\\resources\\img\\UEFA Euro 2020\\Hungary.png'),
('Iceland', 25388, 0, 'src\\main\\resources\\img\\UEFA Euro 2020\\Iceland.png'),
('Republic of Ireland', 26902, 0, 'src\\main\\resources\\img\\UEFA Euro 2020\\Ireland.png'),
('Italy', 34345, 0, 'src\\main\\resources\\img\\UEFA Euro 2020\\Italy.png'),
('Northern Ireland', 22961, 0, 'src\\main\\resources\\img\\UEFA Euro 2020\\NorthIreland.png'),
('Poland', 28306, 0, 'src\\main\\resources\\img\\UEFA Euro 2020\\Poland.png'),
('Portugal', 35138, 0, 'src\\main\\resources\\img\\UEFA Euro 2020\\Portugal.png'),
('Romania', 28038, 0, 'src\\main\\resources\\img\\UEFA Euro 2020\\Romania.png'),
('Russia', 31345, 0, 'src\\main\\resources\\img\\UEFA Euro 2020\\Russia.png'),
('Slovakia', 27171, 0, 'src\\main\\resources\\img\\UEFA Euro 2020\\Slovakia.png'),
('Spain', 37962, 0, 'src\\main\\resources\\img\\UEFA Euro 2020\\Spain.png'),
('Sweden', 29028, 0, 'src\\main\\resources\\img\\UEFA Euro 2020\\Sweden.png'),
('Switzerland', 31254, 0, 'src\\main\\resources\\img\\UEFA Euro 2020\\Switzerland.png'),
('Turkey', 27033, 0, 'src\\main\\resources\\img\\UEFA Euro 2020\\Turkey.png'),
('Ukraine', 30313, 0, 'src\\main\\resources\\img\\UEFA Euro 2020\\Ukraine.png'),
('Wales', 24531, 0, 'src\\main\\resources\\img\\UEFA Euro 2020\\Wales.png');

INSERT INTO ChampionsLeagueTeams VALUES
('Ajax Amsterdam', (SELECT id FROM Countries WHERE country_name = 'Netherlands'), 82500, 1, 0, 'src\\main\\resources\\img\\UEFA Champions League\\Ajax.png'),
('Atalanta Bergamo', (SELECT id FROM Countries WHERE country_name = 'Italy'), 50500, 0, 0, 'src\\main\\resources\\img\\UEFA Champions League\\Atalanta.png'),
('Atletico Madrid', (SELECT id FROM Countries WHERE country_name = 'Spain'), 115000, 1, 0, 'src\\main\\resources\\img\\UEFA Champions League\\Atletico.png'),
('FC Barcelona', (SELECT id FROM Countries WHERE country_name = 'Spain'), 122000, 0, 0, 'src\\main\\resources\\img\\UEFA Champions League\\Barcelona.png'),
('Bayern Munich', (SELECT id FROM Countries WHERE country_name = 'Germany'), 134000, 1, 0, 'src\\main\\resources\\img\\UEFA Champions League\\Bayern.png'),
('Benfica', (SELECT id FROM Countries WHERE country_name = 'Portugal'), 58000, 0, 0, 'src\\main\\resources\\img\\UEFA Champions League\\Benfica.png'),
('Besiktas Istanbul', (SELECT id FROM Countries WHERE country_name = 'Turkey'), 49000, 1, 0, 'src\\main\\resources\\img\\UEFA Champions League\\Besiktas.png'),
('Borussia Dortmund', (SELECT id FROM Countries WHERE country_name = 'Germany'), 90000, 0, 0, 'src\\main\\resources\\img\\UEFA Champions League\\Borussia.png'),
('Club Brugge', (SELECT id FROM Countries WHERE country_name = 'Belgium'), 35500, 1, 0, 'src\\main\\resources\\img\\UEFA Champions League\\Brugge.png'),
('Chelsea', (SELECT id FROM Countries WHERE country_name = 'England'), 98000, 0, 1, 'src\\main\\resources\\img\\UEFA Champions League\\Chelsea.png'),
('Dynamo Kiev', (SELECT id FROM Countries WHERE country_name = 'Ukraine'), 47000, 1, 0, 'src\\main\\resources\\img\\UEFA Champions League\\DynKijow.png'),
('Inter Milan', (SELECT id FROM Countries WHERE country_name = 'Italy'), 53000, 1, 0, 'src\\main\\resources\\img\\UEFA Champions League\\Inter.png'),
('Juventus', (SELECT id FROM Countries WHERE country_name = 'Italy'), 120000, 0, 0, 'src\\main\\resources\\img\\UEFA Champions League\\Juventus.png'),
('RB Leipzig', (SELECT id FROM Countries WHERE country_name = 'Germany'), 66000, 0, 0, 'src\\main\\resources\\img\\UEFA Champions League\\Leipzig.png'),
('Lille', (SELECT id FROM Countries WHERE country_name = 'France'), 14000, 1, 0, 'src\\main\\resources\\img\\UEFA Champions League\\Lille.png'),
('FC Liverpool', (SELECT id FROM Countries WHERE country_name = 'England'), 101000, 0, 0, 'src\\main\\resources\\img\\UEFA Champions League\\Liverpool.png'),
('Malmo', (SELECT id FROM Countries WHERE country_name = 'Sweden'), 18500, 1, 0, 'src\\main\\resources\\img\\UEFA Champions League\\Malmo.png'),
('Manchester City', (SELECT id FROM Countries WHERE country_name = 'England'), 125000, 1, 0, 'src\\main\\resources\\img\\UEFA Champions League\\ManCity.png'),
('Manchester United', (SELECT id FROM Countries WHERE country_name = 'England'), 113000, 0, 0, 'src\\main\\resources\\img\\UEFA Champions League\\ManUnited.png'),
('AC Milan', (SELECT id FROM Countries WHERE country_name = 'Italy'), 31000, 0, 0, 'src\\main\\resources\\img\\UEFA Champions League\\Milan.png'),
('FC Porto', (SELECT id FROM Countries WHERE country_name = 'Portugal'), 87000, 0, 0, 'src\\main\\resources\\img\\UEFA Champions League\\Porto.png'),
('Paris Saint-Germain', (SELECT id FROM Countries WHERE country_name = 'France'), 113000, 0, 0, 'src\\main\\resources\\img\\UEFA Champions League\\PSG.png'),
('Real Madrid', (SELECT id FROM Countries WHERE country_name = 'Spain'), 127000, 0, 0, 'src\\main\\resources\\img\\UEFA Champions League\\Real.png'),
('FC Salzburg', (SELECT id FROM Countries WHERE country_name = 'Austria'), 59000, 1, 0, 'src\\main\\resources\\img\\UEFA Champions League\\Salzburg.png'),
('Sevilla', (SELECT id FROM Countries WHERE country_name = 'Spain'), 98000, 0, 0, 'src\\main\\resources\\img\\UEFA Champions League\\Sevilla.png'),
('Sporting CP', (SELECT id FROM Countries WHERE country_name = 'Portugal'), 45000, 1, 0, 'src\\main\\resources\\img\\UEFA Champions League\\Sporting.png'),
('Shakhtar Donetsk', (SELECT id FROM Countries WHERE country_name = 'Ukraine'), 79000, 0, 0, 'src\\main\\resources\\img\\UEFA Champions League\\Szachtar.png'),
('Sheriff Tiraspol', (SELECT id FROM Countries WHERE country_name = 'Moldova'), 14500, 1, 0, 'src\\main\\resources\\img\\UEFA Champions League\\Szerif.png'),
('Villareal', (SELECT id FROM Countries WHERE country_name = 'Spain'), 63000, 0, 1, 'src\\main\\resources\\img\\UEFA Champions League\\Villareal.png'),
('Wolfsburg', (SELECT id FROM Countries WHERE country_name = 'Germany'), 14714, 0, 0, 'src\\main\\resources\\img\\UEFA Champions League\\Wolfsburg.png'),
('Young Boys', (SELECT id FROM Countries WHERE country_name = 'Switzerland'), 35000, 1, 0, 'src\\main\\resources\\img\\UEFA Champions League\\YoungBoys.png'),
('Zenit St Petersburg', (SELECT id FROM Countries WHERE country_name = 'Russia'), 50000, 1, 0, 'src\\main\\resources\\img\\UEFA Champions League\\Zenit.png');

INSERT INTO EuropaLeagueTeams VALUES
('Olympique Lyon', (SELECT id FROM Countries WHERE country_name = 'France'), 76000, 'src\\main\\resources\\img\\UEFA Europa League\\Lyon.png'),
('Celtic Glasgow', (SELECT id FROM Countries WHERE country_name = 'Scotland'), 34000, 'src\\main\\resources\\img\\UEFA Europa League\\Celtic.png'),
('Olympique Marseille', (SELECT id FROM Countries WHERE country_name = 'France'), 28000, 'src\\main\\resources\\img\\UEFA Europa League\\Marsylia.png'),
('Galatasaray', (SELECT id FROM Countries WHERE country_name = 'Turkey'), 17000, 'src\\main\\resources\\img\\UEFA Europa League\\Galatasaray.png'),
('Antwerp', (SELECT id FROM Countries WHERE country_name = 'Belgium'), 10500, 'src\\main\\resources\\img\\UEFA Europa League\\Antwerp.png'),
('Spartak Moskva', (SELECT id FROM Countries WHERE country_name = 'Russia'), 18500, 'src\\main\\resources\\img\\UEFA Europa League\\Spartak.png'),
('Genk', (SELECT id FROM Countries WHERE country_name = 'Belgium'), 30000, 'src\\main\\resources\\img\\UEFA Europa League\\Genk.png'),
('Dinamo Zagreb', (SELECT id FROM Countries WHERE country_name = 'Croatia'), 44500, 'src\\main\\resources\\img\\UEFA Europa League\\Dinamo.png'),
('Sparta Praha', (SELECT id FROM Countries WHERE country_name = 'Czech Republic'), 17500, 'src\\main\\resources\\img\\UEFA Europa League\\Sparta.png'),
('Ludogorets', (SELECT id FROM Countries WHERE country_name = 'Bulgaria'), 28000, 'src\\main\\resources\\img\\UEFA Europa League\\£udogorec.png'),
('Rangers', (SELECT id FROM Countries WHERE country_name = 'Scotland'), 31250, 'src\\main\\resources\\img\\UEFA Europa League\\Rangers.png'),
('Real Betis', (SELECT id FROM Countries WHERE country_name = 'Spain'), 19571, 'src\\main\\resources\\img\\UEFA Europa League\\Betis.png'),
('Sporting Braga', (SELECT id FROM Countries WHERE country_name = 'Portugal'), 35000, 'src\\main\\resources\\img\\UEFA Europa League\\Braga.png'),
('Napoli', (SELECT id FROM Countries WHERE country_name = 'Italy'), 74000, 'src\\main\\resources\\img\\UEFA Europa League\\Napoli.png'),
('Monaco', (SELECT id FROM Countries WHERE country_name = 'France'), 36000, 'src\\main\\resources\\img\\UEFA Europa League\\Monaco.png'),
('Crvena Zvezda', (SELECT id FROM Countries WHERE country_name = 'Serbia'), 32500, 'src\\main\\resources\\img\\UEFA Europa League\\Crvena.png'),
('Legia Warszawa', (SELECT id FROM Countries WHERE country_name = 'Poland'), 16500, 'src\\main\\resources\\img\\UEFA Europa League\\Legia.png'),
('Ferencvaros', (SELECT id FROM Countries WHERE country_name = 'Hungary'), 13500, 'src\\main\\resources\\img\\UEFA Europa League\\Ferencvaros.png'),
('Fenerbahce', (SELECT id FROM Countries WHERE country_name = 'Turkey'), 19500, 'src\\main\\resources\\img\\UEFA Europa League\\Fenerbahce.png'),
('Brondby', (SELECT id FROM Countries WHERE country_name = 'Denmark'), 7000, 'src\\main\\resources\\img\\UEFA Europa League\\Brondby.png'),
('Sturm Graz', (SELECT id FROM Countries WHERE country_name = 'Austria'), 7165, 'src\\main\\resources\\img\\UEFA Europa League\\Sturm.png'),
('Lokomotiv Moskva', (SELECT id FROM Countries WHERE country_name = 'Russia'), 31000, 'src\\main\\resources\\img\\UEFA Europa League\\Lokomotiv.png'),
('Lazio', (SELECT id FROM Countries WHERE country_name = 'Italy'), 44000, 'src\\main\\resources\\img\\UEFA Europa League\\Lazio.png'),
('Bayer Leverkusen', (SELECT id FROM Countries WHERE country_name = 'Germany'), 57000, 'src\\main\\resources\\img\\UEFA Europa League\\Bayer.png'),
('Rapid Wien', (SELECT id FROM Countries WHERE country_name = 'Austria'), 17000, 'src\\main\\resources\\img\\UEFA Europa League\\Rapid.png'),
('Eintracht Frankfurt', (SELECT id FROM Countries WHERE country_name = 'Germany'), 33000, 'src\\main\\resources\\img\\UEFA Europa League\\Eintracht.png'),
('West Ham', (SELECT id FROM Countries WHERE country_name = 'England'), 20113, 'src\\main\\resources\\img\\UEFA Europa League\\WestHam.png'),
('Midtjylland', (SELECT id FROM Countries WHERE country_name = 'Denmark'), 13500, 'src\\main\\resources\\img\\UEFA Europa League\\Midtjylland.png'),
('Olympiacos', (SELECT id FROM Countries WHERE country_name = 'Greece'), 43000, 'src\\main\\resources\\img\\UEFA Europa League\\Olympiakos.png'),
('Real Sociedad', (SELECT id FROM Countries WHERE country_name = 'Spain'), 19571, 'src\\main\\resources\\img\\UEFA Europa League\\RealSociedad.png'),
('PSV Eindhoven', (SELECT id FROM Countries WHERE country_name = 'Netherlands'), 29000, 'src\\main\\resources\\img\\UEFA Europa League\\PSV.png'),
('Leicester City', (SELECT id FROM Countries WHERE country_name = 'England'), 32000, 'src\\main\\resources\\img\\UEFA Europa League\\Leicester.png');

INSERT INTO Countries VALUES
('Greece'),
('Denmark'),
('Hungary'),
('Poland'),
('Serbia'),
('Scotland'),
('Bulgaria'),
('Czech Republic'),
('Croatia');

INSERT INTO Countries VALUES
('Romania'),
('Slovakia'),
('Gibraltar'),
('Cyprus'),
('Finland'),
('Israel'),
('Norway'),
('Kazakhstan'),
('Estonia'),
('Armenia'),
('Azerbaijan');


INSERT INTO ConferenceLeagueTeams VALUES
('AS Roma', (SELECT id FROM Countries WHERE country_name = 'Italy'), 90000, 'src\\main\\resources\\img\\UEFA Europa League\\Roma.png'),
('Tottenham Hotspur', (SELECT id FROM Countries WHERE country_name = 'England'), 88000, 'src\\main\\resources\\img\\UEFA Europa League\\Tottenham.png'),
('FC Basel', (SELECT id FROM Countries WHERE country_name = 'Switzerland'), 49000, 'src\\main\\resources\\img\\UEFA Europa League\\Basel.png'),
('Slavia Praha', (SELECT id FROM Countries WHERE country_name = 'Czech Republic'), 43500, 'src\\main\\resources\\img\\UEFA Europa League\\Slavia.png'),
('FC Kobenhavn', (SELECT id FROM Countries WHERE country_name = 'Denmark'), 43500, 'src\\main\\resources\\img\\UEFA Europa League\\Kopenhaga.png'),
('AA Gent', (SELECT id FROM Countries WHERE country_name = 'Belgium'), 26500, 'src\\main\\resources\\img\\UEFA Europa League\\Gent.png'),
('AZ Alkmaar', (SELECT id FROM Countries WHERE country_name = 'Netherlands'), 21500, 'src\\main\\resources\\img\\UEFA Europa League\\Alkmaar.png'),
('LASK', (SELECT id FROM Countries WHERE country_name = 'Austria'), 21000, 'src\\main\\resources\\img\\UEFA Europa League\\LASK.png'),
('Lincoln Red Imps', (SELECT id FROM Countries WHERE country_name = 'Gibraltar'), 5750, 'src\\main\\resources\\img\\UEFA Europa League\\Lincoln.png'),
('Randers', (SELECT id FROM Countries WHERE country_name = 'Denmark'), 5575, 'src\\main\\resources\\img\\UEFA Europa League\\Randers.png'),
('Omonia Nicosia', (SELECT id FROM Countries WHERE country_name = 'Cyprus'), 5550, 'src\\main\\resources\\img\\UEFA Europa League\\Omonia.png'),
('Anorthosis Famagusta', (SELECT id FROM Countries WHERE country_name = 'Cyprus'), 5550, 'src\\main\\resources\\img\\UEFA Europa League\\Anorthosis.png'),
('HJK Helsinki', (SELECT id FROM Countries WHERE country_name = 'Finland'), 5500, 'src\\main\\resources\\img\\UEFA Europa League\\HJK.png'),
('Maccabi Haifa', (SELECT id FROM Countries WHERE country_name = 'Israel'), 4875, 'src\\main\\resources\\img\\UEFA Europa League\\Haifa.png'),
('Bodo/Glimt', (SELECT id FROM Countries WHERE country_name = 'Norway'), 4200, 'src\\main\\resources\\img\\UEFA Europa League\\BodoGlimt.png'),
('Mura Murska Sobota', (SELECT id FROM Countries WHERE country_name = 'Slovakia'), 3000, 'src\\main\\resources\\img\\UEFA Europa League\\Mura.png'),
('Kairat Almaty', (SELECT id FROM Countries WHERE country_name = 'Kazakhstan'), 6000, 'src\\main\\resources\\img\\UEFA Europa League\\Kajmat.png'),
('Flora Tallinn', (SELECT id FROM Countries WHERE country_name = 'Estonia'), 6250, 'src\\main\\resources\\img\\UEFA Europa League\\Flora.png'),
('Alashkert', (SELECT id FROM Countries WHERE country_name = 'Armenia'), 6500, 'src\\main\\resources\\img\\UEFA Europa League\\Alashkert.png'),
('FK Jablonec', (SELECT id FROM Countries WHERE country_name = 'Czech Republic'), 7000, 'src\\main\\resources\\img\\UEFA Europa League\\Jablonec.png'),
('Slovan Bratislava', (SELECT id FROM Countries WHERE country_name = 'Slovakia'), 7500, 'src\\main\\resources\\img\\UEFA Europa League\\Slovan.png'),
('Vitesse Arnhem', (SELECT id FROM Countries WHERE country_name = 'Netherlands'), 7840, 'src\\main\\resources\\img\\UEFA Europa League\\Vitesse.png'),
('CSKA Sofia', (SELECT id FROM Countries WHERE country_name = 'Bulgaria'), 8000, 'src\\main\\resources\\img\\UEFA Europa League\\CSKASofia.png'),
('Union Berlin', (SELECT id FROM Countries WHERE country_name = 'Germany'), 14714, 'src\\main\\resources\\img\\UEFA Europa League\\Union.png'),
('Feyenoord', (SELECT id FROM Countries WHERE country_name = 'Netherlands'), 21000, 'src\\main\\resources\\img\\UEFA Europa League\\Feyenoord.png'),
('Qarabag FK', (SELECT id FROM Countries WHERE country_name = 'Azerbaijan'), 21000, 'src\\main\\resources\\img\\UEFA Europa League\\Qarabag.png'),
('Maccabi Tel-Aviv', (SELECT id FROM Countries WHERE country_name = 'Israel'), 20500, 'src\\main\\resources\\img\\UEFA Europa League\\Maccabi.png'),
('PAOK Thessaloniki', (SELECT id FROM Countries WHERE country_name = 'Greece'), 20000, 'src\\main\\resources\\img\\UEFA Europa League\\PAOK.png'),
('Stade Rennais', (SELECT id FROM Countries WHERE country_name = 'France'), 19000, 'src\\main\\resources\\img\\UEFA Europa League\\Rennes.png'),
('Partizan Belgrade', (SELECT id FROM Countries WHERE country_name = 'Serbia'), 18000, 'src\\main\\resources\\img\\UEFA Europa League\\Partizan.png'),
('CFR Cluj', (SELECT id FROM Countries WHERE country_name = 'Romania'), 16500, 'src\\main\\resources\\img\\UEFA Europa League\\Cluj.png'),
('Zorya Luhansk', (SELECT id FROM Countries WHERE country_name = 'Ukraine'), 15000, 'src\\main\\resources\\img\\UEFA Europa League\\Zoria.png');

ALTER TABLE Countries
ADD uefa_rating int;

UPDATE Countries
SET uefa_rating = 90641
WHERE country_name = 'England';

UPDATE Countries
SET uefa_rating = 82570
WHERE country_name = 'Spain';

UPDATE Countries
SET uefa_rating = 65902
WHERE country_name = 'Italy';

UPDATE Countries
SET uefa_rating = 64213
WHERE country_name = 'Germany';

UPDATE Countries
SET uefa_rating = 46415
WHERE country_name = 'France';

UPDATE Countries
SET uefa_rating = 45216
WHERE country_name = 'Portugal';

UPDATE Countries
SET uefa_rating = 36500
WHERE country_name = 'Netherlands';

UPDATE Countries
SET uefa_rating = 32850
WHERE country_name = 'Austria';

UPDATE Countries
SET uefa_rating = 31682
WHERE country_name = 'Russia';

UPDATE Countries
SET uefa_rating = 31300
WHERE country_name = 'Scotland';

UPDATE Countries
SET uefa_rating = 30600
WHERE country_name = 'Ukraine';

UPDATE Countries
SET uefa_rating = 28875
WHERE country_name = 'Serbia';

UPDATE Countries
SET uefa_rating = 28000
WHERE country_name = 'Belgium';

UPDATE Countries
SET uefa_rating = 26925
WHERE country_name = 'Switzerland';

UPDATE Countries
SET uefa_rating = 24900
WHERE country_name = 'Croatia';

UPDATE Countries
SET uefa_rating = 24400
WHERE country_name = 'Czech Republic';

UPDATE Countries
SET uefa_rating = 24375
WHERE country_name = 'Cyprus';

UPDATE Countries
SET uefa_rating = 24200
WHERE country_name = 'Greece';

UPDATE Countries
SET uefa_rating = 23900
WHERE country_name = 'Turkey';

UPDATE Countries
SET uefa_rating = 23250
WHERE country_name = 'Norway';

UPDATE Countries
SET uefa_rating = 22625
WHERE country_name = 'Sweden';

UPDATE Countries
SET uefa_rating = 22575
WHERE country_name = 'Denmark';

UPDATE Countries
SET uefa_rating = 22125
WHERE country_name = 'Israel';

UPDATE Countries
SET uefa_rating = 19250
WHERE country_name = 'Bulgaria';

UPDATE Countries
SET uefa_rating = 16650
WHERE country_name = 'Romania';

UPDATE Countries
SET uefa_rating = 15875
WHERE country_name = 'Poland';

UPDATE Countries
SET uefa_rating = 15875
WHERE country_name = 'Hungary';

UPDATE Countries
SET uefa_rating = 15500
WHERE country_name = 'Azerbaijan';

UPDATE Countries
SET uefa_rating = 15500
WHERE country_name = 'Kazakhstan';

INSERT INTO Countries VALUES
('Slovenia', 14500);

UPDATE Countries
SET uefa_rating = 14375
WHERE country_name = 'Slovakia';

INSERT INTO Countries VALUES
('Belarus', 12500);

UPDATE Countries
SET uefa_rating = 10500
WHERE country_name = 'Moldova';

INSERT INTO Countries VALUES
('Lithuania', 10000);

INSERT INTO Countries VALUES
('Bosnia & Herzegovina', 9125);

UPDATE Countries
SET uefa_rating = 5416
WHERE country_name = 'Gibraltar';

UPDATE Countries
SET uefa_rating = 8375
WHERE country_name = 'Finland';

UPDATE Countries
SET uefa_rating = 5708
WHERE country_name = 'Estonia';

UPDATE Countries
SET uefa_rating = 7875
WHERE country_name = 'Armenia';

INSERT INTO Countries VALUES
('Luxembourg', 8750);

INSERT INTO Countries VALUES
('Latvia', 8625);

INSERT INTO Countries VALUES
('Kosovo', 8166);

INSERT INTO Countries VALUES
('Ireland', 8125);

INSERT INTO Countries VALUES
('Northern Ireland', 8083);

INSERT INTO Countries VALUES
('Albania', 8000);

INSERT INTO Countries VALUES
('Faroe Islands', 7250);

INSERT INTO Countries VALUES
('Malta', 7000);

INSERT INTO Countries VALUES
('Georgia', 7000);

INSERT INTO Countries VALUES
('North Macedonia', 7000);

INSERT INTO Countries VALUES
('Lichtenstein', 6500);

INSERT INTO Countries VALUES
('Wales', 5500);

INSERT INTO Countries VALUES
('Iceland', 5375);

INSERT INTO Countries VALUES
('Montenegro', 4875);

INSERT INTO Countries VALUES
('Andorra', 4665);

INSERT INTO Countries VALUES
('San Marino', 1332);

UPDATE Federations
SET federation_name = 'CONMEBOL'
WHERE federation_name LIKE 'CONM%';

UPDATE WorldCupTeams
SET federation = (SELECT id FROM Federations WHERE federation_name = 'CONMEBOL')
WHERE country = 'Brazil' OR country = 'Argentina' OR country = 'Colombia' OR country = 'Peru' OR country = 'Uruguay';

ALTER TABLE WorldCupTeams
DROP COLUMN logo;

ALTER TABLE WorldCupTeams
ADD logo varchar(255);
