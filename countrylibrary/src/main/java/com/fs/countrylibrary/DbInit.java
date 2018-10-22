package com.fs.countrylibrary;

import android.content.Context;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Administrator on 2018/5/28 0028.
 *
 * @author 这个是吧国家数据库导入到APP运行目录
 */

public class DbInit {


    /**
     * 数据库名称, 修改一次数据库就累加一次数据库名称
     */
    public static final String COUNTRY_DB_NAME = "country3.db";

    public static File importDatabase(Context context) {
        //存放数据库的目录
        String dirPath = context.getFilesDir().getPath();
        File dir = new File(dirPath);
        if (!dir.exists()) {
            dir.mkdir();
        }
        //数据库文件
        File file = new File(dir, COUNTRY_DB_NAME);
        if (!file.exists()) {
            try {
                file.createNewFile();
                //加载需要导入的数据库
                InputStream is = context.getResources().openRawResource(R.raw.country);
                FileOutputStream fos = new FileOutputStream(file);
                byte[] buffere = new byte[is.available()];
                is.read(buffere);
                fos.write(buffere);
                is.close();
                fos.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return file;
    }

}
