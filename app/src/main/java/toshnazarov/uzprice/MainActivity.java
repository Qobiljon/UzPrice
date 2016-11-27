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


    }

    private void updateDatabase(View view) {
        
    }
}
