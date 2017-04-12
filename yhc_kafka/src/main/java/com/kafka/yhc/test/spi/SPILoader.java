package com.kafka.yhc.test.spi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.regex.Pattern;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * SPI扩展点获取。
 * <p>
 * <ul>
 * <li>自动注入关联扩展点。</li>
 * </ul>
 * 
 * @see <a
 *      href="http://java.sun.com/j2se/1.5.0/docs/guide/jar/jar.html#Service%20Provider">JDK1.5的SPI机制实现</a>
 * 
 */
public class SPILoader<T> {

//	private Log logger = LogFactory.getLog(SPILoader.class);

	private static final ConcurrentMap<Class<?>, SPILoader<?>> SPI_LOADERS = new ConcurrentHashMap<Class<?>, SPILoader<?>>();

	private static final ConcurrentMap<Class<?>, Object> SPI_INSTANCES = new ConcurrentHashMap<Class<?>, Object>();

	private static final String SPI_DIRECTORY = "spi/";

	private final Class<?> type;

	private String cachedDefaultName;

	private final ConcurrentMap<String, Holder<Object>> cachedInstances = new ConcurrentHashMap<String, Holder<Object>>();

	private final ConcurrentMap<Class<?>, String> cachedNames = new ConcurrentHashMap<Class<?>, String>();

	private final Holder<Map<String, Class<?>>> cachedClasses = new Holder<Map<String, Class<?>>>();

	private static final Pattern NAME_SEPARATOR = Pattern
			.compile("\\s*[,]+\\s*");

	private Map<String, IllegalStateException> exceptions = new ConcurrentHashMap<String, IllegalStateException>();

	private static <T> boolean withSPIAnnotation(Class<T> type) {
		return type.isAnnotationPresent(SPI.class);
	}

	@SuppressWarnings("unchecked")
	public static <T> SPILoader<T> getSPILoader(Class<T> type) {
		System.out.println("====1====getSPILoader====");
		System.out.println("type====="+type.getName());
		if (type == null)
			throw new IllegalArgumentException("SPI type == null");
		if (!type.isInterface()) {
			throw new IllegalArgumentException("SPI type(" + type
					+ ") is not interface!");
		}
		if (!withSPIAnnotation(type)) {
			throw new IllegalArgumentException("SPI type(" + type
					+ ") is not spi, because WITHOUT @"
					+ SPI.class.getSimpleName() + " Annotation!");
		}

		SPILoader<T> loader = (SPILoader<T>) SPI_LOADERS.get(type);
		if (loader == null) {
			SPI_LOADERS.putIfAbsent(type, new SPILoader<T>(type));
			loader = (SPILoader<T>) SPI_LOADERS.get(type);
		}
		return loader;
	}

	private SPILoader(Class<?> type) {
		System.out.println("====2====SPILoader(Class<?> type)====");
		this.type = type;
	}

	/**
	 * 返回指定名字的扩展。如果指定名字的扩展不存在，则抛异常 {@link IllegalStateException}.
	 * 
	 * @param name
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public T getSPI(String name) {
		System.out.println("====3====T getSPI(String name)====");
		if (name == null || name.length() == 0)
			throw new IllegalArgumentException("SPI name == null");
		if ("true".equals(name)) {
			return getDefaultSPI();
		}
		Holder<Object> holder = cachedInstances.get(name);
		if (holder == null) {
			cachedInstances.putIfAbsent(name, new Holder<Object>());
			holder = cachedInstances.get(name);
		}
		Object instance = holder.get();
		if (instance == null) {
			synchronized (holder) {
				instance = holder.get();
				if (instance == null) {
					instance = createSPI(name);
					holder.set(instance);
				}
			}
		}
		return (T) instance;
	}

	/**
	 * 获得所有SPI的Key集合
	 * 
	 * @return
	 */
	public Set<String> getSupportedSPIKeySet() {
		System.out.println("========Set<String> getSupportedSPIKeySet()====");
		Map<String, Class<?>> clazzes = getSPIClasses();
		return Collections
				.unmodifiableSet(new TreeSet<String>(clazzes.keySet()));
	}

	@SuppressWarnings("unchecked")
	private T createSPI(String name) {
		System.out.println("======4==T createSPI(String name)===="+name);
		Class<?> clazz = getSPIClasses().get(name);
		if (clazz == null) {
			throw findException(name);
		}
		try {
			T instance = (T) SPI_INSTANCES.get(clazz);
			if (instance == null) {
				SPI_INSTANCES.putIfAbsent(clazz, (T) clazz.newInstance());
				instance = (T) SPI_INSTANCES.get(clazz);
			}
			return instance;
		} catch (Throwable t) {
			throw new IllegalStateException("SPI instance(name: " + name
					+ ", class: " + type + ")  could not be instantiated: "
					+ t.getMessage(), t);
		}
	}

	/**
	 * 返回缺省的扩展，如果没有设置则返回<code>null</code>。
	 */
	public T getDefaultSPI() {
		System.out.println("========T getDefaultSPI()====");
		getSPIClasses();
		if (null == cachedDefaultName || cachedDefaultName.length() == 0
				|| "true".equals(cachedDefaultName)) {
			return null;
		}
		return getSPI(cachedDefaultName);
	}

