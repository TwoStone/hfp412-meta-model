package util;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import persistence.PersistentRoot;

/**
 * Annotation zum Injecten von Singletons in GOJA. Das Feld muss dabei den Persistent*-Typen des Singletons habe. Als
 * Parameter erwartet die Annotation den Typen der Singletons, d.h. den gleichen Klassennamen wie das Feld hat nur ohne
 * "Persistent".
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(value = { ElementType.FIELD })
public @interface InjectSingleton {

	/**
	 * Die Klasse des Singleton, der injected werden soll.
	 */
	Class<? extends PersistentRoot> value();
}
