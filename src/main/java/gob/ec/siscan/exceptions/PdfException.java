package gob.ec.siscan.exceptions;

public class PdfException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = -331376403756920392L;
	private static final String DESCRIPTION = "File exception";

    public PdfException(String detail) {
        super(DESCRIPTION + ". " + detail);
    }

}
