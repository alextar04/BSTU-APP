/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.content.res.AssetFileDescriptor
 *  android.net.Uri
 *  android.os.ParcelFileDescriptor
 *  c.c.a.m.t.l
 *  java.io.FileNotFoundException
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 */
package c.c.a.m.t;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import c.b.a.a.a;
import c.c.a.m.t.l;
import java.io.FileNotFoundException;

public class i
extends l<ParcelFileDescriptor> {
    public i(ContentResolver contentResolver, Uri uri) {
        super(contentResolver, uri);
    }

    public Class<ParcelFileDescriptor> a() {
        return ParcelFileDescriptor.class;
    }

    public void d(Object object) {
        ((ParcelFileDescriptor)object).close();
    }

    public Object f(Uri uri, ContentResolver contentResolver) {
        AssetFileDescriptor assetFileDescriptor = contentResolver.openAssetFileDescriptor(uri, "r");
        if (assetFileDescriptor != null) {
            return assetFileDescriptor.getParcelFileDescriptor();
        }
        throw new FileNotFoundException(a.g("FileDescriptor is null for: ", uri));
    }
}

