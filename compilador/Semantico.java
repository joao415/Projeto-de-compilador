package compilador;
//  19 15
import java.util.Stack;

public class Semantico implements Constants {
	
	private String operador = "";
	private StringBuilder codigo = new StringBuilder();
	private Stack<String> pilhaTipos = new Stack<>();
	
	final String tipoFloat = "float64";
	final String tipoInt = "int64";
	final String tipoBoolean = "bool";
	final String tipoString = "string";

	public void executeAction(int action, Token token) throws SemanticError {
		System.out.println("Ação #" + action + ", Token: " + token);
		switch (action) {
		case 1:
			doAcaoSemantica1();
			break;
		case 2:
			doAcaoSemantica2();
			break;
		case 3:
			doAcaoSemantica3();
			break;
		case 4:
			doAcaoSemantica4();
			break;
		case 5:
			doAcaoSemantica5(token);
			break;
		case 6:
			doAcaoSemantica6(token);
			break;
		case 8:
			doAcaoSemantica8();
			break;
		case 9:
			doAcaoSemantica9(token);
			break;
		case 10:
			doAcaoSemantica10();
			break;
		case 11:
			doAcaoSemantica11();
			break;
		case 12:
			doAcaoSemantica12();
			break;
		case 13:
			doAcaoSemantica13();
			break;
		case 14:
			doAcaoSemantica14();
			break;
		case 15:
			doAcaoSemantica15();
			break;
		case 16:
			doAcaoSemantica16();
			break;
		case 17:
			doAcaoSemantica17();
			break;
		case 18:
			doAcaoSemantica18();
			break;
		case 19:
			doAcaoSemantica19();
			break;
		case 20:
			doAcaoSemantica20(token);
			break;
		}
	}
    
    public void doAcaoSemantica1() {
    	String tipo1 = pilhaTipos.pop();
    	String tipo2 = pilhaTipos.pop();

		if (tipo1.equals(tipoFloat) || tipo2.equals(tipoFloat)) {
    		pilhaTipos.push(tipoFloat);
    	} else {
    		pilhaTipos.push(tipoInt);
    	}
    	codigo.append("add\n");
    }
    
    public void doAcaoSemantica2() {
    	
    	String tipo1 = pilhaTipos.pop();
    	String tipo2 = pilhaTipos.pop();
    	
    	if(tipo1.equals(tipoFloat) || tipo2.equals(tipoFloat)) {
    		pilhaTipos.push(tipoFloat);
    	}else {
    		pilhaTipos.push(tipoInt);
    	}
    	codigo.append("sub\n");
    }
    
    public void doAcaoSemantica3() {
		String tipo1 = pilhaTipos.pop();
		String tipo2 = pilhaTipos.pop();

		if (tipo1.equals(tipoFloat) || tipo2.equals(tipoFloat)) {
			pilhaTipos.push(tipoFloat);
		} else {
			pilhaTipos.push(tipoInt);
		}
		codigo.append("mul\n");
	}

	public void doAcaoSemantica4() {
		String tipo1 = pilhaTipos.pop();
		String tipo2 = pilhaTipos.pop();

		if (tipo1.equals(tipoFloat) || tipo2.equals(tipoFloat)) {
			pilhaTipos.push(tipoFloat);
		} else {
			pilhaTipos.push(tipoInt);
		}
		codigo.append("div\n");
	}

	public void doAcaoSemantica5(Token token) {
		pilhaTipos.push(tipoInt);
		codigo.append("ldc.i8\t");
		codigo.append(token.getLexeme()+"\n");
		codigo.append("conv.r8" + "\n");
	}
	
	public void doAcaoSemantica6(Token token) {
		pilhaTipos.push(tipoFloat);
		codigo.append("ldc.r8\t" + token.getLexeme()+"\n");
	}
	
	public void doAcaoSemantica8() {
		codigo.append("ldc.i8 -1\n");
		codigo.append("conv.r8\n");
		codigo.append("mul\n");
	}
	
	public void doAcaoSemantica9(Token token) {
		operador = token.getLexeme();
	}
	
	public void doAcaoSemantica10() throws SemanticError {
		switch (operador) {
		
			case "==":
				codigo.append("ceq\n");
				break;
			case "<":
				codigo.append("clt\n");
				break;
			case ">":
				codigo.append("cgt\n");
				break;
			case ">=":
				codigo.append("clt\n");
				codigo.append("ldc.i4.0\n");
				codigo.append("ceq\n");
				break;
			case "<=":
				codigo.append("cgt\n");
				codigo.append("ldc.i4.0\n");
				codigo.append("ceq\n");
				break;
			case "!=":
				codigo.append("ceq\n");
				codigo.append("ldc.i4.0\n");
				codigo.append("ceq\n");
				break;
			default:
				throw new SemanticError(null);
		}
	}

	public void doAcaoSemantica11() {
		pilhaTipos.push(tipoBoolean);
		codigo.append("ldc.i4.1\n");
	}
	
	public void doAcaoSemantica12() {
		pilhaTipos.push(tipoBoolean);
		codigo.append("ldc.i4.0\n");
	}
	
	public void doAcaoSemantica13() {
		codigo.append("ldc.i4.1\n");
		codigo.append("xor\n");
	}

	public void doAcaoSemantica14() {
		String tipo = pilhaTipos.pop();
		if (tipo.equals(tipoInt)) {
			codigo.append("conv.i8\n");
		} 
		
		codigo.append(("call void [mscorlib]System.Console::Write(" + tipo + ")\n"));


	}
	
	public void doAcaoSemantica15() {
		codigo.append((".assembly extern mscorlib{} \n.assembly _codigo_objeto{} \n.module _codigo_objeto.exe  "
			   +"\n.class public _UNICA{ \n.method static public void _principal(){ \n.entrypoint\n"));
	}
	
	public void doAcaoSemantica16() {
		codigo.append("ret \n}\n}");
	}
	
	public void doAcaoSemantica17() {
        codigo.append("\n");
	}

	public void doAcaoSemantica18() {
		String tipo1 = pilhaTipos.pop();
		String tipo2 = pilhaTipos.pop();
		if (tipo1.equals(tipoBoolean) && tipo2.equals(tipoBoolean)) {
			pilhaTipos.push(tipoBoolean);
			codigo.append("and");
		}
	}

	public void doAcaoSemantica19() {
		String tipo1 = pilhaTipos.pop();
		String tipo2 = pilhaTipos.pop();
		if (tipo1.equals(tipoBoolean) && tipo2.equals(tipoBoolean)) {
			pilhaTipos.push(tipoBoolean);
			codigo.append("or");
		}
	}
	
	public void doAcaoSemantica20(Token token) {
		pilhaTipos.push(tipoString);
		codigo.append("ldstr\t" + token.getLexeme()+"\n");
	}

	public String getCodigo() {
		String cod = this.codigo.toString();
		return cod;
	}

}
