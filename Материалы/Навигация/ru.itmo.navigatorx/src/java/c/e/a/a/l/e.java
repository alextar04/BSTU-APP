/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Matrix
 *  android.util.Property
 *  android.widget.ImageView
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 */
package c.e.a.a.l;

import android.graphics.Matrix;
import android.util.Property;
import android.widget.ImageView;

public class e
extends Property<ImageView, Matrix> {
    public final Matrix a = new Matrix();

    public e() {
        super(Matrix.class, "imageMatrixProperty");
    }

    public Object get(Object object) {
        ImageView imageView = (ImageView)object;
        this.a.set(imageView.getImageMatrix());
        return this.a;
    }

    public void set(Object object, Object object2) {
        ((ImageView)object).setImageMatrix((Matrix)object2);
    }
}

