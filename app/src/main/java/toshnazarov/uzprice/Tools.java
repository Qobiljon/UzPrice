package toshnazarov.uzprice;

import android.content.SharedPreferences;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.Charset;

@SuppressWarnings("unused")
public class Tools {
    // region Variables
    public static SharedPreferences settings;

    public final String url_xls_alcohol = "http://data.gov.uz/ru/datasets/download/65/xls";

    // endregion

    public static byte[] download(String link) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        InputStream is = null;
        try {
            is = new URL(link).openStream();
            byte[] byteChunk = new byte[4096];
            int n;
            while ((n = is.read(byteChunk)) > 0)
                baos.write(byteChunk, 0, n);
        } catch (IOException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        byte[] res = baos.toByteArray();
        try {
            baos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }

    public static String downloadString(String link) {
        byte[] raw = download(link);
        return new String(raw, Charset.forName("utf-8"));
    }
}
