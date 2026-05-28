package LogicLayer;

import java.time.LocalDate;
import java.util.LinkedList;
import javax.swing.JOptionPane;

import DLL.ControllerTarea;
import DLL.ControllerComentario;
import DLL.ControllerEvaluacion;

public class Operativo extends Empleado implements Validador {
private int idOperativo;
private Roles Rol;
private int rendimiento;
private LinkedList<Tarea> tareasAsignadas;
private LinkedList<Evaluacion360> evaluacionesRecibidas;
private static ControllerComentario comentarioController = new ControllerComentario();
private static ControllerTarea tareaController = new ControllerTarea();


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


public int getRendimiento() {
	return rendimiento;
}
public void setRendimiento(int rendimiento) {
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
		LocalDate fechaContratacion, int faltas, Roles rol, int rendimiento) {
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
		LocalDate fechaContratacion, int faltas, int idOperativo, Roles rol, int rendimiento,
		LinkedList<Tarea> tareasAsignadas, LinkedList<Evaluacion360> evaluacionesRecibidas) {
	super(nombre, apellido, mail, contrasenia, dni, sueldoBase, fechaContratacion, faltas);
	this.idOperativo = idOperativo;
	Rol = rol;
	this.rendimiento = rendimiento;
	this.tareasAsignadas =  new LinkedList<>(); 	
	this.evaluacionesRecibidas =  new LinkedList<>();
}


public Operativo(int idOperativo, Roles rol, int rendimiento) {
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
	return "Operativo [idOperativo=" + idOperativo + ", Rol=" + Rol + ", rendimiento=" + rendimiento
			+ ", tareasAsignadas=" + tareasAsignadas + ", evaluacionesRecibidas=" + evaluacionesRecibidas + "]";
}
@Override
public void Menu() {
	
	
	String[] opciones = {
			"Ver informacion personal","Solicitar vacaciones/permisos","Comentar","Cargo","Salir"	
		};
		int opcion;
		do {
			opcion = JOptionPane.showOptionDialog(null, "Bienvenido operativo", "Operativo", 0, 0, null, opciones, opciones);
			switch (opcion) {
			case 0:
				JOptionPane.showMessageDialog(null, "Datos personales\nFaltas\nSueldo\nBonos\nRendimiento");
				break;
			case 1:
				JOptionPane.showMessageDialog(null, "Se solicita vacaciones o permisos");
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
						
						//HAY VALIDAR EN EL FUTURO QUE EL EMPLEADO QUE ESTA REGISTRADO SI ES MIEMBRO
						//Y PONE LIDER LE APAREZCA UN CARTEL DE QUE NO TIENE ESA POSIBILIDAD Y VICEVERSA
						
						switch (elige) {
						case 0:// SI SE ELIGE LIDER
							Roles lider=Roles.LIDER_PROYECTO;
							 String[] subopciones1 = lider.getOpciones();
							 int opcion1;
							 do {
								 opcion1=JOptionPane.showOptionDialog(null, "Realice una accion",
											"Empleado-operativo_lider", 0, 0, null, subopciones1, subopciones1[0]);
								 switch (opcion1) {
//								 
								 
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
											}
										}
									}

									break;
									
									//REGISTRAR TAREA	
								case 1:
									String nombreTarea =
									JOptionPane.showInputDialog(
											"Nombre de la tarea");

							String descripcion =
									JOptionPane.showInputDialog(
											"Descripción");

							int idProyecto =
									Integer.parseInt(
											JOptionPane.showInputDialog(
													"ID proyecto"));

							int idEmpleado =
									Integer.parseInt(
											JOptionPane.showInputDialog(
													"ID empleado asignado"));

							tareaController.crearTarea(
									nombreTarea,
									descripcion,
									idProyecto,
									idEmpleado);

							JOptionPane.showMessageDialog(null,
									"Tarea creada");
							
							//REGISTRAR REUNION
								case 2:
									String nombreReunion =
									JOptionPane.showInputDialog(
											"Nombre de la reunión");

							String fecha =
									JOptionPane.showInputDialog(
											"Fecha");

							JOptionPane.showMessageDialog(
									null,
									"Reunión registrada\n"
									+ nombreReunion
									+ "\nFecha: "
									+ fecha);
							
							
								case 3:// EVALUAR COMPAÑERO
					ControllerEvaluacion ce = new ControllerEvaluacion();
					Operativo empleadoLogueado = this;
					
	LinkedList<Operativo> integrantes= ce.mostrarIntegrantesEquipo(empleadoLogueado.getIdOperativo());
	
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
		   double rendimientoGrupal =evaluado.calcularRendimientoGrupal();
		   
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
							break;
						case 1:// SI SE ELGIGE MIEMBRO
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
											}
										}
									}

									break;
								case 1:
							JOptionPane.showMessageDialog(null, "Ver reuniones que hay");
									break;
								case 2:
								JOptionPane.showMessageDialog(null, "Elegir a un compañero y responder algunas preguntas");
									break;

								
								}
							} while (opcion2!=3);
							break;
						}
	
					}while(elige!=2);
					break;// FIN DEL CASE 3
			}
			}while(opcion!=4);//FIN DEL MENU PRINCIPAL
}

//CALCULAR OPERACIONES DE LOS RENDIMIENTOS
public int calcularRendimientoIndividual() {
	
	 int total = this.tareasAsignadas.size();

	    if(total == 0) {
	    	JOptionPane.showMessageDialog(null, "El operativo no tiene tareas asignadas para poder calcular su rendimiento individual");
	        return 0;
	    }

	    int completadas = 0;

	    for(Tarea t : this.tareasAsignadas) {

	        if(t.getEstado().equalsIgnoreCase("FINALIZADA")) {

	            completadas++;
	        }
	    }
	    return (int)((completadas /total) * 100);
}

//RENDIMIENTO DE EVALUACION 360
public int calcularRendimientoGrupal() {

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
public int calcularRendimientoFinal() {
	
    int individual =calcularRendimientoIndividual();

    int grupal =calcularRendimientoGrupal();
    
    if (individual==0 || grupal==0) {
		JOptionPane.showMessageDialog(null, "El operativo no cumple con algún rendimiennto grupal o invidivual");
		return 0;
	}else {
		
		return this.rendimiento=(individual + grupal) / 2;
	}
}

	
}//fin de la clase operativo
