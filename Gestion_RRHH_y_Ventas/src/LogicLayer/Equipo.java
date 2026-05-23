package LogicLayer;

public class Equipo {
private int id_equipo;
private String nombre;
private int id_lider;
public int getId_equipo() {
	return id_equipo;
}
public void setId_equipo(int id_equipo) {
	this.id_equipo = id_equipo;
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public int getId_lider() {
	return id_lider;
}
public void setId_lider(int id_lider) {
	this.id_lider = id_lider;
}
@Override
public String toString() {
	return "Equipo [id_equipo=" + id_equipo + ", nombre=" + nombre + ", id_lider=" + id_lider + "]";
}


}
