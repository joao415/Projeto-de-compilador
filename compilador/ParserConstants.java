package compilador;

public interface ParserConstants
{
    int START_SYMBOL = 35;

    int FIRST_NON_TERMINAL    = 35;
    int FIRST_SEMANTIC_ACTION = 62;

    int[][] PARSER_TABLE =
        {
            { -1,  0, -1, -1, -1, -1,  0, -1, -1, -1, -1, -1, -1,  0, -1,  0,  0,  0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
            { -1, 21, -1, -1, -1, -1, 21, -1, -1, -1, -1, -1, -1, 21, -1, 21, 21, 21, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
            { 23, 22, -1, -1, -1, -1, 22, -1, 23, 23, -1, -1, -1, 22, -1, 22, 22, 22, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
            { -1,  7,  7,  7,  7,  7, -1, -1, -1, -1,  7,  7, -1, -1,  7, -1, -1, -1, -1, -1, -1, -1,  7, -1, -1, -1, -1, -1, -1, -1,  7,  7, -1, -1 },
            { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,  8, -1, -1, -1, -1,  9, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
            { -1, 16, -1, -1, -1, -1, 20, -1, -1, -1, -1, -1, -1, 17, -1, 18, 18, 19, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
            { -1, 24, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
            { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 25, -1, 26, -1, -1, 26, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
            { -1,  1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
            { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,  3, -1,  2, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
            { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,  4, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
            { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,  5,  6, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
            { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 10, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
            { -1, -1, -1, -1, -1, -1, -1, -1, 11, 12, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
            { -1, -1, -1, -1, -1, -1, 13, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
            { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 15, -1, -1, -1, 14, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
            { -1, 27, 27, 27, 27, 27, -1, -1, -1, -1, 27, 27, -1, -1, 27, -1, -1, -1, -1, -1, -1, -1, 27, -1, -1, -1, -1, -1, -1, -1, 27, 27, -1, -1 },
            { -1, -1, -1, -1, -1, -1, -1, 29, -1, -1, -1, -1, 30, -1, -1, -1, -1, -1, 28, 28, -1, 28, -1, 28, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
            { -1, 31, 31, 31, 31, 31, -1, -1, -1, -1, 33, 34, -1, -1, 32, -1, -1, -1, -1, -1, -1, -1, 31, -1, -1, -1, -1, -1, -1, -1, 31, 31, -1, -1 },
            { -1, 35, 35, 35, 35, 35, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 35, -1, -1, -1, -1, -1, -1, -1, 35, 35, -1, -1 },
            { -1, -1, -1, -1, -1, -1, -1, 36, -1, -1, -1, -1, 36, -1, -1, -1, -1, -1, 36, 36, -1, 36, -1, 36, 37, 37, 37, 37, 37, 37, -1, -1, -1, -1 },
            { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 38, 39, 40, 41, 42, 43, -1, -1, -1, -1 },
            { -1, 44, 44, 44, 44, 44, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 44, -1, -1, -1, -1, -1, -1, -1, 44, 44, -1, -1 },
            { -1, -1, -1, -1, -1, -1, -1, 45, -1, -1, -1, -1, 45, -1, -1, -1, -1, -1, 45, 45, -1, 45, -1, 45, 45, 45, 45, 45, 45, 45, 46, 47, -1, -1 },
            { -1, 48, 48, 48, 48, 48, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 48, -1, -1, -1, -1, -1, -1, -1, 48, 48, -1, -1 },
            { -1, -1, -1, -1, -1, -1, -1, 49, -1, -1, -1, -1, 49, -1, -1, -1, -1, -1, 49, 49, -1, 49, -1, 49, 49, 49, 49, 49, 49, 49, 49, 49, 50, 51 },
            { -1, 52, 53, 54, 55, 56, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 57, -1, -1, -1, -1, -1, -1, -1, 58, 59, -1, -1 }
        };

    int[][] PRODUCTIONS = 
        {
            { 77, 83, 35, 78 },
            { 40, 21, 50, 43 },
            { 87, 22, 18, 50, 88 },
            { 86 },
            { 14, 23, 40, 89, 24 },
            { 16, 23, 37, 24 },
            { 17, 23, 37, 24, 79 },
            { 50, 76, 38 },
            { 19, 37 },
            {  0 },
            { 18, 23, 50, 24, 90, 35, 47, 10, 91 },
            { 92,  9, 35 },
            {  0 },
            {  7, 93, 23, 50, 24, 22, 18, 49, 94, 35, 10, 95 },
            { 15 },
            { 11 },
            { 42 },
            { 44 },
            { 45 },
            { 46 },
            { 48 },
            { 39, 20, 36 },
            { 35 },
            {  0 },
            {  2, 84, 41 },
            { 19, 40 },
            {  0 },
            { 52, 51 },
            {  0 },
            {  8, 52, 80, 51 },
            { 13, 52, 81, 51 },
            { 53 },
            { 15, 73 },
            { 11, 74 },
            { 12, 52, 75 },
            { 56, 54 },
            {  0 },
            { 55, 71, 56, 72 },
            { 25 },
            { 26 },
            { 27 },
            { 28 },
            { 29 },
            { 30 },
            { 58, 57 },
            {  0 },
            { 31, 58, 63, 57 },
            { 32, 58, 64, 57 },
            { 60, 59 },
            {  0 },
            { 33, 60, 65, 59 },
            { 34, 60, 66, 59 },
            {  2, 85 },
            {  3, 67 },
            {  4, 68 },
            {  5 },
            {  6, 82 },
            { 23, 50, 24 },
            { 31, 60 },
            { 32, 60, 70 }
        };

    String[] PARSER_ERROR =
    {
        "",
        "esperado EOF",
        "esperado identificador",
        "esperado constante_int",
        "esperado constante_float",
        "esperado constante_binaria",
        "esperado constante_string",
        "esperado check",
        "esperado and",
        "esperado else",
        "esperado end",
        "esperado false",
        "esperado not",
        "esperado or",
        "esperado read",
        "esperado true",
        "esperado write",
        "esperado writeln",
        "esperado if",
        "esperado \",\"",
        "esperado \";\"",
        "esperado \"=\"",
        "esperado \":\"",
        "esperado \"(\"",
        "esperado \")\"",
        "esperado \"==\"",
        "esperado \"!=\"",
        "esperado \"<\"",
        "esperado \"<=\"",
        "esperado \">\"",
        "esperado \">=\"",
        "esperado \"+\"",
        "esperado \"-\"",
        "esperado \"*\"",
        "esperado \"/\"",
        "esperado identificador check read write writeln if", 							   //"<lista_comandos> inválido",
        "esperado EOF identificador check else end read write writeln if", 				   //"<lista_comandos1> inválido",
        "esperado expressao",  									//<lista_expressao> inválido",
        "esperado , )", 										//<lista_expressao1> inválido",
        "esperado identificador check read write writeln if", 	//"<comando> inválido",
        "esperado identificador", 								//"<lista_id> inválido",
        "esperado , = )", 										//<lista_id1> inválido",
        "esperado identificador", 								//<atribuicao> inválido",
        "esperado ; :", 										//<atribuicao1> inválido",
        "esperado read", 										//<entrada_dados> inválido",
        "esperado write writeln", 								//<saida_dados> inválido",
        "esperado if", 											//<selecao> inválido",
        "esperado else end",									//<selecao1> inválido",
        "esperado check", 										//<repeticao> inválido",
        "esperado false true", 									//<repeticao1> inválido",
        "esperado expressao",  									//"<expressao> inválido",
        "esperado expressao", 			    			 		//<expressao_> inválido",
        "esperado expressao",  	 								//"<elemento> inválido",
        "esperado expressao", 				 					//"<relacional> inválido",
        "esperado expressao", 							    	//<relacional_> inválido",
        "esperado == != < <= > >=",        						//<operador_relacional> inválido",
        "esperado expressao", 		 					    	//"<aritmetica> inválido",
        "esperado expressao", 							    	//<aritmetica_> inválido",
        "esperado expressao", 				 			    	//"<termo> inválido",
        "esperado expressao", 						 			//<termo_> inválido",
        "esperado expressao", 				 			    	//<fator> inválido"
        "esperado identificador check read write writeln if", 	//<programa> inválido"
    };
}
