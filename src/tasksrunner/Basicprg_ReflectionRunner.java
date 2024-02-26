package tasksrunner;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Basicprg_ReflectionRunner {

	private Logger logger = Logger.getLogger(Basicprg_ReflectionRunner.class.getName());

	public void taskRunner() {
		try {
			Class<?> newClass = Class.forName("task.Circle");
			Object constructor = newClass.getDeclaredConstructor().newInstance();

			Constructor<?> parametrizedCon = newClass.getDeclaredConstructor(String.class, int.class);
			Object parametrizedConObj = parametrizedCon.newInstance("hello", 110);
			logger.info(parametrizedConObj.toString());

			Method setString = newClass.getDeclaredMethod("setInputString", String.class);
			setString.invoke(constructor, "Hello hello World");

			Method getString = newClass.getDeclaredMethod("getInputString");
			logger.info(getString.invoke(constructor).toString());

		} 
		catch (NoSuchMethodException | SecurityException e) {
			logger.log(Level.INFO, "An Exception Occured", e);
		}
		catch (InstantiationException e) {
			logger.log(Level.INFO, "An Exception Occured", e);
		}
		catch (IllegalAccessException e) {
			logger.log(Level.INFO, "An Exception Occured", e);
		}
		catch (IllegalArgumentException e) {
			logger.log(Level.INFO, "An Exception Occured", e);
		}
		catch (InvocationTargetException e) {
			logger.log(Level.INFO, "An Exception Occured", e);
		}
		catch (ClassNotFoundException e) {
			logger.log(Level.INFO, "An Exception Occured", e);
		}
	}

}
