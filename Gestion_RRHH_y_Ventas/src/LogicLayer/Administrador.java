package LogicLayer;

import java.time.LocalDate;
import java.util.LinkedList;

import javax.swing.JOptionPane;

import DLL.ControllerComentario;
import DLL.ControllerOperativo;
import DLL.ControllerProyecto;
import DLL.ControllerUsuario;
import DLL.ControllerRendimiento;

public class Administrador extends Usuario{
	 private int idAdmin;
	 private String areaEncargado;
	 private static ControllerOperativo operativoController = new ControllerOperativo();
	 private static ControllerComentario comentarioController = new ControllerComentario();
	 private static ControllerUsuario usuarioController = new ControllerUsuario();
	 private static ControllerProyecto proyectoController = new ControllerProyecto();
	 
	 
	
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
	
	
//	==CRUD==
	
	public void crearEmpleado() {

	    String[] tipos = {"Operativo", "Vendedor"};

	    int tipo = JOptionPane.showOptionDialog(
	            null,
	            "Seleccione tipo de empleado",
	            "Nuevo empleado",
	            0,
	            0,
	            null,
	            tipos,
	            tipos[0]);

	    String nombre = JOptionPane.showInputDialog("Nombre:");
	    String apellido = JOptionPane.showInputDialog("Apellido:");
	    String mail = JOptionPane.showInputDialog("Mail:");
	    String contrasenia = JOptionPane.showInputDialog("Contraseña:");

	    int dni = Integer.parseInt(
	            JOptionPane.showInputDialog("DNI:")
	    );

	    double sueldoBase = Double.parseDouble(
	            JOptionPane.showInputDialog("Sueldo base:")
	    );

	    if(tipo == 0) {

	        String[] roles = {"Lider de Proyecto", "Miembro de Proyecto"};

	        int rolElegido = JOptionPane.showOptionDialog(
	                null,
	                "Seleccione rol",
	                "Rol",
	                0,
	                0,
	                null,
	                roles,
	                roles[0]);

	        String rol;

	        if(rolElegido == 0) {
	            rol = "Lider de Proyecto";
	        } else {
	            rol = "Miembro de Proyecto";
	        }

	        usuarioController.crearOperativo(
	                nombre,
	                apellido,
	                mail,
	                contrasenia,
	                dni,
	                sueldoBase,
	                rol
	        );

	    } else {

	        double comision = Double.parseDouble(
	                JOptionPane.showInputDialog("Comisión:")
	        );

	        usuarioController.crearVendedor(
	                nombre,
	                apellido,
	                mail,
	                contrasenia,
	                dni,
	                sueldoBase,
	                comision
	        );
	    }

	    JOptionPane.showMessageDialog(null,
	            "Empleado creado correctamente");
	}

	public void modificarEmpleado() {
		int idEmpleado = Integer.parseInt(JOptionPane.showInputDialog("Ingrese ID del empleado"));
		String nuevoMail = JOptionPane.showInputDialog("Nuevo Mail:");
		double nuevoSueldo = Double.parseDouble(JOptionPane.showInputDialog("Nuevo sueldo:"));
		
		usuarioController.modificarEmpleado(
				idEmpleado,
				nuevoMail,
				nuevoSueldo
				);
		
		JOptionPane.showMessageDialog(null,
	            "Empleado modificado correctamente");
		
		
	}
	
