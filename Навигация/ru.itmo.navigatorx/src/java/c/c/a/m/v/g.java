/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  android.text.TextUtils
 *  java.lang.CharSequence
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.net.URL
 *  java.nio.charset.Charset
 *  java.security.MessageDigest
 */
package c.c.a.m.v;

import android.net.Uri;
import android.text.TextUtils;
import c.c.a.m.m;
import c.c.a.m.v.h;
import f.b.k.h;
import java.net.URL;
import java.nio.charset.Charset;
import java.security.MessageDigest;

public class g
implements m {
    public final h b;
    public final URL c;
    public final String d;
    public String e;
    public URL f;
    public volatile byte[] g;
    public int h;

    public g(String string) {
        h h2 = h.a;
        this.c = null;
        if (!TextUtils.isEmpty((CharSequence)string)) {
            this.d = string;
            h.i.p(h2, "Argument must not be null");
            this.b = h2;
            return;
        }
        throw new IllegalArgumentException("Must not be null or empty");
    }

    public g(URL uRL) {
        h h2 = h.a;
        h.i.p(uRL, "Argument must not be null");
        this.c = uRL;
        this.d = null;
        h.i.p(h2, "Argument must not be null");
        this.b = h2;
    }

    @Override
    public void a(MessageDigest messageDigest) {
        if (this.g == null) {
            this.g = this.c().getBytes(m.a);
        }
        messageDigest.update(this.g);
    }

    public String c() {
        String string = this.d;
        if (string != null) {
            return string;
        }
        URL uRL = this.c;
        h.i.p(uRL, "Argument must not be null");
        return uRL.toString();
    }

    public URL d() {
        if (this.f == null) {
            if (TextUtils.isEmpty((CharSequence)this.e)) {
                String string = this.d;
                if (TextUtils.isEmpty((CharSequence)string)) {
                    URL uRL = this.c;
                    h.i.p(uRL, "Argument must not be null");
                    string = uRL.toString();
                }
                this.e = Uri.encode((String)string, (String)"@#&=*+-_.,:!?()/~'%;$");
            }
            this.f = new URL(this.e);
        }
        return this.f;
    }

    @Override
    public boolean equals(Object object) {
        boolean bl = object instanceof g;
        boolean bl2 = false;
        if (bl) {
            g g2 = (g)object;
            boolean bl3 = this.c().equals((Object)g2.c());
            bl2 = false;
            if (bl3) {
                boolean bl4 = this.b.equals((Object)g2.b);
                bl2 = false;
                if (bl4) {
                    bl2 = true;
                }
            }
        }
        return bl2;
    }

    @Override
    public int hashCode() {
        if (this.h == 0) {
            int n2;
            this.h = n2 = this.c().hashCode();
            this.h = n2 * 31 + this.b.hashCode();
        }
        return this.h;
    }

    public String toString() {
        return this.c();
    }
}

