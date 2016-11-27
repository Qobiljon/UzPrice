package toshnazarov.uzprice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize();
    }

    private void initialize() {
        Log.e("DATA", "[\"\\u041f\\u043e\\u0440\\u044f\\u0434\\u043e\\u043a\",\"Code\",\"\\u0422\\u0438\\u043f \\u044d\\u043b\\u0435\\u043c\\u0435\\u043d\\u0442\\u0430\",\"\\u041d\\u0430\\u0438\\u043c\\u0435\\u043d\\u043e\\u0432\\u0430\\u043d\\u0438\\u0435 (\\u0420\\u0443\\u0441)\",\"\\u041d\\u0430\\u0438\\u043c\\u0435\\u043d\\u043e\\u0432\\u0430\\u043d\\u0438\\u0435 (\\u0423\\u0437\\u0431)\",\"\\u041e\\u0431\\u044f\\u0437\\u0430\\u0442\\u0435\\u043b\\u044c\\u043d\\u044b\\u0439\",\"\\u0414\\u043b\\u0438\\u043d\\u0430\",[1,\"G1\",\"\\u0421\\u0442\\u0440\\u043e\\u043a\\u0430\",\"\\u0422\\u0438\\u043f \\u043e\\u0431\\u0440\\u0430\\u0437\\u043e\\u0432\\u0430\\u043d\\u0438\\u044f\",\"\\u0422\\u0430\\u044a\\u043b\\u0438\\u043c \\u0442\\u0443\\u0440\\u0438\",\"1\",\"2\"],[2,\"G2\",\"\\u0421\\u0442\\u0440\\u043e\\u043a\\u0430\",\"\\u0421\\u0444\\u0435\\u0440\\u0430 \\u043e\\u0431\\u0440\\u0430\\u0437\\u043e\\u0432\\u0430\\u043d\\u0438\\u044f (\\u0443\\u0437\\u0431)\",\"\\u0422\\u0430\\u044a\\u043b\\u0438\\u043c \\u0441\\u043e\\u04b3\\u0430\\u0441\\u0438\",\"1\",\"68\"],[3,\"G3\",\"\\u0422\\u0435\\u043a\\u0441\\u0442 (\\u0441\\u0442\\u0440\\u043e\\u043a\\u0430 \\u0431\\u043e\\u043b\\u044c\\u0448\\u0435 \\u0447\\u0435\\u043c 255 \\u0441\\u0438\\u043c\\u0432\\u043e\\u043b\\u043e\\u0432)\",\"\\u041d\\u0430\\u043f\\u0440\\u0430\\u0432\\u043b\\u0435\\u043d\\u0438\\u0435 \\u043e\\u0431\\u0440\\u0430\\u0437\\u043e\\u0432\\u0430\\u043d\\u0438\\u044f (\\u0443\\u0437\\u0431)\",\"\\u0422\\u0430\\u044a\\u043b\\u0438\\u043c \\u0439\\u045e\\u043d\\u0430\\u043b\\u0438\\u0448\\u0438\",\"1\",\"267\"],[4,\"G4\",\"\\u0421\\u0442\\u0440\\u043e\\u043a\\u0430\",\"\\u0421\\u0444\\u0435\\u0440\\u0430 \\u043e\\u0431\\u0440\\u0430\\u0437\\u043e\\u0432\\u0430\\u043d\\u0438\\u044f\",\"\\u0422\\u0430\\u044a\\u043b\\u0438\\u043c \\u0441\\u043e\\u04b3\\u0430\\u0441\\u0438 (\\u0440\\u0443\\u0441)\",\"1\",\"77\"],[5,\"G5\",\"\\u0422\\u0435\\u043a\\u0441\\u0442 (\\u0441\\u0442\\u0440\\u043e\\u043a\\u0430 \\u0431\\u043e\\u043b\\u044c\\u0448\\u0435 \\u0447\\u0435\\u043c 255 \\u0441\\u0438\\u043c\\u0432\\u043e\\u043b\\u043e\\u0432)\",\"\\u041d\\u0430\\u043f\\u0440\\u0430\\u0432\\u043b\\u0435\\u043d\\u0438\\u0435 \\u043e\\u0431\\u0440\\u0430\\u0437\\u043e\\u0432\\u0430\\u043d\\u0438\\u044f\",\"\\u0422\\u0430\\u044a\\u043b\\u0438\\u043c \\u0439\\u045e\\u043d\\u0430\\u043b\\u0438\\u0448\\u0438 (\\u0440\\u0443\\u0441)\",\"1\",\"283\"],[6,\"G6\",\"\\u0412\\u0435\\u0449\\u0435\\u0441\\u0442\\u0432\\u0435\\u043d\\u043d\\u044b\\u0439\",\"\\u0421\\u0442\\u043e\\u0438\\u043c\\u043e\\u0441\\u0442\\u044c \\u043e\\u0447\\u043d\\u043e\\u0433\\u043e \\u043e\\u0431\\u0440\\u0430\\u0437\\u043e\\u0432\\u0430\\u043d\\u0438\\u044f 2016-2017 \\u0443\\u0447\\u0435\\u0431\\u043d\\u044b\\u0439 \\u0433\\u043e\\u0434 (\\u0442\\u044b\\u0441. \\u0441\\u0443\\u043c)\",\"\\u041a\\u0443\\u043d\\u0434\\u0443\\u0437\\u0433\\u0438 \\u0442\\u0430\\u044a\\u043b\\u0438\\u043c \\u043d\\u0430\\u0440\\u04b3\\u0438 2016-2017 \\u045e\\u049b\\u0443\\u0432 \\u0439\\u0438\\u043b\\u0438 (\\u043c\\u0438\\u043d\\u0433. \\u0441\\u0443\\u043c)\",\"1\",\"5\"],[7,\"G7\",\"\\u0412\\u0435\\u0449\\u0435\\u0441\\u0442\\u0432\\u0435\\u043d\\u043d\\u044b\\u0439\",\"\\u0421\\u0442\\u043e\\u0438\\u043c\\u043e\\u0441\\u0442\\u044c \\u0441\\u043f\\u0435\\u0446\\u0438\\u0430\\u043b\\u044c\\u043d\\u043e\\u0433\\u043e \\u0437\\u0430\\u043e\\u0447\\u043d\\u043e\\u0433\\u043e \\u043e\\u0431\\u0440\\u0430\\u0437\\u043e\\u0432\\u0430\\u043d\\u0438\\u044f 2016-2017 \\u0443\\u0447\\u0435\\u0431\\u043d\\u044b\\u0439 \\u0433\\u043e\\u0434 (\\u0442\\u044b\\u0441. \\u0441\\u0443\\u043c)\",\"\\u041c\\u0430\\u0445\\u0441\\u0443\\u0441 \\u0441\\u0438\\u0440\\u0442\\u049b\\u0438 \\u0442\\u0430\\u044a\\u043b\\u0438\\u043c \\u043d\\u0430\\u0440\\u0445\\u0438 2016-2017 \\u045e\\u049b\\u0443\\u0432 \\u0439\\u0438\\u043b\\u0438 (\\u043c\\u0438\\u043d\\u0433. \\u0441\\u0443\\u043c)\",\"0\",\"4\"]]");

        Tools.settings = getSharedPreferences("settings", MODE_PRIVATE);

        tools_container = findViewById(R.id.tools_container);
        communal_container = findViewById(R.id.communal_container);
        education_container = findViewById(R.id.education_container);
        transport_container = findViewById(R.id.transport_container);

        mainContainer = findViewById(R.id.main_container);
        search_button = (ImageButton) findViewById(R.id.button_search);
        search_text = (EditText) findViewById(R.id.edittext_search);

        search_text.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    search_button.performClick();
                }
                return false;
            }
        });
    }

    // region Variables
    private View currentContainer;
    private View mainContainer;
    private ImageButton search_button;
    private EditText search_text;

    private View tools_container;
    private View communal_container;
    private View education_container;
    private View transport_container;
    // endregion

    public void moveToScreen(View view) {
        switch (view.getTag().toString()) {
            case "tools":
                currentContainer = tools_container;
                break;
            case "communal":
                currentContainer = communal_container;
                break;
            case "education":
                currentContainer = education_container;
                break;
            case "transport":
                currentContainer = transport_container;
                break;
            default:
                break;
        }

        if (currentContainer != null) {
            mainContainer.setVisibility(View.GONE);
            currentContainer.setVisibility(View.VISIBLE);
        }
    }

    public void updateDatabase(View view) {
        Intent intent = new Intent(getApplicationContext(), UpdateActivity.class);
        startActivityForResult(intent, 0);
    }

    public void searchClick(View view) {
        String query = search_text.getText().toString();
    }

    @Override
    public void onBackPressed() {
        if (currentContainer == null) {
            super.onBackPressed();
        } else {
            mainContainer.setVisibility(View.VISIBLE);
            currentContainer.setVisibility(View.GONE);
            currentContainer = null;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}
