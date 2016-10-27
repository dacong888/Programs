package com.task004;

import java.io.File;
import java.util.Vector;

/*
 * ��ȡ�ƶ�Ŀ¼��mp3�ļ����������ļ�
 * ������ȡ���ļ��������ڿ���̨
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
					fileName.add(rootPath + "Ŀ¼��mp3�ļ���" + getFiles[i]);
				}else{
					StringBuffer tempPath = new StringBuffer(rootPath);
					tempPath.append("/");
					tempPath.append(getFiles[i]);
					listFileName(tempPath.toString(), fileName);//�ݹ��ļ�Ŀ¼
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
			System.out.println("audio·��û��mp3�ļ�.");
		}
	}
}
