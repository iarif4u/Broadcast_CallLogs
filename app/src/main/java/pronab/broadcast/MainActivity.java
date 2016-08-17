package pronab.broadcast;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    Preference preference;
    ListView contactListView;
    CallLog callLog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        preference = new Preference(this);

        ArrayList<CallLog> allProduct = null;
        Adapter customAdapter;

        Map<String, ?> allEntries=preference.saveListData();
        for (Map.Entry<String, ?> entry : allEntries.entrySet()) {

            callLog = new CallLog(entry.getKey(), (Integer) entry.getValue());
            allProduct.add(callLog);

        }

        contactListView= (ListView) findViewById(R.id.callList);

        customAdapter=new Adapter(this,allProduct);
        contactListView.setAdapter(customAdapter);
    }
}
