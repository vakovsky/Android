using Android;
using Android.App;
using Android.OS;
using Android.Widget;
using System;
using System.Collections.Generic;

namespace App1
{
    [Activity(Label = "Activity3", MainLauncher = true)]
    public class Activity3 : Activity
    {
        EditText editText1;
        EditText editText2;
        Button button1;
        ListView listView1;
        List<City> cities;
        protected override void OnCreate(Bundle savedInstanceState)
        {
            base.OnCreate(savedInstanceState);

            // Create your application here
            SetContentView(Resource.Layout.layout3);
            listView1 = FindViewById<ListView>(Resource.Id.listView1);
            cities = new List<City>();
            cities.Add(new City { Cityname = "Пловдив", Population = 321824 });
            cities.Add(new City { Cityname = "Варна", Population = 311093 });
            cities.Add(new City { Cityname = "Бургас", Population = 188242 });

            listView1.Adapter = new CityAdapter(this, Resource.Layout.main_list_row, cities);
            button1 = FindViewById<Button>(Resource.Id.button1);
            button1.Click += Button1_Click;
            editText1 = FindViewById<EditText>(Resource.Id.editText1);
            editText2 = FindViewById<EditText>(Resource.Id.editText2);
            listView1.ItemClick += ListView1_ItemClick;
        }

        private void Button1_Click(object sender, EventArgs e)
        {
            cities.Add(new City { Cityname = editText1.Text, Population = int.Parse(editText2.Text) });
            listView1.Adapter = new CityAdapter(this, Resource.Layout.main_list_row, cities);
        }

        private void ListView1_ItemClick(object sender, AdapterView.ItemClickEventArgs e)
        {
            Toast.MakeText(this,
                        cities[e.Position].Cityname + " - " +
                        cities[e.Position].Population.ToString()
                        , ToastLength.Long).Show();
        }
    }
}
