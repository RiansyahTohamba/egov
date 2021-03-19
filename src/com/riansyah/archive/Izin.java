package com.riansyah.archive;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Izin {
//    contoh classitis , butuh 3 object untuk melakukan perform I/O
    void readDoc() throws IOException {
        String fileName = "izin_tanah_laeya.txt";
        FileInputStream fileStream =
                new FileInputStream(fileName);
//        FileInputStream provide only rudimentary I/O (dasar-dasar I/O saja)
//        it's not capable performing Buffering
//        it's not capable to read and write Serialized Object as well
        BufferedInputStream bufferedStream =
                new BufferedInputStream(fileStream);
//        so we adding BufferedInputStream to perform Buffering
        ObjectInputStream objectStream =
                new ObjectInputStream(bufferedStream);
//        and we adding ObjectInputStream to perform read and write Serialized Object

    }
}
