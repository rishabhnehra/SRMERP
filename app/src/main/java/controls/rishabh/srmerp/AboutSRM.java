package controls.rishabh.srmerp;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.MediaController;
import android.widget.VideoView;


public class AboutSRM extends Activity {
    VideoView videoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_srm);
        videoView = (VideoView) findViewById(R.id.srmVideo);
        videoView.setVideoPath("android.resource://"+getPackageName()+"/"+R.raw.srmncr);
        videoView.setMediaController(new MediaController(this));
        videoView.start();
    }
}
