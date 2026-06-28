--Borrado de Registros
--Cancelar un turno
DELETE FROM turno
WHERE id = 1;

--Suspender un usuario
UPDATE usuario_sistema
SET activo = FALSE
WHERE id = 10;
