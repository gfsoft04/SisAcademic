package br.com.gfsoft.sisacademic.util;

import br.com.gfsoft.sisacademic.persistence.PersistencePessoa;

public class VerificaCamposUnique {
	
	private PersistencePessoa pPessoa;
	
	
	public boolean validaCpfRg(String cpf, String rg){
		
		pPessoa = new PersistencePessoa();
		
		if(pPessoa.qtdRegistros("cpf", cpf) == 0 && pPessoa.qtdRegistros("rg", rg) == 0){
			
			if(validaCpf(cpf)){
				return true;
			}
			
		}
		
		return false;
	}
	
	public boolean validaCpf(String cpf) {
		
		
		return true;
	}

}
