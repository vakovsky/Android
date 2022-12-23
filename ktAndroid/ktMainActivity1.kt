package bg.tcom.c12v1gr.demo122applivation

import android.media.MediaPlayer
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main1)

        val mediaPlayer : MediaPlayer = MediaPlayer.create(this.applicationContext, R.raw.christmas)
        mediaPlayer.start()
    }
}
