package algocraft.creation;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.apache.log4j.Logger;

public enum FlyweightFactory {
    INSTANCE;
    
	private static final Logger LOG = Logger.getLogger(FlyweightFactory.class);

	public static <T> T get(final Class<T> class1) {
		T instance = null;
		try {
			if (class1.isAnnotationPresent(Singleton.class)) {
				LOG.info(class1 + " is singleton.");
				instance = Registry.INSTANCE.get(class1);
				if (instance == null) {
					instance = class1.newInstance();
					Registry.INSTANCE.put(class1, instance);
				}
			} else {
				instance = class1.newInstance();
			}
		} catch (InstantiationException e) {
			LOG.error("Error", e);
		} catch (IllegalAccessException e) {
			LOG.error("Error", e);
		}
		return instance;
	}

	private enum Registry {
		INSTANCE;

		private final ConcurrentMap<Class<?>, Object> MAP = new ConcurrentHashMap<Class<?>, Object>();

		@SuppressWarnings("unchecked")
		private <T> T get(final Class<T> class1) {
			return (T) MAP.get(class1);
		}

		private <T> void put(final Class<T> class1, final T instance) {
			MAP.putIfAbsent(class1, instance);
		}
	}
}
