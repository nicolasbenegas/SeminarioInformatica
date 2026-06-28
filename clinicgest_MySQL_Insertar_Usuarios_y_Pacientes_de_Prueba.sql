USE clinicgest;

-- ===========================
-- ESPECIALIDADES
-- ===========================

INSERT INTO especialidad (nombre, descripcion)
VALUES
('Cardiología','Especialidad relacionada con enfermedades del corazón'),
('Pediatría','Atención médica infantil'),
('Traumatología','Diagnóstico y tratamiento de lesiones'),
('Dermatología','Tratamiento de enfermedades de la piel'),
('Clínica Médica','Atención médica general');


-- ===========================
-- USUARIOS (PROFESIONALES + ADMIN + RECEPCIONISTA)
-- ===========================

INSERT INTO usuario (
dni,
nombre,
apellido,
sexo,
calle,
numero_calle,
barrio,
localidad,
email,
contacto
)
VALUES

-- Administrador
('37119044','Nicolas','Benegas','Masculino',
'Santa Catalina',306,'Tabla Redonda','Santiago del Estero',
'admin@clinicgest.com','3855910195'),

-- Recepcionista
('22111333','Laura','Molina','Femenino',
'Belgrano',240,'Centro','Santiago del Estero',
'laura@clinicgest.com','3855000002'),

-- Profesionales
('23111444','Miguel','Acosta','Masculino',
'Roca',120,'Mosconi','Santiago del Estero',
'miguel@clinicgest.com','3855000003'),

('24111555','Gabriela','Ramos','Femenino',
'San Martín',210,'Autonomía','La Banda',
'gabriela@clinicgest.com','3855000004'),

('25111666','Ricardo','Paz','Masculino',
'Moreno',330,'Centro','Santiago del Estero',
'ricardo@clinicgest.com','3855000005'),

('26111777','Patricia','Ferreyra','Femenino',
'Avellaneda',450,'Tradición','La Banda',
'patricia@clinicgest.com','3855000006'),

('27111888','Fernando','Sosa','Masculino',
'Sarmiento',520,'Parque Aguirre',
'Santiago del Estero',
'fernando@clinicgest.com',
'3855000007');


-- ===========================
-- USUARIO SISTEMA
-- Contraseña: 1234
-- Hash ficticio para pruebas
-- ===========================

INSERT INTO usuario_sistema
(id,usuario,clave,activo,rol)
VALUES

(
(SELECT id FROM usuario WHERE dni='20111222'),
'admin',
'1234',
TRUE,
'ADMINISTRADOR'
),

(
(SELECT id FROM usuario WHERE dni='22111333'),
'recep',
'1234',
TRUE,
'RECEPCIONISTA'
),

(
(SELECT id FROM usuario WHERE dni='23111444'),
'medico1',
'1234',
TRUE,
'PROFESIONAL'
),

(
(SELECT id FROM usuario WHERE dni='24111555'),
'medico2',
'1234',
TRUE,
'PROFESIONAL'
),

(
(SELECT id FROM usuario WHERE dni='25111666'),
'medico3',
'1234',
TRUE,
'PROFESIONAL'
),

(
(SELECT id FROM usuario WHERE dni='26111777'),
'medico4',
'1234',
TRUE,
'PROFESIONAL'
),

(
(SELECT id FROM usuario WHERE dni='27111888'),
'medico5',
'1234',
TRUE,
'PROFESIONAL'
);


-- ===========================
-- ADMINISTRADOR
-- ===========================

INSERT INTO administrador(id)
SELECT id
FROM usuario_sistema
WHERE rol='ADMINISTRADOR';


-- ===========================
-- RECEPCIONISTA
-- ===========================

INSERT INTO recepcionista
(id,legajo,fecha_ingreso)
VALUES
(
(SELECT id FROM usuario WHERE dni='22111333'),
'REC001',
'2025-01-15'
);


-- ===========================
-- PROFESIONALES
-- ===========================

INSERT INTO profesional_salud
(
id,
legajo,
fecha_ingreso,
nro_matricula,
especialidad_id
)
VALUES

(
(SELECT id FROM usuario WHERE dni='23111444'),
'001',
'2024-02-01',
'1001',
(SELECT id FROM especialidad
WHERE nombre='Cardiología')
),

