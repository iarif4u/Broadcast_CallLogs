package pronab.broadcast;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;



/**
 * Created by Mobile App Develop on 23-7-16.
 */
public class Adapter extends ArrayAdapter<CallLog> {
    private Context context;
    private ArrayList<CallLog> profiles;

    public Adapter(Context context,ArrayList<CallLog> profiles) {
        super(context, R.layout.list, profiles);
        this.context=context;
        this.profiles=profiles;
    }


    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView=inflater.inflate(R.layout.list,null,true);

        TextView profileNameText= (TextView) convertView.findViewById(R.id.number);
        TextView profilePic= (TextView) convertView.findViewById(R.id.count);

        profileNameText.setText(profiles.get(position).getNumber());
        profilePic.setText(profiles.get(position).getCount());


        return convertView;
    }

}
