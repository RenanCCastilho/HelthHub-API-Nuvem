package br.com.fiap.exception;

public class RegistroSaudeException extends RuntimeException {

	public RegistroSaudeException(String message) {
		super(message);
	}

	public RegistroSaudeException(String message, Throwable cause) {
		super(message, cause);
	}
}
