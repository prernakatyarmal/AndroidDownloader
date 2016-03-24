package downloader.androiddownloader;

import android.app.Activity;
import android.app.DownloadManager;
import android.app.DownloadManager.Query;
import android.app.DownloadManager.Request;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity implements DownloadProgressListner {
    private long enqueue;
    private DownloadManager dm;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onClick(View view) {

        String urlForDownload = "http://www.vogella.de/img/lars/LarsVogelArticle7.png";
        Downloader downloader = new Downloader(MainActivity.this, urlForDownload);
        downloader.startDownloading();

    }

    public void showDownload(View view) {
        Intent i = new Intent();
        i.setAction(DownloadManager.ACTION_VIEW_DOWNLOADS);
        startActivity(i);
    }

    @Override
    public void getDownloadProgress(final int progressInpercentage) {
        Log.v("DownloadProgress:", String.valueOf(progressInpercentage));
    }

    @Override
    public void onDownlodCompleted(final String UriString) {
        runOnUiThread(new Runnable() {

            @Override
            public void run() {
                ImageView view = (ImageView) findViewById(R.id.imageView1);
                view.setImageURI(Uri.parse(UriString));
            }
        });

    }
}