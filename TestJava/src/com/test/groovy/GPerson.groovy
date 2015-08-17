
package com.test.groovy



/**
 * @author lenovo
 *
 */
public class GPerson implements IPerson{

	
	
	/* (non-Javadoc)
	 * 接口IPerson的具体实现,此方法会在java中调用
	 * @see com.test.groovy.IPerson#say(java.lang.String)
	 */
	public String say(String name){
		println "Hello, $name! ";
		name
		"hello name"
	}
	
	def foo(){
		Person p = new Person("TOM",45);
		p.sayHello();
	}
	
	static void main(args) {
//		GPerson gp = new GPerson();
//		gp.say("JACK");
//		
//		gp.foo();

     def excite = { word ->
         return "${word}!!"
        }
     assert "Groovy!!" == excite("Groovy")
     assert "Java!!" == excite.call("Java")
	}
	
}
