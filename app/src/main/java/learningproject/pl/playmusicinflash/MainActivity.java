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

        final MediaPlayer carelessWhisperMediaPlayer = MediaPlayer.create(this,R.raw.wham_careless_whisper);
        final MediaPlayer cricketMediaPlayer = MediaPlayer.create(this,R.raw.cricket);
        final MediaPlayer standingOvationMediaPlayer = MediaPlayer.create(this,R.raw.standing_applause);
        final MediaPlayer howlDownMediaPlayer = MediaPlayer.create(this,R.raw.boo);

        Button carelessWhisperButton =(Button) this.findViewById(R.id.careless_whisper);
        Button cricketButton =(Button) this.findViewById(R.id.cricket);
        Button standingOvationButton =(Button) this.findViewById(R.id.standing_ovation);
        Button howlDownButton =(Button) this.findViewById(R.id.howl_down);


        carelessWhisperButton.setOnClickListener(playStopClick(carelessWhisperMediaPlayer));
        cricketButton.setOnClickListener(playStopClick(cricketMediaPlayer));
        standingOvationButton.setOnClickListener(playStopClick(standingOvationMediaPlayer));
        howlDownButton.setOnClickListener(playStopClick(howlDownMediaPlayer));
    }

    private View.OnClickListener playStopClick(final MediaPlayer mediaPlayer){
       return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if( mediaPlayer.isPlaying()){
                    mediaPlayer.pause();
                    mediaPlayer.seekTo(0);}
                else
                    mediaPlayer.start();
            }
        };

    }
}
