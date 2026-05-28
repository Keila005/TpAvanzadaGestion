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
				"Gestionar empleados","Registrar proyectos","Ver estadisticas del rendimiento","Solicitudes","Horas extras","Gestionar bonos","Ver empleados", "Ver ausencias","Validar asistencia ","Salir"	
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

						}
					} while (opcionVer!=5);
					break;
				case 3:
				    gestionarSolicitudes();
					break;
			case 4:
				String nombre = JOptionPane.showInputDialog("Nombre del empleado:");
			    String apellido = JOptionPane.showInputDialog("Apellido del empleado:");
			    
			    DLL.ControllerAsistencia asis = new DLL.ControllerAsistencia();
			    int idEmpleado = asis.getIdEmpleadoByNombreApellido(nombre, apellido);
			    
			    if (idEmpleado == -1) {
			        JOptionPane.showMessageDialog(null, "Empleado no encontrado");
			    } else {
			        int horas = Integer.parseInt(JOptionPane.showInputDialog("Cantidad de horas extra:"));
			        String motivo = JOptionPane.showInputDialog("Motivo:");
			        asis.registrarHorasExtra(idEmpleado, horas, motivo);
			    }
				break;
			case 5:
			    gestionarBonos();
			    break;
			case 6:
			    verListaEmpleados();
			    break;
			case 7:
			    verAusenciasTodos();
			    break;
			case 8:
			    validarAsistencia();
			    break;


					
				}
			}while(opcion!= 9);
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
	
	public void gestionarBonos() {
	    DLL.ControllerBono cb = new DLL.ControllerBono();
	    
	    java.util.LinkedList<String> empleados = cb.getListaEmpleados();
	    
	    if (empleados.isEmpty()) {
	        JOptionPane.showMessageDialog(null, "No hay empleados registrados");
	        return;
	    }
	    
	    String[] listaEmpleados = empleados.toArray(new String[0]);
	    
	    String seleccionado = (String) JOptionPane.showInputDialog(
	        null,
	        "Seleccione un empleado:",
	        "Asignar Bono",
	        JOptionPane.QUESTION_MESSAGE,
	        null,
	        listaEmpleados,
	        listaEmpleados[0]
	    );
	    
	    if (seleccionado == null) return;
	    
	    int idEmpleado = cb.getIdEmpleadoByNombre(seleccionado);
	    
	    if (idEmpleado == -1) {
	        JOptionPane.showMessageDialog(null, "Empleado no encontrado");
	        return;
	    }
	    
	    double monto = Double.parseDouble(JOptionPane.showInputDialog("Monto del bono:"));
	    String motivo = JOptionPane.showInputDialog("Motivo del bono:");
	    
	    cb.registrarBono(idEmpleado, monto, motivo);
	}
	
	public void gestionarSolicitudes() {
	    DLL.ControllerSolicitud cs = new DLL.ControllerSolicitud();
	    
	    try {
	        java.sql.ResultSet rs = cs.getSolicitudesPendientes();
	        
	        if (rs == null || !rs.isBeforeFirst()) {
	            JOptionPane.showMessageDialog(null, "No hay solicitudes pendientes");
	            return;
	        }
	        
	        String[] mostrar = new String[100];
	        int[] idsMostrar = new int[100];
	        int count = 0;
	        
	        while (rs.next()) {
	            idsMostrar[count] = rs.getInt("id_solicitud");
	            mostrar[count] = rs.getString("nombre") + " " + rs.getString("apellido") +
	                             " - " + rs.getString("tipo") +
	                             " (" + rs.getString("fecha_inicio") + " a " + rs.getString("fecha_fin") + ")";
	            count++;
	        }
	        
	        String[] opcionesFinal = new String[count];
	        int[] idsFinal = new int[count];
	        for (int i = 0; i < count; i++) {
	            opcionesFinal[i] = mostrar[i];
	            idsFinal[i] = idsMostrar[i];
	        }
	        
	        String seleccionado = (String) JOptionPane.showInputDialog(null, "Seleccione una solicitud:", 
	                                "Aprobar/Rechazar", JOptionPane.QUESTION_MESSAGE, null, opcionesFinal, opcionesFinal[0]);
	        
	        if (seleccionado == null) return;
	        
	        int idx = -1;
	        for (int i = 0; i < opcionesFinal.length; i++) {
	            if (opcionesFinal[i].equals(seleccionado)) {
	                idx = i;
	                break;
	            }
	        }
	        
	        if (idx == -1) return;
	        
	        String[] opciones = {"Aprobar", "Rechazar"};
	        int decision = JOptionPane.showOptionDialog(null, "¿Qué desea hacer?", "Decisión",
	                        JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
	        
	        if (decision == 0) {
	            cs.actualizarEstado(idsFinal[idx], "aprobada");
	            JOptionPane.showMessageDialog(null, "Solicitud aprobada");
	        } else if (decision == 1) {
	            cs.actualizarEstado(idsFinal[idx], "rechazada");
	            JOptionPane.showMessageDialog(null, "Solicitud rechazada");
	        }
	        
	    } catch (Exception e) {
	        JOptionPane.showMessageDialog(null, "Error");
	    }
	}
	
	public void verListaEmpleados() {
	    DLL.ControllerRendimiento cr = new DLL.ControllerRendimiento();
	    
	    try {
	        java.sql.ResultSet rs = cr.getListaEmpleados();
	        
	        if (rs == null || !rs.isBeforeFirst()) {
	            JOptionPane.showMessageDialog(null, "No hay empleados registrados");
	            return;
	        }
	        
	        String mensaje = "=== LISTA DE EMPLEADOS ===\n\n";
	        
	        while (rs.next()) {
	            mensaje += "ID: " + rs.getInt("id_empleado") + "\n";
	            mensaje += "Nombre: " + rs.getString("nombre") + " " + rs.getString("apellido") + "\n";
	            mensaje += "Email: " + rs.getString("email") + "\n";
	            mensaje += "DNI: " + rs.getString("dni") + "\n";
	            mensaje += "Sueldo Base: $" + rs.getDouble("sueldo_base") + "\n";
	            mensaje += "------------------------\n";
	        }
	        
	        JOptionPane.showMessageDialog(null, mensaje, "Empleados", JOptionPane.INFORMATION_MESSAGE);
	        
	    } catch (Exception e) {
	        JOptionPane.showMessageDialog(null, "Error al cargar empleados");
	    }
	}
	
	public void verAusenciasTodos() {
	    DLL.ControllerAsistencia asis = new DLL.ControllerAsistencia();
	    
	    try {
	        java.sql.ResultSet rs = asis.getAusenciasTodos();
	        
	        if (rs == null || !rs.isBeforeFirst()) {
	            JOptionPane.showMessageDialog(null, "No hay ausencias registradas");
	            return;
	        }
	        
	        String mensaje = "=== AUSENCIAS DE EMPLEADOS ===\n\n";
	        while (rs.next()) {
	            mensaje += rs.getString("nombre") + " " + rs.getString("apellido") + "\n";
	            mensaje += "Fecha: " + rs.getString("fecha") + "\n";
	            mensaje += "------------------------\n";
	        }
	        
	        JOptionPane.showMessageDialog(null, mensaje, "Ausencias", JOptionPane.INFORMATION_MESSAGE);
	    } catch (Exception e) {
	        JOptionPane.showMessageDialog(null, "Error");
	    }
	}
	
public void validarAsistencia() {
    DLL.ControllerAsistencia asis = new DLL.ControllerAsistencia();
    DLL.ControllerRendimiento cr = new DLL.ControllerRendimiento();
    
    try {
        java.sql.ResultSet rsEmpleados = cr.getListaEmpleados();
        
        if (rsEmpleados == null || !rsEmpleados.isBeforeFirst()) {
            JOptionPane.showMessageDialog(null, "No hay empleados");
            return;
        }
        
        String[] empleados = new String[100];
        int[] idsEmpleados = new int[100];
        int countEmp = 0;
        
        while (rsEmpleados.next()) {
            idsEmpleados[countEmp] = rsEmpleados.getInt("id_empleado");
            empleados[countEmp] = rsEmpleados.getString("nombre") + " " + rsEmpleados.getString("apellido");
            countEmp++;
        }
        
        String[] opcionesEmp = new String[countEmp];
        int[] idsEmpFinal = new int[countEmp];
        for (int i = 0; i < countEmp; i++) {
            opcionesEmp[i] = empleados[i];
            idsEmpFinal[i] = idsEmpleados[i];
        }
        
        String empSeleccionado = (String) JOptionPane.showInputDialog(null, "Seleccione un empleado:", 
                                "Validar Asistencia", JOptionPane.QUESTION_MESSAGE, null, opcionesEmp, opcionesEmp[0]);
        
        if (empSeleccionado == null) return;
        
        int idxEmp = -1;
        for (int i = 0; i < opcionesEmp.length; i++) {
            if (opcionesEmp[i].equals(empSeleccionado)) {
                idxEmp = i;
                break;
            }
        }
        
        if (idxEmp == -1) return;
        
        int idEmpleado = idsEmpFinal[idxEmp];
        
        java.sql.ResultSet rsAsis = asis.getAsistenciasPorEmpleadoSimple(idEmpleado);
        
        if (rsAsis == null || !rsAsis.isBeforeFirst()) {
            JOptionPane.showMessageDialog(null, "No hay asistencias para este empleado");
            return;
        }
        
        String[] asistencias = new String[100];
        int[] idsAsis = new int[100];
        int countAsis = 0;
        
        while (rsAsis.next()) {
            idsAsis[countAsis] = rsAsis.getInt("id_asistencia");
            String entrada = rsAsis.getString("hora_entrada") != null ? rsAsis.getString("hora_entrada") : "sin registro";
            String salida = rsAsis.getString("hora_salida") != null ? rsAsis.getString("hora_salida") : "sin registro";
            asistencias[countAsis] = rsAsis.getString("fecha") + " - Entrada: " + entrada + " - Salida: " + salida;
            countAsis++;
        }
        
        String[] opcionesAsis = new String[countAsis];
        int[] idsAsisFinal = new int[countAsis];
        for (int i = 0; i < countAsis; i++) {
            opcionesAsis[i] = asistencias[i];
            idsAsisFinal[i] = idsAsis[i];
        }
        
        String asisSeleccionada = (String) JOptionPane.showInputDialog(null, "Seleccione una asistencia:", 
                                "Modificar", JOptionPane.QUESTION_MESSAGE, null, opcionesAsis, opcionesAsis[0]);
        
        if (asisSeleccionada == null) return;
        
        int idxAsis = -1;
        for (int i = 0; i < opcionesAsis.length; i++) {
            if (opcionesAsis[i].equals(asisSeleccionada)) {
                idxAsis = i;
                break;
            }
        }
        
        if (idxAsis == -1) return;
        
        int horaEntrada = Integer.parseInt(JOptionPane.showInputDialog("Hora de entrada:"));
        int minutoEntrada = Integer.parseInt(JOptionPane.showInputDialog("Minuto de entrada:"));
        String nuevaEntrada = String.format("%02d:%02d:00", horaEntrada, minutoEntrada);
        
        int horaSalida = Integer.parseInt(JOptionPane.showInputDialog("Hora de salida:"));
        int minutoSalida = Integer.parseInt(JOptionPane.showInputDialog("Minuto de salida:"));
        String nuevaSalida = String.format("%02d:%02d:00", horaSalida, minutoSalida);
        
        asis.actualizarAsistencia(idsAsisFinal[idxAsis], nuevaEntrada, nuevaSalida);
        JOptionPane.showMessageDialog(null, "Asistencia modificada");
        
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error");
    }
}
}
