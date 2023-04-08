-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2023-04-05 19:11:36.11

-- tables
-- Table: plant
DROP SCHEMA IF EXISTS PlantInfo;
CREATE SCHEMA PlantInfo;
USE PlantInfo;
CREATE TABLE plant (
                       informalname varchar(100)  NULL DEFAULT null,
                       id int  NOT NULL AUTO_INCREMENT,
                       CONSTRAINT plant_pk PRIMARY KEY (id)
) AUTO_INCREMENT 3 ENGINE InnoDB CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci;

-- Table: user
CREATE TABLE user (
                      id int  NOT NULL AUTO_INCREMENT,
                      firstname varchar(30)  NULL DEFAULT null,
                      lastname varchar(50)  NULL DEFAULT null,
                      username varchar(50)  NULL DEFAULT null,
                      UNIQUE INDEX user_pk2 (id),
                      CONSTRAINT user_pk PRIMARY KEY (id)
) AUTO_INCREMENT 3 ENGINE InnoDB CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci;

-- Table: userplant
CREATE TABLE userplant (
                           id int  NOT NULL AUTO_INCREMENT,
                           userid int  NULL DEFAULT null,
                           plantid int  NULL DEFAULT null,
                           CONSTRAINT userplant_pk PRIMARY KEY (id)
) AUTO_INCREMENT 4 ENGINE InnoDB CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci;

CREATE INDEX userplant_plant_fk ON userplant (plantid);

CREATE INDEX userplant_user_fk ON userplant (userid);

-- foreign keys
-- Reference: userplant_plant_fk (table: userplant)
ALTER TABLE userplant ADD CONSTRAINT userplant_plant_fk FOREIGN KEY userplant_plant_fk (plantid)
    REFERENCES plant (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE;

-- Reference: userplant_user_fk (table: userplant)
ALTER TABLE userplant ADD CONSTRAINT userplant_user_fk FOREIGN KEY userplant_user_fk (userid)
    REFERENCES user (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE;

-- End of file.

INSERT INTO user (id, firstname, lastname, username) VALUES (1,'Kue','Xiong','kxiong'),(2,'Spongebob','Square Pants','ssquarepants');
INSERT INTO plant (id, informalname) VALUES (1,'Peace Lily'),(2,'Mini Monstera');