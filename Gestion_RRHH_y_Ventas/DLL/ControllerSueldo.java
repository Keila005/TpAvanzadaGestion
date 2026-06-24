package DLL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ControllerSueldo {
    
    private Connection con = Conexion.getInstance().getConnection();
    
    public int getIdEmpleadoByUsuario(int idUsuario) {
        int idEmpleado = -1;
        String sql = "SELECT id_empleado FROM empleado WHERE id_usuario = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idUsuario);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                idEmpleado = rs.getInt("id_empleado");
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
        }
        return idEmpleado;
    }
    
    public ResultSet getUltimaLiquidacion(int idEmpleado) {
        ResultSet rs = null;
        String sql = "SELECT l.sueldo_base, l.bonos, l.horas_extra, l.monto_total, " +
                     "e.dni, u.nombre, u.apellido " +
                     "FROM liquidacion_sueldo l " +
                     "JOIN empleado e ON l.id_empleado = e.id_empleado " +
                     "JOIN usuario u ON e.id_usuario = u.id_usuario " +
                     "WHERE l.id_empleado = ? " +
                     "ORDER BY l.id_liquidacion DESC LIMIT 1";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idEmpleado);
            rs = ps.executeQuery();
        } catch (Exception e) {
        }
        return rs;
    }
    
    public ResultSet getHistorialLiquidaciones(int idEmpleado) {
        ResultSet rs = null;
        String sql = "SELECT id_liquidacion, sueldo_base, bonos, horas_extra, monto_total " +
                     "FROM liquidacion_sueldo " +
                     "WHERE id_empleado = ? " +
                     "ORDER BY id_liquidacion DESC";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idEmpleado);
            rs = ps.executeQuery();
        } catch (Exception e) {
        }
        return rs;
    }
}