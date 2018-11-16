package exercise1;

public class ExceptionThrower {
	//le throw peut détecter des erreurs que nous avons prévu, ces erreurs necessitent donc l'utilisation d'une autre classe
	// pour les traiter, une classe est necessaire par type d'erreur (erreurs prévue --> bien codé)
	void throwACustomExceptionWhenValueIs42(int value) {
		if (value ==42) {
			throw new ValueException42();
		}
	}
}
