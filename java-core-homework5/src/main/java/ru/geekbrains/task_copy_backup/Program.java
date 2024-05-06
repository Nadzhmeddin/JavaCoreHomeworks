package ru.geekbrains.task_copy_backup;

import java.io.*;

/**
 * Написать функцию, создающую резервную копию всех файлов в директории (без поддиректорий)
 * во вновь созданную папку ./backup
 */
public class Program {

    public static void main(String[] args) {
        backupProgram(".", "./backup");
    }

    /**
     * Метод копирования с помощью потоков.
     * @param directory корневая директория
     * @param backup новая созданная директория, куда копируются все файлы из корневой директории.
     */
    static void backupProgram(String directory, String backup) {
        File directoryFile = new File(directory);
        File backupDir = new File(backup);
        backupDir.mkdir();
        File [] files = directoryFile.listFiles();
        for(File file : files) {
            if(file.isFile()) {
                File backupFile = new File(backupDir.getPath(), file.getName());
                try (FileInputStream fileInputStream = new FileInputStream(file);
                     FileOutputStream fileOutputStream = new FileOutputStream(backupFile)) {
                    byte[] buffer = new byte[1024];
                    int i;
                    while ((i = fileInputStream.read()) != -1) {
                        fileOutputStream.write(buffer, 0, i);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
