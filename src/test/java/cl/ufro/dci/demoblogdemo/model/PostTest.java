package cl.ufro.dci.demoblogdemo.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Prueba de la clase Post")
class PostTest {

    private Post p1;
    private Comentario c1;
    private Comentario c2;
    HashMap<String, String> textos = new HashMap<>();

    @BeforeEach
    @DisplayName("Dadas una publicación y dos comentarios")
    void setUp() {
        c1 = new Comentario(1, LocalDateTime.now(), "Buena publicación");
        c2 = new Comentario(2, LocalDateTime.now(), "Muy mala publicación");
        p1 = new Post((long) 1, LocalDateTime.now(), "Primera Publicación", "Lorem ipsum");

        textos.put("msjNulo", "El objeto es nulo");
        textos.put("msjCorrecto", "El comentario fue agregado correctamente");
        textos.put("msjVacio", "El comentario está vacío");

    }

    @Test
    @DisplayName("Verifica que se agregan comentarios correctos")
    public void testAgregarRegular() {
        //dado comentario y un post
        //cuando se agregar un comentario al post
        //entonces obtener una respuesta afirmativa

        assertEquals(textos.get("msjCorrecto"), null);
    }

    @Test
    @DisplayName("Verifica que se agregan comentarios Vacío")
    public void testAgregarComentarioVacio() {
        //dado comentario y un post

        //cuando se agregar un comentario vacío al post
        Comentario c4 = new Comentario();
        c4.setComentario("");
        //entonces obtener una respuesta afirmativa
        assertEquals(textos.get("msjVacio"), p1.agregarComentario(c4));
    }

    @Test
    @DisplayName("Verifica que el objeto no sea nulo")
    public void testAgregarComentarioNulo(){
        //dado un post y un comentario
        //cuando se agrega un comentario nulo
        //entonces lanazar excepcion

        Throwable excepcion = assertThrows(NullPointerException.class, () -> {
            p1.agregarComentario(null);
        });

    }

    @Test
    @DisplayName("Verifica editar un comentario correcto")
    public void testEditarUnComentario(){
        p1.agregarComentario(c1);
        p1.agregarComentario(c2);
        String edicion = "Edite este comentario";
        //dado un post y comentario existente
        //se cambia su contenido
        //entonces se espera un afirmativo
        assertEquals("El comentario fue editado correctamente", p1.editarComentario(edicion,c1));
    }
    @Test
    @DisplayName("Verifica editar un comentario vacio")
    public void testEditarUnComentarioVacio(){
        p1.agregarComentario(c1);
        p1.agregarComentario(c2);
        String edicion = "";
        //dado un post y comentario existente
        //se cambia su contenido a vacio
        //entonces se espera un afirmativo
        assertEquals(textos.get("msjVacio"), p1.editarComentario(edicion,c1));
    }
    @Test
    @DisplayName("Verifica borrar un comentario")
    public void testBorrarUnComentario(){
        p1.agregarComentario(c1);
        p1.agregarComentario(c2);
        //dado un post y comentario existente
        //se indica que comentario se eliminara de la lista
        //entonces se espera un afirmativo

        assertEquals("comentario eliminado",  p1.borrarComentario(c2));
    }

    @Test
    @DisplayName("Verifica contabilizar los comentario")
    public void testContarComentarios(){
        p1.agregarComentario(c1);
        p1.agregarComentario(c2);
        //dado un post y comentario existente
        //se indica la cantidad de comentarios que se espera contar
        //entonces se espera un afirmativo

        assertEquals(2,  p1.contabilizarComentarios());
    }
    @Test
    @DisplayName("Verifica listar comentarios")
    public void testListarComentarios(){
        p1.agregarComentario(c1);
        p1.agregarComentario(c2);
        //dado un post existente
        //se listan todos los comentarios en el
        //y se indica cuantos comentarios tiene
        //se espera ver los comentarios por consola y el numero de estos
        System.out.println(p1.getComentarios());
        System.out.println(p1.contabilizarComentarios());

    }
}









