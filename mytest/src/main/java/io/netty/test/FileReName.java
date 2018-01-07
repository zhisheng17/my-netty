package io.netty.test;

import java.io.File;

/**
 * Created by 10412 on 2018/1/6.
 */
public class FileReName
{
    public static void main(String[] args) {
        renameFiles("G:\\xxx\\");
    }

    public static void renameFiles(String path)
    {
        //遍历文件夹下所有单个文件尽心操作转移
        File file = new File(path);
        File[] files = file.listFiles();
        for (int i = 0; i < files.length; i++) {
            if(!files[i].isDirectory()){
//                System.out.println(files[i].getName());
                files[i].renameTo(new File(path + i +  ".jpg"));
            }
        }
        //直接通过文件夹重命名
//        File file1 = new File("C:\\Users\\ddd\\Documents\\Tencent Files\\ddd\\Image\\");
//        file1.renameTo(new File("重新定义的文件名"));
    }

}
