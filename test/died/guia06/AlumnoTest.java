package died.guia06;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AlumnoTest {
	Alumno a;
	
	@BeforeEach
	public void init() {
		a= new Alumno("Damian Lipschitz", 25320);
	}
	
	@Test
	void testCreditosObtenidosSinAprobarNada() {
		Curso c1= new Curso();
		c1.setCreditos(50);
		a.inscripcionAceptada(c1);
		int c= a.creditosObtenidos();
		assertEquals(c,0);
	}
	@Test
	void testCreditosObtenidosSinCursarNada() {
		int c= a.creditosObtenidos();
		assertEquals(c,0);
	}

	
	@Test
	void testCreditosObtenidosConMateriaDe50() {
		Curso c1= new Curso();
		c1.setCreditos(50);
		a.inscripcionAceptada(c1);
		a.aprobar(c1);
		int creditos= a.creditosObtenidos();
		assertEquals(creditos,50);
	}
	@Test
	void testCreditosObtenidosCon2MateriasDe50() {
		Curso c1= new Curso() , c2= new Curso();
		c1.setCreditos(50);
		c2.setCreditos(50);
		a.inscripcionAceptada(c1);
		a.inscripcionAceptada(c2);
		a.aprobar(c1);
		a.aprobar(c2);
		int creditos= a.creditosObtenidos();
		assertEquals(creditos,100);
	}

	@Test
	void testNoAprobarCursoSinInscribirse() {
		Curso c1= new Curso() , c2= new Curso();
		boolean aprobado;
		a.inscripcionAceptada(c1);
		a.aprobar(c1);
		a.aprobar(c2);
		aprobado=a.getAprobados().contains(c2);	
		assertFalse(aprobado);
	}
	@Test
	void testNoAprobarCursoSinInscribirseANada() {
		Curso c2= new Curso();
		boolean vacio;
		a.aprobar(c2);
		vacio=(a.getAprobados() == null );	
		assertTrue(vacio);
	}
	
	@Test
	void testAprobarCursos() {
		Curso c1= new Curso() , c2= new Curso();
		boolean aprobado;
		a.inscripcionAceptada(c1);
		a.inscripcionAceptada(c2);
		a.aprobar(c1);
		a.aprobar(c2);
		aprobado= (a.getAprobados().contains(c1) && a.getAprobados().contains(c2)  ) ;	
		assertTrue(aprobado);
	}
	

	@Test
	void testInscripcionAceptada() {
		Curso c1= new Curso();
		boolean inscripto;
		a.inscripcionAceptada(c1);
		inscripto=(a.getCursando().contains(c1));
		assertTrue(inscripto);
	}
	
	
	
	
	
	

}
