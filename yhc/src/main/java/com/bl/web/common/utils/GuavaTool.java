package com.bl.web.common.utils;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/** 
 * @Project：yhc
 * @Package：com.bl.web.common.utils
 * @ClassName: GuavaTool 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author Yhc yinhc@yinhu.com
 * @date 2015年12月17日 下午3:31:37  
 */
public class GuavaTool {

	/**
	 * list转换为字符串
	 */
	@Test
	public void joinTest(){
	    List<String> names = Lists.newArrayList("John", "Jane", "Adam", "Tom");
	    String result = Joiner.on(",").join(names);
	 
	    assertEquals(result, "John,Jane,Adam,Tom");
	}


	/**
	 * map转换为字符串
	 */
	@Test
	public void whenConvertMapToString_thenConverted() {
	    Map<String, Integer> salary = Maps.newHashMap();
	    salary.put("John", 1000);
	    salary.put("Jane", 1500);
	    String result = Joiner.on(" , ").withKeyValueSeparator(" = ")
	                                    .join(salary);
	    System.out.println(result);
	}
	
	/**
	 * list转String，跳过null
	 */
	@Test
	public void whenConvertListToStringAndSkipNull_thenConverted() {
	    List<String> names = Lists.newArrayList("John", null, "Jane", "Adam", "Tom");
	    String result = Joiner.on(",").skipNulls().join(names);
	    System.out.println(result);
	    assertEquals(result, "John,Jane,Adam,Tom");
	}

	/**
	 * list转String，将null变成其他值
	 */
	@Test
	public void whenUseForNull_thenUsed() {
	    List<String> names = Lists.newArrayList("John", null, "Jane", "Adam", "Tom");
	    String result = Joiner.on(",").useForNull("nameless").join(names);
	    System.out.println(result);
	    assertEquals(result, "John,nameless,Jane,Adam,Tom");
	}
	
	/**
	 * String to List
	 */
	@Test
	public void whenCreateListFromString_thenCreated() {
	    String input = "apple - banana - orange";
	    List<String> result = Lists.newArrayList(Splitter.on("-").trimResults().split(input));
	    System.out.println(result);
	    //assertThat(result, contains("apple", "banana", "orange"));
	}

	/**
	 * String to Map
	 */
	@Test
	public void whenCreateMapFromString_thenCreated() {
	    String input = "John=first,Adam=second";
	    Map<String, String> result = Splitter.on(",")
	                                         .withKeyValueSeparator("=")
	                                         .split(input);
	 
	    assertEquals("first", result.get("John"));
	    assertEquals("second", result.get("Adam"));
	}

	/**
	 * 多个字符进行分割
	 */
	@Test
	public void whenSplitStringOnMultipleSeparator_thenSplit() {
	    String input = "apple.banana,,orange,,.";
	    List<String> result = Lists.newArrayList(Splitter.onPattern("[.|,]")
	                                  .omitEmptyStrings()
	                                  .split(input));
	    System.out.println(result);
	}
	
	/**
	 * 每隔多少字符进行分割
	 */
	@Test
	public void whenSplitStringOnSpecificLength_thenSplit() {
	    String input = "Hello world";
	    List<String> result = Lists.newArrayList(Splitter.fixedLength(3).split(input));
	    System.out.println(result);
	}

	/**
	 * 限制分割多少字后停止
	 */
	@Test
	public void whenLimitSplitting_thenLimited() {
	    String input = "a,b,c,d,e";
	    List<String> result = Lists.newArrayList(Splitter.on(",")
	                                  .limit(4)
	                                  .split(input));
	 
	    assertEquals(4, result.size());
	    System.out.println(result);
	}
 



}

	