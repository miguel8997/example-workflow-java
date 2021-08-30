package cl.ufro.dci.demoblogdemo.model;

import java.time.LocalDateTime;

public class Comentario {

    private long id;
    private LocalDateTime fecha;
    private String comentario;

    public Comentario() {
    }

    public Comentario(long id, LocalDateTime fecha, String comentario) {
        this.id = id;
        this.fecha = fecha;
        this.comentario = comentario;
    }

    @Override
    public String toString() {
        return "Comentario{" +
                "id=" + id +
                ", fecha=" + fecha +
                ", comentario='" + comentario + '\'' +
                '}';
    }

    //lombok
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
}
