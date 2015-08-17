package com.test.groovy;

import java.io.File;
import java.io.IOException;

import org.codehaus.groovy.control.CompilationFailedException;

import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyObject;
import groovy.util.ResourceException;
import groovy.util.ScriptException;

public class Person extends Java2GroovyEngine {
	private String name;

	private int age;
	
	public Person()
	{
		
	}

	public Person(String name, int age)
	{
		this.age = age;
		this.name = name;
	}
	/**
	 * 此方法会在groovy中调用
	 */
	public void sayHello()
	{
		System.out.println("hello, my name is: " + name + " ,and age is:" + age);
	}
	/**
	 * 调用groovy中的方法
	 */
	private void foo()
	{
		try
		{
			//groovyClass=groovyCl.parseClass(new File("src/com/test/groovy/GPerson.groovy")); 加载单个groovy脚本
			groovyClass=gse.loadScriptByName("GPerson");//根据groovy名称加载
			
			GroovyObject p = (GroovyObject) groovyClass.newInstance();
            IPerson iperson=(IPerson) groovyClass.newInstance();
            iperson.say("LUCK1");//调用GPerson.groovy实现接口IPerson的方法
			Object[] param = {"Luck2"};
			String rp=(String) p.invokeMethod("say", param);//调用GPerson.groovy自身的方法
			p.invokeMethod("foo", null);//调用GPerson.groovy自身的方法
			System.out.println("return="+rp);
			
			//
			binding.setVariable("input", "Groovy");

			gse.run("GroovyScript.groovy", binding);

			System.out.println(binding.getVariable("output"));
		}
		catch (CompilationFailedException e)
		{
			e.printStackTrace();
		}
		catch (InstantiationException e)
		{
			e.printStackTrace();
		}
		catch (IllegalAccessException e)
		{
			e.printStackTrace();
		}
		catch (ResourceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ScriptException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args)
	{
		Person p = new Person();
		
		p.foo();
	}

}
