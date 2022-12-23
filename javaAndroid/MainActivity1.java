package bg.tcom.c12v1gr.demo122applivation;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);

        MediaPlayer mediaPlayer = MediaPlayer.create(this.getApplicationContext(), R.raw.christmas);
        mediaPlayer.start();
    }
}
