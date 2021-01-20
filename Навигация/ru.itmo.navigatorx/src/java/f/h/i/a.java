/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.util.Base64
 *  c.b.a.a.a
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.List
 */
package f.h.i;

import android.util.Base64;
import java.util.List;

public final class a {
    public final String a;
    public final String b;
    public final String c;
    public final List<List<byte[]>> d;
    public final int e;
    public final String f;

    public a(String string, String string2, String string3, List<List<byte[]>> list) {
        this.a = string;
        this.b = string2;
        this.c = string3;
        if (list != null) {
            this.d = list;
            this.e = 0;
            StringBuilder stringBuilder = new StringBuilder(string);
            stringBuilder.append("-");
            stringBuilder.append(this.b);
            stringBuilder.append("-");
            stringBuilder.append(this.c);
            this.f = stringBuilder.toString();
            return;
        }
        throw null;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder stringBuilder2 = c.b.a.a.a.c((String)"FontRequest {mProviderAuthority: ");
        stringBuilder2.append(this.a);
        stringBuilder2.append(", mProviderPackage: ");
        stringBuilder2.append(this.b);
        stringBuilder2.append(", mQuery: ");
        stringBuilder2.append(this.c);
        stringBuilder2.append(", mCertificates:");
        stringBuilder.append(stringBuilder2.toString());
        for (int i2 = 0; i2 < this.d.size(); ++i2) {
            stringBuilder.append(" [");
            List list = (List)this.d.get(i2);
            for (int i3 = 0; i3 < list.size(); ++i3) {
                stringBuilder.append(" \"");
                stringBuilder.append(Base64.encodeToString((byte[])((byte[])list.get(i3)), (int)0));
                stringBuilder.append("\"");
            }
            stringBuilder.append(" ]");
        }
        stringBuilder.append("}");
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append("mCertificatesArray: ");
        stringBuilder3.append(this.e);
        stringBuilder.append(stringBuilder3.toString());
        return stringBuilder.toString();
    }
}

