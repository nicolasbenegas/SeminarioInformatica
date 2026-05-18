--Consultar todos los pacientes
SELECT u.id, u.dni, u.nombre, u.apellido
FROM usuario u
INNER JOIN paciente p ON u.id = p.id;

--Consultar turnos de un paciente
SELECT *
FROM turno
WHERE paciente_id = 1;
