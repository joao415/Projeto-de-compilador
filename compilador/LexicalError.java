package compilador;
public class LexicalError extends AnalysisError
{
	private String lexema;
	 
    public LexicalError(String msg, int position, String lexema)
	 {
        super(msg, position);
        this.lexema = lexema;
    }

    public LexicalError(String msg)
    {
        super(msg);
    }

    public LexicalError() {
        super();
    }
    
    public String getLexema() {
		return lexema;
	}
}
