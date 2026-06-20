package DLL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import LogicLayer.Operativo;
import LogicLayer.Vendedor;

public class ControllerRendimiento {
    
    private Connection con = Conexion.getInstance().getConnection();
    
    public LinkedList<Operativo> getTodosOperativos() {
        LinkedList<Operativo> lista = new LinkedList<>();
        String sql = "SELECT o.id_empleado, o.rol, o.rendimiento, u.nombre, u.apellido " +
                     "FROM operativo o " +
                     "JOIN empleado e ON o.id_empleado = e.id_empleado " +
                     "JOIN usuario u ON e.id_usuario = u.id_usuario";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Operativo op = new Operativo();
                op.setIdEmpleado(rs.getInt("id_empleado"));
                op.setNombre(rs.getString("nombre"));
                op.setApellido(rs.getString("apellido"));
                op.setRendimiento(rs.getInt("rendimiento"));
                lista.add(op);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
        }
        return lista;
    }
    
    public LinkedList<Vendedor> getTodosVendedores() {
    	LinkedList<Vendedor> lista = new LinkedList<>();
        String sql = "SELECT v.id_empleado, v.ventas_totales, u.nombre, u.apellido " +
                     "FROM vendedor v " +
                     "JOIN empleado e ON v.id_empleado = e.id_empleado " +
                     "JOIN usuario u ON e.id_usuario = u.id_usuario";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	int id_empleado=rs.getInt("id_empleado");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                int ventasTotales = rs.getInt("ventas_totales");
         Vendedor ven = new Vendedor(id_empleado,nombre, apellido,ventasTotales);
         
         
                lista.add(ven);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
        }
        return lista;
    }
    public ResultSet getListaEmpleados() {
        String sql = "SELECT e.id_empleado, u.nombre, u.apellido, u.email, e.dni, e.sueldo_base " +
                     "FROM empleado e " +
                     "JOIN usuario u ON e.id_usuario = u.id_usuario";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            return ps.executeQuery();
        } catch (Exception e) {
            return null;
        }
    }
}