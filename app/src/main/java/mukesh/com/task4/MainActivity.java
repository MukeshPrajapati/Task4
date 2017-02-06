package mukesh.com.task4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "JSON Parsing ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String jasonString = "{\n" +
                "    \"glossary\": {\n" +
                "        \"title\": \"example glossary\",\n" +
                "\t\t\"GlossDiv\": {\n" +
                "            \"title\": \"S\",\n" +
                "\t\t\t\"GlossList\": {\n" +
                "                \"GlossEntry\": {\n" +
                "                    \"ID\": \"SGML\",\n" +
                "\t\t\t\t\t\"SortAs\": \"SGML\",\n" +
                "\t\t\t\t\t\"GlossTerm\": \"Standard Generalized Markup Language\",\n" +
                "\t\t\t\t\t\"Acronym\": \"SGML\",\n" +
                "\t\t\t\t\t\"Abbrev\": \"ISO 8879:1986\",\n" +
                "\t\t\t\t\t\"GlossDef\": {\n" +
                "                        \"para\": \"A meta-markup language, used to create markup languages such as DocBook.\",\n" +
                "\t\t\t\t\t\t\"GlossSeeAlso\": [\"GML\", \"XML\"]\n" +
                "                    },\n" +
                "\t\t\t\t\t\"GlossSee\": \"markup\"\n" +
                "                }\n" +
                "            }\n" +
                "        }\n" +
                "    }\n" +
                "}";

        try {
                JSONObject rootObject = new JSONObject(jasonString);
                JSONObject glossaryObject = rootObject.getJSONObject("glossary");

                String title = glossaryObject.getString("title");
                Log.d(TAG, "Title: "+title);

                JSONObject glossDivObject = glossaryObject.getJSONObject("GlossDiv");
                String title1 = glossDivObject.getString("title");
                Log.d(TAG, "Title 1: " +title1);

                JSONObject GlossListObject = glossDivObject.getJSONObject("GlossList");
                JSONObject GlossEntryObject = GlossListObject.getJSONObject("GlossEntry");

                String ID = GlossEntryObject.getString("ID");
                Log.d(TAG, "ID: " +ID);

                String sortAs = GlossEntryObject.getString("SortAs");
                Log.d(TAG, "SortAs: " +sortAs);

                String GlossTerm = GlossEntryObject.getString("GlossTerm");
                Log.d(TAG, "GlossTerm: " +GlossTerm);

                String Acronym = GlossEntryObject.getString("Acronym");
                Log.d(TAG, "Acronym: " +Acronym);

                String Abbrev = GlossEntryObject.getString("Abbrev");
                Log.d(TAG, "Abbrev" +Abbrev);

                JSONObject GlossDefObject = GlossEntryObject.getJSONObject("GlossDef");
                String para = GlossDefObject.getString("para");
                Log.d(TAG, "para: " +para);

                JSONArray GlossSeeAlsoObject = GlossDefObject.getJSONArray("GlossSeeAlso");
                for (int i = 0; i <GlossSeeAlsoObject.length() ; i++) {

                    String array = GlossSeeAlsoObject.getString(i);
                    Log.d(TAG, "GlossSeeAlso: "+array);
                }

                String GlossSee = GlossEntryObject.getString("GlossSee");
                Log.d(TAG, "GlossSee: "+GlossSee);


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}