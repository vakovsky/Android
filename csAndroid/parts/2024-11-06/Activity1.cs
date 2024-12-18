using Android.App;
using Android.Content;
using Android.OS;
using Android.Runtime;
using Android.Views;
using Android.Widget;
using ClassLibrary1;
using Java.Interop;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;

namespace App1
{
    [Activity(Label = "Activity1", MainLauncher = true)]
    public class Activity1 : Activity
    {
        EditText editText1;
        TextView textView1;
        Button button1;
        RadioButton radioButton1;
        RadioButton radioButton2;
        ListView listView1;
        List<Transport> transports;
        ArrayAdapter<Transport> adapter;
        Button button2;
        Button button3;
        Button button4;
        protected override void OnCreate(Bundle savedInstanceState)
        {
            base.OnCreate(savedInstanceState);
            // Create your application here
            SetContentView(Resource.Layout.layout1);
            editText1 = FindViewById<EditText>(Resource.Id.editText1);
            textView1 = FindViewById<TextView>(Resource.Id.textView1);
            button1 = FindViewById<Button>(Resource.Id.button1);
            radioButton1 = FindViewById<RadioButton>(Resource.Id.radioButton1);
            radioButton2 = FindViewById<RadioButton>(Resource.Id.radioButton2);
            listView1 = FindViewById<ListView>(Resource.Id.listView1);
            transports = new List<Transport>();
            adapter = new ArrayAdapter<Transport>(this, Android.Resource.Layout.SimpleListItem1, transports);
            listView1.Adapter = adapter;
            button2 = FindViewById<Button>(Resource.Id.button2);
            button3 = FindViewById<Button>(Resource.Id.button3);
            button4 = FindViewById<Button>(Resource.Id.button4);
            button1.Click += Button1_Click;
            button2.Click += Button2_Click;
            button3.Click += Button3_Click;
            button4.Click += Button4_Click;
        }

        private void Button4_Click(object sender, EventArgs e)
        {
            transports.Clear();
            RefreshMethod();
        }

        private void Button1_Click(object sender, EventArgs e)
        {
            Transport transport = new Transport();
            transport.N = int.Parse(editText1.Text);
            if (radioButton1.Checked == true)
            {
                transport.DayOrNight = "day";
            }
            else if (radioButton2.Checked == true)
            {
                {
                    transport.DayOrNight = "night";
                }
            }
            textView1.Text = transport.Price.ToString();
            transports.Add(transport);
            RefreshMethod();
        }

        private void RefreshMethod()
        {
            adapter = new ArrayAdapter<Transport>(this, Android.Resource.Layout.SimpleListItem1, transports);
            listView1.Adapter = adapter;
        }

        private void Button2_Click(object sender, EventArgs e)
        {
            string path = Android.OS.Environment.GetExternalStoragePublicDirectory(Android.OS.Environment.DirectoryDocuments).AbsolutePath + "/data.txt";
            using (StreamWriter streamWriter = new StreamWriter(path))
            {
                foreach (Transport item in transports)
                {
                    streamWriter.WriteLine(item.N + ":" + item.DayOrNight.ToString());
                }
            }
        }
        private void Button3_Click(object sender, EventArgs e)
        {
            string path = Android.OS.Environment.GetExternalStoragePublicDirectory(Android.OS.Environment.DirectoryDocuments).AbsolutePath + "/data.txt";
            using (StreamReader streamReader = new StreamReader(path))
            {
                transports.Clear();
                while (!streamReader.EndOfStream)
                {
                    string line = streamReader.ReadLine();
                    string[] items = line.Split(':');
                    Transport transport = new Transport { N = int.Parse(items[0]), DayOrNight = items[1] };
                    transports.Add(transport);
                }
                RefreshMethod();
            }
        }
    }
}
