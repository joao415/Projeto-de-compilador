package compilador;

import java.util.Stack;

public class Semantico implements Constants {
	
	private String operador = "";
	private String codigo;
	private Stack<String> pilhaTipos;
	String tipoFloat = "float64";
	String tipoInt = "int64";
	String tipoBoolean = "bool";

	public void executeAction(int action, Token token) throws SemanticError {
		System.out.println("Ação #" + action + ", Token: " + token);
	}
    
    public void doAcaoSemantica1() {
    	String tipo1 = pilhaTipos.peek();
    	String tipo2 = pilhaTipos.peek();

		// transformado em atributo de classe
    	//String tipoFloat = "float64";
    	//String tipoInt = "int64";
    	
		if (tipo1 == tipoFloat || tipo2 == tipoFloat) {
    		pilhaTipos.push(tipoFloat);
    	} else {
    		pilhaTipos.push(tipoInt);
    	}
    	// TODO codigo.adiciona(add);

    }
    
    public void doAcaoSemantica2() {
    	
    }

	public void doAcaoSemantica5(Token token) {
		pilhaTipos.push(tipoInt);
		codigo += token.getLexeme();
		codigo += ".0";
	}

	public void doAcaoSemantica12() {
		pilhaTipos.push(tipoBoolean);
		codigo += "false";
	}

	public void doAcaoSemantica14() {
		String tipo = pilhaTipos.pop();
		if (tipo.equals("int64")) {
			// como converter para inteiro?
		}

		codigo += "(" + tipo + ")";
		System.out.println("(" + tipo + ")");

	}

	public void doAcaoSemantica20(Token token) { // TODO
		pilhaTipos.push(tipoInt);
		codigo += token.getLexeme();
		codigo += ".0";
	}

	public void doAcaoSemantica10() {
		// TODO
	}

}
