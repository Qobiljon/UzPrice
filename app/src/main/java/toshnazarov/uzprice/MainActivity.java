package toshnazarov.uzprice;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.TransitionDrawable;
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
import android.widget.Toast;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

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
        rootview = findViewById(R.id.root_container);

        mainContainer = findViewById(R.id.main_container);
        search_button = (ImageButton) findViewById(R.id.button_search);
        search_text = (EditText) findViewById(R.id.edittext_search);

        search_text.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (b) {
                    ColorDrawable[] color = new ColorDrawable[]{new ColorDrawable(Color.WHITE), new ColorDrawable(Color.GRAY)};
                    TransitionDrawable trans = new TransitionDrawable(color);
                    trans.startTransition(700);
                    rootview.setBackgroundDrawable(trans);
                }
            }
        });

        search_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ColorDrawable[] color = new ColorDrawable[]{new ColorDrawable(Color.WHITE), new ColorDrawable(Color.GRAY)};
                TransitionDrawable trans = new TransitionDrawable(color);
                trans.startTransition(700);
                rootview.setBackgroundDrawable(trans);
            }
        });

        search_text.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    search_button.performClick();

                    ColorDrawable[] color = new ColorDrawable[]{new ColorDrawable(Color.GRAY), new ColorDrawable(Color.WHITE)};
                    TransitionDrawable trans = new TransitionDrawable(color);
                    trans.startTransition(600);
                    rootview.setBackgroundDrawable(trans);
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
    private View rootview;

    private View tools_container;
    private View communal_container;
    private View education_container;
    private View transport_container;

    private boolean terminate = false;
    // endregion

    public void moveToScreen(View view) {
        terminate = false;
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
            case "products":
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

    public void infoClick(final View view) {
        Executor exec = Executors.newCachedThreadPool();

        exec.execute(new Runnable() {
            @Override
            public void run() {
                String data = null;
                switch (view.getTag().toString()) {
                    case "info_tuition":
                        data = Tools.downloadRaw(Tools.no_tuitionfee);
                        break;
                    case "info_stipend":
                        data = Tools.downloadRaw(Tools.no_stipend);
                        break;
                    default:
                        break;
                }

                Bundle bundle = new Bundle();
                bundle.putString("rawdata", data);
                Intent intent = new Intent(getApplicationContext(), InfoActivity.class);
                intent.putExtras(bundle);
                startActivityForResult(intent, 0);
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (currentContainer == null) {
            if (terminate)
                super.onBackPressed();
            else {
                terminate = true;
                Toast.makeText(getApplicationContext(), getString(R.string.tap2quit), Toast.LENGTH_SHORT).show();
            }
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
