/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.AnimatorSet
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.graphics.Canvas
 *  android.graphics.Matrix
 *  android.graphics.Picture
 *  android.graphics.RectF
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.ViewGroup
 *  android.view.ViewGroupOverlay
 *  android.view.ViewParent
 *  android.widget.ImageView
 *  android.widget.ImageView$ScaleType
 *  java.lang.Math
 *  java.lang.Object
 */
package f.r;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Picture;
import android.graphics.RectF;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;
import android.view.ViewParent;
import android.widget.ImageView;
import f.r.b0;
import f.r.v;

public class p {
    public static final boolean a;

    public static {
        boolean bl = Build.VERSION.SDK_INT >= 28;
        a = bl;
    }

    public static View a(ViewGroup viewGroup, View view, View view2) {
        int n2;
        int n3;
        int n4;
        Bitmap bitmap;
        ImageView imageView;
        int n5;
        block8 : {
            ViewGroup viewGroup2;
            Matrix matrix;
            RectF rectF;
            int n6;
            boolean bl;
            block9 : {
                block6 : {
                    block7 : {
                        matrix = new Matrix();
                        matrix.setTranslate((float)(-view2.getScrollX()), (float)(-view2.getScrollY()));
                        v.a.g(view, matrix);
                        v.a.h((View)viewGroup, matrix);
                        rectF = new RectF(0.0f, 0.0f, (float)view.getWidth(), (float)view.getHeight());
                        matrix.mapRect(rectF);
                        n4 = Math.round((float)rectF.left);
                        n3 = Math.round((float)rectF.top);
                        n5 = Math.round((float)rectF.right);
                        n2 = Math.round((float)rectF.bottom);
                        imageView = new ImageView(view.getContext());
                        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                        bl = true ^ view.isAttachedToWindow();
                        boolean bl2 = viewGroup == null ? false : viewGroup.isAttachedToWindow();
                        if (!bl) break block6;
                        if (bl2) break block7;
                        bitmap = null;
                        break block8;
                    }
                    viewGroup2 = (ViewGroup)view.getParent();
                    n6 = viewGroup2.indexOfChild(view);
                    viewGroup.getOverlay().add(view);
                    break block9;
                }
                n6 = 0;
                viewGroup2 = null;
            }
            int n7 = Math.round((float)rectF.width());
            int n8 = Math.round((float)rectF.height());
            bitmap = null;
            if (n7 > 0) {
                bitmap = null;
                if (n8 > 0) {
                    Bitmap bitmap2;
                    float f2 = Math.min((float)1.0f, (float)(1048576.0f / (float)(n7 * n8)));
                    int n9 = Math.round((float)(f2 * (float)n7));
                    int n10 = Math.round((float)(f2 * (float)n8));
                    matrix.postTranslate(-rectF.left, -rectF.top);
                    matrix.postScale(f2, f2);
                    if (a) {
                        Picture picture = new Picture();
                        Canvas canvas = picture.beginRecording(n9, n10);
                        canvas.concat(matrix);
                        view.draw(canvas);
                        picture.endRecording();
                        bitmap2 = Bitmap.createBitmap((Picture)picture);
                    } else {
                        bitmap2 = Bitmap.createBitmap((int)n9, (int)n10, (Bitmap.Config)Bitmap.Config.ARGB_8888);
                        Canvas canvas = new Canvas(bitmap2);
                        canvas.concat(matrix);
                        view.draw(canvas);
                    }
                    bitmap = bitmap2;
                }
            }
            if (bl) {
                viewGroup.getOverlay().remove(view);
                viewGroup2.addView(view, n6);
            }
        }
        if (bitmap != null) {
            imageView.setImageBitmap(bitmap);
        }
        imageView.measure(View.MeasureSpec.makeMeasureSpec((int)(n5 - n4), (int)1073741824), View.MeasureSpec.makeMeasureSpec((int)(n2 - n3), (int)1073741824));
        imageView.layout(n4, n3, n5, n2);
        return imageView;
    }

    public static Animator b(Animator animator, Animator animator2) {
        if (animator == null) {
            return animator2;
        }
        if (animator2 == null) {
            return animator;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{animator, animator2});
        return animatorSet;
    }
}

