package DLL;

import java.sql.PreparedStatement;

import com.mysql.jdbc.Connection;

import LogicLayer.Venta;

public class ControllerVenta {
	
	private static Connection con = Conexion.getInstance().getConnection();
	
	
	public void generarVenta(Venta vent) {

	    try {

	        PreparedStatement stmt = con.prepareStatement(
	            "INSERT INTO venta(fecha, total, id_vendedor) " +
	            "VALUES (?, ?, ?)"
	        );

	        stmt.setDate(1,java.sql.Date.valueOf(vent.getFecha()));
	        stmt.setDouble(2,vent.getTotal());
	        stmt.setInt(3, vent.getIdVendedor());
	       

	        stmt.executeUpdate();

	    } catch(Exception e) {
	        e.printStackTrace();
	    }
	}
	
	
	

}
