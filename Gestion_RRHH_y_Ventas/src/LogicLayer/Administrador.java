package LogicLayer;

import javax.swing.JOptionPane;

public class Administrador extends Usuario{
	 private int idAdmin;
	 private String apellido;
	 private String areaEncargado;
	 
	 
	public Administrador(String nombre, String mail, String contrasenia, int idAdmin, String apellido,
			String areaEncargado) {
		super(nombre, mail, contrasenia);
		this.idAdmin = idAdmin;
		this.apellido = apellido;
		this.areaEncargado = areaEncargado;
	}
	public int getIdAdmin() {
		return idAdmin;
	}
	public void setIdAdmin(int idAdmin) {
		this.idAdmin = idAdmin;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getAreaEncargado() {
		return areaEncargado;
	}
	public void setAreaEncargado(String areaEncargado) {
		this.areaEncargado = areaEncargado;
	}
	@Override
	public void Menu() {
		String[] opciones = {
				"Gestionar empleados","Registrar proyectos","Ver estadisticas del rendimiento","Solicitudes","Horas extras","Salir"	
			};
			int opcion;
			do {
				opcion = JOptionPane.showOptionDialog(null, "Bienvenido administardor", "", 0, 0, null, opciones, opciones);
				switch (opcion) {
				case 0:
					JOptionPane.showMessageDialog(null, "Ver datos del empleado\nEditar datos del empleado");
					break;
				case 1:
					JOptionPane.showMessageDialog(null, "Crear nuevo proyecto(se define nombre, asignacion de lider y fecha)\nVer proyecto existentes");
					break;
				case 2:
					JOptionPane.showMessageDialog(null, "Rendimiento Operativo\nRendimiento vendedor\nRendimiento de productos");
					break;
				case 3:
					JOptionPane.showMessageDialog(null, "Aceptar\nRechazar");
					break;
			case 4:
				JOptionPane.showMessageDialog(null, "Busca al empleado y le asigna las horas extras trabajadas, para calcular el sueldo");
				break;
					
				}
			}while(opcion!=5);
	}
	 
	
}
