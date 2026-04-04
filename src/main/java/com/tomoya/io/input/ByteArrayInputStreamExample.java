package com.tomoya.io.input;

import java.io.*;

/**********************************************************************
 * ByteArrayInputStream の基本動作を確認するためのサンプルクラス
 * --------------------------------------------------------------------
 * ByteArrayInputStream は、メモリ上の byte 配列を
 * InputStream として扱うためのクラスであり、ファイル I/O を伴わずに
 * InputStream の動作テスト・検証する際に有用である。
 * --------------------------------------------------------------------
 * このクラスでは、"Hello" を UTF-8 のバイト列として用意し、
 * read() による 1 バイトずつの読み込み動作を確認する。
 * FileInputStream と同様に、終端では -1 が返される。
 **********************************************************************/
public class ByteArrayInputStreamExample {
    // "Hello" を UTF-8 のバイト列に変換
    private static final byte[] DATA = "Hello".getBytes();
    private static int value;
    private static int count = 0;

    static void main(String[] args) throws IOException {

        // メモリ上の byte[] を InputStream として扱う
        try (ByteArrayInputStream bais = new ByteArrayInputStream(DATA)) {

            while ((value = bais.read()) != -1) {
                System.out.println("byte[" + count + "] = " + value);
                count++;
            }

            System.out.println("Total bytes read: " + count);

        } catch (IOException e) {
            e.printStackTrace(new PrintStream(System.out));
        }
    }
}
