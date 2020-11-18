package br.uece.ligadin.CompanyService.exception;

public class CompanyEmptyOrNullException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CompanyEmptyOrNullException(String message) {
		super(message);
	}
}
