package havering.schoollookup;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void submitData(View button) {
        final EditText address = (EditText) findViewById(R.id.addrEditText);
        String addr = address.getText().toString();

        final EditText city = (EditText) findViewById(R.id.cityEditText);
        String ci = city.getText().toString();

        final Spinner spinState = (Spinner) findViewById(R.id.spinner);
        String state = spinState.getSelectedItem().toString();

        final EditText zip = (EditText) findViewById(R.id.zipEdit);
        String z = zip.getText().toString();

//        Log.d("ADDRESS", addr);
//        Log.d("CITY", ci);
//        Log.d("STATE", state);
    }


}
