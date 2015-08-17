package com.test.groovy;

import java.io.File;
import java.io.IOException;

import groovy.lang.Binding;
import groovy.lang.GroovyClassLoader;
import groovy.util.GroovyScriptEngine;

public class Java2GroovyEngine {
//		String path = "C:\\normandy_workspace\\groovy\\src\\groovy\\";
	//将groovy脚本放在同一个包里
		private File groovyPath=new File("src/com/test/groovy");
		protected GroovyScriptEngine gse;
		protected Binding binding = new Binding();
		protected ClassLoader cl = getClass().getClassLoader();
		protected GroovyClassLoader groovyCl = new GroovyClassLoader(cl);
		protected Class groovyClass = null;
		public Java2GroovyEngine( ){
			try {
				gse=new GroovyScriptEngine(groovyPath.getPath());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}
