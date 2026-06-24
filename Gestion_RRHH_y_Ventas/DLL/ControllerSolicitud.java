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
    public ResultSet getSolicitudesPendientes() {
        String sql = "SELECT s.id_solicitud, s.tipo, s.fecha_inicio, s.fecha_fin, u.nombre, u.apellido " +
                     "FROM solicitudes s " +
                     "JOIN empleado e ON s.id_empleado = e.id_empleado " +
                     "JOIN usuario u ON e.id_usuario = u.id_usuario " +
                     "WHERE s.estado = 'pendiente'";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            return ps.executeQuery();
        } catch (Exception e) {
            return null;
        }
    }

    public void actualizarEstado(int idSolicitud, String estado) {
        String sql = "UPDATE solicitudes SET estado = ? WHERE id_solicitud = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, estado);
            ps.setInt(2, idSolicitud);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
        }
    }
}