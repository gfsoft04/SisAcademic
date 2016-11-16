package br.com.gfsoft.sisacademic.util;

import br.com.gfsoft.sisacademic.model.Pessoa;

public class GeraMatricula {
	
	private String matricula;
	
	/**
	 * 
	 * @param String contendo o tipo de Pessoa
	 * @return String -> Matricula ou NULL, se der problema
	 */
	public String gerarMatricula(Pessoa pessoa){// parametro tipo de pessoal

		if(pessoa.getTipoPessoa().equals("Aluno")){
			
			matricula = "1" + "ano" + "semestre" + "pessoa.getId()";
			return matricula;
			
		} else if(pessoa.getTipoPessoa().equals("Professor")){
			
			matricula = "2" + "ano" + "semestre" + "pessoa.getId()";
			return matricula;
			
		} else if(pessoa.getTipoPessoa().equals("Funcionario")){
			
			matricula = "3" + "ano" + "semestre" + "pessoa.getId()";
			return matricula;
			
		} else if(pessoa.getTipoPessoa().equals("Administracao")) {
			
			matricula = "9" + "ano" + "semestre" + "pessoa.getId()";
			return matricula;
			
		}
		
		return null;
	}

}
