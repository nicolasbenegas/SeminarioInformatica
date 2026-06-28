--Consultar historia clínica de un paciente
SELECT
u.nombre,
u.apellido,
c.fecha,
c.descripcion,
d.descripcion AS diagnostico,
r.medicamentos,
r.indicaciones,
s.tipo_examen
FROM consulta c

INNER JOIN paciente p
ON c.paciente_id=p.id

INNER JOIN usuario u
ON p.id=u.id

LEFT JOIN diagnostico d
ON c.id=d.consulta_id

LEFT JOIN receta_medica r
ON c.id=r.consulta_id

LEFT JOIN solicitud_examen s
ON c.id=s.consulta_id

WHERE u.dni='30111222';


--Listar Profesionales Disponibles
SELECT
u.id,
u.nombre,
u.apellido,
ps.nro_matricula AS matricula,
e.nombre AS especialidad,
u.email,
u.contacto
FROM profesional_salud ps

INNER JOIN usuario u
ON ps.id = u.id

INNER JOIN especialidad e
ON ps.especialidad_id = e.id

ORDER BY
u.apellido,
u.nombre;


--Listar Turnos
SELECT
t.id,
t.fecha_hora,
t.estado,

up.nombre AS paciente,
up.apellido AS apellido_paciente,

upr.nombre AS profesional,
upr.apellido AS apellido_profesional,

ps.nro_matricula,
e.nombre AS especialidad

FROM turno t

INNER JOIN paciente p
ON t.paciente_id = p.id

INNER JOIN usuario up
ON p.id = up.id

INNER JOIN profesional_salud ps
ON t.profesional_id = ps.id

INNER JOIN usuario upr
ON ps.id = upr.id

INNER JOIN especialidad e
ON ps.especialidad_id = e.id

ORDER BY
t.fecha_hora;


--Búsqueda de Paciente por DNI
SELECT
u.id,
u.dni,
u.nombre,
u.apellido,
u.email,
u.contacto,
u.direccion
FROM usuario u

INNER JOIN paciente p
ON u.id = p.id

WHERE u.dni = '30111222';
