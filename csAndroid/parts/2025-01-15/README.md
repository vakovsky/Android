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
