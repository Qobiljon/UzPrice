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

    public final static String url_xls_alcohol = "http://data.gov.uz/ru/datasets/download/65/xls";
    public final static String url_xls_bigmix = "http://data.gov.uz/ru/datasets/download/57/xls";
    public final static String url_xls_fuel = "http://data.gov.uz/ru/datasets/download/55/xls";
    public final static String url_xls_electricity = "http://data.gov.uz/ru/datasets/download/52/xls";
    public final static String url_json_tuitionfee = "http://data.gov.uz/ru/datasets/download/189/json";
    public final static String url_json_col_tuitionfee = "http://data.gov.uz/ru/convert/download/189?ext=json";
    public final static String url_html_water = "http://www.suvsoz.uz/abonentam/tariffs";
    public final static String url_json_medicine = "http://data.gov.uz/ru/datasets/download/614/json";
    public final static String url_json_col_medicine = "http://data.gov.uz/ru/convert/download/614?ext=json";
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
