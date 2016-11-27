package toshnazarov.uzprice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize();
    }

    private void initialize() {
        Tools.settings = getSharedPreferences("settings", MODE_PRIVATE);

        String tuitionJSON = Tools.downloadString(Tools.url_json_tuitionfee);
        String col_tuitionJSON = Tools.downloadString(Tools.url_json_col_tuitionfee);
        String medicine = Tools.downloadString(Tools.url_json_medicine);
        String col_medicine = Tools.downloadString(Tools.url_json_col_medicine);
    }

    private void updateDatabase(View view) {

    }
}
