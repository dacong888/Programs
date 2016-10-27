package com.task004;

import java.io.File;
import java.util.Vector;

/*
 * 读取制定目录的mp3文件，包括子文件
 * 将所读取的文件名呈现在控制台
 */
public class FileOperator {

	public static int listFileName(String rootPath, Vector<String> fileName){
		File files = new File(rootPath);
		String[] getFiles = files.list();
		if (getFiles.length <= 0) {
			return getFiles.length;
		}
		else{
			for(int i = 0; i < getFiles.length; i++){
				if (getFiles[i].endsWith("mp3")) {
					fileName.add(rootPath + "目录下mp3文件：" + getFiles[i]);
				}else{
					StringBuffer tempPath = new StringBuffer(rootPath);
					tempPath.append("/");
					tempPath.append(getFiles[i]);
					listFileName(tempPath.toString(), fileName);//递归文件目录
				}
			}
		}
		
		return fileName.size();
	}
	
	public static void main(String[] args){
		Vector<String> mp3FilesName = new Vector<>();
		int fileCounts = listFileName("./audio", mp3FilesName);
		if (fileCounts > 0) {
			for(int i = 0; i < mp3FilesName.size(); i++){
				System.out.println(mp3FilesName.get(i));
			}
		}
		else{
			System.out.println("audio路径没有mp3文件.");
		}
	}
}
