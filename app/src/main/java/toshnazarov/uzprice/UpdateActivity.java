package toshnazarov.uzprice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import org.json.JSONArray;
import org.json.JSONException;

public class UpdateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
    }

    public void updateClick(View view) {
        String raw;
        String[] cols;

        switch (view.getTag().toString()) {
            case "communal":
                break;
            case "products":
                break;
            case "transport":
                break;
            case "tuitionfee":
                raw = Tools.downloadString(Tools.url_json_tuitionfee);
            {
                try {
                    JSONArray arr = new JSONArray(Tools.downloadString(Tools.url_json_col_tuitionfee));
                    cols = new String[arr.length()];
                    for (int n = 0; n < cols.length; n++) {
                        //cols[n] = arr.get(n);
                    }
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

        //Tools.downloadString(Tools.url_json_medicine);
        //Tools.downloadString(Tools.url_json_col_medicine);
    }
}
