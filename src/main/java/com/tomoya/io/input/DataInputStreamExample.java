package com.tomoya.io.input;

import java.io.*;

/**********************************************************************
 * DataInputStream の基本動作を確認するためのサンプルクラス
 * --------------------------------------------------------------------
 * DataInputStream は、InputStream から読み込んだバイト列を
 * int / long / float / double / boolean などのプリミティブ型として
 * 読み取るためのデコレーターである。
 * --------------------------------------------------------------------
 * このクラスでは、メモリ上の byte[] を ByteArrayInputStream として扱い
 * DataInputStream によるプリミティブ型の読み込み動作を確認する。
 * バイト列の並び順はビッグエンディアンで処理される。
 **********************************************************************/
public class DataInputStreamExample {
    // int(4バイト) と boolean(1バイト) を含むバイト列を用意
    private static final byte[] DATA = {
            0, 0, 0, 10,    // int 10
            1               // boolean true
    };

    static void main(String[] args) throws IOException {

        try (InputStream is = new ByteArrayInputStream(DATA);
             DataInputStream dis = new DataInputStream(is)) {

            int number = dis.readInt();         // 4バイト ⇒ int
            boolean flag =  dis.readBoolean();  // 1バイト ⇒ boolean

            System.out.println("readInt()     = " + number);
            System.out.println("readBoolean() = " + flag);
        }
        catch (IOException e) {
            e.printStackTrace(new PrintStream(System.out));
        }
    }
}
