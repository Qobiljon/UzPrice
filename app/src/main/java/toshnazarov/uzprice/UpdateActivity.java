package toshnazarov.uzprice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class UpdateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
    }

    public void updateClick(View view) {
        String data;

        switch (view.getTag().toString()) {
            case "communal":
                break;
            case "products":
                break;
            case "transport":
                break;
            case "tuitionfee":
                break;
            default:
                break;
        }

        Tools.downloadString(Tools.url_json_tuitionfee);
        Tools.downloadString(Tools.url_json_col_tuitionfee);
        Tools.downloadString(Tools.url_json_medicine);
        Tools.downloadString(Tools.url_json_col_medicine);
    }
}
