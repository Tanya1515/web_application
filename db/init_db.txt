— инициализация бд

CREATE TABLE Employee (
    id_employee serial PRIMARY KEY,
    name varchar(50) NOT NULL,
    surname varchar(50) NOT NULL,
    phone char(11) NOT NULL UNIQUE,
    e_mail text NOT NULL UNIQUE,
    education varchar(50) NOT NULL,
    home_address varchar(50), 
    position  varchar(50) NOT NULL,
    CHECK(position IN ('paralegal', 'associate', 'senior_associate', 'partner', 'legal_advisor', 'lawyer')),
    work_experience integer NOT NULL
);

CREATE TABLE Service (
    id_service serial PRIMARY KEY,
    name_of__service varchar(50) NOT NULL,
    cost_of__service integer NOT NULL
);

CREATE TABLE Client (
    id_client serial PRIMARY KEY,
    name varchar(50) NOT NULL,
    surname varchar(50) NOT NULL,
    phone char(11) NOT NULL UNIQUE,
    e_mail text NOT NULL UNIQUE
);
	
CREATE TABLE Contract(
    id_contract serial PRIMARY KEY,
    id_employee integer REFERENCES Employee (id_employee) ON DELETE CASCADE,
    id_service integer REFERENCES Service (id_service) ON DELETE CASCADE, 
    id_client integer REFERENCES Client (id_client) ON DELETE CASCADE,
    date_of__begining date NOT NULL,
    date_of__end date NOT NULL,
    CHECK (date_of__end > date_of__begining)
);

