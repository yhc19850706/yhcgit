package com.test.forkJoin;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.TimeUnit;
/**
 * 在一个文件夹及其子文件夹内查找确定扩展名的文件
 * @author lenovo
 *
 */
public class FolderProcessor extends RecursiveTask<List<String>> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String path;//文件夹的全路径
	private String extension;//文件的扩展名

	private long i=1_000_000;
	public FolderProcessor(String path, String extension) {
		this.path = path;
		this.extension = extension;
	}

	@Override
	protected List<String> compute() {
		// TODO Auto-generated method stub
		List<String> list=new ArrayList<>();
		
		List<FolderProcessor> tasks=new ArrayList<>();
		File file=new File(path);
		File content[] = file.listFiles();
		if(content!=null){
			for(int i=0;i<content.length;i++){
				if(content[i].isDirectory()){
					FolderProcessor task=new FolderProcessor(content[i].getPath(), extension);
					task.fork();
					tasks.add(task);
				}else{
					if(chedkFile(content[i].getName())){
						list.add(content[i].getAbsolutePath());
					}
				}
			}
		}
		if(tasks.size()>50){
			System.out.printf("%s:%d tasks ran.\n",file.getAbsoluteFile(),tasks.size());
		}
		addResultsFromTasks(list,tasks);
		return list;
	}

	private boolean chedkFile(String name) {
		// TODO Auto-generated method stub
		return name.endsWith(extension);
	}

	private void addResultsFromTasks(List<String> list,
			List<FolderProcessor> tasks) {
		// TODO Auto-generated method stub
		for(FolderProcessor item:tasks){
			list.addAll(item.join());
		}
	}

	public static void main(String[] args) {
		ForkJoinPool pool=new ForkJoinPool();
		FolderProcessor system=new FolderProcessor("C:\\Windows", "log");
		FolderProcessor apps=new FolderProcessor("C:\\Program Files", "log");
		FolderProcessor documents=new FolderProcessor("C:\\Documents And Settings", "log");
		pool.execute(system);
		pool.execute(apps);
		pool.execute(documents);
		do {
			System.out.printf("******************************************\n");
			System.out.printf("Main: Parallelism: %d\n",pool.
			getParallelism());
			System.out.printf("Main: Active Threads: %d\n",pool.
			getActiveThreadCount());
			System.out.printf("Main: Task Count: %d\n",pool.
			getQueuedTaskCount());
			System.out.printf("Main: Steal Count: %d\n",pool.
			getStealCount());
			System.out.printf("******************************************\n");
			try {
			TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
			e.printStackTrace();
			}
			} while((!system.isDone())||(!apps.isDone())||(!documents.
			isDone()));
		pool.shutdown();
		List<String> results;
		results=system.join();
		System.out.printf("System: %d files found.\n",results.size());
		for(String result:results){
			System.out.println(result);
		}
		results=apps.join();
		System.out.printf("Apps: %d files found.\n",results.size());
		for(String result:results){
			System.out.println(result);
		}
		results=documents.join();
		System.out.printf("Documents: %d files found.\n",results.
		size());
		for(String result:results){
			System.out.println(result);
		}
	}
}
