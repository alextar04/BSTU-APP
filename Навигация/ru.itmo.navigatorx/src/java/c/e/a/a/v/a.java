/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  c.e.a.a.v.e
 *  java.lang.ClassLoader
 *  java.lang.IllegalArgumentException
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Arrays
 *  java.util.Calendar
 */
package c.e.a.a.v;

import android.os.Parcel;
import android.os.Parcelable;
import c.e.a.a.v.a0;
import c.e.a.a.v.e;
import c.e.a.a.v.s;
import java.util.Arrays;
import java.util.Calendar;

public final class a
implements Parcelable {
    public static final Parcelable.Creator<a> CREATOR = new Parcelable.Creator<a>(){

        public Object createFromParcel(Parcel parcel) {
            s s2 = (s)parcel.readParcelable(s.class.getClassLoader());
            s s3 = (s)parcel.readParcelable(s.class.getClassLoader());
            s s4 = (s)parcel.readParcelable(s.class.getClassLoader());
            c c2 = (c)parcel.readParcelable(c.class.getClassLoader());
            a a2 = new a(s2, s3, s4, c2, null);
            return a2;
        }

        public Object[] newArray(int n2) {
            return new a[n2];
        }
    };
    public final s e;
    public final s f;
    public final s g;
    public final c h;
    public final int i;
    public final int j;

    public a(s s2, s s3, s s4, c c2, a a2) {
        this.e = s2;
        this.f = s3;
        this.g = s4;
        this.h = c2;
        if (s2.e.compareTo(s4.e) <= 0) {
            if (s4.e.compareTo(s3.e) <= 0) {
                this.j = 1 + s2.k(s3);
                this.i = 1 + (s3.h - s2.h);
                return;
            }
            throw new IllegalArgumentException("current Month cannot be after end Month");
        }
        throw new IllegalArgumentException("start Month cannot be after current Month");
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof a)) {
            return false;
        }
        a a2 = (a)object;
        return this.e.equals(a2.e) && this.f.equals(a2.f) && this.g.equals(a2.g) && this.h.equals((Object)a2.h);
    }

    public int hashCode() {
        Object[] arrobject = new Object[]{this.e, this.f, this.g, this.h};
        return Arrays.hashCode((Object[])arrobject);
    }

    public void writeToParcel(Parcel parcel, int n2) {
        parcel.writeParcelable((Parcelable)this.e, 0);
        parcel.writeParcelable((Parcelable)this.f, 0);
        parcel.writeParcelable((Parcelable)this.g, 0);
        parcel.writeParcelable((Parcelable)this.h, 0);
    }

    public static final class b {
        public static final long e = a0.a(s.b((int)1900, (int)0).k);
        public static final long f = a0.a(s.b((int)2100, (int)11).k);
        public long a = e;
        public long b = f;
        public Long c;
        public c d = new e(Long.MIN_VALUE);

        public b(a a2) {
            this.a = a2.e.k;
            this.b = a2.f.k;
            this.c = a2.g.k;
            this.d = a2.h;
        }
    }

    public static interface c
    extends Parcelable {
        public boolean m(long var1);
    }

}

