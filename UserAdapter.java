package bg.tcom.c12v1gr.demo122applivation;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class UserAdapter extends ArrayAdapter<User> {
        private Context context;
        private int layoutId;
        private List<User> data;
        public UserAdapter(@NonNull Context context, int resource, @NonNull List<User> objects) {
            super(context, resource, objects);
            this.context = context;
            this.layoutId = resource;
            this.data = objects;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = ((Activity)context).getLayoutInflater();
            View row = layoutInflater.inflate(layoutId, parent, false);

            TextView tw1 = row.findViewById(R.id.twName);
            tw1.setText(data.get(position).getUserName());

            TextView tw2 = row.findViewById(R.id.twPop);
            tw2.setText(data.get(position).geteMail());

            return row;
        }
    }
