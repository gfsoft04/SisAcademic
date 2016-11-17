package br.com.gfsoft.sisacademic.util;

import br.com.gfsoft.sisacademic.persistence.PersistencePessoa;

public class GeraMatricula {
	
	private String matricula;
	private int id;
	PersistencePessoa pPessoa;
	
	/**
	 * 
	 * @param String contendo o tipo de Pessoa
	 * @return String -> Matricula ou NULL, se der problema
	 */
	public String gerarMatricula(int tipoPessoa, int ano){// parametro tipo de pessoal
		pPessoa = new PersistencePessoa();
		id = pPessoa.selectUltimoID();

		
		
		matricula = tipoPessoa + ano + "semestre" + id;
		
		
		
		return matricula;
	}

}
