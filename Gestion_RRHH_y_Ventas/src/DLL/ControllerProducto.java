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

        String lista = "";

        for(Producto p : productos) {

            lista +=
                    "ID: " + p.getIdproducto() +
                    " | Nombre: " + p.getNombre() +
                    " | Precio: $" + p.getPrecio() +
                    "\n";
        }

        JOptionPane.showMessageDialog(
                null,
                lista
        );

        int id = Integer.parseInt(
                JOptionPane.showInputDialog(
                        "Ingrese el ID del producto"
                )
        );

        for(Producto p : productos) {

            if(p.getIdproducto() == id) {

                elegido = p;
            }
        }

    } catch(Exception e) {
        e.printStackTrace();
    }

    return elegido;
}
	
	
	
	
	public void agregarProducto(Producto producto) {

	    try {

	        PreparedStatement statement = con.prepareStatement(
	            "INSERT INTO producto(nombre, precio) VALUES (?, ?)"
	        );

	        statement.setString(1, producto.getNombre());
	        statement.setDouble(2, producto.getPrecio());

	        int filas = statement.executeUpdate();

	        if(filas > 0) {

	            JOptionPane.showMessageDialog(
	                null,
	                "Producto agregado correctamente."
	            );
	        }

	    } catch(Exception e) {
	        e.printStackTrace();
	    }
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
