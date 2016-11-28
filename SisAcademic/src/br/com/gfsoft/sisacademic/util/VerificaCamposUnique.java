package br.com.gfsoft.sisacademic.util;

import java.util.InputMismatchException;

import javax.swing.JOptionPane;

import br.com.gfsoft.sisacademic.persistence.PersistencePessoa;

public class VerificaCamposUnique {
	
	private PersistencePessoa pPessoa;
	
	
	public boolean validaCpfRg(String cpf, String rg){
		
		pPessoa = new PersistencePessoa();
		
		if(pPessoa.qtdRegistros("cpf", cpf) == 0 && pPessoa.qtdRegistros("rg", rg) == 0){
			
			if(validaCpf(cpf)){
				return true;
			} else {
				JOptionPane.showMessageDialog(null, "CPF Invalido!", "Erro", JOptionPane.ERROR_MESSAGE);
				return false;
			}
			
		} else {
			// Data invalida???? Acho que aqui eh aquele bug
			JOptionPane.showMessageDialog(null, "Usuario ja cadastrado!", "Erro", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
	}
	
	public static boolean validaCpf(String CPF) {
		
		// considera-se erro CPF's formados por uma sequencia de numeros iguais
		if (CPF == null || CPF.length() != 11 
			|| CPF.matches("^(0{11}|1{11}|2{11}|3{11}|4{11}|5{11}|6{11}|7{11}|9{11}|9{11})$")) return false; 

			char dig10, dig11;
		    int sm, i, r, num, peso;

		// "try" - protege o codigo para eventuais erros de conversao de tipo (int)
	    try {
		// Calculo do 1o. Digito Verificador
		   sm = 0;
		   peso = 10;
		   for (i=0; i<9; i++) {              
			   // converte o i-esimo caractere do CPF em um numero:
			   // por exemplo, transforma o caractere '0' no inteiro 0         
			   // (48 eh a posicao de '0' na tabela ASCII)         
			   num = (int)(CPF.charAt(i) - 48); 
		       sm = sm + (num * peso);
		       peso = peso - 1;
		   }

		   	r = 11 - (sm % 11);
			if ((r == 10) || (r == 11))
				dig10 = '0';
			else dig10 = (char)(r + 48); // converte no respectivo caractere numerico

			// Calculo do 2o. Digito Verificador
			sm = 0;
			peso = 11;
			
			for(i=0; i<10; i++) {
		        num = (int)(CPF.charAt(i) - 48);
		        sm = sm + (num * peso);
		        peso = peso - 1;
			}

			r = 11 - (sm % 11);
		    if ((r == 10) || (r == 11))
		        dig11 = '0';
		    else dig11 = (char)(r + 48);
		    
			// Verifica se os digitos calculados conferem com os digitos informados.
		    if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10)))
		         return(true);
			else return(false);
	    } catch (InputMismatchException erro) {
	    	return(false);
	    }
		
		
	}

}
