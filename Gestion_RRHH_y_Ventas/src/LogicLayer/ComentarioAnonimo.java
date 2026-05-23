package LogicLayer;

import java.time.LocalDate;

public class ComentarioAnonimo {
	 	private int idMensaje;
	    private String contenido;
	    private LocalDate fecha;
	    private String sentimiento;
	    private int idReporte;
	    
	    
		public ComentarioAnonimo(int idMensaje, String contenido, LocalDate fecha, String sentimiento, int idReporte) {
			super();
			this.idMensaje = idMensaje;
			this.contenido = contenido;
			this.fecha = fecha;
			this.sentimiento = sentimiento;
			this.idReporte = idReporte;
		}
		
		
		public ComentarioAnonimo(String contenido, LocalDate fecha, String sentimiento) {
			super();
			this.contenido = contenido;
			this.fecha = fecha;
			this.sentimiento = sentimiento;
		}


		public int getIdMensaje() {
			return idMensaje;
		}
		public void setIdMensaje(int idMensaje) {
			this.idMensaje = idMensaje;
		}
		public String getContenido() {
			return contenido;
		}
		public void setContenido(String contenido) {
			this.contenido = contenido;
		}
		public LocalDate getFecha() {
			return fecha;
		}
		public void setFecha(LocalDate fecha) {
			this.fecha = fecha;
		}
		public String getSentimiento() {
			return sentimiento;
		}
		public void setSentimiento(String sentimiento) {
			this.sentimiento = sentimiento;
		}
		public int getIdReporte() {
			return idReporte;
		}
		public void setIdReporte(int idReporte) {
			this.idReporte = idReporte;
		}
		
		@Override
		public String toString() {
			return "ComentarioAnonimo [idMensaje=" + idMensaje + ", contenido=" + contenido + ", fecha=" + fecha
					+ ", sentimiento=" + sentimiento;
		}
	    
	    
}
