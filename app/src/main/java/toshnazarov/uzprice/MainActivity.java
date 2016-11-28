package toshnazarov.uzprice;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.EditorInfo;
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
            Animation disappear = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.disappear);
            disappear.setAnimationListener(new Animation.AnimationListener() {
                Animation appear = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.appear);

                @Override
                public void onAnimationStart(Animation animation) {

                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    mainContainer.setVisibility(View.GONE);
                    currentContainer.setVisibility(View.VISIBLE);
                    currentContainer.startAnimation(appear);
                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });
            mainContainer.startAnimation(disappear);
        }
    }

    public void toolsClick(View view) {
        switch (view.getTag().toString()) {
            case "currency": {
                Intent intent = new Intent(getApplicationContext(), CurrencyActivity.class);
                startActivityForResult(intent, 0);
            }
            break;
            case "calculator": {
                Intent intent = new Intent(getApplicationContext(), CalculatorActivity.class);
                startActivityForResult(intent, 0);
            }
            break;
            case "assets":
                break;
            default:
                break;
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
            Animation disappear = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.disappear);
            disappear.setAnimationListener(new Animation.AnimationListener() {
                Animation appear = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.appear);

                @Override
                public void onAnimationStart(Animation animation) {

                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    currentContainer.setVisibility(View.GONE);
                    mainContainer.setVisibility(View.VISIBLE);
                    mainContainer.startAnimation(appear);
                    currentContainer = null;
                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });
            currentContainer.startAnimation(disappear);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}
