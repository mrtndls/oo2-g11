drop schema if exists cc;
create database if not exists cc;
use cc;

-- Tabla Persona
DROP TABLE IF EXISTS persona;
CREATE TABLE persona (
  idPersona BIGINT NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(255) NOT NULL,
  apellido VARCHAR(255) NOT NULL,
  dni int not null,
  email VARCHAR(255),
  telefono VARCHAR(20),
  fechaNacimiento DATE,
  baja BIT(1) DEFAULT 0,
  PRIMARY KEY (idPersona)
);

-- Tabla Servicio
DROP TABLE IF EXISTS servicio;
CREATE TABLE servicio (
  idServicio BIGINT NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(255) NOT NULL,
  descripcion TEXT,
  activo BIT(1) DEFAULT 1,
  creadoEn TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  actualizadoEn TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (idServicio)
);

-- Tabla Turno
DROP TABLE IF EXISTS turno;
CREATE TABLE turno (
  idTurno BIGINT NOT NULL AUTO_INCREMENT,
  fecha DATE NOT NULL,
  hora TIME NOT NULL,
  cupoMaximo INT NOT NULL,
  estado varchar(50) ,
  idServicio BIGINT NOT NULL,
  baja BIT(1) DEFAULT 0,
  PRIMARY KEY (idTurno),
  FOREIGN KEY (idServicio) REFERENCES servicio(idServicio)
);

-- Tabla ReservaTurno
DROP TABLE IF EXISTS reserva_turno;
CREATE TABLE reserva_turno (
  idReservaTurno BIGINT NOT NULL AUTO_INCREMENT,
  fechaReserva TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  estado VARCHAR(50)  ,
  idPersona BIGINT NOT NULL,
  idTurno BIGINT NOT NULL,
  PRIMARY KEY (idReservaTurno),
  FOREIGN KEY (idPersona) REFERENCES persona(idPersona),
  FOREIGN KEY (idTurno) REFERENCES turno(idTurno)
);

-- Tabla Persona_Servicio (Relación Muchos a Muchos)
DROP TABLE IF EXISTS persona_servicio;
CREATE TABLE persona_servicio (
  idPersona BIGINT NOT NULL,
  idServicio BIGINT NOT NULL,
  PRIMARY KEY (idPersona, idServicio),
  FOREIGN KEY (idPersona) REFERENCES persona(idPersona),
  FOREIGN KEY (idServicio) REFERENCES servicio(idServicio)
);

-- Insertar Personas
INSERT INTO persona (nombre, apellido, dni, email, telefono, fechaNacimiento, baja) VALUES
('Martin', 'Di Alessio', 388411670,'martin@example.com', '1234567890', '1990-05-15', 0),
('Ignacio', 'Pizuto', 388411671,'ignacio@example.com', '1234567891', '1985-03-20', 0),
('Fernando', 'Luis', 388411672,'fernando@example.com', '1234567892', '1980-07-30', 0),
('Carmen', 'Abel', 388411673,'carmen@example.com', '1234567893', '1995-11-10', 0);

-- Insertar Servicios
INSERT INTO servicio (nombre, descripcion, activo) VALUES
('VTV', 'Inspección Técnica Vehicular', 1),
('Medico', 'Consultas Médicas Generales', 1),
('Anses', 'Trámites Anses', 1),
('Arba', 'Trámites ARBA', 1);

-- Insertar Turnos (De lunes a viernes, de 8am a 16pm con duración de 1 hora)
INSERT INTO turno (fecha, hora, cupoMaximo,estado, idServicio) VALUES
('2025-05-10', '08:00:00', 10,'DISPONIBLE', 1),  -- VTV
('2025-05-10', '09:00:00', 10,'DISPONIBLE', 1),  -- VTV
('2025-05-10', '10:00:00', 10,'DISPONIBLE', 2),  -- Médico
('2025-05-10', '11:00:00', 10,'DISPONIBLE', 2),  -- Médico
('2025-05-10', '12:00:00', 10,'DISPONIBLE', 3),  -- Anses
('2025-05-10', '13:00:00', 10,'DISPONIBLE', 3),  -- Anses
('2025-05-10', '14:00:00', 10,'DISPONIBLE', 4),  -- ARBA
('2025-05-10', '15:00:00', 10,'DISPONIBLE', 4),  -- ARBA
('2025-05-11', '08:00:00', 10,'DISPONIBLE', 1),  -- VTV
('2025-05-11', '09:00:00', 10,'DISPONIBLE', 2);  -- Médico

-- Insertar Reservas de Turnos
INSERT INTO reserva_turno (estado, idPersona, idTurno) VALUES
('CONFIRMADA', 1, 1),   -- Martin reserva turno para VTV el 10 de mayo a las 08:00
('CONFIRMADA', 2, 2),   -- Ignacio reserva turno para VTV el 10 de mayo a las 09:00
('CONFIRMADA', 3, 3),   -- Fernando reserva turno para Médico el 10 de mayo a las 10:00
('CONFIRMADA', 4, 4);   -- Carmen reserva turno para Médico el 10 de mayo a las 11:00

-- Insertar Relaciones Persona_Servicio (Muchos a Muchos)
INSERT INTO persona_servicio (idPersona, idServicio) VALUES
(1, 1),  -- Martin tiene VTV
(1, 2),  -- Martin tiene Médico
(2, 3),  -- Ignacio tiene Anses
(3, 4),  -- Fernando tiene ARBA
(4, 2);  -- Carmen tiene Médico
