package ru.javastudy.springMVC.model;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.compress.compressors.xz.XZCompressorInputStream;

import java.io.*;
public class Decoder {
    public static String decode(String s)throws IOException {

        byte[] bt = Base64.decodeBase64(s);
        ByteArrayInputStream stream = new ByteArrayInputStream(bt);
        XZCompressorInputStream xzIn = new XZCompressorInputStream(stream);
        byte[] result = new byte[bt.length];
        xzIn.read(result);
        xzIn.close();
        return new String(result);
    }
}
