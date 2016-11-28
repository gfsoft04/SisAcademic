package br.com.gfsoft.sisacademic.util.test;

import br.com.gfsoft.sisacademic.util.GeraMatricula;
import junit.framework.TestCase;

public class TestGeraMatricula extends TestCase{
	
	
	GeraMatricula geraMatricula;
	
	public void setUp(){
		geraMatricula = new GeraMatricula();
	}
	
	public void tearDown(){
		geraMatricula = null;
	}
	
	public void testGerarMatricula(){
		
		String matricula = geraMatricula.gerarMatricula(1, 2016);
		
		assertEquals(matricula, "1201600042");
		
	}

}
