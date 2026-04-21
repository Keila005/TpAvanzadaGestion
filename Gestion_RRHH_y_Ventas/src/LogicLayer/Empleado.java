package LogicLayer;

import java.time.LocalDate;

public abstract class Empleado extends Usuario {
	private String apellido; 
	private int dni;
	private double sueldoBase;
	private LocalDate fechaContratacion;
	private int faltas;
	
public Empleado(String nombre, String mail, String contrasenia, String apellido, int dni, double sueldoBase,
			LocalDate fechaContratacion, int faltas) {
		super(nombre, mail, contrasenia);
		this.apellido = apellido;
		this.dni = dni;
		this.sueldoBase = sueldoBase;
		this.fechaContratacion = fechaContratacion;
		this.faltas = faltas;
	}

	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
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
