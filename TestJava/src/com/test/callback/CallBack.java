package com.test.callback;

/**  
 * 回调接口  
 */    
public interface CallBack {    
    /**  
     * 执行回调方法  
     * @param objects   将处理后的结果作为参数返回给回调方法  
     */    
    public void execute(Object... objects );    
} 