package LogicLayer;

import java.util.LinkedList;

import javax.swing.JOptionPane;
import DLL.ControllerOperativo;

public class Administrador extends Usuario{
	 private int idAdmin;
	 private String areaEncargado;
	 private static ControllerOperativo operativoController = new ControllerOperativo();
	 
	 
	
	public Administrador(String nombre, String apellido, String mail, String contrasenia, int idAdmin,
			String areaEncargado) {
		super(nombre, apellido, mail, contrasenia);
		this.idAdmin = idAdmin;
		this.areaEncargado = areaEncargado;
	}
	public int getIdAdmin() {
		return idAdmin;
	}
	public void setIdAdmin(int idAdmin) {
		this.idAdmin = idAdmin;
	}
	
	public String getAreaEncargado() {
		return areaEncargado;
	}
	public void setAreaEncargado(String areaEncargado) {
		this.areaEncargado = areaEncargado;
	}
	
	
	
	@Override
	public String toString() {
		return "Administrador [idAdmin=" + idAdmin + ", areaEncargado=" + areaEncargado
				+ "]";
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
					String[] ver = {
							"Rendimiento:Operativo","Rendimiento:Vendedor","Rendimiento:Productos","Salir"};
					int opcionVer;
					do {
						opcionVer= JOptionPane.showOptionDialog(null, "Elija que rendimiento quiere ver", 
								"Rendimientos", 0, 0, null, ver, ver[0]);
						switch (opcionVer) {
						case 0: // operativos
							 
				LinkedList<Operativo> operativos =operativoController.mostrarOperativos();

					    if(operativos.isEmpty()) {

					        JOptionPane.showMessageDialog(null,"No hay operativos");
					        break;
					    }

					    String[] nombres =new String[operativos.size()];

					    for(int i = 0; i < operativos.size(); i++) {

			nombres[i] =operativos.get(i).getNombre()+ " "+ operativos.get(i).getApellido();
					    }
					    
		String seleccionado =(String) JOptionPane.showInputDialog(null,"Seleccione un operativo",
					   "Rendimiento Operativo",JOptionPane.QUESTION_MESSAGE,null,nombres,nombres[0]
					            );

					    if(seleccionado != null) {

					        Operativo operativoSeleccionado = null;

					        for(Operativo op : operativos) {

					     String nombreCompleto =op.getNombre()+ " "+ op.getApellido();

					            if(nombreCompleto.equals(seleccionado)) {

					                operativoSeleccionado = op;
					                break;
					            }
					        }

					        if(operativoSeleccionado != null) {

					int individual = operativoSeleccionado.calcularRendimientoIndividual();

					int grupal =operativoSeleccionado.calcularRendimientoGrupal();
					
					int  finalRendimiento=operativoSeleccionado.getRendimiento();
					//int finalRendimiento =operativoSeleccionado.calcularRendimientoFinal();

					            JOptionPane.showMessageDialog(
					                    null,
					                    "Empleado: "
					                    + operativoSeleccionado.getNombre()

					                    + "\nRol: "
					                    + operativoSeleccionado.getRol()

					                    + "\n\nRendimiento Individual: "
					                    + individual + "%"

					                    + "\nRendimiento 360°: "
					                    + grupal + "%"

					                    + "\nRendimiento Final: "
					                    + finalRendimiento + "%"
					            );
					        }
					    }
							break;
						case 1: //vendedor
							
							break;
						case 2: // productos
							
							break;

						default:
							break;
						}
					} while (opcionVer!=3);
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
