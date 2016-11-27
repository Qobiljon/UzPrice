package toshnazarov.uzprice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        initialize();
    }

    private void initialize() {
        // region Animations on splash screen
        View icon = findViewById(R.id.app_icon);
        Animation icon_anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.icon_anim);
        icon_anim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                View title = findViewById(R.id.app_title);
                View quot = findViewById(R.id.app_quot);
                title.setVisibility(View.VISIBLE);
                quot.setVisibility(View.VISIBLE);

                Animation title_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.ad_title);
                Animation quot_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.ad_title);

                title.startAnimation(title_in);
                quot.startAnimation(quot_in);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        icon.startAnimation(icon_anim);
        // endregion

        
    }
}
