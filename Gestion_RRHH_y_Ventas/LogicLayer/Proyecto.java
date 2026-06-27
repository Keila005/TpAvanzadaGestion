package LogicLayer;

import java.util.Date;
import java.util.LinkedList;

public class Proyecto {
	private static int contador = 1;
	private int idProyecto;
	private String nombre, descripcion;
	private Date fechaInicio, fechaFin;
	private int idLiderProyecto;
	private int idEquipo;
	private LinkedList<Tarea> tareas;
	private LinkedList<Empleado> miembros;
	private String lider;
	private String equipo;

	public Proyecto(String nombre, String descripcion, Date fechaInicio, Date fechaFin) {
		this.idProyecto = contador++;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.tareas = new LinkedList<>();
		this.miembros = new LinkedList<>();
	}
	
	public String getLider() {
		return lider;
	}

	public void setLider(String lider) {
		this.lider = lider;
	}

	public String getEquipo() {
		return equipo;
	}

	public void setEquipo(String equipo) {
		this.equipo = equipo;
	}

	public Proyecto(int idProyecto, String nombre, String descripcion, Date fechaInicio, Date fechaFin, String lider,
			String equipo) {
		super();
		this.idProyecto = idProyecto;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.lider = lider;
		this.equipo = equipo;
	}

	public Proyecto(int idProyecto, String nombre, String descripcion, Date fechaInicio, Date fechaFin,
			int idLiderProyecto, int idEquipo) {
		super();
		this.idProyecto = idProyecto;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.idLiderProyecto = idLiderProyecto;
		this.idEquipo = idEquipo;
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

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public int getIdLiderProyecto() {
		return idLiderProyecto;
	}

	public void setIdLiderProyecto(int idLiderProyecto) {
		this.idLiderProyecto = idLiderProyecto;
	}

	public int getIdEquipo() {
		return idEquipo;
	}

	public void setIdEquipo(int idEquipo) {
		this.idEquipo = idEquipo;
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

	 @Override
	 public String toString() {
	     return nombre;
	 }

}
