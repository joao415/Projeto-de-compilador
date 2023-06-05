package compilador;
//  19 15
import java.util.Stack;

public class Semantico implements Constants {
	
	private StringBuilder codigo;
	private Stack<String> pilhaTipos;
	String tipoFloat = "float64";
	String tipoInt = "int64";
	String tipoBoolean = "bool";

	public void executeAction(int action, Token token) throws SemanticError {
		System.out.println("Ação #" + action + ", Token: " + token);
	}
    
    public void doAcaoSemantica1() {
    	String tipo1 = pilhaTipos.pop();// não desempilhou
    	String tipo2 = pilhaTipos.pop();

		// transformado em atributo de classe
    	//String tipoFloat = "float64";
    	//String tipoInt = "int64";
    	
		if (tipo1 == tipoFloat || tipo2 == tipoFloat) {
    		pilhaTipos.push(tipoFloat);
    	} else {
    		pilhaTipos.push(tipoInt);
    	}
    	codigo.append("add");

    }
    
    public void doAcaoSemantica2() {
    	
    	String tipo1 = pilhaTipos.pop();
    	String tipo2 = pilhaTipos.pop();
    	
    	if(tipo1.equals(tipoFloat) || tipo2.equals(tipoFloat)) {
    		pilhaTipos.push(tipoFloat);
    	}else {
    		pilhaTipos.push(tipoInt);
    	}
    	codigo.append("\nsub\n");
    }

	public void doAcaoSemantica5(Token token) {
		pilhaTipos.push(tipoInt);
		codigo.append(token.getLexeme());
		codigo.append(".0");
	}
	
	public void doAcaoSemantica8() {
		codigo.append("\nldc.i8 -1\n");
		codigo.append("\nconv.r8\n");
		codigo.append("\nmul\n");
	}

	public void doAcaoSemantica11() {
		pilhaTipos.push(tipoBoolean);
		codigo.append("\nldc.i4.1\n");
	}
	
	public void doAcaoSemantica12() {
		pilhaTipos.push(tipoBoolean);
		codigo.append("false");
	}
	
	public void doAcaoSemantica13() {
		codigo.append("ldc.i4.1");
		codigo.append("xor");
	}

	public void doAcaoSemantica14() {
		String tipo = pilhaTipos.pop();
		if (tipo.equals("int64")) {
			// como converter para inteiro?
		}

		codigo.append("(" + tipo + ")");
		System.out.println("(" + tipo + ")");

	}
	
	public void doAcaoSemantica15() {
		codigo.append((".assembly extern mscorlib{} \n.assembly _codigo_objeto{} \n.module _codigo_objeto.exe  "
			   +"\n.class public _UNICA{ \n.method static public void _principal(){ \n.entrypoint"));
	}
	
	public void doAcaoSemantica16() {
		// TODO codigo.adiciona(ret }});
	}

	public void doAcaoSemantica19() {
		
	}
	
	public void doAcaoSemantica20(Token token) { // TODO
		pilhaTipos.push(tipoInt);
		codigo.append(token.getLexeme());
		codigo.append(".0");
	}

	public void doAcaoSemantica10() {
		// TODO
	}

}
