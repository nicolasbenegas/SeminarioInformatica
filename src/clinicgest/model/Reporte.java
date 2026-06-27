package clinicgest.model;

import java.time.LocalDate;

/**

Clase "Reporte"

Paquete de modelo de objetos y datos.
*/
public class Reporte {

//Atributos
private int id;

private int administradorId;

private String tipo;

private LocalDate fechaGeneracion;

private String contenido;

//Constructor
public Reporte() {

 fechaGeneracion =
         LocalDate.now();

}

//Métodos
public int getId() {
return id;
}

public void setId(
int id) {

 this.id = id;

}

public int getAdministradorId() {
return administradorId;
}

public void setAdministradorId(
int administradorId) {

 this.administradorId =
         administradorId;

}

public String getTipo() {
return tipo;
}

public void setTipo(
String tipo) {

 this.tipo = tipo;

}

public LocalDate getFechaGeneracion() {
return fechaGeneracion;
}

public void setFechaGeneracion(
LocalDate fechaGeneracion) {

 this.fechaGeneracion =
         fechaGeneracion;

}

public String getContenido() {
return contenido;
}

public void setContenido(
String contenido) {

 this.contenido =
         contenido;

}

//Sobrescribe el método heredado de la clase Padre.
@Override
public String toString() {

 return "Reporte{" +
         "id=" + id +
         ", administradorId=" +
         administradorId +
         ", tipo='" + tipo + '\'' +
         ", fechaGeneracion=" +
         fechaGeneracion +
         '}';

}
}