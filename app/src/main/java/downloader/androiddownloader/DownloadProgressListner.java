package downloader.androiddownloader;

/**
 * Created by prerana_katyarmal on 3/24/2016.
 */
public interface DownloadProgressListner {
    public void getDownloadProgress(int progressInpercentage);
    public void onDownlodCompleted(String downlodedFileUri);
}
