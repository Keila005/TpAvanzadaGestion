package DLL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;

import com.mysql.jdbc.Connection;

import LogicLayer.Venta;
import LogicLayer.detalle_venta;

public class ControllerVenta {
	
	private static Connection con = Conexion.getInstance().getConnection();
	
	
	
	public void generarVenta(Venta venta) {

        try {

            PreparedStatement stmt = con.prepareStatement(
                "INSERT INTO venta(fecha, total, id_vendedor) " +
                "VALUES (?, ?, ?)",
                PreparedStatement.RETURN_GENERATED_KEYS
            );

            stmt.setDate(1,java.sql.Date.valueOf(venta.getFecha()));

            stmt.setDouble(2,venta.calcularTotal());

            stmt.setInt(3,venta.getIdVendedor());

            stmt.executeUpdate();

            ResultSet rs =
                    stmt.getGeneratedKeys();

            int idVenta = 0;

            if(rs.next()) {

                idVenta = rs.getInt(1);
            }

            for(detalle_venta d :
                    venta.getDetalles()) {

                PreparedStatement detalleStmt =
                        con.prepareStatement(

                    "INSERT INTO detalle_venta(" +
                    "id_venta, id_producto, cantidad, subtotal) " +
                    "VALUES (?, ?, ?, ?)"
                );

                detalleStmt.setInt(1,idVenta);

                detalleStmt.setInt(2,d.getProducto().getIdproducto());

                detalleStmt.setInt(3,d.getCantidad());

                detalleStmt.setDouble(4,d.getSubtotal());

                detalleStmt.executeUpdate();

                detalleStmt.close();
            }

            stmt.close();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
	
	
	
	public LinkedList<Venta> mostrarVentas(
	        int idVendedor
	) {

	    LinkedList<Venta> ventas =
	            new LinkedList<>();

	    try {

	        PreparedStatement stmt =
	                con.prepareStatement(

	            "SELECT * FROM venta " +
	            "WHERE id_vendedor = ?"
	        );

	        stmt.setInt(1, idVendedor);

	        ResultSet rs =
	                stmt.executeQuery();

	        while(rs.next()) {

	            Venta venta = new Venta();

	            venta.setIdVenta(
	                    rs.getInt("id_venta")
	            );

	            venta.setFecha(
	                    rs.getDate("fecha")
	                    .toLocalDate()
	            );

	            venta.setTotal(
	                    rs.getDouble("total")
	            );

	            venta.setIdVendedor(
	                    rs.getInt("id_vendedor")
	            );

	            ventas.add(venta);
	        }

	        stmt.close();

	    } catch(Exception e) {
	        e.printStackTrace();
	    }

	    return ventas;
	}
	
	
	public String obtenerRankingVendedores() {

	    String ranking = "";

	    try {

	        PreparedStatement stmt =
	                con.prepareStatement(

	            "SELECT u.nombre, u.apellido, " +
	            "COUNT(v.id_venta) AS totalVentas " +
	            "FROM vendedor ve " +
	            "INNER JOIN empleado e " +
	            "ON ve.id_empleado = e.id_empleado " +
	            "INNER JOIN usuario u " +
	            "ON e.id_usuario = u.id_usuario " +
	            "LEFT JOIN venta v " +
	            "ON e.id_empleado = v.id_vendedor " +
	            "GROUP BY e.id_empleado, u.nombre, u.apellido " +
	            "ORDER BY totalVentas DESC"
	        );

	        ResultSet rs = stmt.executeQuery();

	        int posicion = 1;

	        while(rs.next()) {

	            ranking +=
	                    posicion + ". "
	                    + rs.getString("nombre")
	                    + " "
	                    + rs.getString("apellido")
	                    + " - Ventas realizadas: "
	                    + rs.getInt("totalVentas")
	                    + "\n";

	            posicion++;
	        }

	        stmt.close();

	    } catch(Exception e) {
	        e.printStackTrace();
	    }

	    return ranking;
	}
	
	
	
}// fin de clase controller
	
	
	
	
	
	


