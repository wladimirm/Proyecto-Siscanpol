package gob.ec.siscan.exceptions;

public class FileException extends NotFoundException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String DESCRIPTION = "File exception";

    public FileException(String detail) {
        super(DESCRIPTION + ". " + detail);
    }

}
