--Insertar especialidad
INSERT INTO especialidad (nombre, descripcion)
VALUES ('Cardiología', 'Especialidad médica del corazón');

--Insertar usuario
INSERT INTO usuario (dni, nombre, apellido, sexo, email, contacto)
VALUES ('30111222', 'Juan', 'Pérez', 'Masculino', 'juan@gmail.com', '3851234567');

--Insertar paciente
INSERT INTO paciente (id)
VALUES (1);

--Insertar historia clínica
INSERT INTO historia_clinica (paciente_id)
VALUES (1);