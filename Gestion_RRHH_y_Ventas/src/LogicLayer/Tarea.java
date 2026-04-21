package LogicLayer;

public class Tarea {
	  private static int contador = 1;
	    private int idTarea;
	    private String nombre, descripcion, estado;
	    private int progreso, idProyecto, idEmpleadoAsignado;
	    
	    // QUE SERIA ESTO DE PROGRESO?? A QUE SE REFIERE?
	    public Tarea(String nombre, String descripcion, String estado, int progreso, int idProyecto, int idEmpleadoAsignado) {
	    	this.idTarea = contador++;
	    	this.nombre = nombre; this.descripcion = descripcion; this.estado = estado;
	    	this.progreso = progreso; this.idProyecto = idProyecto; this.idEmpleadoAsignado = idEmpleadoAsignado;
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

//		 public void actualizarProgreso(int progreso) { 
		//this.progreso = progreso; 
		//if (progreso >= 100) this.estado = "COMPLETADA"; }
	   

}
