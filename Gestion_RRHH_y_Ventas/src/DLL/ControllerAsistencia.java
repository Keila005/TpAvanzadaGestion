package DLL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalTime;

public class ControllerAsistencia {
    
    private Connection con = Conexion.getInstance().getConnection();
    
    public void registrarEntrada(int idEmpleado) {
        String sql = "INSERT INTO asistencia (fecha, hora_entrada, presente, id_empleado) VALUES (?, ?, 1, ?)";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDate(1, java.sql.Date.valueOf(LocalDate.now()));
            ps.setTime(2, java.sql.Time.valueOf(LocalTime.now()));
            ps.setInt(3, idEmpleado);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
        }
    }
    
    public void registrarSalida(int idEmpleado) {
        String sql = "UPDATE asistencia SET hora_salida = ? WHERE id_empleado = ? AND fecha = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setTime(1, java.sql.Time.valueOf(LocalTime.now()));
            ps.setInt(2, idEmpleado);
            ps.setDate(3, java.sql.Date.valueOf(LocalDate.now()));
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
        }
    }
    
    public boolean yaRegistroEntradaHoy(int idEmpleado) {
        String sql = "SELECT id_asistencia FROM asistencia WHERE id_empleado = ? AND fecha = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idEmpleado);
            ps.setDate(2, java.sql.Date.valueOf(LocalDate.now()));
            ResultSet rs = ps.executeQuery();
            boolean existe = rs.next();
            rs.close();
            ps.close();
            return existe;
        } catch (Exception e) {
            return false;
        }
        
        
        
        
    }
    public int getIdEmpleadoByUsuario(int idUsuario) {
        String sql = "SELECT id_empleado FROM empleado WHERE id_usuario = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idUsuario);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("id_empleado");
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
        }
        return -1;
    }
}