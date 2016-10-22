import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.compress.compressors.xz.XZCompressorOutputStream;
/**
 * Created by 1 on 21.10.2016.
 */
public class Encoder {
    public static String encode(String s) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //System.out.print("Enter String: ");
        //String s = br.readLine();

        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        XZCompressorOutputStream xzOut = new XZCompressorOutputStream(bout);
        xzOut.write(s.getBytes());
        xzOut.close();

        String result = Base64.encodeBase64String(bout.toByteArray());
       // System.out.println(result);
        return result;
    }
}
