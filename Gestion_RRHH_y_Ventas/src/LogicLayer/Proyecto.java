package LogicLayer;

import java.time.LocalDate;
import java.util.LinkedList;

public class Proyecto {
	private static int contador = 1;
	private int idProyecto;
	private String nombre, descripcion;
	private LocalDate fechaInicio, fechaFin;
	private int idLiderProyecto;
	private LinkedList<Tarea> tareas;
	private LinkedList<Empleado> miembros;

	public Proyecto(String nombre, String descripcion, LocalDate fechaInicio, LocalDate fechaFin) {
		this.idProyecto = contador++;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.tareas = new LinkedList<>();
		this.miembros = new LinkedList<>();
	}
	
	public Proyecto(int idProyecto, String nombre) {
		super();
		this.idProyecto = idProyecto;
		this.nombre = nombre;
	}


	public static int getContador() {
		return contador;
	}

	public static void setContador(int contador) {
		Proyecto.contador = contador;
	}

	public int getIdProyecto() {
		return idProyecto;
	}

	public void setIdProyecto(int idProyecto) {
		this.idProyecto = idProyecto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public LocalDate getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}

	public int getIdLiderProyecto() {
		return idLiderProyecto;
	}

	public void setIdLiderProyecto(int idLiderProyecto) {
		this.idLiderProyecto = idLiderProyecto;
	}

	public LinkedList<Tarea> getTareas() {
		return tareas;
	}

	public void setTareas(LinkedList<Tarea> tareas) {
		this.tareas = tareas;
	}

	public LinkedList<Empleado> getMiembros() {
		return miembros;
	}

	public void setMiembros(LinkedList<Empleado> miembros) {
		this.miembros = miembros;
	}
	
	 public void agregarTarea(Tarea tarea) { 
		 this.tareas.add(tarea); 
		 }


}
