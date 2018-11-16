package exercise1;

public class ExceptionCatcher {
	private final ExceptionThrower exceptionThrower;

	public ExceptionCatcher(ExceptionThrower exceptionThrower) {
		this.exceptionThrower = exceptionThrower;
	}

	void executeExceptionThrowerSafely(int value) {
		//le try catch peut servir en cas de code mal fait à détecter n'importe quel type d'erreur (erreur non prévue --> bourrin)
		// mais peut aussi servir comme dans ce cas ci à détecter des erreurs auquelles on s'attend
		// ne nécessite pas de classe comme le throw
		try{
			exceptionThrower.throwACustomExceptionWhenValueIs42(value);
		}
		catch(RuntimeException e){ //e pour event, e est un objet de type évenement, il faudra toujours mettre e
			//RuntimeException est une fonction java qui est utilisée pour détecter les erreurs
			//System.out.println("La valeur est 42");
		}
	}
}
