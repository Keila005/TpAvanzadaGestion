package LogicLayer;

import java.time.LocalDate;
import java.util.LinkedList;
import javax.swing.JOptionPane;

import DLL.ControllerTarea;
import DLL.ControllerComentario;
import DLL.ControllerEvaluacion;
import DLL.ControllerOperativo;
import DLL.ControllerProyecto;
import DLL.ControllerReunion;
import DLL.ControllerAsistenciaReunion;

public class Operativo extends Empleado implements Validador {
private int idOperativo;
private Roles Rol;
private double rendimiento;
private double rendimientoGrupal;
private double rendimientoIndividual;
private LinkedList<Tarea> tareasAsignadas;
private LinkedList<Evaluacion360> evaluacionesRecibidas;
private static ControllerComentario comentarioController = new ControllerComentario();
private static ControllerTarea tareaController = new ControllerTarea();
private static ControllerProyecto proyectoController = new ControllerProyecto();
private static ControllerReunion reunionController = new ControllerReunion();


public int getIdOperativo() {
	return idOperativo;
}
public void setIdOperativo(int idOperativo) {
	this.idOperativo = idOperativo;
}
public Roles getRol() {
	return Rol;
}
public void setRol(Roles rol) {
	Rol = rol;
}


public double getRendimientoGrupal() {
	return rendimientoGrupal;
}
public void setRendimientoGrupal(double rendimientoGrupal) {
	this.rendimientoGrupal = rendimientoGrupal;
}
public double getRendimientoIndividual() {
	return rendimientoIndividual;
}
public void setRendimientoIndividual(double rendimientoIndividual) {
	this.rendimientoIndividual = rendimientoIndividual;
}
public double getRendimiento() {
	return rendimiento;
}
public void setRendimiento(double rendimiento) {
	this.rendimiento = rendimiento;
}
public LinkedList<Tarea> getTareasAsignadas() {
	return tareasAsignadas;
}
public void setTareasAsignadas(LinkedList<Tarea> tareasAsignadas) {
	this.tareasAsignadas = tareasAsignadas;
}

public LinkedList<Evaluacion360> getEvaluacionesRecibidas() {
	return evaluacionesRecibidas;
}
public void setEvaluacionesRecibidas(LinkedList<Evaluacion360> evaluacionesRecibidas) {
	this.evaluacionesRecibidas = evaluacionesRecibidas;
}

public Operativo(String nombre, String mail, String contrasenia, String apellido, int dni, double sueldoBase,
		LocalDate fechaContratacion, int faltas, Roles rol, double rendimiento) {
	super(nombre, mail, contrasenia, apellido, dni, sueldoBase, fechaContratacion, faltas);
	Rol = rol;
	this.rendimiento = rendimiento; //ACA FALTA YA QUE NECESITO TENER EL RENDIMIENTO INDIVIDUAL,
									//EL RENDIMIENTO 360 Y HACER EL PROMEDIO *100
	this.tareasAsignadas = new LinkedList<>();
	this.evaluacionesRecibidas = new LinkedList<>();
}

public Operativo() {
	super();
	   this.tareasAsignadas = new LinkedList<>();
	    this.evaluacionesRecibidas = new LinkedList<>();
}

public Operativo(String nombre, String apellido, String mail, String contrasenia, int dni, double sueldoBase,
		LocalDate fechaContratacion, int faltas, int idOperativo, Roles rol, double rendimiento,
		LinkedList<Tarea> tareasAsignadas, LinkedList<Evaluacion360> evaluacionesRecibidas, int idUsuario) {
	super(nombre, apellido, mail, contrasenia, dni, sueldoBase, fechaContratacion, faltas);
	this.idOperativo = idOperativo;
	Rol = rol;
	this.rendimiento = rendimiento;
	this.tareasAsignadas =  new LinkedList<>(); 	
	this.evaluacionesRecibidas =  new LinkedList<>();
	setIdUsuario(idUsuario);
}


public Operativo(int idOperativo, Roles rol, double rendimiento) {
	super();
	this.idOperativo = idOperativo;
	Rol = rol;
	this.rendimiento = rendimiento;
}

public void agregarEvaluacion(Evaluacion360 e) {

    evaluacionesRecibidas.add(e);
}


@Override
public String toString() {
	return "Operativo:\nID=" + idOperativo + "\nRol=" + Rol + "\nRendimiento=" + rendimiento+" %";
}
@Override
public void Menu() {
	
	
	String[] opciones = {
			"Ver informacion personal","Solicitar vacaciones/permisos","Comentar","Cargo","Salir"	
		};
		int opcion;
		do {
			opcion = JOptionPane.showOptionDialog(null,"Bienvenido operativo: "+ this.getNombre()+" "+this.getApellido(), "Operativo", 0, 0, null, opciones, opciones);
			switch (opcion) {
			case 0:
				String[] personal = {"Ver mi sueldo","Ver ausencias","Rendimiento","Mis datos","Atrás"};
				int elegir;
				do {
					elegir=JOptionPane.showOptionDialog(null, "Ver información personal", "Informacion", 0, 0, null, personal, personal);
					switch (elegir) {
					case 0:
						verSueldo();
						break;
					case 1:
						verAusencias();
						break;
					case 2:
						ControllerEvaluacion ce = new ControllerEvaluacion();

						double individual = calcularRendimientoIndividual();
						double grupal = ce.obtenerRendimientoGrupal(this.getIdOperativo());
						
						String mensaje ="Rendimiento Individual: " + individual + "%\n"
						        + "Rendimiento Grupal: " + grupal + "%\n";

						if(individual == 0 && grupal == 0) {

						    mensaje += "\nAún no hay suficientes actividades o evaluaciones para recalcular el rendimiento."
						             + "\nÚltimo rendimiento registrado: "
						             + this.getRendimiento() + "%";

						} else {

						    mensaje += "\nRendimiento Final: "
						             + calcularRendimientoFinal() + "%";
						}

						JOptionPane.showMessageDialog(null, mensaje);
						break;

					case 3:
						JOptionPane.showMessageDialog(null, this);
						break;
					}
				}while(elegir!=4);

				break;
			case 1:
			    SolicitarPermiso();
				break;
			case 2: //COMENTAR
				String comentario = Validador.ValidarString("Escriba un comentario sobre el clima laboral");
				LocalDate fechaComentario= LocalDate.now();
				String[] sentimientos = {"Positivo","Neutro","Negativo"};

				String sentimiento = (String)JOptionPane.showInputDialog(
				        null,"Seleccione su sentimiento","Comentario Anónimo",
				        JOptionPane.QUESTION_MESSAGE,
				        null,sentimientos,sentimientos[0]
				);
				if(sentimiento != null) {
					comentarioController.agregarComentarios(
							new ComentarioAnonimo(comentario,fechaComentario,sentimiento));
				}
				break;
			case 3:
				String cargo[]= {"Lider del proyecto","Miembro del proyecto","Volver"};
	
					int elige;
					do {
						elige=JOptionPane.showOptionDialog(null, "Ingrese su cargo:",
								"Empleado-operativo", 0, 0, null, cargo, cargo[0]);
									
						switch (elige) {
						case 0:// SI SE ELIGE LIDER
							if (this.Rol.equals(Roles.LIDER_PROYECTO)) {
								Roles lider=Roles.LIDER_PROYECTO;
								 String[] subopciones1 = lider.getOpciones();
								 int opcion1;
								 do {
							//"Visualizar Kanban","Crear tareas","Registrar reunion","Evaluar compañero"
									 opcion1=JOptionPane.showOptionDialog(null, "Realice una accion",
												"Empleado-operativo_lider", 0, 0, null, subopciones1, subopciones1[0]);
									 switch (opcion1) {								 
									 
									 //VISUALIZAR TAREAS && KANBAN
									case 0:
										if(tareasAsignadas.isEmpty()) {

											JOptionPane.showMessageDialog(null,
													"No tiene tareas asignadas");
											break;
										}

										String[] tareas = new String[tareasAsignadas.size()];

										for(int i = 0; i < tareasAsignadas.size(); i++) {

											Tarea t = tareasAsignadas.get(i);

											tareas[i] =
													t.getNombre()
													+ " | "
													+ t.getEstado()
													+ " | "
													+ t.getSesionesTrabajo()
													+ "/3";
										}

										String seleccionada =
												(String) JOptionPane.showInputDialog(
														null,
														"Seleccione una tarea",
														"KANBAN",
														JOptionPane.QUESTION_MESSAGE,
														null,
														tareas,
														tareas[0]);

										if(seleccionada != null) {

											Tarea tareaElegida = null;

											for(Tarea t : tareasAsignadas) {

												String texto =
														t.getNombre()
														+ " | "
														+ t.getEstado()
														+ " | "
														+ t.getSesionesTrabajo()
														+ "/3";

												if(texto.equals(seleccionada)) {

													tareaElegida = t;
													break;
												}
											}

											if(tareaElegida != null) {

												if(tareaElegida.isBloqueada()) {

													JOptionPane.showMessageDialog(null,
															"La tarea está completada");
													break;
												}

												String[] acciones;

												if(tareaElegida.getSesionesTrabajo() >= 3) {

													acciones = new String[] {
															"Trabajar",
															"Completar",
															"Volver"
													};

												} else {

													acciones = new String[] {
															"Trabajar",
															"Volver"
													};
												}

												int accion =
														JOptionPane.showOptionDialog(
																null,
																"TAREA:\n"
																+ tareaElegida.getDescripcion(),
																"KANBAN",
																0,
																0,
																null,
																acciones,
																acciones[0]);

												if(accion == 0) {

													tareaElegida.trabajar();

													tareaController.trabajarTarea(
															tareaElegida.getIdTarea());
												}

												else if(accion == 1
														&& tareaElegida.getSesionesTrabajo() >= 3) {

													tareaElegida.completarTarea();

													tareaController.completarTarea(
															tareaElegida.getIdTarea());
													this.calcularRendimientoFinal();
												}
											}
										}

										break;
										
										//REGISTRAR TAREA	
									case 1:
										String nombreTarea =
										Validador.ValidarString(
												"Nombre de la tarea");

								String descripcion =
										Validador.ValidarString(
												"Descripción");
								
								LinkedList<Proyecto> proyectos =
								        proyectoController.obtenerProyectosLider(this.getIdOperativo());
								String[] nombreProyecto = new String[proyectos.size()];
								
								for(int i = 0; i < proyectos.size(); i++) {
									nombreProyecto[i] = proyectos.get(i).getNombre();
								}
								String seleccionar =
								        (String) JOptionPane.showInputDialog( null,
								                "Seleccione un proyecto",
								                "Proyectos",JOptionPane.QUESTION_MESSAGE, null,nombreProyecto,nombreProyecto[0]
								        );
								int idProyecto = -1;

								for(Proyecto p : proyectos) {

								    if(p.getNombre().equals(seleccionar)) {

								        idProyecto = p.getIdProyecto();
								        break;
								    }
								}
								//LISTA DE EMPLEADOS DEL PROYECTO , NO CUALQUIERA
								
								ControllerOperativo controllerOperativo =new ControllerOperativo();

					LinkedList<Operativo> integrantesProyecto =controllerOperativo.obtenerOperativosProyecto(idProyecto);
					String[] nombresOperativos =
					        new String[integrantesProyecto.size()];

					for(int i = 0; i < integrantesProyecto.size(); i++) {

					    nombresOperativos[i] =integrantesProyecto.get(i).getNombre()
					    		+ " "+ integrantesProyecto.get(i).getApellido();
					}
					String select =(String) JOptionPane.showInputDialog(
					                null,"Seleccione un operativo",
					                "Asignar tarea",JOptionPane.QUESTION_MESSAGE,
					                null,nombresOperativos,nombresOperativos[0]);
					int idEmpleado = -1;

					for(Operativo op : integrantesProyecto) {

					    String nombreCompleto =
					            op.getNombre()+ " "+ op.getApellido();

					    if(nombreCompleto.equals(select)) {

					        idEmpleado = op.getIdOperativo();
					        break;
					    }
					}
								
								tareaController.crearTarea(
										nombreTarea,
										descripcion,
										idProyecto,
										idEmpleado);

								JOptionPane.showMessageDialog(null,
										"Tarea creada");
								break;
								//REGISTRAR REUNION
									case 2:

									    String titulo =
									            Validador.ValidarString(
									                    "Título de la reunión");

									    String descripcionReunion =
									            Validador.ValidarString(
									                    "Descripción");

									    LinkedList<Proyecto> proyectosReunion =
									            proyectoController.obtenerProyectosLider(
									                    this.getIdOperativo());

									    if(proyectosReunion.isEmpty()) {

									        JOptionPane.showMessageDialog(
									                null,
									                "No tiene proyectos asignados");

									        break;
									    }

									    String[] nombresProyecto =
									            new String[proyectosReunion.size()];

									    for(int i = 0; i < proyectosReunion.size(); i++) {

									        nombresProyecto[i] =
									                proyectosReunion.get(i).getNombre();
									    }

									    String seleccionadoProyecto =
									            (String) JOptionPane.showInputDialog(
									                    null,
									                    "Seleccione un proyecto",
									                    "Proyecto",
									                    JOptionPane.QUESTION_MESSAGE,
									                    null,
									                    nombresProyecto,
									                    nombresProyecto[0]);

									    if(seleccionadoProyecto == null) {
									        break;
									    }

									    int idProyectoReunion = -1;

									    for(Proyecto p : proyectosReunion) {

									        if(p.getNombre().equals(seleccionadoProyecto)) {

									            idProyectoReunion =
									                    p.getIdProyecto();

									            break;
									        }
									    }

									    LocalDate fechaReunion =
									            LocalDate.parse(
									                    JOptionPane.showInputDialog(
									                            "Fecha (AAAA-MM-DD)")
									            );

									    reunionController.crearReunion(titulo, fechaReunion, idProyectoReunion);

									    JOptionPane.showMessageDialog(
									            null,
									            "Reunión registrada correctamente");

									    break;
									case 3:// EVALUAR COMPAÑERO
						ControllerEvaluacion ce = new ControllerEvaluacion();
						Operativo empleadoLogueado = this;
						
		LinkedList<Operativo> integrantes= ce.mostrarIntegrantesEquipo(empleadoLogueado.getIdOperativo());
		if(integrantes.isEmpty()) {

		    JOptionPane.showMessageDialog(null,"No hay compañeros para evaluar");
		    break;
		}
		  String nombres[] = new String[integrantes.size()];

	      for(int i = 0; i < integrantes.size(); i++) {

	          nombres[i] =integrantes.get(i).getNombre() + " " + integrantes.get(i).getApellido();
	      }
	   
	      String seleccionado = (String) JOptionPane.showInputDialog(
	    null, "Seleccione un integrante del equipo","Evaluacion 360", JOptionPane.QUESTION_MESSAGE, null,nombres,nombres[0]);
	      
	      if (seleccionado!=null) {
			Operativo evaluado= null;
			
			for(Operativo op : integrantes) { 
				String nombreCompleto = op.getNombre() + " " + op.getApellido(); 		
				if(nombreCompleto.equals(seleccionado)) { 
					evaluado = op; 
					if(evaluado != null) {

			    	    int[] respuestas = new int[10];

			    	    String[] preguntas = {
			    	        "¿Cumple sus tareas a tiempo?",
			    	        "¿Asiste regularmente al trabajo grupal?",
			    	        "¿Apoya a sus compañeros cuando es necesario?",
			    	        "¿Se comunica de forma clara?",
			    	        "¿Escucha y respeta las opiniones de otros?",
			    	        "¿Muestra iniciativa en su trabajo?",
			    	        "¿Se adapta a cambios en el proyecto?",
			    	        "¿Mantiene una actitud responsable?",
			    	        "¿Cumple con su rol dentro del equipo?",
			    	        "¿Contribuye positivamente al resultado del proyecto?"
			    	    };

			    	    for(int i = 0; i < preguntas.length; i++) {

			    	        int btn = JOptionPane.showConfirmDialog(
			    	                null,
			    	                preguntas[i],
			    	                "Evaluación 360",
			    	                JOptionPane.YES_NO_OPTION
			    	        );

			    	        if(btn == JOptionPane.YES_OPTION) {
			    	            respuestas[i] = 1;
			    	        } else {
			    	            respuestas[i] = 0;
			    	        }
			    	    }
			    	    String comentariOpcional= JOptionPane.showInputDialog("Ingrese algún comentario adicional");
	 Evaluacion360 evaluacion =new Evaluacion360(empleadoLogueado, evaluado, respuestas,comentariOpcional);
			   evaluado.agregarEvaluacion(evaluacion);
			   ce.guardarEvaluacion(evaluacion);
//
//			   evaluado.setRendimientoGrupal(evaluado.calcularRendimientoGrupal());
//
//			   evaluado.calcularRendimientoFinal();
			   
			   JOptionPane.showMessageDialog( null, "Evaluación realizada correctamente" +"\nEvaluado: "
				        + evaluado.getNombre() + "\nPuntaje otorgado: "
				        + evaluacion.getPuntajeTotal()+ "/10"
				);

				//break;// si hay un evaluado termina de contestar y sale
				}
			}
		}
	      
	    	}// SI SELECCIONO UN NOMBRE
	      else {
				JOptionPane.showMessageDialog(null, "No se selecciono a nadie");
			}
	     
										break;// del caso 3

									
									}
								} while (opcion1!=4);

							}else {
								JOptionPane.showMessageDialog(null, "Su cargo no corresponde a  este puesto");
							}
														break;
						case 1:// SI SE ELGIGE MIEMBRO
							if (this.Rol.equals(Roles.MIEMBRO_PROYECTO)) {
								Roles miembro=Roles.MIEMBRO_PROYECTO;
								 String[] subopciones2 = miembro.getOpciones();
								 int opcion2;
								 do {
									 opcion2=JOptionPane.showOptionDialog(null, "Realice una accion",
												"Empleado-operativo_Miembro", 0, 0, null, subopciones2, subopciones2[0]);
									 switch (opcion2) {

									case 0:
										if(tareasAsignadas.isEmpty()) {

											JOptionPane.showMessageDialog(null,
													"No tiene tareas asignadas");
											break;
										}

										String[] tareas = new String[tareasAsignadas.size()];

										for(int i = 0; i < tareasAsignadas.size(); i++) {

											Tarea t = tareasAsignadas.get(i);

											tareas[i] =
													t.getNombre()
													+ " | "
													+ t.getEstado()
													+ " | "
													+ t.getSesionesTrabajo()
													+ "/3";
										}

										String seleccionada =
												(String) JOptionPane.showInputDialog(
														null,
														"Seleccione una tarea",
														"KANBAN",
														JOptionPane.QUESTION_MESSAGE,
														null,
														tareas,
														tareas[0]);

										if(seleccionada != null) {

											Tarea tareaElegida = null;

											for(Tarea t : tareasAsignadas) {

												String texto =
														t.getNombre()
														+ " | "
														+ t.getEstado()
														+ " | "
														+ t.getSesionesTrabajo()
														+ "/3";

												if(texto.equals(seleccionada)) {

													tareaElegida = t;
													break;
												}
											}

											if(tareaElegida != null) {

												if(tareaElegida.isBloqueada()) {

													JOptionPane.showMessageDialog(null,
															"La tarea está completada");
													break;
												}

												String[] acciones;

												if(tareaElegida.getSesionesTrabajo() >= 3) {

													acciones = new String[] {
															"Trabajar",
															"Completar",
															"Volver"
													};

												} else {

													acciones = new String[] {
															"Trabajar",
															"Volver"
													};
												}

												int accion =
														JOptionPane.showOptionDialog(
																null,
																"TAREA:\n"
																+ tareaElegida.getDescripcion(),
																"KANBAN",
																0,
																0,
																null,
																acciones,
																acciones[0]);

												if(accion == 0) {

													tareaElegida.trabajar();

													tareaController.trabajarTarea(
															tareaElegida.getIdTarea());
												}

												else if(accion == 1
														&& tareaElegida.getSesionesTrabajo() >= 3) {

													tareaElegida.completarTarea();

													tareaController.completarTarea(
															tareaElegida.getIdTarea());
													this.calcularRendimientoFinal();
												}
											}
										}

										break;
									case 1:

									    ControllerReunion cr = new ControllerReunion();
									    ControllerAsistenciaReunion car =
									            new ControllerAsistenciaReunion();

									    LinkedList<Proyecto> proyectos =
									            proyectoController.obtenerProyectosMiembro(
									                    this.getIdOperativo());

									    if(proyectos.isEmpty()) {

									        JOptionPane.showMessageDialog(
									                null,
									                "No tiene proyectos asignados");

									        break;
									    }

									    String[] nombresProyectos =
									            new String[proyectos.size()];

									    for(int i = 0; i < proyectos.size(); i++) {

									        nombresProyectos[i] =
									                proyectos.get(i).getNombre();
									    }

									    String proyectoSeleccionado =
									            (String) JOptionPane.showInputDialog(
									                    null,
									                    "Seleccione un proyecto",
									                    "Proyectos",
									                    JOptionPane.QUESTION_MESSAGE,
									                    null,
									                    nombresProyectos,
									                    nombresProyectos[0]);

									    if(proyectoSeleccionado == null) {
									        break;
									    }

									    int idProyecto = -1;

									    for(Proyecto p : proyectos) {

									        if(p.getNombre().equals(
									                proyectoSeleccionado)) {

									            idProyecto = p.getIdProyecto();
									            break;
									        }
									    }

									    LinkedList<Reunion> reuniones =
									            cr.obtenerReunionesProyecto(
									                    idProyecto);

									    if(reuniones.isEmpty()) {

									        JOptionPane.showMessageDialog(
									                null,
									                "No hay reuniones");

									        break;
									    }

									    String[] opcionesReunion =
									            new String[reuniones.size()];

									    for(int i = 0; i < reuniones.size(); i++) {

									        opcionesReunion[i] =
									                reuniones.get(i).getTitulo();
									    }

									    String reunionSeleccionada =
									            (String) JOptionPane.showInputDialog(
									                    null,
									                    "Seleccione una reunión",
									                    "Reuniones",
									                    JOptionPane.QUESTION_MESSAGE,
									                    null,
									                    opcionesReunion,
									                    opcionesReunion[0]);

									    if(reunionSeleccionada == null) {
									        break;
									    }

									    int idReunion = -1;

									    for(Reunion r : reuniones) {

									        if(r.getTitulo().equals(
									                reunionSeleccionada)) {

									            idReunion = r.getIdReunion();
									            break;
									        }
									    }

									    car.registrarAsistencia(
									            idReunion,
									            this.getIdOperativo());

									    JOptionPane.showMessageDialog(
									            null,
									            "Asistencia registrada");

									    break;
									case 2:
										ControllerEvaluacion ce = new ControllerEvaluacion();
										Operativo empleadoLogueado = this;
										
						LinkedList<Operativo> integrantes= ce.mostrarIntegrantesEquipo(empleadoLogueado.getIdOperativo());
						if(integrantes.isEmpty()) {

						    JOptionPane.showMessageDialog(null,"No hay compañeros para evaluar");
						    break;
						}
						  String nombres[] = new String[integrantes.size()];

					      for(int i = 0; i < integrantes.size(); i++) {

					          nombres[i] =integrantes.get(i).getNombre() + " " + integrantes.get(i).getApellido();
					      }
					   
					      String seleccionado = (String) JOptionPane.showInputDialog(
					    null, "Seleccione un integrante del equipo","Evaluacion 360", JOptionPane.QUESTION_MESSAGE, null,nombres,nombres[0]);
					      
					      if (seleccionado!=null) {
							Operativo evaluado= null;
							
							
							for(Operativo op : integrantes) { 
								String nombreCompleto = op.getNombre() + " " + op.getApellido(); 		
								if(nombreCompleto.equals(seleccionado)) { 
									evaluado = op; 
									if(evaluado != null) {

							    	    int[] respuestas = new int[10];

							    	    String[] preguntas = {
							    	        "¿Cumple sus tareas a tiempo?",
							    	        "¿Asiste regularmente al trabajo grupal?",
							    	        "¿Apoya a sus compañeros cuando es necesario?",
							    	        "¿Se comunica de forma clara?",
							    	        "¿Escucha y respeta las opiniones de otros?",
							    	        "¿Muestra iniciativa en su trabajo?",
							    	        "¿Se adapta a cambios en el proyecto?",
							    	        "¿Mantiene una actitud responsable?",
							    	        "¿Cumple con su rol dentro del equipo?",
							    	        "¿Contribuye positivamente al resultado del proyecto?"
							    	    };

							    	    for(int i = 0; i < preguntas.length; i++) {

							    	        int btn = JOptionPane.showConfirmDialog(
							    	                null,
							    	                preguntas[i],
							    	                "Evaluación 360",
							    	                JOptionPane.YES_NO_OPTION
							    	        );

							    	        if(btn == JOptionPane.YES_OPTION) {
							    	            respuestas[i] = 1;
							    	        } else {
							    	            respuestas[i] = 0;
							    	        }
							    	    }
							    	    String comentariOpcional= JOptionPane.showInputDialog("Ingrese algún comentario adicional");
					 Evaluacion360 evaluacion =new Evaluacion360(empleadoLogueado, evaluado, respuestas,comentariOpcional);
							   evaluado.agregarEvaluacion(evaluacion);
							   ce.guardarEvaluacion(evaluacion);

//							   evaluado.setRendimientoGrupal(evaluado.calcularRendimientoGrupal());
//
//							   evaluado.calcularRendimientoFinal();
							   
							   JOptionPane.showMessageDialog( null, "Evaluación realizada correctamente" +"\nEvaluado: "
								        + evaluado.getNombre() + "\nPuntaje otorgado: "
								        + evaluacion.getPuntajeTotal()+ "/10"
								);

								//break;// si hay un evaluado termina de contestar y sale
								}
							}
						}
					      
					    	}// SI SELECCIONO UN NOMBRE
					      else {
								JOptionPane.showMessageDialog(null, "No se selecciono a nadie");
							}
										    break;
										

									
									}
								} while (opcion2!=3); // FIN DE LA OPCION DEL MIEMBRO

							}else {
								JOptionPane.showMessageDialog(null, "Usted no corresponde a este cargo");
							}
						break;
						}//FIN  DEL SWITCH SOBRE SU CARGO
	
					}while(elige!=2);
					break;// FIN DEL CASE 3
			}
			}while(opcion!=4);//FIN DEL MENU PRINCIPAL
}

//CALCULAR OPERACIONES DE LOS RENDIMIENTOS
public double calcularRendimientoIndividual() {
	
	 int total = this.tareasAsignadas.size();

	    if(total == 0) {
	    	return 0;
	    }

	    int completadas = 0;

	    for(Tarea t : this.tareasAsignadas) {

	        if(t.getEstado().equalsIgnoreCase("FINALIZADA")) {

	            completadas++;
	        }
	    }
	    return ((double) completadas / total) * 100;
}

//RENDIMIENTO DE EVALUACION 360
public double calcularRendimientoGrupal() {

    if(evaluacionesRecibidas.isEmpty()) {

    	JOptionPane.showMessageDialog(null, "Nadie hizo la evaluacion 360°");
        return 0;   

    }

    int suma = 0;

    for(Evaluacion360 e : evaluacionesRecibidas) {

        suma += e.getPuntajeTotal();
    }

    int promedio =suma/evaluacionesRecibidas.size();

    return (int) ((promedio / 10.0) * 100);
}

//RENDIMIENTO DE LOS DOS TIPOS JUNTOS

public double calcularRendimientoFinal() {
    ControllerEvaluacion ce = new ControllerEvaluacion();

    double individual = calcularRendimientoIndividual();
    double grupal = ce.obtenerRendimientoGrupal(this.idOperativo);

    this.rendimiento = (individual + grupal) / 2;

    return this.rendimiento;
}

	
}//fin de la clase operativo
