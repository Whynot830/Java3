CREATE TABLE IF NOT EXISTS departures
(
    id SERIAL PRIMARY KEY,
    departure_type VARCHAR(256) NOT NULL,
    departure_date VARCHAR(256) NOT NULL
    );

CREATE TABLE IF NOT EXISTS postoffices
(
    id SERIAL PRIMARY KEY,
    office_name VARCHAR(256) NOT NULL,
    city_name VARCHAR(256) NOT NULL
    );
-- DROP TABLE departures;
-- DROP TABLE postoffices;
