package LogicLayer;

import java.time.LocalDate;

public class Venta {
	  
	    private int idVenta;
	    private Producto producto;
	    private int cantidad;
	    private double precioUnitario;
	    private double subtotal;
	    private double total;
	    private LocalDate fecha;
	    private int idVendedor;
		
	    
	     
		public int getIdVenta() {
			return idVenta;
		}
		public void setIdVenta(int idVenta) {
			this.idVenta = idVenta;
		}
		
		public Producto getProducto() {
			return producto;
		}
		public void setProducto(Producto producto) {
			this.producto = producto;
		}
		public int getCantidad() {
			return cantidad;
		}
		public void setCantidad(int cantidad) {
			this.cantidad = cantidad;
		}
		public double getPrecioUnitario() {
			return precioUnitario;
		}
		public void setPrecioUnitario(double precioUnitario) {
			this.precioUnitario = precioUnitario;
		}
		public double getSubtotal() {
			return subtotal;
		}
		public void setSubtotal(double subtotal) {
			this.subtotal = subtotal;
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
		public Venta(int idVenta, Producto producto, int cantidad, double precioUnitario, double subtotal, double total,
				LocalDate fecha, int idVendedor) {
			super();
			this.idVenta = idVenta;
			this.producto = producto;
			this.cantidad = cantidad;
			this.precioUnitario = precioUnitario;
			this.subtotal = subtotal;
			this.total = total;
			this.fecha = fecha;
			this.idVendedor = idVendedor;
		}
		
		
		
	    
		
	    
}
