using Android.App;
using Android.Views;
using Android.Widget;
using System.Collections.Generic;
using Android.Content;

namespace App2
{
    public class User
    {
        public string UserName { get; set; }
        public string Mail { get; set; }
    }

    public class UserAdapter : ArrayAdapter<User>
    {
        private Context context;
        private int layoutId;
        private List<User> data;
        public UserAdapter(Context context, int resource, List<User> objects) : base(context, resource, objects)
        {

            this.context = context;
            this.layoutId = resource;
            this.data = objects;
        }

        public override View GetView(int position, View convertView, ViewGroup parent)
        {
            LayoutInflater layoutInflater = ((Activity)context).LayoutInflater;
            View row = layoutInflater.Inflate(layoutId, parent, false);

            TextView tw1 = row.FindViewById<TextView>(Resource.Id.twName);
            tw1.Text = data[position].UserName;

            TextView tw2 = row.FindViewById<TextView>(Resource.Id.twPop);
            tw2.Text = data[position].Mail;

            return row;
        }
    }

}
