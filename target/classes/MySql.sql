CREATE TABLE SpecificationTrain
(
    id INTEGER PRIMARY KEY,
    typeTrainCar VARCHAR(50),
    ComfortLevel INTEGER,
    NumbPassengers INTEGER,
    NumbLuggage INTEGER
);

INSERT INTO SpecificationTrain
VALUES(1,'Luxury',10,17,20),
      (2,'Coupe',6,40,55),
      (3,'Common',4,50,70);





CREATE TABLE TrainDefaultSpecs (
                                   id INTEGER PRIMARY KEY,
                                   typeTrainCar VARCHAR(50),
                                   ComfortLevel INTEGER,
                                   NumbPassengers INTEGER,
                                   NumbLuggage INTEGER
);

INSERT INTO TrainDefaultSpecs
VALUES  (1,'Luxury',10,8,20),
        (2,'Coupe',6,40,55),
        (3,'Common',3,35,39);


CREATE TABLE TrainSpecification
(
    id SERIAL PRIMARY KEY,
    typeTrainCar VARCHAR(50),
    comfortLevel INTEGER,
    numbPassengers INTEGER,
    numbLuggage INTEGER
);

INSERT INTO TrainSpecification (typeTrainCar, comfortLevel, numbPassengers, numbLuggage)
VALUES  ('Luxury',10,8,20),
        ('Coupe',6,40,55),
        ('Common',3,35,39);

SELECT * FROM TrainSpecification;  