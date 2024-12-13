using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

using Android.App;
using Android.Content;
using Android.OS;
using Android.Runtime;
using Android.Views;
using Android.Widget;
using Android.Media;

namespace App1
{
    [Activity(Label = "MainActivity1", MainLauncher = true)]
    public class MainActivity1 : Activity
    {
        protected override void OnCreate(Bundle savedInstanceState)
        {
            base.OnCreate(savedInstanceState);
            SetContentView(Resource.Layout.layout1);

            MediaPlayer mediaPlayer = MediaPlayer.Create(ApplicationContext, Resource.Raw.christmas);
            mediaPlayer.Start();
        }
    }
}
