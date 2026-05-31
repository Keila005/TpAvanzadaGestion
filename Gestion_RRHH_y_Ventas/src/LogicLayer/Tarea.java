package LogicLayer;

import javax.swing.JOptionPane;

public class Tarea {
	  private static int contador = 1;
	    private int idTarea;
	    private String nombre, descripcion, estado;
	    private int progreso, idProyecto, idEmpleadoAsignado;
	    private boolean editable;
	    private int sesionesTrabajo;
	    private boolean bloqueada;
	    
	    
	    public Tarea(String nombre, String descripcion, String estado, int progreso, int idProyecto, int idEmpleadoAsignado) {
	    	this.idTarea = contador++;
	    	this.nombre = nombre; this.descripcion = descripcion; this.estado = estado;
	    	this.progreso = progreso; this.idProyecto = idProyecto; this.idEmpleadoAsignado = idEmpleadoAsignado;
	    	this.editable = true;
	    	this.sesionesTrabajo = 0;
	    	this.bloqueada = false;
	    }
	    
	    
	    public Tarea() {
			super();
		}


		public static int getContador() {
			return contador;
		}

		public static void setContador(int contador) {
			Tarea.contador = contador;
		}

		public int getIdTarea() {
			return idTarea;
		}

		public void setIdTarea(int idTarea) {
			this.idTarea = idTarea;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public String getDescripcion() {
			return descripcion;
		}

		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}

		public String getEstado() {
			return estado;
		}

		public void setEstado(String estado) {
			this.estado = estado;
		}

		public int getProgreso() {
			return progreso;
		}

		public void setProgreso(int progreso) {
			this.progreso = progreso;
		}

		public int getIdProyecto() {
			return idProyecto;
		}

		public void setIdProyecto(int idProyecto) {
			this.idProyecto = idProyecto;
		}

		public int getIdEmpleadoAsignado() {
			return idEmpleadoAsignado;
		}

		public void setIdEmpleadoAsignado(int idEmpleadoAsignado) {
			this.idEmpleadoAsignado = idEmpleadoAsignado;
		}
		
		public boolean isEditable() {
			return editable;
		}
		public int getSesionesTrabajo() {
			return sesionesTrabajo;
		}

		public void setSesionesTrabajo(int sesionesTrabajo) {
			this.sesionesTrabajo = sesionesTrabajo;
		}

		public boolean isBloqueada() {
			return bloqueada;
		}

		public void setBloqueada(boolean bloqueada) {
			this.bloqueada = bloqueada;
		}
		
		
		@Override
		public String toString() {
			return "\n-"+nombre + "\nDescripcion:" + descripcion + "\nEstado=" + estado + ", progreso="
					+ progreso + "\n";
		}


		public void trabajar() {

			if(estado.equals("COMPLETADA")) {

				return;
			}

			if(progreso < 100) {

				progreso += 33;
			}

			if(progreso >= 33 &&
					estado.equals("POR_HACER")) {

				estado = "EN_PROCESO";
			}

			if(progreso >= 99) {

				progreso = 100;

				estado = "COMPLETADA";

				editable = false;
			}
		}
		
		public void completarTarea() {

			if(sesionesTrabajo < 3) {

				JOptionPane.showMessageDialog(null,
						"Necesita 3 sesiones de trabajo");

				return;
			}

			estado = "FINALIZADA";

			progreso = 100;

			bloqueada = true;

			JOptionPane.showMessageDialog(null,
					"Tarea completada");
		}
		
//		 public void actualizarProgreso(int progreso) { 
		//this.progreso = progreso; 
		//if (progreso >= 100) this.estado = "COMPLETADA"; }
	   

}
