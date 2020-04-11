package died.guia06.util;

public class NoTieneCreditosException extends Exception {
	
	public NoTieneCreditosException() {
		super("No tiene creditos suficientes");
	}

}
