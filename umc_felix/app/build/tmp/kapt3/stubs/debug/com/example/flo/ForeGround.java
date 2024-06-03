package com.example.flo;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\r"}, d2 = {"Lcom/example/flo/ForeGround;", "Landroid/app/Service;", "()V", "CHANNEL_ID", "", "getCHANNEL_ID", "()Ljava/lang/String;", "createNotificationChannel", "", "onBind", "Landroid/os/IBinder;", "intent", "Landroid/content/Intent;", "app_debug"})
public final class ForeGround extends android.app.Service {
    @org.jetbrains.annotations.NotNull
    private final java.lang.String CHANNEL_ID = "FGS153";
    
    public ForeGround() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getCHANNEL_ID() {
        return null;
    }
    
    public final void createNotificationChannel() {
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public android.os.IBinder onBind(@org.jetbrains.annotations.NotNull
    android.content.Intent intent) {
        return null;
    }
}