CREATE DATABASE clinicgest CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE clinicgest;


CREATE TABLE especialidad (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL UNIQUE,
    descripcion VARCHAR(255)
);


CREATE TABLE usuario (
    id INT AUTO_INCREMENT PRIMARY KEY,
    dni VARCHAR(20) NOT NULL UNIQUE,
    nombre VARCHAR(100) NOT NULL,
    apellido VARCHAR(100) NOT NULL,
    sexo VARCHAR(20),
    calle VARCHAR(100),
    numero_calle INT,
    barrio VARCHAR(100),
    localidad VARCHAR(100),
    email VARCHAR(100),
    contacto VARCHAR(30)
);


CREATE TABLE usuario_sistema (
    id INT PRIMARY KEY,
    usuario VARCHAR(50) NOT NULL UNIQUE,
    clave VARCHAR(255) NOT NULL,
    activo BOOLEAN NOT NULL DEFAULT TRUE,
    rol ENUM('ADMINISTRADOR','RECEPCIONISTA','PROFESIONAL') NOT NULL,
    FOREIGN KEY (id) REFERENCES usuario(id)
);


CREATE TABLE administrador (
    id INT PRIMARY KEY,
    FOREIGN KEY (id) REFERENCES usuario_sistema(id)
);


CREATE TABLE recepcionista (
    id INT PRIMARY KEY,
    legajo VARCHAR(20),
    fecha_ingreso DATE,
    FOREIGN KEY (id) REFERENCES usuario_sistema(id)
);


CREATE TABLE profesional_salud (
    id INT PRIMARY KEY,
    legajo VARCHAR(20),
    fecha_ingreso DATE,
    nro_matricula VARCHAR(50) NOT NULL,
    especialidad_id INT NOT NULL,
    FOREIGN KEY (id) REFERENCES usuario_sistema(id),
    FOREIGN KEY (especialidad_id) REFERENCES especialidad(id)
);


CREATE TABLE paciente (
    id INT PRIMARY KEY,
    FOREIGN KEY (id) REFERENCES usuario(id)
);


CREATE TABLE historia_clinica (
    id INT AUTO_INCREMENT PRIMARY KEY,
    paciente_id INT NOT NULL UNIQUE,
    FOREIGN KEY (paciente_id) REFERENCES paciente(id)
);


CREATE TABLE turno (
    id INT AUTO_INCREMENT PRIMARY KEY,
    paciente_id INT NOT NULL,
    profesional_id INT NOT NULL,
    fecha_hora DATETIME NOT NULL,
    estado ENUM('PENDIENTE','CONFIRMADO','CANCELADO','COMPLETADO') NOT NULL DEFAULT 'PENDIENTE',
    FOREIGN KEY (paciente_id) REFERENCES paciente(id),
    FOREIGN KEY (profesional_id) REFERENCES profesional_salud(id)
);


CREATE TABLE consulta (
    id INT AUTO_INCREMENT PRIMARY KEY,
    historia_clinica_id INT NOT NULL,
    paciente_id INT NOT NULL,
    profesional_id INT NOT NULL,
    turno_id INT NULL,
    fecha DATETIME NOT NULL,
    descripcion TEXT,
    FOREIGN KEY (historia_clinica_id) REFERENCES historia_clinica(id),
    FOREIGN KEY (paciente_id) REFERENCES paciente(id),
    FOREIGN KEY (profesional_id) REFERENCES profesional_salud(id),
    FOREIGN KEY (turno_id) REFERENCES turno(id)
);


CREATE TABLE diagnostico (
    id INT AUTO_INCREMENT PRIMARY KEY,
    consulta_id INT NOT NULL,
    descripcion TEXT NOT NULL,
    tratamiento TEXT,
    indicaciones TEXT,
    FOREIGN KEY (consulta_id) REFERENCES consulta(id)
);


CREATE TABLE receta_medica (
    id INT AUTO_INCREMENT PRIMARY KEY,
    consulta_id INT NOT NULL UNIQUE,
    fecha DATE,
    medicamentos TEXT,
    indicaciones TEXT,
    FOREIGN KEY (consulta_id) REFERENCES consulta(id)
);


CREATE TABLE solicitud_examen (
    id INT AUTO_INCREMENT PRIMARY KEY,
    consulta_id INT NOT NULL,
    fecha DATETIME,
    tipo_examen VARCHAR(100),
    descripcion TEXT,
    indicaciones TEXT,
    estado ENUM('PENDIENTE','REALIZADO','CANCELADO') DEFAULT 'PENDIENTE',
    FOREIGN KEY (consulta_id) REFERENCES consulta(id)
);


CREATE TABLE reporte (
    id INT AUTO_INCREMENT PRIMARY KEY,
    administrador_id INT NOT NULL,
    tipo VARCHAR(100) NOT NULL,
    fecha_generacion DATE NOT NULL,
    contenido TEXT,
    FOREIGN KEY (administrador_id) REFERENCES administrador(id)
);
