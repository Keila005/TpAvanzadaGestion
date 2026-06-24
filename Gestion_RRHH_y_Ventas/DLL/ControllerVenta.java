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
	                    + "\n- - - - - - - - -\n";

	            posicion++;
	        }

	        stmt.close();

	    } catch(Exception e) {
	        e.printStackTrace();
	    }

	    return ranking;
	}
	
	
	public String obtenerProductoMasVendido() {

	    String resultado = "";

	    try {

	        PreparedStatement stmt =
	                con.prepareStatement(

	            "SELECT p.nombre, " +
	            "SUM(d.cantidad) AS totalVendido " +
	            "FROM detalle_venta d " +
	            "INNER JOIN producto p " +
	            "ON d.id_producto = p.id_producto " +
	            "GROUP BY p.id_producto, p.nombre " +
	            "ORDER BY totalVendido DESC " +
	            "LIMIT 1"
	        );

	        ResultSet rs = stmt.executeQuery();

	        if(rs.next()) {

	            resultado =
	                    "Producto más vendido:\n\n"
	                    + rs.getString("nombre")
	                    + "\nCantidad vendida: "
	                    + rs.getInt("totalVendido");
	        }

	        stmt.close();

	    } catch(Exception e) {
	        e.printStackTrace();
	    }

	    return resultado;
	}
	
	
	public String obtenerProductoMenosVendido() {

	    String resultado = "";

	    try {

	        PreparedStatement stmt =
	                con.prepareStatement(

	            "SELECT p.nombre, " +
	            "SUM(d.cantidad) AS totalVendido " +
	            "FROM detalle_venta d " +
	            "INNER JOIN producto p " +
	            "ON d.id_producto = p.id_producto " +
	            "GROUP BY p.id_producto, p.nombre " +
	            "ORDER BY totalVendido ASC " +
	            "LIMIT 1"
	        );

	        ResultSet rs = stmt.executeQuery();

	        if(rs.next()) {

	            resultado =
	                    "Producto menos vendido:\n\n"
	                    + rs.getString("nombre")
	                    + "\nCantidad vendida: "
	                    + rs.getInt("totalVendido");
	        }

	        stmt.close();

	    } catch(Exception e) {
	        e.printStackTrace();
	    }

	    return resultado;
	}
	
	public String mostrarTodasLasVentas() {

	    String ventas = "";

	    try {

	        PreparedStatement stmt =
	                con.prepareStatement(

	            "SELECT v.id_venta, " +
	            "v.fecha, " +
	            "v.total, " +
	            "u.nombre, " +
	            "u.apellido " +
	            "FROM venta v " +
	            "INNER JOIN empleado e " +
	            "ON v.id_vendedor = e.id_empleado " +
	            "INNER JOIN usuario u " +
	            "ON e.id_usuario = u.id_usuario " +
	            "ORDER BY v.fecha DESC"
	        );

	        ResultSet rs = stmt.executeQuery();

	        while(rs.next()) {

	            ventas +=
	                    "ID Venta: "
	                    + rs.getInt("id_venta")
	                    + "\nVendedor: "
	                    + rs.getString("nombre")
	                    + " "
	                    + rs.getString("apellido")
	                    + "\nFecha: "
	                    + rs.getDate("fecha")
	                    + "\nTotal: $"
	                    + rs.getDouble("total")
	                    + "\n----------------------\n";
	        }

	        stmt.close();

	    } catch(Exception e) {
	        e.printStackTrace();
	    }

	    return ventas;
	}
	public LinkedList<Venta> mostrarVentas() {

	    LinkedList<Venta> ventas = new LinkedList<>();

	    try {

	        String sql =
	                "SELECT v.id_venta, v.fecha, v.total, " +
	                "u.nombre, u.apellido " +
	                "FROM venta v " +
	                "JOIN empleado e ON v.id_vendedor = e.id_empleado " +
	                "JOIN usuario u ON e.id_usuario = u.id_usuario " +
	                "ORDER BY v.fecha DESC";

	        PreparedStatement stmt = con.prepareStatement(sql);

	        ResultSet rs = stmt.executeQuery();

	        while(rs.next()) {

	            Venta v = new Venta();

	            v.setIdVenta(rs.getInt("id_venta"));
	            v.setFecha(rs.getDate("fecha").toLocalDate());
	            v.setTotal(rs.getDouble("total"));


	            v.setNombreVendedor(
	                    rs.getString("nombre") + " " +
	                    rs.getString("apellido")
	                );

	            ventas.add(v);
	        }

	    } catch(Exception ex) {
	        ex.printStackTrace();
	    }

	    return ventas;
	}
	public ResultSet mostrarDetalleVentas() {

	    try {

	        String sql =
	            "SELECT d.id_detalle, d.id_venta, " +
	            "p.nombre AS producto, " +
	            "d.cantidad, d.subtotal " +
	            "FROM detalle_venta d " +
	            "JOIN producto p ON d.id_producto = p.id_producto " +
	            "ORDER BY d.id_venta DESC";

	        PreparedStatement stmt = con.prepareStatement(sql);

	        return stmt.executeQuery();

	    } catch(Exception e) {
	        e.printStackTrace();
	    }

	    return null;
	}

}// fin de clase controller
	
	
	
	
	
	


