package LogicLayer;

import java.time.LocalDate;
import java.util.LinkedList;

public class Venta {
	  
	    private int idVenta;
	    private LinkedList<detalle_venta> detalles;
	    private double total;
	    private LocalDate fecha;
	    private int idVendedor;
		
	    
	     
		public Venta(int idVenta, LinkedList<detalle_venta> detalles, double total, LocalDate fecha, int idVendedor) {
			super();
			this.idVenta = idVenta;
			this.detalles = detalles;
			this.total = total;
			this.fecha = fecha;
			this.idVendedor = idVendedor;
		}
		
		
		public Venta() {

		    this.detalles = new LinkedList<>();
		    this.fecha = LocalDate.now();
		}
		
		
		
		public LinkedList<detalle_venta> getDetalles() {
			return detalles;
		}
		public void setDetalles(LinkedList<detalle_venta> detalles) {
			this.detalles = detalles;
		}
		public int getIdVenta() {
			return idVenta;
		}
		public void setIdVenta(int idVenta) {
			this.idVenta = idVenta;
		}
		
	
		public double getTotal() {
			return total;
		}
		public void setTotal(double total) {
			this.total = total;
		}
		public LocalDate getFecha() {
			return fecha;
		}
		public void setFecha(LocalDate fecha) {
			this.fecha = fecha;
		}
		public int getIdVendedor() {
			return idVendedor;
		}
		public void setIdVendedor(int idVendedor) {
			this.idVendedor = idVendedor;
		}
		
		
		public void agregarDetalle(
		        detalle_venta detalle
		) {

		    detalles.add(detalle);
		}
		
		
		
		public double calcularTotal() {

		    double total = 0;

		    for(detalle_venta d : detalles) {

		        total += d.getSubtotal();
		    }

		    return total;
		}
		
		
		
	    
		
	    
}
