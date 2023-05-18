CREATE TABLE IF NOT EXISTS departuresR
(
    id SERIAL PRIMARY KEY,
    post_office_id INT NOT NULL,
    departure_type VARCHAR(256) NOT NULL,
    departure_date VARCHAR(256) NOT NULL
    );

CREATE TABLE IF NOT EXISTS postofficesR
(
    id SERIAL PRIMARY KEY,
    office_name VARCHAR(256) NOT NULL,
    city_name VARCHAR(256) NOT NULL
    );
-- DROP TABLE departuresR;
-- DROP TABLE postofficesR;