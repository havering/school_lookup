package havering.schoollookup;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.util.Log;
import java.io.InputStream;
import java.net.URL;
import java.net.HttpURLConnection;
import java.io.BufferedInputStream;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner;
    private config c;
    public final static String apiURL = "http://api.greatschools.org/schools/nearby?";

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
        // gather data from form
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

        String assembled = assembleURL(addr, ci, state, z);

        new CallAPI().execute(assembled);
    }

    public String getKey() {
        return c.getter();
    }

    public String assembleURL(String a, String ci, String s, String z) {
        // API key held in config file but retrieved for API call
        final String key = getKey();

        String converted = convertState(ci);

        String urlString = apiURL + "key=" + key + "&address=" + a + "&city=" + converted + "&state=" + s + "&zip=" + z + "&schoolType=public";

        return urlString;
    }

    private class CallAPI extends AsyncTask<String, String, String> {
        @Override
        protected String doInBackground(String... params) {

            String urlString=params[0]; // URL to call

            String resultToDisplay = "";

            InputStream in = null;

            // HTTP Get
            try {

                URL url = new URL(urlString);

                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

                in = new BufferedInputStream(urlConnection.getInputStream());

            } catch (Exception e ) {

                System.out.println(e.getMessage());

                return e.getMessage();

            }

            return resultToDisplay;
        }

        protected void onPostExecute(String result) {

        }
    }

    private class schoolResult {
        
    }

    public String convertState(String statename) {
        if (statename == "Alabama") {
            return "AL";
        }
        if (statename == "Alaska") {
            return "AK";
        }
        if (statename == "Arizona") {
            return "AZ";
        }
        if (statename == "Arkansas") {
            return "AR";
        }
        if (statename == "California") {
            return "CA";
        }
        if (statename == "Colorado") {
            return "CO";
        }
        if (statename == "Connecticut") {
            return "CT";
        }
        if (statename == "Delaware") {
            return "DE";
        }
        if (statename == "Florida") {
            return "FL";
        }
        if (statename == "Georgia") {
            return "GA";
        }
        if (statename == "Hawaii") {
            return "HI";
        }
        if (statename == "Idaho") {
            return "ID";
        }
        if (statename == "Illinois") {
            return "IL";
        }
        if (statename == "Indiana") {
            return "IN";
        }
        if (statename == "Iowa") {
            return "IA";
        }
        if (statename == "Kansas") {
            return "KS";
        }
        if (statename == "Kentucky") {
            return "KY";
        }
        if (statename == "Louisiana") {
            return "LA";
        }
        if (statename == "Maine") {
            return "ME";
        }
        if (statename == "Maryland") {
            return "MD";
        }
        if (statename == "Massachusetts") {
            return "MA";
        }
        if (statename == "Michigan") {
            return "MI";
        }
        if (statename == "Minnesota") {
            return "MN";
        }
        if (statename == "Mississippi") {
            return "MS";
        }
        if (statename == "Missouri") {
            return "MO";
        }
        if (statename == "Montana") {
            return "MT";
        }
        if (statename == "Nebraska") {
            return "NE";
        }
        if (statename == "Nevada") {
            return "NV";
        }
        if (statename == "New Hampshire") {
            return "NH";
        }
        if (statename == "New Jersey") {
            return "NJ";
        }
        if (statename == "New Mexico") {
            return "NM";
        }
        if (statename == "New York") {
            return "NY";
        }
        if (statename == "North Carolina") {
            return "NC";
        }
        if (statename == "North Dakota") {
            return "ND";
        }
        if (statename == "Ohio") {
            return "OH";
        }
        if (statename == "Oklahoma") {
            return "OK";
        }
        if (statename == "Oregon") {
            return "OR";
        }
        if (statename == "Pennsylvania") {
            return "PA";
        }
        if (statename == "Rhode Island") {
            return "RI";
        }
        if (statename == "South Carolina") {
            return "SC";
        }
        if (statename == "South Dakota") {
            return "SD";
        }
        if (statename == "Tennessee") {
            return "TN";
        }
        if (statename == "Texas") {
            return "TX";
        }
        if (statename == "Utah") {
            return "UT";
        }
        if (statename == "Vermont") {
            return "VT";
        }
        if (statename == "Virginia") {
            return "VA";
        }
        if (statename == "Washington") {
            return "WA";
        }
        if (statename == "West Virginia") {
            return "WV";
        }
        if (statename == "Wisconsin") {
            return "WI";
        }
        if (statename == "Wyoming") {
            return "WY";
        }
        return null;
    }

}
