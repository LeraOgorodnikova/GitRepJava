package ru.javastudy.springMVC.model;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.compress.compressors.xz.XZCompressorOutputStream;

public class Encoder {
    public static String encode(String s) throws IOException {

        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        XZCompressorOutputStream xzOut = new XZCompressorOutputStream(bout);
        xzOut.write(s.getBytes());
        xzOut.close();

        String result = Base64.encodeBase64String(bout.toByteArray());
        return result;
    }
}
