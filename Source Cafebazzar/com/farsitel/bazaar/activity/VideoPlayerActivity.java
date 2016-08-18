package com.farsitel.bazaar.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnVideoSizeChangedListener;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.NotificationCompat;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.farsitel.bazaar.BazaarApplication;
import com.farsitel.bazaar.g;
import com.farsitel.bazaar.h.o;
import com.farsitel.bazaar.i;
import com.farsitel.bazaar.util.c;
import com.farsitel.bazaar.widget.h;

public class VideoPlayerActivity extends Activity implements OnBufferingUpdateListener, OnCompletionListener, OnPreparedListener, OnVideoSizeChangedListener, Callback {
    public static final char[] a = new char[]{'A', 'U'};
    private RelativeLayout b;
    private MediaPlayer c;
    private SurfaceView d;
    private SurfaceHolder e;
    private ProgressBar f;
    private h g;
    private int h;
    private double i;
    private boolean j = false;
    private boolean k = false;
    private String l;
    private String m;
    private char n;
    private Handler o = new Handler();

    private void a(int i, int i2) {
        LayoutParams layoutParams = this.d.getLayoutParams();
        if ((this.i > ((double) (i / i2)) ? 1 : null) != null) {
            this.e.setFixedSize(i, (int) (((double) i) / this.i));
            layoutParams.width = -1;
            layoutParams.height = -2;
        } else {
            this.e.setFixedSize((int) (((double) i2) * this.i), i2);
            layoutParams.width = -2;
            layoutParams.height = -1;
        }
        this.d.setLayoutParams(layoutParams);
    }

    public static void a(Context context, String str, char c, View view) {
        Intent intent = new Intent(context, VideoPlayerActivity.class);
        intent.setData(Uri.parse("bazaar://video?hashorurl=" + str + "&type" + "=" + c));
        c.a(context, intent, view);
    }

    private void b() {
        if (!isFinishing()) {
            this.k = false;
            this.j = false;
            try {
                this.c = new MediaPlayer();
                this.c.setDataSource(this.l);
                this.c.setDisplay(this.e);
                this.c.prepareAsync();
                this.c.setOnBufferingUpdateListener(this);
                this.c.setOnCompletionListener(this);
                this.c.setOnPreparedListener(this);
                this.c.setOnVideoSizeChangedListener(this);
                setVolumeControlStream(3);
            } catch (Exception e) {
                a();
            }
        }
    }

    private void c() {
        a(this.b.getWidth(), this.b.getHeight());
        this.c.start();
        this.g.g.sendEmptyMessage(0);
    }

    public final void a() {
        this.o.post(new ea(this));
    }

    public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
        this.h = i;
    }

    public void onCompletion(MediaPlayer mediaPlayer) {
        if (this.g != null) {
            h hVar = this.g;
            hVar.c.setVisibility(0);
            hVar.c.setImageResource(g.ic_av_replay);
            hVar.c.clearAnimation();
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(2130903086);
        getWindow().addFlags(NotificationCompat.FLAG_HIGH_PRIORITY);
        this.b = (RelativeLayout) findViewById(2131624169);
        this.d = (SurfaceView) findViewById(2131624201);
        this.f = (ProgressBar) findViewById(2131624043);
        this.e = this.d.getHolder();
        this.e.addCallback(this);
        this.e.setFormat(1);
        this.b.getViewTreeObserver().addOnGlobalLayoutListener(new dz(this));
        this.h = 0;
        Uri data = getIntent().getData();
        String queryParameter = data.getQueryParameter("type");
        if (queryParameter != null) {
            this.n = queryParameter.charAt(0);
        } else {
            this.n = 'U';
        }
        this.m = data.getQueryParameter("hashorurl");
        BazaarApplication.c().d();
        i.a("/Video/" + this.m);
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.c != null) {
            this.c.stop();
            this.c.release();
        }
    }

    protected void onPause() {
        super.onPause();
        if (this.c != null && this.c.isPlaying()) {
            this.c.pause();
        }
    }

    public void onPrepared(MediaPlayer mediaPlayer) {
        if (!isFinishing()) {
            this.f.setVisibility(8);
            this.g = new h(this, this.b, new RelativeLayout.LayoutParams(-1, -1), new ec());
            if (this.n == 'A') {
                this.g.a(true);
            } else {
                this.g.a(false);
            }
            this.k = true;
            if (this.j) {
                c();
            }
        }
    }

    protected void onResume() {
        super.onResume();
        if (this.c != null) {
            this.c.start();
        }
    }

    public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
        if (i != 0 && i2 != 0) {
            this.j = true;
            this.i = ((double) i) / ((double) i2);
            if (this.k) {
                c();
            }
        }
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.f.setVisibility(0);
        switch (this.n) {
            case 'A':
                new Thread(new o("http://aparat.com/etc/api/videoshow/videohash/" + this.m, new eb())).start();
                return;
            case 'U':
                this.l = this.m;
                b();
                return;
            default:
                finish();
                return;
        }
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        finish();
    }
}
