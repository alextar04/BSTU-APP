/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.TypedArray
 *  android.graphics.Bitmap
 *  android.graphics.BitmapShader
 *  android.graphics.ColorFilter
 *  android.graphics.Paint
 *  android.graphics.RectF
 *  android.graphics.Shader
 *  android.graphics.Shader$TileMode
 *  android.graphics.drawable.AnimationDrawable
 *  android.graphics.drawable.BitmapDrawable
 *  android.graphics.drawable.ClipDrawable
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.LayerDrawable
 *  android.graphics.drawable.ShapeDrawable
 *  android.graphics.drawable.shapes.RoundRectShape
 *  android.graphics.drawable.shapes.Shape
 *  android.util.AttributeSet
 *  android.widget.ProgressBar
 *  java.lang.Object
 */
package f.b.p;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import f.b.p.w0;
import f.h.f.k.a;

public class p {
    public static final int[] c = new int[]{16843067, 16843068};
    public final ProgressBar a;
    public Bitmap b;

    public p(ProgressBar progressBar) {
        this.a = progressBar;
    }

    public void a(AttributeSet attributeSet, int n2) {
        Drawable drawable;
        w0 w02 = w0.q(this.a.getContext(), attributeSet, c, n2, 0);
        Drawable drawable2 = w02.h(0);
        if (drawable2 != null) {
            ProgressBar progressBar = this.a;
            if (drawable2 instanceof AnimationDrawable) {
                AnimationDrawable animationDrawable = (AnimationDrawable)drawable2;
                int n3 = animationDrawable.getNumberOfFrames();
                AnimationDrawable animationDrawable2 = new AnimationDrawable();
                animationDrawable2.setOneShot(animationDrawable.isOneShot());
                for (int i2 = 0; i2 < n3; ++i2) {
                    Drawable drawable3 = this.b(animationDrawable.getFrame(i2), true);
                    drawable3.setLevel(10000);
                    animationDrawable2.addFrame(drawable3, animationDrawable.getDuration(i2));
                }
                animationDrawable2.setLevel(10000);
                drawable2 = animationDrawable2;
            }
            progressBar.setIndeterminateDrawable(drawable2);
        }
        if ((drawable = w02.h(1)) != null) {
            this.a.setProgressDrawable(this.b(drawable, false));
        }
        w02.b.recycle();
    }

    public final Drawable b(Drawable drawable, boolean bl) {
        if (drawable instanceof a) {
            a a2 = (a)drawable;
            Drawable drawable2 = a2.a();
            if (drawable2 != null) {
                a2.b(this.b(drawable2, bl));
                return drawable;
            }
        } else {
            if (drawable instanceof LayerDrawable) {
                LayerDrawable layerDrawable = (LayerDrawable)drawable;
                int n2 = layerDrawable.getNumberOfLayers();
                Drawable[] arrdrawable = new Drawable[n2];
                int n3 = 0;
                for (int i2 = 0; i2 < n2; ++i2) {
                    int n4 = layerDrawable.getId(i2);
                    Drawable drawable3 = layerDrawable.getDrawable(i2);
                    boolean bl2 = n4 == 16908301 || n4 == 16908303;
                    arrdrawable[i2] = this.b(drawable3, bl2);
                }
                LayerDrawable layerDrawable2 = new LayerDrawable(arrdrawable);
                while (n3 < n2) {
                    layerDrawable2.setId(n3, layerDrawable.getId(n3));
                    ++n3;
                }
                return layerDrawable2;
            }
            if (drawable instanceof BitmapDrawable) {
                BitmapDrawable bitmapDrawable = (BitmapDrawable)drawable;
                Bitmap bitmap = bitmapDrawable.getBitmap();
                if (this.b == null) {
                    this.b = bitmap;
                }
                ShapeDrawable shapeDrawable = new ShapeDrawable((Shape)new RoundRectShape(new float[]{5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f}, null, null));
                BitmapShader bitmapShader = new BitmapShader(bitmap, Shader.TileMode.REPEAT, Shader.TileMode.CLAMP);
                shapeDrawable.getPaint().setShader((Shader)bitmapShader);
                shapeDrawable.getPaint().setColorFilter(bitmapDrawable.getPaint().getColorFilter());
                if (bl) {
                    shapeDrawable = new ClipDrawable((Drawable)shapeDrawable, 3, 1);
                }
                return shapeDrawable;
            }
        }
        return drawable;
    }
}

