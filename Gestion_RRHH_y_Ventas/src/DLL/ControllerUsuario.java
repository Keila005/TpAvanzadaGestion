package DLL;

import java.sql.*;
import LogicLayer.Usuario;

public class ControllerUsuario {

    public static Usuario login(String email, String pass) {
        Usuario user = null;
        
        try {
            Connection conn = Conexion.getInstance().getConnection();
            String sql = "SELECT * FROM usuarios WHERE email = ? AND contrasenia = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                user = new Usuario(
                    rs.getString("nombre"),
                    "",
                    rs.getString("email"),
                    rs.getString("contrasenia")
                );
                user.sueldo = rs.getDouble("sueldo");
                user.rol = rs.getString("rol");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
}
