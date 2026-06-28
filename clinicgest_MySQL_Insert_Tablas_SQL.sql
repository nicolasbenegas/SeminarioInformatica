--Inserción de registros
--Insertar especialidad
INSERT INTO especialidad (nombre, descripcion)
VALUES (
    'Cardiología',
    'Especialidad médica dedicada al diagnóstico y tratamiento de enfermedades del corazón.'
);

--Insertar usuario
INSERT INTO usuario
(dni, nombre, apellido, sexo, email, contacto, direccion)
VALUES
(
    '30111222',
    'Juan',
    'Pérez',
    'Masculino',
    'juan@gmail.com',
    '3851234567',
    'Av. Belgrano 250'
);

--Insertar paciente
INSERT INTO paciente (id)
VALUES (1);

--Insertar historia clínica
INSERT INTO historia_clinica (paciente_id)
VALUES (1);

--Registrar una consulta médica
INSERT INTO consulta
(
    historia_clinica_id,
    paciente_id,
    profesional_id,
    turno_id,
    fecha,
    descripcion
)
VALUES
(
    1,
    1,
    3,
    NULL,
    NOW(),
    'Motivo: Dolor abdominal

Observaciones: Posible gastroenteritis.'
);

--Registrar un diagnóstico
INSERT INTO diagnostico
(
    consulta_id,
    descripcion,
    tratamiento,
    indicaciones
)
VALUES
(
    1,
    'Gastroenteritis leve',
    'Tratamiento ambulatorio',
    'Reposo e hidratación'
);

--Registrar una receta médica
INSERT INTO receta_medica
(
    consulta_id,
    fecha,
    medicamentos,
    indicaciones
)
VALUES
(
    1,
    CURRENT_DATE,
    'Sertal o Buscapina',
    'Tomar un comprimido cada 8 horas'
);

--Registrar una solicitud de examen
INSERT INTO solicitud_examen
(
    consulta_id,
    fecha,
    tipo_examen,
    descripcion,
    indicaciones
)
VALUES
(
    1,
    NOW(),
    'Ecografía abdominal',
    'Evaluar órganos abdominales',
    'Ayuno de 8 horas'
);