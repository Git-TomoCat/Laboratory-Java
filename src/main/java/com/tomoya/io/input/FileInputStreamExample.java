package com.tomoya.io.input;

import java.io.*;

/**********************************************************************
 * FileInputStream の基本動作を確認するためのサンプルクラス
 * --------------------------------------------------------------------
 * FileInputStream はファイルを「バイト単位」で読み込むための
 * 最も低レベルな入力ストリームであり、文字コードや行の概念を持たない。
 * このクラスでは、 read() による 1 バイトずつの読み込み動作と、
 * 終端（-1）の扱いを確認する。
 * --------------------------------------------------------------------
 * 対象ファイルは sample.bin とし、拡張子に意味はないが
 * 「バイト列として扱う」意図を明確にするために .bin を使用。
 **********************************************************************/
public class FileInputStreamExample {
    private static final String PATH = "src/main/resources/sample.bin";
    private static int data;
    private static int count = 0;

    void main(String[] args) {

        try(InputStream is = new FileInputStream(PATH)) {

            while ((data = is.read()) != -1) {
                System.out.println("byte[" + count + "] = " + data);
                count++;
            }

            System.out.println("Total data read: " + count);
        }
        catch (IOException e) {
            e.printStackTrace(new PrintStream(System.out));
        }
    }
}
