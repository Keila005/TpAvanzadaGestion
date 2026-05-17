package LogicLayer;

public class Producto {

	private int idProducto;
	private String nombre;
	private double precio;
	private int Stock;
	public Producto(int idProducto, String nombre, double precio, int stock) {
		super();
		this.idProducto = idProducto;
		this.nombre = nombre;
		this.precio = precio;
		Stock = stock;
	}
	public int getIdProducto() {
		return idProducto;
	
	}
	public String getNombre() {
		return nombre;
	
	}
	public double getPrecio() {
		return precio;
	}
	
	public int getStock() {
		return Stock;
	}
	public void setStock(int stock) {
		this.Stock = stock;
	}

	
}
