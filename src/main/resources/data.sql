DROP TABLE IF EXISTS persona;
 
CREATE TABLE persona (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  nombre VARCHAR(250) NOT NULL,
  apellido VARCHAR(250) NOT NULL,
  edad VARCHAR(250) DEFAULT NULL
);
 
INSERT INTO persona (nombre, apellido, edad) VALUES
  ('Sebastian', 'Agudelo', '25'),
  ('Natali', 'Posada', '20'),
  ('Juan', 'Perez', '30');