--Consultas de Registros
--Listar pacientes registrados
SELECT
u.id,
u.dni,
u.nombre,
u.apellido,
u.email,
u.contacto
FROM usuario u
INNER JOIN paciente p
ON u.id = p.id;

--Consultar turnos de un paciente
SELECT
t.id,
t.fecha_hora,
t.estado,
u.nombre,
u.apellido
FROM turno t
INNER JOIN profesional_salud ps
ON t.profesional_id = ps.id
INNER JOIN usuario u
ON ps.id = u.id
WHERE t.paciente_id = 1;
