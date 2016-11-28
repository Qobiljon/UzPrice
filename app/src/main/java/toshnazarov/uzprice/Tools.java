package toshnazarov.uzprice;

import android.content.SharedPreferences;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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
    public final static String url_html_water = "http://www.suvsoz.uz/abonentam/tariffs";

    public final static int no_tuitionfee = 189;
    public final static int no_medicine = 614;
    public final static int no_stipend = 808;
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

    public static String downloadCols(int dataset) {
        String colURL = String.format("http://data.gov.uz/ru/api/v1/json/dataset/%d?access_key=d399732be30e9e7528021bd292101ab8", dataset);
        return downloadString(colURL);
    }

    public static String downloadRaw(int dataset) {
        String versionURL = String.format(
                "http://data.gov.uz/ru/api/v1/json/dataset/%d/version?access_key=d399732be30e9e7528021bd292101ab8",
                dataset);
        int version;
        {
            String temp = new String(download(versionURL));
            version = Integer.parseInt(temp.substring(7, temp.indexOf(',')));
            try {
                JSONArray arr = new JSONArray(temp);
                for (int n = 0; n < arr.length(); n++) {
                    JSONObject object = arr.getJSONObject(n);
                    if (version < object.getInt("id"))
                        version = object.getInt("id");
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }

        String rawURL = String.format(
                "http://data.gov.uz/ru/api/v1/json/dataset/%d/version/%d?access_key=d399732be30e9e7528021bd292101ab8",
                dataset, version);

        return downloadString(rawURL);
    }

    public static String downloadString(String link) {
        byte[] raw = download(link);
        return new String(raw, Charset.forName("utf-8"));
    }
}
