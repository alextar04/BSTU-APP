/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.content.UriMatcher
 *  android.net.Uri
 *  android.provider.ContactsContract
 *  android.provider.ContactsContract$Contacts
 *  c.c.a.m.t.l
 *  java.io.FileNotFoundException
 *  java.io.InputStream
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 */
package c.c.a.m.t;

import android.content.ContentResolver;
import android.content.UriMatcher;
import android.net.Uri;
import android.provider.ContactsContract;
import c.b.a.a.a;
import c.c.a.m.t.l;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class n
extends l<InputStream> {
    public static final UriMatcher h;

    public static {
        UriMatcher uriMatcher;
        h = uriMatcher = new UriMatcher(-1);
        uriMatcher.addURI("com.android.contacts", "contacts/lookup/*/#", 1);
        h.addURI("com.android.contacts", "contacts/lookup/*", 1);
        h.addURI("com.android.contacts", "contacts/#/photo", 2);
        h.addURI("com.android.contacts", "contacts/#", 3);
        h.addURI("com.android.contacts", "contacts/#/display_photo", 4);
        h.addURI("com.android.contacts", "phone_lookup/*", 5);
    }

    public n(ContentResolver contentResolver, Uri uri) {
        super(contentResolver, uri);
    }

    public Class<InputStream> a() {
        return InputStream.class;
    }

    public void d(Object object) {
        ((InputStream)object).close();
    }

    public Object f(Uri uri, ContentResolver contentResolver) {
        block8 : {
            InputStream inputStream;
            block7 : {
                Uri uri2;
                block5 : {
                    block6 : {
                        int n2 = h.match(uri);
                        if (n2 == 1) break block5;
                        if (n2 == 3) break block6;
                        if (n2 == 5) break block5;
                        inputStream = contentResolver.openInputStream(uri);
                        break block7;
                    }
                    inputStream = ContactsContract.Contacts.openContactPhotoInputStream((ContentResolver)contentResolver, (Uri)uri, (boolean)true);
                    break block7;
                }
                if ((uri2 = ContactsContract.Contacts.lookupContact((ContentResolver)contentResolver, (Uri)uri)) == null) break block8;
                inputStream = ContactsContract.Contacts.openContactPhotoInputStream((ContentResolver)contentResolver, (Uri)uri2, (boolean)true);
            }
            if (inputStream != null) {
                return inputStream;
            }
            throw new FileNotFoundException(a.g("InputStream is null for ", uri));
        }
        throw new FileNotFoundException("Contact cannot be found");
    }
}

