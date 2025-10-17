package leonardoferrante.gestioneviaggi.exceptions;

public class NotFoundExceptions extends RuntimeException {
    public NotFoundExceptions(String entityName, Long id) {
        super(entityName + "con id" + id + "non trovato");
    }
}
