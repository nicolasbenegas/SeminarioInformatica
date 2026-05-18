--Historia Clínica Completa de un Paciente
SELECT c.fecha,
       c.descripcion AS consulta,
       d.descripcion AS diagnostico,
       rm.medicamentos
FROM consulta c
LEFT JOIN diagnostico d ON d.consulta_id = c.id
LEFT JOIN receta_medica rm ON rm.consulta_id = c.id
WHERE c.paciente_id = 1
ORDER BY c.fecha DESC;


--Profesionales Disponibles
SELECT u.nombre, u.apellido, e.nombre AS especialidad
FROM profesional_salud ps
JOIN usuario u ON ps.id = u.id
JOIN especialidad e ON ps.especialidad_id = e.id
WHERE ps.id NOT IN (
    SELECT profesional_id
    FROM turno
    WHERE fecha_hora = '2026-06-01 10:00:00'
      AND estado IN ('PENDIENTE', 'CONFIRMADO')
);


--Reporte de Turnos por Estado
SELECT estado, COUNT(*) AS cantidad
FROM turno
GROUP BY estado;


--Búsqueda de Paciente por DNI
SELECT *
FROM usuario
WHERE dni = '30111222';
