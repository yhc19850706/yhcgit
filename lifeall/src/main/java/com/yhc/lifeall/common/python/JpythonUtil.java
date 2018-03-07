package com.yhc.lifeall.common.python;

import org.python.core.PyFunction;
import org.python.core.PyList;
import org.python.core.PyObject;
import org.python.util.PythonInterpreter;

public class JpythonUtil {
    public static void main(String[] args) {
        PythonInterpreter interpreter = new PythonInterpreter();
        interpreter.execfile("/Users/yhc/mypython/CrawlNetData/crawlnet/cctvjingji.py");
        PyFunction pyFunction = interpreter.get("crawlcctv2", PyFunction.class); // 第一个参数为期望获得的函数（变量）的名字，第二个参数为期望返回的对象类型
        PyObject pyObject = pyFunction.__call__(); // 调用函数
        System.out.println(pyObject);
    }
}
