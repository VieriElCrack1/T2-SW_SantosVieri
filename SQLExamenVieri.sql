create database BDCibertec;
use BDCibertec;

CREATE TABLE Medico
(
 IdMedico 		INT NOT NULL AUTO_INCREMENT,
 NomMedico		VARCHAR(50) NOT NULL,
 ApeMedico 		VARCHAR(50) NOT NULL,
 FechNacMedico	DATE NOT NULL,
 PRIMARY KEY (IdMedico)
);

insert into Medico(NomMedico,ApeMedico,FechNacMedico) values
("Francisco","Campos",Date("2000-10-07")),
("Juliana","Torrez",Date("1998-12-10")),
("Emilio","Sanchez",Date("1992-08-12")),
("Cecilia","Dulanto",Date("1995-12-24")),
("Jefferson","Carrazco",Date("1989-03-04"));

CREATE TABLE Especialidad
(
 IdEspecialidad 		INT NOT NULL AUTO_INCREMENT,
 Titulo 			VARCHAR(250) NOT NULL,
 Funcion 			VARCHAR(250) NOT NULL,
 FechGraduacion	DATE NOT NULL,
 IdMedico 			INT NOT NULL,
 PRIMARY KEY (IdEspecialidad),
 FOREIGN KEY (IdMedico) REFERENCES Medico(IdMedico)
 );
 
 insert into Especialidad(Titulo,Funcion,FechGraduacion,IdMedico) values
 ("Cardiologo","Ver el corazón del paciente",Date("2023-10-12"),1),
 ("Gastroenterologia","Ver problemas del estomago",Date("2022-06-12"),2),
 ("Ginecologo","Ver sistema repoductor",Date("2020-01-21"),3),
 ("Dermatologia","Ver el tipo piel de las personas",Date("2021-03-24"),4),
 ("Odontologia","Ver la salud bucal",Date("2018-12-14"),5);
 
 
 