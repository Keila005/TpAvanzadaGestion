package LogicLayer;

import java.time.LocalDate;

public abstract class Empleado extends Usuario {
	
	private int dni;
	private double sueldoBase;
	private LocalDate fechaContratacion;
	private int faltas;
	
	public Empleado() {
		super();
	}

	public Empleado(String nombre, String apellido, String mail, String contrasenia, int dni, double sueldoBase,
			LocalDate fechaContratacion, int faltas) {
		super(nombre, apellido, mail, contrasenia);
		this.dni = dni;
		this.sueldoBase = sueldoBase;
		this.fechaContratacion = fechaContratacion;
		this.faltas = faltas;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public double getSueldoBase() {
		return sueldoBase;
	}

	public void setSueldoBase(double sueldoBase) {
		this.sueldoBase = sueldoBase;
	}

	public LocalDate getFechaContratacion() {
		return fechaContratacion;
	}

	public void setFechaContratacion(LocalDate fechaContratacion) {
		this.fechaContratacion = fechaContratacion;
	}
	public void VerInformacion() {
//		+verDatos();
//		+verSueldo();
//		+verAsistencia();
	}
	public void SolicitarPermiso() {}

	@Override
	public abstract void Menu();
	
	
	
}
