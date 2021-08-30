package cl.ufro.dci.demoblogdemo.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Post {

    private long id;
    private LocalDateTime fecha;
    private String titulo;
    private String contenido;
    private List<Comentario> comentarios = new ArrayList<>();

    public Post() {
    }

    public Post(long id, LocalDateTime fecha, String titulo, String contenido) {
        this.id = id;
        this.fecha = fecha;
        this.titulo = titulo;
        this.contenido = contenido;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", fecha=" + fecha +
                ", titulo='" + titulo + '\'' +
                ", contenido='" + contenido + '\'' +
                '}';
    }

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

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }



    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

    /**
     * Permite agregar un comentario a un post
     *
     * @param c1
     * @return
     */
    public String agregarComentario(Comentario c1) {

        String outPut;

        if (Optional.ofNullable(c1).isPresent()) { //no es nulo

            if (!c1.getComentario().equals("")) {
                this.comentarios.add(c1);
                outPut = "El comentario fue agregado correctamente";

            } else {
                outPut = "El comentario está vacío";
            }
        } else {
            throw new NullPointerException("El objeto es nulo");
        }

        return outPut;
    }
    /**
     * Permite editar un comentario
     *
     * @param cEdit, c
     * @return
     */
    public String editarComentario(String cEdit, Comentario c){

        String outPut;

        if (Optional.ofNullable(c).isPresent()) { //no es nulo

            if (!cEdit.equals("")) {
                c.setComentario(cEdit);
                outPut = "El comentario fue editado correctamente";

            } else {
                outPut = "El comentario está vacío";
            }
        } else {
            throw new NullPointerException("El objeto es nulo");
        }

        return outPut;
    }

    /**
     * Permite borrar un comentario
     *
     * @param  c
     */
    public String borrarComentario(Comentario c){
       comentarios.remove(c);
        for (int i=0;i<comentarios.size();i++) {
            if (comentarios.get(i).equals(c)){
                return "comentario no eliminado";
            }else {
                return "comentario eliminado";
            }
        }
        return "";
    }

    /**
     * Permite contar la cantidad de comentarios
     */
    public int contabilizarComentarios(){
       return  comentarios.size();
    }
    /**
     * Permite contar la cantidad de comentarios
     */
    public List<Comentario> getComentarios() {
        return comentarios;
    }
}
