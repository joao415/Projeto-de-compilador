package compilador;

public interface Constants extends ScannerConstants, ParserConstants
{
    int EPSILON  = 0;
    int DOLLAR   = 1;

    int t_identificador = 2;
    int t_constante_int = 3;
    int t_constante_float = 4;
    int t_constante_binaria = 5;
    int t_constante_string = 6;
    int t_pr_check = 7;
    int t_pr_and = 8;
    int t_pr_else = 9;
    int t_pr_end = 10;
    int t_pr_false = 11;
    int t_pr_not = 12;
    int t_pr_or = 13;
    int t_pr_read = 14;
    int t_pr_true = 15;
    int t_pr_write = 16;
    int t_pr_writeln = 17;
    int t_pr_if = 18;
    int t_TOKEN_19 = 19; //","
    int t_TOKEN_20 = 20; //";"
    int t_TOKEN_21 = 21; //"="
    int t_TOKEN_22 = 22; //":"
    int t_TOKEN_23 = 23; //"("
    int t_TOKEN_24 = 24; //")"
    int t_TOKEN_25 = 25; //"=="
    int t_TOKEN_26 = 26; //"!="
    int t_TOKEN_27 = 27; //"<"
    int t_TOKEN_28 = 28; //"<="
    int t_TOKEN_29 = 29; //">"
    int t_TOKEN_30 = 30; //">="
    int t_TOKEN_31 = 31; //"+"
    int t_TOKEN_32 = 32; //"-"
    int t_TOKEN_33 = 33; //"*"
    int t_TOKEN_34 = 34; //"/"

}
