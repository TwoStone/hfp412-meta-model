package util;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.List;

import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.FrameworkField;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.Statement;

import persistence.PersistentRoot;

/**
 * Ein JUnit 4 Testrunner für Tetsfälle für GOJA. Der TestRunner sorgt dafür, dass mit {@link InjectSingleton}
 * annotierte Felder korrekt belegt werden.
 */
public class GOJAUnitTestRunner extends BlockJUnit4ClassRunner {

	public GOJAUnitTestRunner(Class<? extends TestingBase> klass) throws InitializationError {
		super(klass);
	}

	@Override
	protected Object createTest() throws Exception {
		TestingBase testObject = (TestingBase) super.createTest();

		injectSingletons(testObject);

		return testObject;
	}

	@Override
	protected Statement methodInvoker(FrameworkMethod method, Object test) {
		assert test instanceof TestingBase;

		return new InjectingMethodInvoker(method, (TestingBase) test);
	}

	@Override
	protected void validatePublicVoidNoArgMethods(Class<? extends Annotation> annotation, boolean isStatic,
			List<Throwable> errors) {

		List<FrameworkMethod> methods = getTestClass().getAnnotatedMethods(annotation);

		for (FrameworkMethod currentMethod : methods) {
			currentMethod.validatePublicVoid(isStatic, errors);
		}
	}

	private void injectSingletons(TestingBase testObject) throws IllegalArgumentException, IllegalAccessException,
			NoSuchFieldException {

		for (FrameworkField field : this.getTestClass().getAnnotatedFields(InjectSingleton.class)) {
			injectField(testObject, field.getField());
		}
	}

	private void injectField(TestingBase testObject, Field field) throws IllegalAccessException, NoSuchFieldException {

		InjectSingleton annotation = field.getAnnotation(InjectSingleton.class);

		Class<? extends PersistentRoot> singletonClass = annotation.value();
		testObject.resetSingleton(singletonClass);
		PersistentRoot singleton = testObject.getManager(singletonClass);
		field.setAccessible(true);
		field.set(testObject, singleton);
	}

}
