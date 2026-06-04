package DLL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;

import LogicLayer.Producto;
import LogicLayer.Venta;

public class ControllerProducto {

	
private static Connection con = Conexion.getInstance().getConnection();


public Producto BuscarProducto() {

    Producto elegido = null;

    try {

        LinkedList<Producto> productos =
                mostrarProductos();

        if(productos.isEmpty()) {

            JOptionPane.showMessageDialog(
                    null,
                    "No hay productos registrados"
            );

            return null;
        }

        String lista = "";

        for(Producto p : productos) {

        	ControllerStock controllerStock =
        	        new ControllerStock();

        	lista +=
        	    "ID: " + p.getIdproducto() +
        	    " | Nombre: " + p.getNombre() +
        	    " | Precio: $" + p.getPrecio() +
        	    " | Stock: " +
        	    controllerStock.obtenerStockActual(
        	            p.getIdproducto()
        	    ) +
        	    "\n";
        }

        JOptionPane.showMessageDialog(
                null,
                lista
        );

        String texto = JOptionPane.showInputDialog(
                "Ingrese el ID del producto"
        );

        if(texto == null || texto.trim().isEmpty()) {
            return null;
        }

        int id = Integer.parseInt(texto);

        for(Producto p : productos) {

            if(p.getIdproducto() == id) {

                elegido = p;
                break;
            }
        }

        if(elegido == null) {

            JOptionPane.showMessageDialog(
                    null,
                    "No existe un producto con ese ID"
            );
        }

    } catch(NumberFormatException e) {

        JOptionPane.showMessageDialog(
                null,
                "Debe ingresar un número válido"
        );

    } catch(Exception e) {

        e.printStackTrace();
    }

    return elegido;
}
	
	
	
public int agregarProducto(Producto producto) {

    try {

        PreparedStatement statement = con.prepareStatement(
            "INSERT INTO producto(nombre, precio) VALUES (?, ?)",
            PreparedStatement.RETURN_GENERATED_KEYS
        );

        statement.setString(1, producto.getNombre());
        statement.setDouble(2, producto.getPrecio());

        int filas = statement.executeUpdate();

        if(filas > 0) {

            ResultSet rs = statement.getGeneratedKeys();

            if(rs.next()) {

                int idGenerado = rs.getInt(1);

                JOptionPane.showMessageDialog(
                    null,
                    "Producto agregado correctamente."
                );

                return idGenerado;
            }
        }

    } catch(Exception e) {
        e.printStackTrace();
    }

    return 0;
}
	
	
	
	public void modificarProducto(Producto producto) {

	    try {

	        PreparedStatement statement = con.prepareStatement(
	            "UPDATE producto " +
	            "SET nombre = ?, precio = ? " +
	            "WHERE id_producto = ?"
	        );

	        statement.setString(1, producto.getNombre());
	        statement.setDouble(2, producto.getPrecio());
	        statement.setInt(3, producto.getIdproducto());

	        int filas = statement.executeUpdate();

	        if(filas > 0) {

	            JOptionPane.showMessageDialog(
	                null,
	                "Producto modificado correctamente."
	            );
	        }

	    } catch(Exception e) {
	        e.printStackTrace();
	    }
	}
	
	
	
	public LinkedList<Producto> mostrarProductos() {

	    LinkedList<Producto> productos = new LinkedList<>();

	    try {

	        PreparedStatement stmt = con.prepareStatement(
	            "SELECT * FROM producto"
	        );

	        ResultSet rs = stmt.executeQuery();

	        while(rs.next()) {

	            int idProducto = rs.getInt("id_producto");
	            String nombre = rs.getString("nombre");
	            double precio = rs.getDouble("precio");

	            Producto producto = new Producto(
	                idProducto,
	                nombre,
	                precio
	            );

	            productos.add(producto);
	        }

	        stmt.close();

	    } catch(Exception e) {
	        e.printStackTrace();
	    }

	    return productos;
	}
	

	
	public void eliminarProducto(Producto producto) {

	    try {

	        PreparedStatement statement = con.prepareStatement(
	            "DELETE FROM producto WHERE id_producto = ?"
	        );

	        statement.setInt(1, producto.getIdproducto());

	        int filas = statement.executeUpdate();

	        if(filas > 0) {

	            JOptionPane.showMessageDialog(
	                null,
	                "Producto eliminado correctamente."
	            );
	        }

	    } catch(Exception e) {
	        e.printStackTrace();
	    }
	}
	
	
}// fin de clase controller producto
