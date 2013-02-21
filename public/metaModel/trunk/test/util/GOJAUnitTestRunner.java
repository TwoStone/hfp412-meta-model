package util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.InitializationError;

import persistence.PersistentRoot;
import utils.Lists;

/**
 * Ein JUnit 4 Testrunner für Tetsfälle für GOJA. Der TestRunner sorgt dafür, dass mit {@link InjectSingleton}
 * annotierte Felder korrekt belegt werden.
 */
public class GOJAUnitTestRunner extends BlockJUnit4ClassRunner {

	private final Class<? extends TestingBase> klass;

	public GOJAUnitTestRunner(Class<? extends TestingBase> klass) throws InitializationError {
		super(klass);
		this.klass = klass;
	}

	@Override
	protected Object createTest() throws Exception {
		TestingBase testObject = (TestingBase) super.createTest();

		injectSingletons(testObject);

		return testObject;
	}

	private void injectSingletons(TestingBase testObject) throws IllegalArgumentException, IllegalAccessException,
			NoSuchFieldException {
		List<Field> fields = this.getFields(this.klass);
		for (Field field : fields) {
			injectField(testObject, field);
		}
	}

	private void injectField(TestingBase testObject, Field field) throws IllegalAccessException, NoSuchFieldException {
		InjectSingleton annotation = field.getAnnotation(InjectSingleton.class);
		if (annotation != null) {
			Class<? extends PersistentRoot> singletonClass = annotation.value();
			testObject.resetSingleton(singletonClass);
			PersistentRoot singleton = testObject.getManager(singletonClass);
			field.setAccessible(true);
			field.set(testObject, singleton);
		}
	}

	private List<Field> getFields(Class<?> cls) {
		if (cls == null) {
			return new ArrayList<Field>();
		}
		List<Field> fields = Lists.newArrayList(cls.getDeclaredFields());
		fields.addAll(getFields(cls.getSuperclass()));
		return fields;
	}

}
