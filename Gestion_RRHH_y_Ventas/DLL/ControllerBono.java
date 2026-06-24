package DLL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import javax.swing.JOptionPane;

public class ControllerBono {
    
    private Connection con = Conexion.getInstance().getConnection();
    
    public LinkedList<String> getListaEmpleados() {
        LinkedList<String> lista = new LinkedList<>();
        String sql = "SELECT u.nombre, u.apellido, e.id_empleado FROM empleado e " +
                     "JOIN usuario u ON e.id_usuario = u.id_usuario";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                lista.add(rs.getString("nombre") + " " + rs.getString("apellido"));
            }
        } catch (Exception e) {
        }
        return lista;
    }
    
    public int getIdEmpleadoByNombre(String nombreCompleto) {
        String[] partes = nombreCompleto.split(" ");
        String nombre = partes[0];
        String apellido = partes[1];
        
        String sql = "SELECT e.id_empleado FROM empleado e " +
                     "JOIN usuario u ON e.id_usuario = u.id_usuario " +
                     "WHERE u.nombre = ? AND u.apellido = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nombre);
            ps.setString(2, apellido);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("id_empleado");
            }
        } catch (Exception e) {
        }
        return -1;
    }
    
    public void registrarBono(int idEmpleado, double monto, String motivo) {
        String sql = "INSERT INTO bonos (id_empleado, fecha, monto, motivo) VALUES (?, CURDATE(), ?, ?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idEmpleado);
            ps.setDouble(2, monto);
            ps.setString(3, motivo);
            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null, "Bono registrado: $" + monto);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al registrar bono");
        }
    }
}