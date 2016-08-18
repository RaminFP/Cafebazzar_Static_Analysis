package com.farsitel.bazaar.activity;

import android.widget.MediaController.MediaPlayerControl;

final class ec implements MediaPlayerControl {
    final /* synthetic */ VideoPlayerActivity a;

    private ec(VideoPlayerActivity videoPlayerActivity) {
        this.a = videoPlayerActivity;
    }

    public final boolean canPause() {
        return false;
    }

    public final boolean canSeekBackward() {
        return false;
    }

    public final boolean canSeekForward() {
        return false;
    }

    public final int getAudioSessionId() {
        return 0;
    }

    public final int getBufferPercentage() {
        return this.a.h;
    }

    public final int getCurrentPosition() {
        return this.a.c.getCurrentPosition();
    }

    public final int getDuration() {
        return this.a.c.getDuration();
    }

    public final boolean isPlaying() {
        return this.a.c.isPlaying();
    }

    public final void pause() {
        this.a.c.pause();
    }

    public final void seekTo(int i) {
        this.a.c.seekTo(i);
    }

    public final void start() {
        this.a.c.start();
    }
}
