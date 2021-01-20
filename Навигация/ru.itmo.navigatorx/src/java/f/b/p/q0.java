/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.app.SearchableInfo
 *  android.content.ComponentName
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.content.pm.ActivityInfo
 *  android.content.pm.ApplicationInfo
 *  android.content.pm.PackageManager
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.content.res.ColorStateList
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.database.Cursor
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.Drawable$ConstantState
 *  android.net.Uri
 *  android.net.Uri$Builder
 *  android.os.Bundle
 *  android.text.SpannableString
 *  android.text.TextUtils
 *  android.text.style.TextAppearanceSpan
 *  android.util.Log
 *  android.util.TypedValue
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.widget.BaseAdapter
 *  android.widget.ImageView
 *  android.widget.TextView
 *  androidx.appcompat.widget.SearchView
 *  f.i.a.a
 *  java.io.FileNotFoundException
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.Integer
 *  java.lang.NumberFormatException
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.List
 *  java.util.WeakHashMap
 */
package f.b.p;

import android.annotation.SuppressLint;
import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.SearchView;
import f.b.f;
import f.i.a.c;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.WeakHashMap;

@SuppressLint(value={"RestrictedAPI"})
public class q0
extends c
implements View.OnClickListener {
    public int A = -1;
    public int B = -1;
    public int C = -1;
    public final SearchView p;
    public final SearchableInfo q;
    public final Context r;
    public final WeakHashMap<String, Drawable.ConstantState> s;
    public final int t;
    public boolean u = false;
    public int v = 1;
    public ColorStateList w;
    public int x = -1;
    public int y = -1;
    public int z = -1;

    public q0(Context context, SearchView searchView, SearchableInfo searchableInfo, WeakHashMap<String, Drawable.ConstantState> weakHashMap) {
        super(context, searchView.getSuggestionRowLayout(), null, true);
        this.p = searchView;
        this.q = searchableInfo;
        this.t = searchView.getSuggestionCommitIconResId();
        this.r = context;
        this.s = weakHashMap;
    }

    public static String e(Cursor cursor, String string) {
        return q0.i(cursor, cursor.getColumnIndex(string));
    }

    public static String i(Cursor cursor, int n2) {
        if (n2 == -1) {
            return null;
        }
        try {
            String string = cursor.getString(n2);
            return string;
        }
        catch (Exception exception) {
            Log.e((String)"SuggestionsAdapter", (String)"unexpected error retrieving valid column from cursor, did the remote process die?", (Throwable)exception);
            return null;
        }
    }

    public void a(View view, Context context, Cursor cursor) {
        int n2;
        int n3;
        ImageView imageView;
        a a2;
        block18 : {
            Object object;
            ImageView imageView2;
            block20 : {
                block22 : {
                    String string;
                    Drawable drawable;
                    block24 : {
                        block23 : {
                            String string2;
                            ActivityInfo activityInfo;
                            ComponentName componentName;
                            block21 : {
                                int n4;
                                block19 : {
                                    a2 = view.getTag();
                                    int n5 = this.C;
                                    n2 = n5 != -1 ? cursor.getInt(n5) : 0;
                                    if (a2.a != null) {
                                        String string3 = q0.i(cursor, this.x);
                                        TextView textView = a2.a;
                                        textView.setText((CharSequence)string3);
                                        int n6 = TextUtils.isEmpty((CharSequence)string3) ? 8 : 0;
                                        textView.setVisibility(n6);
                                    }
                                    if (a2.b != null) {
                                        String string4;
                                        String string5 = q0.i(cursor, this.z);
                                        if (string5 != null) {
                                            if (this.w == null) {
                                                TypedValue typedValue = new TypedValue();
                                                this.h.getTheme().resolveAttribute(f.b.a.textColorSearchUrl, typedValue, true);
                                                this.w = this.h.getResources().getColorStateList(typedValue.resourceId);
                                            }
                                            string4 = new SpannableString((CharSequence)string5);
                                            TextAppearanceSpan textAppearanceSpan = new TextAppearanceSpan(null, 0, 0, this.w, null);
                                            string4.setSpan((Object)textAppearanceSpan, 0, string5.length(), 33);
                                        } else {
                                            string4 = q0.i(cursor, this.y);
                                        }
                                        if (TextUtils.isEmpty((CharSequence)string4)) {
                                            TextView textView = a2.a;
                                            if (textView != null) {
                                                textView.setSingleLine(false);
                                                a2.a.setMaxLines(2);
                                            }
                                        } else {
                                            TextView textView = a2.a;
                                            if (textView != null) {
                                                textView.setSingleLine(true);
                                                a2.a.setMaxLines(1);
                                            }
                                        }
                                        TextView textView = a2.b;
                                        textView.setText((CharSequence)string4);
                                        int n7 = TextUtils.isEmpty((CharSequence)string4) ? 8 : 0;
                                        textView.setVisibility(n7);
                                    }
                                    if ((imageView2 = a2.c) == null) break block18;
                                    n4 = this.A;
                                    if (n4 != -1) break block19;
                                    object = null;
                                    break block20;
                                }
                                object = this.g(cursor.getString(n4));
                                if (object != null) break block20;
                                componentName = this.q.getSearchActivity();
                                string = componentName.flattenToShortString();
                                if (!this.s.containsKey((Object)string)) break block21;
                                Drawable.ConstantState constantState = (Drawable.ConstantState)this.s.get((Object)string);
                                object = constantState == null ? null : constantState.newDrawable(this.r.getResources());
                                break block22;
                            }
                            PackageManager packageManager = this.h.getPackageManager();
                            try {
                                activityInfo = packageManager.getActivityInfo(componentName, 128);
                            }
                            catch (PackageManager.NameNotFoundException nameNotFoundException) {
                                string2 = nameNotFoundException.toString();
                            }
                            int n8 = activityInfo.getIconResource();
                            if (n8 == 0) break block23;
                            drawable = packageManager.getDrawable(componentName.getPackageName(), n8, activityInfo.applicationInfo);
                            if (drawable != null) break block24;
                            StringBuilder stringBuilder = c.b.a.a.a.d("Invalid icon resource ", n8, " for ");
                            stringBuilder.append(componentName.flattenToShortString());
                            string2 = stringBuilder.toString();
                            Log.w((String)"SuggestionsAdapter", (String)string2);
                        }
                        drawable = null;
                    }
                    Drawable.ConstantState constantState = drawable == null ? null : drawable.getConstantState();
                    this.s.put((Object)string, (Object)constantState);
                    object = drawable;
                }
                if (object == null) {
                    object = this.h.getPackageManager().getDefaultActivityIcon();
                }
            }
            imageView2.setImageDrawable(object);
            if (object == null) {
                imageView2.setVisibility(4);
            } else {
                imageView2.setVisibility(0);
                object.setVisible(false, false);
                object.setVisible(true, false);
            }
        }
        if ((imageView = a2.d) != null) {
            int n9 = this.B;
            Drawable drawable = n9 == -1 ? null : this.g(cursor.getString(n9));
            imageView.setImageDrawable(drawable);
            if (drawable == null) {
                imageView.setVisibility(8);
            } else {
                imageView.setVisibility(0);
                drawable.setVisible(false, false);
                drawable.setVisible(true, false);
            }
        }
        if ((n3 = this.v) != 2 && (n3 != 1 || (n2 & 1) == 0)) {
            a2.e.setVisibility(8);
            return;
        }
        a2.e.setVisibility(0);
        a2.e.setTag((Object)a2.a.getText());
        a2.e.setOnClickListener((View.OnClickListener)this);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void b(Cursor cursor) {
        if (this.u) {
            Log.w((String)"SuggestionsAdapter", (String)"Tried to change cursor after adapter was closed.");
            if (cursor == null) return;
            cursor.close();
            return;
        }
        f.i.a.a.super.b(cursor);
        if (cursor == null) return;
        try {
            this.x = cursor.getColumnIndex("suggest_text_1");
            this.y = cursor.getColumnIndex("suggest_text_2");
            this.z = cursor.getColumnIndex("suggest_text_2_url");
            this.A = cursor.getColumnIndex("suggest_icon_1");
            this.B = cursor.getColumnIndex("suggest_icon_2");
            this.C = cursor.getColumnIndex("suggest_flags");
            return;
        }
        catch (Exception exception) {
            Log.e((String)"SuggestionsAdapter", (String)"error changing cursor and caching columns", (Throwable)exception);
        }
    }

    public CharSequence c(Cursor cursor) {
        String string;
        String string2;
        if (cursor == null) {
            return null;
        }
        String string3 = q0.i(cursor, cursor.getColumnIndex("suggest_intent_query"));
        if (string3 != null) {
            return string3;
        }
        if (this.q.shouldRewriteQueryFromData() && (string2 = q0.i(cursor, cursor.getColumnIndex("suggest_intent_data"))) != null) {
            return string2;
        }
        if (this.q.shouldRewriteQueryFromText() && (string = q0.i(cursor, cursor.getColumnIndex("suggest_text_1"))) != null) {
            return string;
        }
        return null;
    }

    @Override
    public View d(Context context, Cursor cursor, ViewGroup viewGroup) {
        View view = this.o.inflate(this.m, viewGroup, false);
        view.setTag(new Object(view){
            public final TextView a;
            public final TextView b;
            public final ImageView c;
            public final ImageView d;
            public final ImageView e;
            {
                this.a = (TextView)view.findViewById(16908308);
                this.b = (TextView)view.findViewById(16908309);
                this.c = (ImageView)view.findViewById(16908295);
                this.d = (ImageView)view.findViewById(16908296);
                this.e = (ImageView)view.findViewById(f.edit_query);
            }
        });
        ((ImageView)view.findViewById(f.edit_query)).setImageResource(this.t);
        return view;
    }

    public Drawable f(Uri uri) {
        block10 : {
            block11 : {
                block12 : {
                    int n2;
                    Resources resources;
                    String string = uri.getAuthority();
                    if (TextUtils.isEmpty((CharSequence)string)) break block10;
                    try {
                        resources = this.h.getPackageManager().getResourcesForApplication(string);
                    }
                    catch (PackageManager.NameNotFoundException nameNotFoundException) {
                        throw new FileNotFoundException(c.b.a.a.a.g("No package found for authority: ", uri));
                    }
                    List list = uri.getPathSegments();
                    if (list == null) break block11;
                    int n3 = list.size();
                    if (n3 == 1) {
                        try {
                            n2 = Integer.parseInt((String)((String)list.get(0)));
                        }
                        catch (NumberFormatException numberFormatException) {
                            throw new FileNotFoundException(c.b.a.a.a.g("Single path segment is not a resource ID: ", uri));
                        }
                    }
                    if (n3 != 2) break block12;
                    n2 = resources.getIdentifier((String)list.get(1), (String)list.get(0), string);
                    if (n2 != 0) {
                        return resources.getDrawable(n2);
                    }
                    throw new FileNotFoundException(c.b.a.a.a.g("No resource found for: ", uri));
                }
                throw new FileNotFoundException(c.b.a.a.a.g("More than two path segments: ", uri));
            }
            throw new FileNotFoundException(c.b.a.a.a.g("No path: ", uri));
        }
        throw new FileNotFoundException(c.b.a.a.a.g("No authority: ", uri));
    }

    /*
     * Exception decompiling
     */
    public final Drawable g(String var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl183 : ALOAD : trying to set 0 previously set to 1
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:203)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.g.p(Method.java:396)
        // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
        // org.benf.cfr.reader.entities.d.b(ClassFile.java:792)
        // org.benf.cfr.reader.b.a(Driver.java:128)
        // org.benf.cfr.reader.a.a(CfrDriverImpl.java:63)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.decompileWithCFR(JavaExtractionWorker.kt:61)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.doWork(JavaExtractionWorker.kt:130)
        // com.njlabs.showjava.decompilers.BaseDecompiler.withAttempt(BaseDecompiler.kt:108)
        // com.njlabs.showjava.workers.DecompilerWorker$b.run(DecompilerWorker.kt:118)
        // java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1162)
        // java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:636)
        // java.lang.Thread.run(Thread.java:764)
        throw new IllegalStateException("Decompilation failed");
    }

    public View getDropDownView(int n2, View view, ViewGroup viewGroup) {
        try {
            View view2 = f.i.a.a.super.getDropDownView(n2, view, viewGroup);
            return view2;
        }
        catch (RuntimeException runtimeException) {
            Log.w((String)"SuggestionsAdapter", (String)"Search suggestions cursor threw exception.", (Throwable)runtimeException);
            View view3 = this.o.inflate(this.n, viewGroup, false);
            if (view3 != null) {
                (view3.getTag()).a.setText((CharSequence)runtimeException.toString());
            }
            return view3;
        }
    }

    public View getView(int n2, View view, ViewGroup viewGroup) {
        try {
            View view2 = f.i.a.a.super.getView(n2, view, viewGroup);
            return view2;
        }
        catch (RuntimeException runtimeException) {
            Log.w((String)"SuggestionsAdapter", (String)"Search suggestions cursor threw exception.", (Throwable)runtimeException);
            View view3 = this.d(this.h, this.g, viewGroup);
            (view3.getTag()).a.setText((CharSequence)runtimeException.toString());
            return view3;
        }
    }

    public Cursor h(SearchableInfo searchableInfo, String string, int n2) {
        String[] arrstring = null;
        if (searchableInfo == null) {
            return null;
        }
        String string2 = searchableInfo.getSuggestAuthority();
        if (string2 == null) {
            return null;
        }
        Uri.Builder builder = new Uri.Builder().scheme("content").authority(string2).query("").fragment("");
        String string3 = searchableInfo.getSuggestPath();
        if (string3 != null) {
            builder.appendEncodedPath(string3);
        }
        builder.appendPath("search_suggest_query");
        String string4 = searchableInfo.getSuggestSelection();
        if (string4 != null) {
            arrstring = new String[]{string};
        } else {
            builder.appendPath(string);
        }
        String[] arrstring2 = arrstring;
        if (n2 > 0) {
            builder.appendQueryParameter("limit", String.valueOf((int)n2));
        }
        Uri uri = builder.build();
        return this.h.getContentResolver().query(uri, null, string4, arrstring2, null);
    }

    public boolean hasStableIds() {
        return false;
    }

    public final void j(Cursor cursor) {
        Bundle bundle = cursor != null ? cursor.getExtras() : null;
        if (bundle == null || bundle.getBoolean("in_progress")) {
            // empty if block
        }
    }

    public void notifyDataSetChanged() {
        BaseAdapter.super.notifyDataSetChanged();
        this.j(this.g);
    }

    public void notifyDataSetInvalidated() {
        BaseAdapter.super.notifyDataSetInvalidated();
        this.j(this.g);
    }

    public void onClick(View view) {
        Object object = view.getTag();
        if (object instanceof CharSequence) {
            this.p.z((CharSequence)object);
        }
    }

}

