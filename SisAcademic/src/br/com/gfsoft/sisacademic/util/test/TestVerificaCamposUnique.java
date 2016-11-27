package br.com.gfsoft.sisacademic.util.test;

import br.com.gfsoft.sisacademic.util.VerificaCamposUnique;
import junit.framework.TestCase;

public class TestVerificaCamposUnique extends TestCase{
	
	/*VerificaCamposUnique verificaCamposUnique;
	
	public void setUp(){
		verificaCamposUnique = new VerificaCamposUnique();
	}
	
	public void tearDown(){
		verificaCamposUnique = null;
	}*/
	
	public void testValidaCpf(){
		Boolean valido = VerificaCamposUnique.validaCpf("20128108614");
		
		assertTrue(valido);
		
	}
	
	//public void testValidaCpfRg(){
		
	//}

}
