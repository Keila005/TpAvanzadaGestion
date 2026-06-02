package LogicLayer;

import java.time.LocalDate;

public class Stock {	
		private int idStock;
	    private Producto producto;
	    private int cantidad;
	    private LocalDate fecha;
	    private String tipoMovimiento;

	    
	    
	   

	    public Stock(int idStock, Producto producto, int cantidad, LocalDate fecha, String tipoMovimiento) {
			super();
			this.idStock = idStock;
			this.producto = producto;
			this.cantidad = cantidad;
			this.fecha = fecha;
			this.tipoMovimiento = tipoMovimiento;
		}

		public Stock(Producto producto, int cantidad, LocalDate fecha, String tipoMovimiento) {
			super();
			this.producto = producto;
			this.cantidad = cantidad;
			this.fecha = fecha;
			this.tipoMovimiento = tipoMovimiento;
		}
		
		
		
		

		public int getIdStock() {
			return idStock;
		}

		public void setIdStock(int idStock) {
			this.idStock = idStock;
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

		public LocalDate getFecha() {
			return fecha;
		}

		public void setFecha(LocalDate fecha) {
			this.fecha = fecha;
		}

		public String getTipoMovimiento() {
			return tipoMovimiento;
		}

		public void setTipoMovimiento(String tipoMovimiento) {
			this.tipoMovimiento = tipoMovimiento;
		}
	    
	    
	
	
}//fin de clase stock
