namespace App1

open System
open Android.App
open Android.Media

type Resources = App1.Resource

[<Activity (Label = "MainActivity1", MainLauncher = true)>]
type MainActivity1 () =
  inherit Activity()

  override this.OnCreate(bundle) =
    base.OnCreate (bundle)
    // Create your application here
    this.SetContentView (Resources.Layout.layout1)

    let mutable mediaPlayer : MediaPlayer = MediaPlayer.Create(this, Resources.Raw.christmas)
    mediaPlayer.Start()