(
(SELECT id FROM usuario WHERE dni='24111555'),
'002',
'2024-03-01',
'1002',
(SELECT id FROM especialidad
WHERE nombre='Pediatría')
),

(
(SELECT id FROM usuario WHERE dni='25111666'),
'003',
'2024-04-01',
'1003',
(SELECT id FROM especialidad
WHERE nombre='Traumatología')
),

(
(SELECT id FROM usuario WHERE dni='26111777'),
'004',
'2024-05-01',
'1004',
(SELECT id FROM especialidad
WHERE nombre='Dermatología')
),

(
(SELECT id FROM usuario WHERE dni='27111888'),
'005',
'2024-06-01',
'1005',
(SELECT id FROM especialidad
WHERE nombre='Clínica Médica')
);


-- ===========================
-- INSERTAR PACIENTES DE PRUEBA
-- ===========================
-- Insertar usuarios (pacientes)
INSERT INTO usuario (
dni,
nombre,
apellido,
sexo,
calle,
numero_calle,
barrio,
localidad,
email,
contacto
)
VALUES
('30111222','Juan','Pérez','Masculino','Belgrano',123,'Centro','Santiago del Estero','juan.perez@gmail.com','3854111111'),

('28999888','María','Gómez','Femenino','Rivadavia',456,'Mosconi','Santiago del Estero','maria.gomez@gmail.com','3854222222'),

('32444555','Carlos','López','Masculino','Independencia',890,'Almirante Brown','La Banda','carlos.lopez@gmail.com','3854333333'),

('33888777','Ana','Martínez','Femenino','Mitre',250,'8 de Abril','Santiago del Estero','ana.martinez@gmail.com','3854444444'),

('29999666','Luis','Fernández','Masculino','San Martín',154,'Parque Aguirre','La Banda','luis.fernandez@gmail.com','3854555555'),

('31123456','Sofía','Ruiz','Femenino','Avellaneda',777,'Centro','Santiago del Estero','sofia.ruiz@gmail.com','3854666666'),

('35555777','Pedro','Torres','Masculino','Moreno',852,'Tradición','Santiago del Estero','pedro.torres@gmail.com','3854777777'),

('36777888','Lucía','Herrera','Femenino','Urquiza',963,'Autonomía','La Banda','lucia.herrera@gmail.com','3854888888'),

('37788999','Diego','Castro','Masculino','Sarmiento',741,'Jardín','Santiago del Estero','diego.castro@gmail.com','3854999999'),

('38899111','Valentina','Silva','Femenino','Libertad',369,'Centro','La Banda','valentina.silva@gmail.com','3854000000');


-- Registrar los usuarios como pacientes
INSERT INTO paciente (id)
SELECT id
FROM usuario
WHERE dni IN (
'30111222',
'28999888',
'32444555',
'33888777',
'29999666',
'31123456',
'35555777',
'36777888',
'37788999',
'38899111'
);


-- Crear historias clínicas para cada paciente
INSERT INTO historia_clinica (paciente_id)
SELECT id
FROM paciente;


-- ===========================
-- TURNOS DE PRUEBA
-- ===========================

INSERT INTO turno
(
paciente_id,
profesional_id,
fecha_hora,
estado
)
VALUES

((SELECT id FROM usuario WHERE dni='30111222'),
 (SELECT id FROM usuario WHERE dni='23111444'),
 '2026-06-10 09:00:00','PENDIENTE'),

((SELECT id FROM usuario WHERE dni='28999888'),
 (SELECT id FROM usuario WHERE dni='24111555'),
 '2026-06-10 10:00:00','CONFIRMADO'),

((SELECT id FROM usuario WHERE dni='32444555'),
 (SELECT id FROM usuario WHERE dni='25111666'),
 '2026-06-10 11:00:00','PENDIENTE'),

((SELECT id FROM usuario WHERE dni='33888777'),
 (SELECT id FROM usuario WHERE dni='26111777'),
 '2026-06-11 09:30:00','CONFIRMADO'),

((SELECT id FROM usuario WHERE dni='29999666'),
 (SELECT id FROM usuario WHERE dni='27111888'),
 '2026-06-11 10:30:00','PENDIENTE');

