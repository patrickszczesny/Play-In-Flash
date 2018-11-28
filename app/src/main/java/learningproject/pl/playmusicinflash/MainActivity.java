package learningproject.pl.playmusicinflash;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final MediaPlayer playInFlashMediaPlayer = MediaPlayer.create(this,R.raw.wham_careless_whisper);

        Button playInFlash =(Button) this.findViewById(R.id.playInFlash);

        playInFlash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if( playInFlashMediaPlayer.isPlaying()){
                    playInFlashMediaPlayer.pause();
                    playInFlashMediaPlayer.seekTo(0);}
                else
                    playInFlashMediaPlayer.start();
            }
        });
    }
}
