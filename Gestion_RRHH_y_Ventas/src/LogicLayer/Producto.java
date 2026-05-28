package LogicLayer;

public class Producto {
	private int idProducto;
	private String nombre;
	private double precio;
	
	
	public Producto(int idproducto, String nombre, double precio) {
		super();
		this.idProducto = idproducto;
		this.nombre = nombre;
		this.precio = precio;
	}
	
	
	public int getIdproducto() {
		return idProducto;
	}
	public void setIdproducto(int idproducto) {
		this.idProducto = idproducto;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	
	
	
	

}// fin de clase producto
