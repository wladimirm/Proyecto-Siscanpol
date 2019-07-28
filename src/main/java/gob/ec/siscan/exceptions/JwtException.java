package gob.ec.siscan.exceptions;

public class JwtException extends UnauthorizedException {
    /**
	 * 
	 */
	private static final long serialVersionUID = -954173918084867846L;
	private static final String DESCRIPTION = "Jwt exception";

    public JwtException(String detail) {
        super(DESCRIPTION + ". " + detail);
    }

}
