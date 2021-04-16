package com.riansyah;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.MissingResourceException;

public class Configuration {
    //    path vs system
    private static String userDir = System.getProperty("user.home");
    private static Path workingDir = Paths.get(System.getProperty("user.dir"));
    static String config = userDir + FileSystems.getDefault().getSeparator() + "DFMC4J_JavaVersions_List.properties";
    public static Path getConfig(String path) {
//        resolve ?, menambahi path, seperti a/b/ + c = a/b/c
//        c adalah path tambahan yg jadi paramater di resolve(path_tambahan)
        return workingDir.resolve(path);
    }

    void read(){
//jadi bagaiman
        try {
            System.out.println("config file disini "+ config);

            System.out.println("working dir disini "+ workingDir);
            System.out.println("padahal filenya bisa diklik wkwk, " +
                    "Can't find configuration file "+ getConfig(config).toString() );
//            pencarian dilakukan disini
//            di kode mana itu terjadi ?
//            jika gagal sudah ada catch nya
        } catch (MissingResourceException var3) {
            System.exit(1);
        }
    }
}
