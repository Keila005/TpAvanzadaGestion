package LogicLayer;

import java.time.LocalDate;

public class Reunion {

    private int idReunion;
    private String titulo;
    private LocalDate fechaReunion;
    private int idProyecto;


    public Reunion(int idReunion, String titulo, LocalDate fechaReunion, int idProyecto) {

        this.idReunion = idReunion;
        this.titulo = titulo;
        this.fechaReunion = fechaReunion;
        this.idProyecto = idProyecto;
    }

    public int getIdReunion() {
        return idReunion;
    }

    public void setIdReunion(int idReunion) {
        this.idReunion = idReunion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public LocalDate getFechaReunion() {
        return fechaReunion;
    }

    public void setFechaReunion(LocalDate fechaReunion) {
        this.fechaReunion = fechaReunion;
    }

    public int getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(int idProyecto) {
        this.idProyecto = idProyecto;
    }

    @Override
    public String toString() {
        return "Reunion [idReunion=" + idReunion
                + ", titulo=" + titulo
                + ", fecha=" + fechaReunion
                + ", idProyecto=" + idProyecto + "]";
    }
}