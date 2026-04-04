package com.tomoya.io.input;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**********************************************************************
 * InputStreamReader の基本動作を確認するためのサンプルクラス
 * --------------------------------------------------------------------
 * InputStreamReader は、InputStream が読み込んだ「バイト列」を
 * 指定した文字コードに基づいて「文字（char）」へ変換する役割を持つ。
 * このクラスでは、1 文字ずつ読み込みながら、変換後の文字と
 * 元のバイト値（Unicode コードポイント）を確認する。
 * --------------------------------------------------------------------
 * InputStreamReader を使用することで、バイト列を人間が理解できる
 * 文字として扱えるようになる。文字コードを明示しない場合は
 * OD のデフォルトエンコーディングに依存するため、教材としては
 * UTF-8 を明示的に指定している。
 **********************************************************************/
public class InputStreamReaderExample {
    private static final String PATH = "src/main/resources/sample.txt";
    private static int data;
    private static int count = 0;

    void main(String[] args) throws IOException {
        
        // UTR-8 を明示してバイト ⇒ 文字変換を行う
        try(InputStreamReader isr =
                    new InputStreamReader(new FileInputStream(PATH), StandardCharsets.UTF_8)) {

            // read() は 1 文字分の Unicode コードポイントを返す
            while((data = isr.read()) != -1) {
                char ch = (char)data;
                System.out.print("char[" + count + "] = '" + ch + "' (" + data + ")\n");
                count++;
            }

            System.out.println("Total chars read: " + count);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace(new PrintStream(PATH));
        }
    }
}
