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
    
    public double getSueldoBase(int idEmpleado) {
        String sql = "SELECT sueldo_base FROM empleado WHERE id_empleado = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idEmpleado);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getDouble("sueldo_base");
            }
        } catch (Exception e) {
        }
        return 0;
    }

    public int getIdEmpleadoByNombreApellido(String nombre, String apellido) {
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

    public void registrarHorasExtra(int idEmpleado, int horas, String motivo) {
        String sql = "INSERT INTO horas_extra (id_empleado, fecha, horas, valor_hora, motivo) VALUES (?, CURDATE(), ?, ?, ?)";
        try {
            double sueldoBase = getSueldoBase(idEmpleado);
            double valorHora = (sueldoBase / 30) / 8;
            double valorHoraExtra = valorHora * 1.5;
            
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idEmpleado);
            ps.setInt(2, horas);
            ps.setDouble(3, valorHoraExtra);
            ps.setString(4, motivo);
            ps.executeUpdate();
            ps.close();
            
            javax.swing.JOptionPane.showMessageDialog(null, "Horas extra registradas: " + horas + " horas");
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(null, "Error al registrar horas extra");
        }
    }
}
    
