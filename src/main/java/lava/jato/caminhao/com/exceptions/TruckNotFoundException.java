package lava.jato.caminhao.com.exceptions;

public class TruckNotFoundException extends RuntimeException {

    private static final long seriaVersionUID = 1L;

    public TruckNotFoundException(String message){
        super(message);
    }
}
