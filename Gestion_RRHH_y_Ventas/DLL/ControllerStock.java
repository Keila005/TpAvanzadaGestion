package DLL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.LinkedList;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;

import LogicLayer.Producto;
import LogicLayer.Stock;

public class ControllerStock {

    private static Connection con =
            Conexion.getInstance().getConnection();

    public void registrarMovimiento(
            Stock stock
    ) {

        try {

            PreparedStatement stmt =
                    con.prepareStatement(

                "INSERT INTO stock(" +
                "id_producto, cantidad, fecha, tipo_movimiento) " +
                "VALUES (?, ?, ?, ?)"
            );

            stmt.setInt(
                    1,
                    stock.getProducto()
                    .getIdproducto()
            );

            stmt.setInt(
                    2,
                    stock.getCantidad()
            );

            stmt.setDate(
                    3,
                    java.sql.Date.valueOf(
                            stock.getFecha()
                    )
            );

            stmt.setString(
                    4,
                    stock.getTipoMovimiento()
            );

            stmt.executeUpdate();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public LinkedList<Stock> mostrarMovimientos() {

        LinkedList<Stock> movimientos =
                new LinkedList<>();

        try {

            PreparedStatement stmt =
                    con.prepareStatement(

                "SELECT s.*, p.nombre, p.precio " +
                "FROM stock s " +
                "INNER JOIN producto p " +
                "ON s.id_producto = p.id_producto"
            );

            ResultSet rs =
                    stmt.executeQuery();

            while(rs.next()) {

                Producto producto =
                        new Producto(
                            rs.getInt("id_producto"),
                            rs.getString("nombre"),
                            rs.getDouble("precio")
                        );

                Stock stock =
                        new Stock(
                            producto,
                            rs.getInt("cantidad"),
                            rs.getDate("fecha")
                            .toLocalDate(),
                            rs.getString(
                                "tipo_movimiento"
                            )
                        );

                movimientos.add(stock);
            }

        } catch(Exception e) {
            e.printStackTrace();
        }

        return movimientos;
    }

    public int obtenerStockActual(
            int idProducto
    ) {

        int stock = 0;

        try {

            PreparedStatement stmt =
                    con.prepareStatement(

                "SELECT * FROM stock " +
                "WHERE id_producto = ?"
            );

            stmt.setInt(1, idProducto);

            ResultSet rs =
                    stmt.executeQuery();

            while(rs.next()) {

                String tipo =
                        rs.getString(
                            "tipo_movimiento"
                        );

                int cantidad =
                        rs.getInt(
                            "cantidad"
                        );

                if(
                	    tipo.equalsIgnoreCase("INGRESO")
                	    ||
                	    tipo.equalsIgnoreCase("AGREGACION")
                	) {

                	    stock += cantidad;

                	}
                	else if(
                	    tipo.equalsIgnoreCase("VENTA")
                	) {

                	    stock -= cantidad;
                	}
            }

        } catch(Exception e) {
            e.printStackTrace();
        }

        return stock;
    }

    public boolean hayStock(
            int idProducto,
            int cantidadSolicitada
    ) {

        return obtenerStockActual(
                idProducto
        ) >= cantidadSolicitada;
    }
}//fin de controller de stock