package com.test.newjdk7;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import static java.nio.file.StandardWatchEventKinds.*;
/**
 * 监听文件系统的更改
 * 实现流程如下
 * 1.为文件系统创建一个WatchService 实例 watcher
	2.为你想监听的目录注册 watcher。注册时，要注明监听那些事件。
	3.在无限循环里面等待事件的触发。当一个事件发生时，key发出信号，并且加入到watcher的queue
	4.从watcher的queue查找到key，你可以从中获取到文件名等相关信息
	5.遍历key的各种事件
	6.重置 key，重新等待事件
	7.关闭服务
 * @author kencs@foxmail.com
 */
public class TestWatcherService {
    
    private WatchService watcher;
    
    public TestWatcherService(Path path)throws IOException{
        watcher = FileSystems.getDefault().newWatchService();
        path.register(watcher, ENTRY_CREATE,ENTRY_DELETE,ENTRY_MODIFY);
    }
    
    public void handleEvents() throws InterruptedException{
        while(true){
            WatchKey key = watcher.take();
            for(WatchEvent<?> event : key.pollEvents()){
                WatchEvent.Kind kind = event.kind();
                
                if(kind == OVERFLOW){//事件可能lost or discarded
                    continue;
                }
                
                WatchEvent<Path> e = (WatchEvent<Path>)event;
                Path fileName = e.context();
                
                System.out.printf("Event %s has happened,which fileName is %s%n"
                        ,kind.name(),fileName);
            }
            if(!key.reset()){
                break;
            }
        }
    }
    
    public static void main(String args[]) throws IOException, InterruptedException{
        if(args.length!=1){
            System.out.println("请设置要监听的文件目录作为参数");
            System.exit(-1);
        }
        new TestWatcherService(Paths.get("D:\\work\\Test")).handleEvents();
    }
}
