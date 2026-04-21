package LogicLayer;

import java.time.LocalDate;

public class Venta {
	  private static int contador = 1;
	    private int idVenta;
	    private String prenda;
	    private int cantidad;
	    private double precioUnitario;
	    private LocalDate fecha;
	    private int idVendedor;
	    
	    
		public Venta(String prenda, int cantidad, double precioUnitario, LocalDate fecha, int idVendedor) {
			super();
			this.idVenta = contador++;;
			this.prenda = prenda;
			this.cantidad = cantidad;
			this.precioUnitario = precioUnitario;
			this.fecha = fecha;
			this.idVendedor = idVendedor;
		}
		public static int getContador() {
			return contador;
		}
		public static void setContador(int contador) {
			Venta.contador = contador;
		}
		public int getIdVenta() {
			return idVenta;
		}
		public void setIdVenta(int idVenta) {
			this.idVenta = idVenta;
		}
		public String getPrenda() {
			return prenda;
		}
		public void setPrenda(String prenda) {
			this.prenda = prenda;
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
	    
}
