--Eliminar un turno
DELETE FROM turno
WHERE id = 1;

--Suspender un usuario (borrado lógico)
UPDATE usuario_sistema
SET activo = FALSE
WHERE id = 10;
