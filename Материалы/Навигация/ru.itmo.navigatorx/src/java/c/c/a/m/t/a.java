/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.content.res.AssetFileDescriptor
 *  android.net.Uri
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
import c.c.a.m.t.l;
import java.io.FileNotFoundException;

public final class a
extends l<AssetFileDescriptor> {
    public a(ContentResolver contentResolver, Uri uri) {
        super(contentResolver, uri);
    }

    public Class<AssetFileDescriptor> a() {
        return AssetFileDescriptor.class;
    }

    public void d(Object object) {
        ((AssetFileDescriptor)object).close();
    }

    public Object f(Uri uri, ContentResolver contentResolver) {
        AssetFileDescriptor assetFileDescriptor = contentResolver.openAssetFileDescriptor(uri, "r");
        if (assetFileDescriptor != null) {
            return assetFileDescriptor;
        }
        throw new FileNotFoundException(c.b.a.a.a.g("FileDescriptor is null for: ", uri));
    }
}

