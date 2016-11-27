package toshnazarov.uzprice;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class CurrencyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency);

        initialize();
    }

    private void initialize() {
        value_text = (TextView) findViewById(R.id.currency_value);
        button_currency = (Button) findViewById(R.id.button_currency);

        Executor exec = Executors.newCachedThreadPool();
        exec.execute(new Runnable() {
            @Override
            public void run() {
                String data = Tools.downloadString("http://cbu.uz/uzc/arkhiv-kursov-valyut/xml/");
                data = data.substring(data.indexOf("<Ccy>USD</Ccy>"));

                Log.e("DATA", data);

                data = data.substring(data.indexOf("RU>") + 3);
                final String title = data.substring(0, data.indexOf('<'));

                data = data.substring(data.indexOf("<Rate>") + 6);
                final String value = data.substring(0, data.indexOf('<'));

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        button_currency.setText(title);
                        value_text.setText(String.format("1USD = %s sum", value));
                    }
                });
            }
        });
    }

    // region Variables
    private TextView value_text;
    private Button button_currency;
    // endregion
}
