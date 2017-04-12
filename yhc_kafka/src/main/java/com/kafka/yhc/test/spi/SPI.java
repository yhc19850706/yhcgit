package com.kafka.yhc.test.spi;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 扩展点接口的标识。
 * <p />
 * 
 * @author sunsx
 * @export
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface SPI {
	/**
	 * 缺省扩展名
	 */
	String value() default "";
}
