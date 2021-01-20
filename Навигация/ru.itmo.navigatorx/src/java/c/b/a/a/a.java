/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  android.util.Log
 *  androidx.fragment.app.Fragment
 *  androidx.recyclerview.widget.RecyclerView
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  org.xmlpull.v1.XmlPullParser
 */
package c.b.a.a;

import android.net.Uri;
import android.util.Log;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import org.xmlpull.v1.XmlPullParser;

public class a {
    public static String a(RecyclerView recyclerView, StringBuilder stringBuilder) {
        stringBuilder.append(recyclerView.A());
        return stringBuilder.toString();
    }

    public static String b(String string, int n2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        stringBuilder.append(n2);
        return stringBuilder.toString();
    }

    public static StringBuilder c(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        return stringBuilder;
    }

    public static StringBuilder d(String string, int n2, String string2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        stringBuilder.append(n2);
        stringBuilder.append(string2);
        return stringBuilder;
    }

    public static void e(StringBuilder stringBuilder, Fragment fragment, String string) {
        stringBuilder.append((Object)fragment);
        Log.d((String)string, (String)stringBuilder.toString());
    }

    public static String f(String string, long l2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        stringBuilder.append(l2);
        return stringBuilder.toString();
    }

    public static String g(String string, Uri uri) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        stringBuilder.append((Object)uri);
        return stringBuilder.toString();
    }

    public static String h(String string, Fragment fragment, String string2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        stringBuilder.append((Object)fragment);
        stringBuilder.append(string2);
        return stringBuilder.toString();
    }

    public static String i(String string, Object object) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        stringBuilder.append(object);
        return stringBuilder.toString();
    }

    public static String j(String string, String string2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        stringBuilder.append(string2);
        return stringBuilder.toString();
    }

    public static String k(String string, String string2, String string3) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        stringBuilder.append(string2);
        stringBuilder.append(string3);
        return stringBuilder.toString();
    }

    public static String l(StringBuilder stringBuilder, String string, String string2) {
        stringBuilder.append(string);
        stringBuilder.append(string2);
        return stringBuilder.toString();
    }

    public static String m(XmlPullParser xmlPullParser, StringBuilder stringBuilder, String string) {
        stringBuilder.append(xmlPullParser.getPositionDescription());
        stringBuilder.append(string);
        return stringBuilder.toString();
    }
}

