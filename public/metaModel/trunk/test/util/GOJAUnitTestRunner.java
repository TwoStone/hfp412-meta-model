package util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.InitializationError;

import utils.Lists;

public class GOJAUnitTestRunner extends BlockJUnit4ClassRunner {

	private final Class<? extends TestingBase> klass;
	private TestingBase testObject;

	public GOJAUnitTestRunner(Class<? extends TestingBase> klass) throws InitializationError {
		super(klass);
		this.klass = klass;
	}

	@Override
	protected Object createTest() throws Exception {
		testObject = (TestingBase) super.createTest();

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
			Class<?> singletonClass = annotation.value();
			testObject.resetSingleton(singletonClass);
			Object singleton = testObject.getManager(singletonClass);
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
