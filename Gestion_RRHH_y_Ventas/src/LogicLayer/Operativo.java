package LogicLayer;

import java.time.LocalDate;
import java.util.LinkedList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Operativo extends Empleado {
private Roles Rol;
private int rendimientoIndividual;
private LinkedList<Tarea> tareasAsignadas;


public Roles getRol() {
	return Rol;
}
public void setRol(Roles rol) {
	Rol = rol;
}
public int getRendimientoIndividual() {
	return rendimientoIndividual;
}
public void setRendimientoIndividual(int rendimientoIndividual) {
	this.rendimientoIndividual = rendimientoIndividual;
}

public LinkedList<Tarea> getTareasAsignadas() {
	return tareasAsignadas;
}
public void setTareasAsignadas(LinkedList<Tarea> tareasAsignadas) {
	this.tareasAsignadas = tareasAsignadas;
}
public Operativo(String nombre, String mail, String contrasenia, String apellido, int dni, double sueldoBase,
		LocalDate fechaContratacion, int faltas, Roles rol, int rendimientoIndividual) {
	super(nombre, mail, contrasenia, apellido, dni, sueldoBase, fechaContratacion, faltas);
	Rol = rol;
	this.rendimientoIndividual = rendimientoIndividual;
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

//CALCULAR OPERACIONES DE LOS RENDIMIENTOS
public double calcularRendimientoIndividual(Operativo ope) {
	
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

	    return (completadas/total)*100;
}

	
}//fin de la clase operativo
