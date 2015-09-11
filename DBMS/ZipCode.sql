CREATE DATABASE zipcodeInfo;
USE zipcodeInfo;

-- Creating table stateInfo
CREATE TABLE stateInfo(
    State_id INT PRIMARY KEY NOT NULL,
    stateName varchar(20)
);
-- Creating table cityInfo
CREATE TABLE cityInfo(
    zipcode INT PRIMARY KEY AUTO_INCREMENT,
    State_id INT NOT NULL,
    cityName varchar(20),
    FOREIGN KEY (State_id)
        REFERENCES stateInfo (State_id)
);

 -- Inserting values in stateInfo table
INSERT INTO stateInfo(State_id,stateName) VALUES (801,'bihar');
INSERT INTO stateInfo(State_id,stateName) VALUES (802,'rajasthan');
INSERT INTO stateInfo(State_id,stateName) VALUES (803,'delhi');

 
 -- Inserting values in cityInfo table
INSERT INTO cityInfo(zipcode,cityName,State_id) VALUES (101,'patna',801);
INSERT INTO cityInfo(zipcode,cityName,State_id) VALUES (102,'jaipur',802);
INSERT INTO cityInfo(zipcode,cityName,State_id) VALUES (103,'delhi',803);
 

 -- Query to find the zip code city name and stateName
SELECT 
    c.zipcode, cityName, stateName
from
    cityInfo c,
    stateInfo s
where
(c.State_id = s.State_id)
ORDER BY stateName asc ,cityName asc;

 
