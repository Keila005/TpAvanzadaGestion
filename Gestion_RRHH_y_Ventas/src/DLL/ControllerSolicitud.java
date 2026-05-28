package DLL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ControllerSolicitud {
    
    private Connection con = Conexion.getInstance().getConnection();
    
    private int getIdEmpleadoByIdUsuario(int idUsuario) {
        String sql = "SELECT id_empleado FROM empleado WHERE id_usuario = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idUsuario);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("id_empleado");
            }
        } catch (Exception e) {
        }
        return -1;
    }
    
    public void guardarSolicitud(int idUsuario, String tipo, String fechaInicio, String fechaFin) {
        int idEmpleado = getIdEmpleadoByIdUsuario(idUsuario);
        
        if (idEmpleado == -1) {
            return;
        }
        
        String sql = "INSERT INTO solicitudes (id_empleado, tipo, fecha_inicio, fecha_fin) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idEmpleado);
            ps.setString(2, tipo);
            ps.setString(3, fechaInicio);
            ps.setString(4, fechaFin);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
        }
    }
}