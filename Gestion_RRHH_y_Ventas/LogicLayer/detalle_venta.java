package LogicLayer;

public class detalle_venta {

	    private Producto producto;
	    private int cantidad;
	    private double subtotal;
	    

	    public detalle_venta(
	            Producto producto,
	            int cantidad
	    ) {

	        this.producto = producto;
	        this.cantidad = cantidad;
	        this.subtotal =
	                producto.getPrecio() * cantidad;
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

	    public double getSubtotal() {
	        return subtotal;
	    }

	    public void setSubtotal(double subtotal) {
	        this.subtotal = subtotal;
	    }
	
	
	
}//fin de detalle venta
