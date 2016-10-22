/**
 * Created by 1 on 21.10.2016.
 */
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.compress.compressors.xz.XZCompressorInputStream;

import java.io.*;
public class Decoder {
    public static String decode(String s)throws IOException {
        /*BufferedReader bufferReader=new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter String: ");
        String s = bufferReader.readLine();*/
        //String s="/Td6WFoAAATm1rRGAgAhARYAAAB0L+WjAQBEQXBhY2hlIE1hdmVuIGlzIGEgc29mdHdhcmUgcHJvamVjdCBtYW5hZ2VtZW50IGFuZCBjb21wcmVoZW5zaW9uIHRvb2wuAAAAAMXaU7TVffeMAAFdRS0jJSkftvN9AQAAAAAEWVo=";

        byte[] bt = Base64.decodeBase64(s);
        ByteArrayInputStream stream = new ByteArrayInputStream(bt);
        XZCompressorInputStream xzIn = new XZCompressorInputStream(stream);
        byte[] result = new byte[bt.length];
        xzIn.read(result);
        xzIn.close();
        //System.out.println(new String(result));
        return new String(result);
    }
}
