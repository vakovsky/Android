# [csAndroid](https://github.com/vakovsky/Android/tree/main/csAndroid)
ORM
###### [DataBase Microsoft](https://learn.microsoft.com/en-us/xamarin/android/data-cloud/data-access/using-sqlite-orm)
###### [DataBase sqlite-net](https://github.com/praeclarum/sqlite-net)


using Android.App;
using Android.Content;
using Android.OS;
using Android.Runtime;
using Android.Views;
using Android.Widget;
using SQLite;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;

namespace App1
{
    [Activity(Label = "Activity4", MainLauncher = true)]
    public class Activity4 : Activity
    {
        protected override void OnCreate(Bundle savedInstanceState)
        {
            base.OnCreate(savedInstanceState);

            // Create your application here
            SetContentView(Resource.Layout.layout3);
            var databasePath = Path.Combine(System.Environment.GetFolderPath(System.Environment.SpecialFolder.MyDocuments), "MyData.db");

            var db = new SQLiteConnection(databasePath);
            db.CreateTable<Stock>();
            db.CreateTable<Valuation>();

            var stock = new Stock()
            {
                Symbol = "B",
            };
            db.Insert(stock);
            Console.WriteLine("{0} == {1}", stock.Symbol, stock.Id);

            var query = db.Table<Stock>().Where(v => v.Symbol.StartsWith("A"));

            foreach (var stock2 in query)
                Console.WriteLine("Stock: " + stock2.Symbol);

            var valuation = new Valuation { StockId = stock.Id, Price = (decimal)12.52, Time = DateTime.Now.ToLocalTime() };

            db.Insert(valuation);
        }
    }
}

using Android.App;
using Android.Content;
using Android.OS;
using Android.Runtime;
using Android.Views;
using Android.Widget;
using SQLite;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using static Android.App.DownloadManager;

namespace App1
{
    [Activity(Label = "Activity5", MainLauncher = true)]
    public class Activity5 : Activity
    {
        EditText editText1;
        EditText editText2;
        Button button1;
        ListView listView1;
        List<City> cities;
        SQLiteConnection db;
        protected override void OnCreate(Bundle savedInstanceState)
        {
            base.OnCreate(savedInstanceState);

            // Create your application here
            SetContentView(Resource.Layout.layout3);
            listView1 = FindViewById<ListView>(Resource.Id.listView1);
            button1 = FindViewById<Button>(Resource.Id.button1);
            button1.Click += Button1_Click;
            editText1 = FindViewById<EditText>(Resource.Id.editText1);
            editText2 = FindViewById<EditText>(Resource.Id.editText2);
            cities = new List<City>();
            NewMethod();
        }

        private void NewMethod()
        {
            cities.Clear();
            var databasePath = $"/data/data/" + Application.PackageName + "/databases/data.db";
            db = new SQLiteConnection(databasePath);
            db.CreateTable<City>();

            foreach (var item in db.Table<City>())
            {
                City city = new City
                {
                    Cityname = item.Cityname,
                    Population = item.Population,
                };
                cities.Add(city);
            }

            listView1.Adapter = new CityAdapter(this, Resource.Layout.main_list_row, cities);
        }

        private void Button1_Click(object sender, EventArgs e)
        {
            var city = new City()
            {
                Cityname = editText1.Text,
                Population = int.Parse(editText2.Text),
            };
            db.Insert(city);
            NewMethod();
        }
    }
}