	private Map<String, Class<?>> getSPIClasses() {
		System.out.println("====5====Map<String, Class<?>> getSPIClasses()====");
		Map<String, Class<?>> classes = cachedClasses.get();
		if (classes == null) {
			synchronized (cachedClasses) {
				classes = cachedClasses.get();
				if (classes == null) {
					classes = loadSPIClasses();
					cachedClasses.set(classes);
				}
			}
		}
		return classes;
	}

	private Map<String, Class<?>> loadSPIClasses() {
		System.out.println("====6====Map<String, Class<?>> loadSPIClasses()====");
		final SPI defaultAnnotation = type.getAnnotation(SPI.class);
		if (defaultAnnotation != null) {
			String value = defaultAnnotation.value();
			if (value != null && (value = value.trim()).length() > 0) {
				String[] names = NAME_SEPARATOR.split(value);
				if (names.length > 1) {
					throw new IllegalStateException(
							"more than 1 default spi name on SPI "
									+ type.getName() + ": "
									+ Arrays.toString(names));
				}
				if (names.length == 1)
					cachedDefaultName = names[0];
			}
		}

		Map<String, Class<?>> spiClasses = new HashMap<String, Class<?>>();
		loadFile(spiClasses, SPI_DIRECTORY);
		return spiClasses;
	}

	private void loadFile(Map<String, Class<?>> spiClasses, String dir) {
		System.out.println("===7=====loadFile===="+dir);
		String fileName = dir + type.getName();
		try {
			Enumeration<java.net.URL> urls;
			ClassLoader classLoader = findClassLoader();
			if (classLoader != null) {
				urls = classLoader.getResources(fileName);
			} else {
				urls = ClassLoader.getSystemResources(fileName);
			}
			if (urls != null) {
				while (urls.hasMoreElements()) {
					java.net.URL url = urls.nextElement();
					try {
						BufferedReader reader = new BufferedReader(
								new InputStreamReader(url.openStream(), "utf-8"));
						try {
							String line = null;
							while ((line = reader.readLine()) != null) {
								final int ci = line.indexOf('#');
								if (ci >= 0)
									line = line.substring(0, ci);
								line = line.trim();
								if (line.length() > 0) {
									try {
										String name = null;
										int i = line.indexOf('=');
										if (i > 0) {
											name = line.substring(0, i).trim();
											line = line.substring(i + 1).trim();
										} else {
											throw new IllegalStateException(
													"Error when load spi class(interface: "
															+ type
															+ ", file("
															+ url.getFile()
															+ ") has wrong format pattern not like key = value )");
										}
										if (line.length() > 0) {
											Class<?> clazz = Class.forName(
													line, true, classLoader);
											if (!type.isAssignableFrom(clazz)) {
												throw new IllegalStateException(
														"Error when load spi class(interface: "
																+ type
																+ ", class line: "
																+ clazz.getName()
																+ "), class "
																+ clazz.getName()
																+ "is not subtype of interface.");
											}

											clazz.getConstructor();
											String[] names = NAME_SEPARATOR
													.split(name);
											if (names != null
													&& names.length > 0) {
												for (String n : names) {
													if (!cachedNames
															.containsKey(clazz)) {
														cachedNames.put(clazz,
																n);
													}
													Class<?> c = spiClasses
															.get(n);
													if (c == null) {
														spiClasses
																.put(n, clazz);
													} else if (c != clazz) {
														throw new IllegalStateException(
																"Duplicate spi "
																		+ type.getName()
																		+ " name "
																		+ n
																		+ " on "
																		+ c.getName()
																		+ " and "
																		+ clazz.getName());
													}
												}
											}
										}
									} catch (Throwable t) {
										IllegalStateException e = new IllegalStateException(
												"Failed to load spi class(interface: "
														+ type
														+ ", class line: "
														+ line + ") in " + url
														+ ", cause: "
														+ t.getMessage(), t);
										exceptions.put(line, e);
									}
								}
							} // end of while read lines
						} finally {
							reader.close();
						}
					} catch (Throwable t) {
						t.printStackTrace();
//						logger.error(
//								"Exception when load spi class(interface: "
//										+ type + ", class file: " + url
//										+ ") in " + url, t);
					}
				} // end of while urls
			}
		} catch (Throwable t) {
			t.printStackTrace();
//			logger.error("Exception when load spi class(interface: " + type
//					+ ", description file: " + fileName + ").", t);
		}
	}

	private IllegalStateException findException(String name) {
		System.out.println("====8====findException===="+name);
		for (Map.Entry<String, IllegalStateException> entry : exceptions
				.entrySet()) {
			if (entry.getKey().toLowerCase().contains(name.toLowerCase())) {
				return entry.getValue();
			}
		}
		StringBuilder buf = new StringBuilder("No such spi " + type.getName()
				+ " by name " + name);

		int i = 1;
		for (Map.Entry<String, IllegalStateException> entry : exceptions
				.entrySet()) {
			if (i == 1) {
				buf.append(", possible causes: ");
			}

			buf.append("\r\n(");
			buf.append(i++);
			buf.append(") ");
			buf.append(entry.getKey());
			buf.append(":\r\n");
			buf.append(entry.getValue());
		}
		return new IllegalStateException(buf.toString());
	}

	private static ClassLoader findClassLoader() {
		System.out.println("====8====findClassLoader====");
		return SPILoader.class.getClassLoader();
	}

	@Override
	public String toString() {
		return this.getClass().getName() + "[" + type.getName() + "]";
	}

}