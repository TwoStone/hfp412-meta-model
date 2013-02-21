package util;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation zum Injecten von Singletons in GOJA.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(value = { ElementType.FIELD })
public @interface InjectSingleton {

	/**
	 * Die Klasse der Singletons, der injected werden soll.
	 */
	Class<?> value();
}
