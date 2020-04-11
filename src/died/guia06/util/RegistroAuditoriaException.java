package died.guia06.util;

public class RegistroAuditoriaException extends Exception {
	public RegistroAuditoriaException() {
		super("La operacion no se pudo registrar, intente nuevamente");
	}

}
