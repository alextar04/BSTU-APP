/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  java.lang.Object
 *  java.util.Arrays
 */
package c.e.a.a.v;

import android.os.Parcel;
import android.os.Parcelable;
import c.e.a.a.v.a;
import c.e.a.a.v.e;
import java.util.Arrays;

public class e
implements a.c {
    public static final Parcelable.Creator<e> CREATOR = new Parcelable.Creator<e>(){

        public Object createFromParcel(Parcel parcel) {
            return new e(parcel.readLong(), null);
        }

        public Object[] newArray(int n2) {
            return new e[n2];
        }
    };
    public final long e;

    public e(long l2) {
        this.e = l2;
    }

    public e(long l2, a a2) {
        this.e = l2;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof e)) {
            return false;
        }
        e e2 = (e)object;
        return this.e == e2.e;
    }

    public int hashCode() {
        Object[] arrobject = new Object[]{this.e};
        return Arrays.hashCode((Object[])arrobject);
    }

    @Override
    public boolean m(long l2) {
        return l2 >= this.e;
    }

    public void writeToParcel(Parcel parcel, int n2) {
        parcel.writeLong(this.e);
    }
}

