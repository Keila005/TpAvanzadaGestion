package DLL;

import java.sql.PreparedStatement;
import java.time.LocalDate;

import com.mysql.jdbc.Connection;

import LogicLayer.Reunion;

public class ControllerReunion {

    private static Connection con =
            Conexion.getInstance().getConnection();

    public void crearReunion(
            String titulo,
            LocalDate fechaReunion,
            int idProyecto) {

        try {

            PreparedStatement stmt =
                    con.prepareStatement(

                    "INSERT INTO reunion "
                    + "(titulo,fechaReunion,id_proyecto) "
                    + "VALUES (?,?,?)"
            );

            stmt.setString(1, titulo);
            stmt.setDate(2, java.sql.Date.valueOf(fechaReunion));
            stmt.setInt(3, idProyecto);

            stmt.executeUpdate();

        } catch(Exception e) {

            e.printStackTrace();
        }
    }

}