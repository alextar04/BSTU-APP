/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Application
 *  android.content.Context
 *  android.content.SharedPreferences
 *  g.a.x
 *  h.e
 *  java.lang.Object
 *  java.lang.String
 *  ru.zakoulov.navigatorx.App$a
 */
package ru.zakoulov.navigatorx;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import b.a.a.b.g;
import g.a.x;
import h.e;
import h.m.b.j;
import ru.zakoulov.navigatorx.App;

public final class App
extends Application {
    public final h.a e;
    public g f;

    public App() {
        a a2 = new a(this);
        j.e((Object)a2, "initializer");
        this.e = new e((h.m.a.a)a2, null, 2);
    }

    public void onCreate() {
        super.onCreate();
        x.v((Context)this);
        SharedPreferences sharedPreferences = this.getSharedPreferences("NavigatorXSharedPreferences", 0);
        j.d((Object)sharedPreferences, "getSharedPreferences(SHA\u2026ME, Context.MODE_PRIVATE)");
        this.f = new g(sharedPreferences);
    }
}

