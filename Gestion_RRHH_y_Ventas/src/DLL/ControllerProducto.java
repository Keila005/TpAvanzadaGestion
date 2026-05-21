package DLL;

import java.sql.PreparedStatement;

import com.mysql.jdbc.Connection;

import LogicLayer.Producto;
import LogicLayer.Venta;

public class ControllerProducto {

	
private static Connection con = Conexion.getInstance().getConnection();
	
	
	public void agregarProducto(Producto produc) {

	    try {

	        PreparedStatement stmt = con.prepareStatement(
	            "INSERT INTO producto(nombre, precios) " +
	            "VALUES (?, ?)"
	        );

	        stmt.setString(1,produc.getNombre());
	        stmt.setDouble(2,produc.getPrecio());
	       

	        stmt.executeUpdate();

	    } catch(Exception e) {
	        e.printStackTrace();
	    }
	}
	
	
	
}// fin de clase controller producto