	public void eliminarEmpleado() {

	    int idEmpleado = Integer.parseInt(
	            JOptionPane.showInputDialog("Ingrese ID del empleado")
	    );

	    usuarioController.eliminarEmpleado(idEmpleado);

	    JOptionPane.showMessageDialog(null,
	            "Empleado eliminado");
	}	
		
	
	public void crearProyecto() {

	    String nombre =
	            JOptionPane.showInputDialog("Nombre proyecto");

	    String descripcion =
	            JOptionPane.showInputDialog("Descripción");

	    int idLider = Integer.parseInt(
	            JOptionPane.showInputDialog("ID líder")
	    );

	    int idEquipo = Integer.parseInt(
	            JOptionPane.showInputDialog("ID equipo")
	    );

	    proyectoController.crearProyecto(
	            nombre,
	            descripcion,
	            LocalDate.now(),
	            LocalDate.now().plusMonths(1),
	            idLider,
	            idEquipo
	    );

	    JOptionPane.showMessageDialog(null,
	            "Proyecto creado");
	}
	
	
	
	
	@Override
	public void Menu() {
		String[] opciones = {
				"Gestionar empleados","Registrar proyectos","Ver estadisticas del rendimiento","Solicitudes","Horas extras","Salir"	
			};
			int opcion;
			do {
				opcion = JOptionPane.showOptionDialog(null, "Bienvenido administrador", "", 0, 0, null, opciones, opciones);
				switch (opcion) {
				case 0:

					String[] gestion = {
							"Crear empleado",
							"Modificar empleado",
							"Eliminar empleado",
							"Volver"
					};

					int opcionGestion;

					do {

						opcionGestion = JOptionPane.showOptionDialog(
								null,
								"Gestión de empleados",
								"Administrador",
								0,
								0,
								null,
								gestion,
								gestion[0]);

						switch (opcionGestion) {

						case 0:

							crearEmpleado();

							break;

						case 1:

							modificarEmpleado();

							break;

						case 2:

							eliminarEmpleado();

							break;
						}

					} while(opcionGestion != 3);

					break;
				case 1:  

					String[] proyectos = {
							"Crear proyecto",
							"Asignar líder",
							"Volver"
					};

					int opcionProyecto;

					do {

						opcionProyecto = JOptionPane.showOptionDialog(
								null,
								"Gestión de proyectos",
								"Administrador",
								0,
								0,
								null,
								proyectos,
								proyectos[0]);

						switch (opcionProyecto) {

						case 0:

							crearProyecto();

							break;

						case 1:

							int idProyecto = Integer.parseInt(
									JOptionPane.showInputDialog("ID proyecto")
							);

							int idLider = Integer.parseInt(
									JOptionPane.showInputDialog("Nuevo líder")
							);

							proyectoController.asignarLider(
									idProyecto,
									idLider
							);

							JOptionPane.showMessageDialog(null,
									"Líder asignado correctamente");

							break;
						}

					} while(opcionProyecto != 2);

					break;
				case 2:
					
					String[] ver = {"Rendimiento:Operativo","Rendimiento:Vendedor",
							"Rendimiento:Productos","Clima laboral","Ranking Operativos","Salir"};
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
						case 3: // comentarios
			LinkedList<ComentarioAnonimo> comentarios =comentarioController.verComentarios();

					    if(comentarios.isEmpty()) {

					        JOptionPane.showMessageDialog(null,"No hay comentarios registrados");

					    } else {
					        String mensaje = "Comentarios laborales:\n";

					        for(ComentarioAnonimo c : comentarios) {

					     mensaje += "Comentario: " + c.getContenido()+ "\nFecha: " + c.getFecha()
					             + "\nSentimiento: " + c.getSentimiento()
					               + "\n----------------------\n";
					        }

					        JOptionPane.showMessageDialog(null, mensaje);
					        
					        String reporte = comentarioController.generarReporteClima();

					        JOptionPane.showMessageDialog(null, reporte);
					    }
							break;
						case 4:
							verRankingOperativos();
							break;

						default:
							break;
						}
					} while (opcionVer!=5);
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
	
	public void verRankingOperativos() {
	    DLL.ControllerRendimiento cr = new DLL.ControllerRendimiento();
	    LinkedList<Operativo> operativos = cr.getTodosOperativos();
	    
	    if (operativos.isEmpty()) {
	        JOptionPane.showMessageDialog(null, "No hay operativos registrados");
	        return;
	    }
	    
	    String mensaje = "=== RANKING DE RENDIMIENTO ===\n\n";
	    for (int i = 0; i < operativos.size(); i++) {
	        Operativo op = operativos.get(i);
	        mensaje += (i + 1) + ". " + op.getNombre() + " " + op.getApellido();
	        mensaje += " - Rendimiento: " + op.getRendimiento() + "%\n";
	    }
	    
	    JOptionPane.showMessageDialog(null, mensaje, "Rendimiento Operativos", JOptionPane.INFORMATION_MESSAGE);
	}
	
}
