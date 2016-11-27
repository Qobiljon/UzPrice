package toshnazarov.uzprice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class UpdateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
    }

    public void updateClick(final View view) {
        Executor exec = Executors.newCachedThreadPool();
        exec.execute(new Runnable() {
            @Override
            public void run() {
                String raw = null;
                String filename = null;
                String[] cols = null;

                switch (view.getTag().toString()) {
                    case "communal":
                        break;
                    case "products":
                        break;
                    case "transport":
                        break;
                    case "tuitionfee":
                        raw = Tools.downloadRaw(Tools.no_tuitionfee);
                        filename = "tuitionfee.json";
                    {
                        try {
                            String rawCols = Tools.downloadCols(Tools.no_tuitionfee);
                            JSONArray arr = new JSONArray(rawCols);
                            cols = new String[arr.length()];
                            Log.e("LENGTH", cols.length + "");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                    case "currency":

                        break;
                    default:
                        break;
                }

                if (filename != null && raw != null && cols != null) {
                    File file = new File(getFilesDir(), filename);
                    try {
                        if (file.exists()) {
                            file.delete();
                        }
                        file.createNewFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    //FileOutputStream fos = new FileOutputStream();
                    //Tools.downloadString(Tools.url_json_medicine);
                    //Tools.downloadString(Tools.url_json_col_medicine);
                }
            }
        });
    }
}
