package util;

import java.lang.annotation.Annotation;
import java.util.List;

import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.Statement;

import utils.Lists;

class InjectingMethodInvoker extends Statement {

	private final FrameworkMethod method;
	private final TestingBase test;

	/**
	 * Erstellt einen neuen Method Invoker, der vor beim Aufrufen der Methode eine Paramterinjection durchführt.
	 */
	public InjectingMethodInvoker(FrameworkMethod method, TestingBase test) {
		this.method = method;
		this.test = test;
	}

	@Override
	public void evaluate() throws Throwable {
		
		List<Object> parameters = getInjectionParameters();

		this.method.invokeExplosively(test, parameters.toArray());
	}

	private List<Object> getInjectionParameters() {
		List<Object> parameters = Lists.newArrayList();

		for (Annotation[] annotations : method.getMethod().getParameterAnnotations()) {
			createInjectionParameter(parameters, annotations);
		}
		return parameters;
	}

	private void createInjectionParameter(List<Object> result, Annotation[] annotations) {
		if (annotations.length == 0) {
			throw new RuntimeException(String.format("The method has parameter that is not annotated with %s.",
					InjectSingleton.class.getSimpleName()));
		}

		for (Annotation annotation : annotations) {
			if (annotation.annotationType().equals(InjectSingleton.class)) {
				InjectSingleton injectSingleton = (InjectSingleton) annotation;
				result.add(test.getManager(injectSingleton.value()));
				return;
			}
		}
		throw new RuntimeException(String.format("The method has parameter that is not annotated with %s.",
				InjectSingleton.class.getSimpleName()));
	}
}