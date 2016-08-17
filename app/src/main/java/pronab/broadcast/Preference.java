package pronab.broadcast;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.Map;

/**
 * Created by MD.Arifur on 7/25/2016.
 */
public class Preference {
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private Context context;

    public Preference(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences("CallLog", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public Map<String, ?> saveListData() {
        Map<String, ?> dataTobeShown = sharedPreferences.getAll();
        return dataTobeShown;
    }

    public void saveUserData(String key,int data) {
        data=data+getUserData(key);
        editor.putInt(key, data);
        editor.commit();
    }

    public int getUserData(String key) {
        int dataTobeShown = sharedPreferences.getInt(key, 0);
        return dataTobeShown;

    }
}
