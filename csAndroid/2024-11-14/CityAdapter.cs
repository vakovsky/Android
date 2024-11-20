using Android.App;
using Android.Content;
using Android.OS;
using Android.Runtime;
using Android.Views;
using Android.Widget;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace App3
{
    public class CityAdapter : ArrayAdapter<City>
    {
        private Context context;
        private int layoutId;
        private List<City> data;
        public CityAdapter(Context context, int resource, List<City> objects) : base(context, resource, objects)
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
            tw1.Text = data[position].Cityname;

            TextView tw2 = row.FindViewById<TextView>(Resource.Id.twPop);
            tw2.Text = data[position].Pop;

            return row;
        }
    }
}
