package DLL;

import java.sql.PreparedStatement;
import com.mysql.jdbc.Connection;

public class ControllerReunion {

    private static Connection con =
            Conexion.getInstance().getConnection();

    public void crearReunion(
            String titulo,
            String descripcion,
            String fecha,
            int idProyecto) {

        try {

            PreparedStatement stmt =
                    con.prepareStatement(

                    "INSERT INTO reunion "
                    + "(titulo,fecha,descripcion,id_proyecto) "
                    + "VALUES (?,?,?,?)"
            );

            stmt.setString(1, titulo);
            stmt.setString(2, fecha);
            stmt.setString(3, descripcion);
            stmt.setInt(4, idProyecto);

            stmt.executeUpdate();

        } catch(Exception e) {

            e.printStackTrace();
        }
    }

}