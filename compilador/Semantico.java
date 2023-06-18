package compilador;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Stack;
import java.util.regex.Pattern;

public class Semantico implements Constants {

	private static final String tipoFloat = "float64";
	private static final String tipoInt = "int64";
	private static final String tipoBoolean = "bool";
	private static final String tipoString = "string";
	private Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");

	private String operador = "";
	private StringBuilder codigo = new StringBuilder();
	private Stack<String> pilhaTipos = new Stack<String>();
	private LinkedHashMap<String, String> tabela_simbolos = new LinkedHashMap<>();
	private String listaId = "";

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
		case 21:
			doAcaoSemantica21();
			break;
		case 22:
			doAcaoSemantica22(token);
			break;
		case 23:
			doAcaoSemantica23(token);
			break;
		case 24:
			doAcaoSemantica24(token);
			break;
		case 25:
			doAcaoSemantica25();
			break;
		case 26:
			doAcaoSemantica26();
			break;
		case 27:
			doAcaoSemantica27();
			break;
		case 28:
			doAcaoSemantica28();
			break;
		case 29:
			doAcaoSemantica29();
			break;
		case 30:
			doAcaoSemantica30();
			break;
		case 31:
			doAcaoSemantica31();
			break;
		case 32:
			doAcaoSemantica32();
			break;
		case 33:
			doAcaoSemantica33();
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

		if (tipo1.equals(tipoFloat) || tipo2.equals(tipoFloat)) {
			pilhaTipos.push(tipoFloat);
		} else {
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
		String lexeme = token.getLexeme().replace(".", "");
		codigo.append(lexeme + "\n");
		codigo.append("conv.r8" + "\n");
	}

	public void doAcaoSemantica6(Token token) {
		pilhaTipos.push(tipoFloat);
		String lexeme = token.getLexeme().replace(".", "");
		lexeme = lexeme.replace(",", ".");
		codigo.append("ldc.r8\t" + lexeme + "\n");
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
		pilhaTipos.pop();
		pilhaTipos.pop();
		
		pilhaTipos.push(tipoBoolean);
		
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
				+ "\n.class public _UNICA{ \n.method static public void _principal(){ \n.entrypoint\n"));
	}

	public void doAcaoSemantica16() {
		codigo.append("ret \n}\n}");
	}

	public void doAcaoSemantica17() {
		codigo.append("ldstr " + "\"\\n\"\n");
		codigo.append("call void [mscorlib]System.Console::Write(string)\n");
	}

	public void doAcaoSemantica18() {
		String tipo1 = pilhaTipos.pop();
		String tipo2 = pilhaTipos.pop();
		if (tipo1.equals(tipoBoolean) && tipo2.equals(tipoBoolean)) {
			pilhaTipos.push(tipoBoolean);
			codigo.append("and ");
		}
	}

	public void doAcaoSemantica19() {
		String tipo1 = pilhaTipos.pop();
		String tipo2 = pilhaTipos.pop();
		if (tipo1.equals(tipoBoolean) && tipo2.equals(tipoBoolean)) {
			pilhaTipos.push(tipoBoolean);
			codigo.append("or ");
		}
	}

	public void doAcaoSemantica20(Token token) {
		pilhaTipos.push(tipoString);
		codigo.append("ldstr\t" + token.getLexeme() + "\n");
	}
	
	public void doAcaoSemantica21() {
		codigo.append(".locals(int64 _temp_int, float64 _temp_float,\r\n"
				+ " string _temp_str, bool _temp_bool)");
	}
	
	public void doAcaoSemantica22(Token token) {
		addListaId(token.getLexeme());
	}
	
	public void doAcaoSemantica23(Token token) {
		String[] identificadores = getIdentificadores();
		
		boolean encontrou = false;
		try { 
			String lexeme = token.getLexeme();
			for (String identificador : identificadores) {
				if (lexeme.equals(identificador)) {
					encontrou = true;
					break;
				}
			}
			if (!encontrou) {
				// TODO - tratar mensagem de erro 
			}
			
			String tipo = tipoString;
			codigo.append("(ldloc " +  lexeme + ")" + "\n");
			if (isNumero(lexeme)) {
				tipo = tipoInt;
				if (lexeme.contains(",")) {
					tipo = tipoFloat;
				} 
			}
			
			if (tipo.equals(tipoInt)) {
				codigo.append("conv.r8\n");
			}
			
		} catch (Exception e) {
			throw e;
		}
		
	}

	private String[] getIdentificadores() {
		String[] identificadores = getListaId().split(" ");
		return identificadores;
	}
	
	public void doAcaoSemantica24(Token token) {
		String tipo1 = pilhaTipos.pop();
		
		String[] identificadores = getIdentificadores();
		int n = identificadores.length -1 ;
		
		for (int i = 0; i <= n; i++) {
			codigo.append("dup");
		}
		
		for (String string : identificadores) {
			String id = tabela_simbolos.get(token.getLexeme());
			if (id == null) {
				tabela_simbolos.put(string, tipo1);
				codigo.append(".locals " + string);
			}
		}
		
		
	}
	public void doAcaoSemantica25() {
		codigo.append(".locals(int64 _temp_int, float64 _temp_float,\r\n"
				+ " string _temp_str, bool _temp_bool)");
	}
	public void doAcaoSemantica26() {
		codigo.append(".locals(int64 _temp_int, float64 _temp_float,\r\n"
				+ " string _temp_str, bool _temp_bool)");
	}
	public void doAcaoSemantica27() {
		codigo.append(".locals(int64 _temp_int, float64 _temp_float,\r\n"
				+ " string _temp_str, bool _temp_bool)");
	}
	public void doAcaoSemantica28() {
		codigo.append(".locals(int64 _temp_int, float64 _temp_float,\r\n"
				+ " string _temp_str, bool _temp_bool)");
	}
	
	public void doAcaoSemantica29() {
		codigo.append(".locals(int64 _temp_int, float64 _temp_float,\r\n"
				+ " string _temp_str, bool _temp_bool)");
	}
	
	public void doAcaoSemantica30() {
		codigo.append(".locals(int64 _temp_int, float64 _temp_float,\r\n"
				+ " string _temp_str, bool _temp_bool)");
	}
	
	public void doAcaoSemantica31() {
		codigo.append(".locals(int64 _temp_int, float64 _temp_float,\r\n"
				+ " string _temp_str, bool _temp_bool)");
	}
	
	public void doAcaoSemantica32() {
		codigo.append(".locals(int64 _temp_int, float64 _temp_float,\r\n"
				+ " string _temp_str, bool _temp_bool)");
	}
	
	public void doAcaoSemantica33() {
		codigo.append(".locals(int64 _temp_int, float64 _temp_float,\r\n"
				+ " string _temp_str, bool _temp_bool)");
	}

	public String getCodigo() {
		String cod = this.codigo.toString();
		return cod;
	}
	
	public String getListaId() {
		return listaId;
	}
	
	public void addListaId(String listaId) {
		this.listaId += listaId + " ";
	}
	
	public void clearIdentificadores() {
		this.listaId = "";
	}
	
	public boolean isNumero(String strNum) {
	    if (strNum == null) {
	        return false; 
	    }
	    return pattern.matcher(strNum).matches();
	}
	
}
