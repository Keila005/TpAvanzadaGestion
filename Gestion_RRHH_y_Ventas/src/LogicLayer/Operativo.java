package LogicLayer;

import java.time.LocalDate;
import java.util.LinkedList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Operativo extends Empleado {
private Roles Rol;
private int rendimiento;
private int horasExtra;
//private LinkedList<Tarea> tareasAsignadas;

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
public int getHorasExtra() { 
	return horasExtra; 
	}
public void setHorasExtra(int horasExtra) { this.horasExtra = horasExtra; }



public Operativo(String nombre, String apellido, String mail, String contrasenia, int dni, double sueldoBase,
        LocalDate fechaContratacion, int faltas, Roles rol, int rendimiento) {
    super(nombre, apellido, mail, contrasenia, dni, sueldoBase, fechaContratacion, faltas);
    Rol = rol;
    this.rendimiento = rendimiento;
    this.horasExtra = 0;
}


//public void asignarTarea(String nombreTarea, String descripcion, Empleado asignado, Proyecto proyecto) {
//    if (Rol != Roles.LIDER_PROYECTO) {
//        JOptionPane.showMessageDialog(null, "Error: Solo un líder puede asignar tareas.", 
//                                    "Acceso Denegado", JOptionPane.ERROR_MESSAGE);
//        return;
//    }
//    
//    Tarea tarea = new Tarea(nombreTarea, descripcion, "PENDIENTE", 0, 
//                            proyecto.getIdProyecto(), asignado.getDni());
//    proyecto.agregarTarea(tarea);
//    
//  //  if (asignado instanceof Operativo) {
////        ((Operativo) asignado).getTareasAsignadas().add(tarea);
//    }
@Override
public void Menu() {
	
	java.time.LocalTime ahora = java.time.LocalTime.now();
	java.time.LocalDate fechaHoy = java.time.LocalDate.now();
	String hora = ahora.getHour() + ":" + (ahora.getMinute() < 10 ? "0" + ahora.getMinute() : ahora.getMinute());
	String dia = fechaHoy.getDayOfMonth() + "/" + fechaHoy.getMonthValue();
	JOptionPane.showMessageDialog(null, "Fichaje registrado - " + hora + "hs el día " + dia);
	
	String[] opciones = {
			"Ver informacion personal","Solicitar vacaciones/permisos","Comentar","Cargo","Salir"	
		};
		int opcion;
		do {
			opcion = JOptionPane.showOptionDialog(null, "Bienvenido operativo", "Operativo", 0, 0, null, opciones, opciones);
			switch (opcion) {
			case 0:
			    int horasExtraPrueba = 5; // PRUEBA
			    JOptionPane.showMessageDialog(null, "Datos personales\nFaltas\nSueldo: $" + getSueldoBase() + "\nHoras extra: " + horasExtraPrueba + "\nBonos\nRendimiento: " + rendimiento);
			    break;
			case 1:
			    String[] tipos = {"Vacaciones", "Permiso"};
			    int tipo = JOptionPane.showOptionDialog(null, "¿Qué deseas solicitar?", "Solicitud", 0, 0, null, tipos, tipos[0]);
			    if (tipo == -1) break;
			    
			    String fecha = JOptionPane.showInputDialog("Fecha (dd/mm/aaaa):");
			    if (fecha == null || fecha.trim().isEmpty()) {
			        JOptionPane.showMessageDialog(null, "Fecha no válida");
			        break;
			    }
			    
			    if (!fecha.matches("\\d{2}/\\d{2}/\\d{4}")) {
			        JOptionPane.showMessageDialog(null, "Formato incorrecto. Use dd/mm/aaaa");
			        break;
			    }
			    
			    String motivo = JOptionPane.showInputDialog("Motivo:");
			    if (motivo == null || motivo.trim().isEmpty()) {
			        JOptionPane.showMessageDialog(null, "Motivo no válido");
			        break;
			    }
			    
			    JOptionPane.showMessageDialog(null, "Solicitud de " + tipos[tipo] + " enviada");
			    break;
			case 2:
				JOptionPane.showMessageDialog(null, "Escribe un comentario y califica su emocion del 1 al 10");
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
//								 "Visualizar Kanban","Crear tareas","Registrar reunion","Evaluar compañero"
								case 0:
									JOptionPane.showMessageDialog(null, "Se ven las tareas pendientes\nEn procesos\nFinalizados");
									break;
								case 1:
							JOptionPane.showMessageDialog(null, "Crear nombre y descripcion de la tarea");
									break;
								case 2:
								JOptionPane.showMessageDialog(null, "Crear nombre de la reunion y una fecha");
									break;
								case 3:
								JOptionPane.showMessageDialog(null, "Elegir a un compañero y responder algunas preguntas");
									break;

								
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
									JOptionPane.showMessageDialog(null, "Se ven las tareas pendientes\nEn procesos\nFinalizados\nBtn trabajar(en proceso)");
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
}//fin de la clase operativo
