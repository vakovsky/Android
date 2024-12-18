using Android.App;
using Android.Content;
using Android.OS;
using Android.Runtime;
using Android.Views;
using Android.Widget;
using System;
using System.Collections.Generic;
using System.ComponentModel.Design;
using System.Linq;
using System.Text;

namespace App1
{
    [Activity(Label = "Activity2", MainLauncher = false)]
    public class Activity2 : Activity
    {
        ProgressBar progressBar1;
        SeekBar seekBar1;
        Switch switch1;
        CheckBox checkBox1;
        CheckBox checkBox2;
        CheckBox checkBox3;
        RadioButton radioButton1;
        RadioButton radioButton2;
        RadioButton radioButton3;
        RadioButton radioButton4;
        RadioButton radioButton5;
        RadioButton radioButton6;
        ImageView imageView1;
        ImageButton imageButton1;
        protected override void OnCreate(Bundle savedInstanceState)
        {
            base.OnCreate(savedInstanceState);
            // Create your application here
            SetContentView(Resource.Layout.layout2);

            progressBar1 = FindViewById<ProgressBar>(Resource.Id.progressBar1);
            progressBar1.Max = 10;
            progressBar1.Progress = 4;

            seekBar1 = FindViewById<SeekBar>(Resource.Id.seekBar1);
            seekBar1.Max = 10;
            seekBar1.Progress = 4;
            seekBar1.ProgressChanged += SeekBar1_ProgressChanged;

            switch1 = FindViewById<Switch>(Resource.Id.switch1);
            switch1.Checked = true;

            checkBox1 = FindViewById<CheckBox>(Resource.Id.checkBox1);
            checkBox1.Checked = true;

            checkBox2 = FindViewById<CheckBox>(Resource.Id.checkBox2);
            checkBox2.Checked = false;

            checkBox3 = FindViewById<CheckBox>(Resource.Id.checkBox3);
            checkBox3.Checked = true;

            radioButton1 = FindViewById<RadioButton>(Resource.Id.radioButton1);
            radioButton1.Checked = true;

            radioButton2 = FindViewById<RadioButton>(Resource.Id.radioButton2);
            radioButton2.Checked = true;

            radioButton3 = FindViewById<RadioButton>(Resource.Id.radioButton3);
            radioButton3.Checked = true;

            radioButton4 = FindViewById<RadioButton>(Resource.Id.radioButton4);
            radioButton4.Checked = true;

            radioButton5 = FindViewById<RadioButton>(Resource.Id.radioButton5);
            radioButton5.Checked = true;

            radioButton6 = FindViewById<RadioButton>(Resource.Id.radioButton5);
            radioButton6.Checked = true;

            imageView1 = FindViewById<ImageView>(Resource.Id.imageView1);
            imageView1.SetImageResource(Resource.Drawable.a123);

            imageButton1 = FindViewById<ImageButton>(Resource.Id.imageButton1);
            imageButton1.SetImageResource(Resource.Drawable.a123);

            if (checkBox1.Checked == true)
            {

            }
            if(checkBox2.Checked == true)
            {

            }
            if(checkBox3.Checked == true)
            {

            }

            if (radioButton1.Checked == true)
            {

            }
            else if (radioButton2.Checked == true)
            {

            }
            else if (radioButton3.Checked == true)
            {

            }

            if (radioButton4.Checked == true)
            {

            }
            else if (radioButton5.Checked == true)
            {

            }
            else if (radioButton6.Checked == true)
            {

            }
        }

        private void SeekBar1_ProgressChanged(object sender, SeekBar.ProgressChangedEventArgs e)
        {
            progressBar1.Progress = e.SeekBar.Progress;
        }
    }
}
