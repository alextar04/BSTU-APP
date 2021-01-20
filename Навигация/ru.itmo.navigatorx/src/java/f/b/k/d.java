/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Dialog
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnCancelListener
 *  android.content.DialogInterface$OnClickListener
 *  android.content.DialogInterface$OnDismissListener
 *  android.content.DialogInterface$OnKeyListener
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.graphics.drawable.Drawable
 *  android.os.Bundle
 *  android.text.TextUtils
 *  android.util.TypedValue
 *  android.view.ContextThemeWrapper
 *  android.view.KeyEvent
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewParent
 *  android.view.Window
 *  android.widget.AdapterView
 *  android.widget.AdapterView$OnItemClickListener
 *  android.widget.Button
 *  android.widget.FrameLayout
 *  android.widget.ImageView
 *  android.widget.ListAdapter
 *  android.widget.ListView
 *  android.widget.TextView
 *  androidx.appcompat.app.AlertController
 *  androidx.appcompat.app.AlertController$RecycleListView
 *  androidx.appcompat.app.AlertController$b
 *  androidx.appcompat.app.AlertController$d
 *  androidx.core.widget.NestedScrollView
 *  f.b.k.n
 *  f.h.l.l
 *  java.lang.CharSequence
 *  java.lang.Object
 */
package f.b.k;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AlertController;
import androidx.core.widget.NestedScrollView;
import f.b.f;
import f.b.k.c;
import f.b.k.n;
import f.b.p.h0;
import f.h.l.l;

public class d
extends n
implements DialogInterface {
    public final AlertController g = new AlertController(this.getContext(), (n)this, this.getWindow());

    public d(Context context, int n2) {
        super(context, d.d(context, n2));
    }

    public static int d(Context context, int n2) {
        if ((255 & n2 >>> 24) >= 1) {
            return n2;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(f.b.a.alertDialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    public void onCreate(Bundle bundle) {
        ListAdapter listAdapter;
        AlertController alertController;
        ViewGroup viewGroup;
        boolean bl;
        ListView listView;
        ListView listView2;
        int n2;
        boolean bl2;
        block57 : {
            Object object;
            block58 : {
                block56 : {
                    boolean bl3;
                    int n3;
                    ViewGroup viewGroup2;
                    View view;
                    ViewGroup viewGroup3;
                    ViewGroup viewGroup4;
                    block52 : {
                        Button button;
                        block54 : {
                            block55 : {
                                block53 : {
                                    Button button2;
                                    Button button3;
                                    Button button4;
                                    TextView textView;
                                    boolean bl4;
                                    NestedScrollView nestedScrollView;
                                    super.onCreate(bundle);
                                    alertController = this.g;
                                    int n4 = alertController.K;
                                    if (n4 == 0 || alertController.Q != 1) {
                                        n4 = alertController.J;
                                    }
                                    alertController.b.setContentView(n4);
                                    View view2 = alertController.c.findViewById(f.parentPanel);
                                    View view3 = view2.findViewById(f.topPanel);
                                    View view4 = view2.findViewById(f.contentPanel);
                                    View view5 = view2.findViewById(f.buttonPanel);
                                    viewGroup4 = (ViewGroup)view2.findViewById(f.customPanel);
                                    Object object2 = alertController.h;
                                    if (object2 == null) {
                                        object2 = alertController.i != 0 ? LayoutInflater.from((Context)alertController.a).inflate(alertController.i, viewGroup4, false) : null;
                                    }
                                    if (!(bl4 = object2 != null) || !AlertController.a((View)object2)) {
                                        alertController.c.setFlags(131072, 131072);
                                    }
                                    if (bl4) {
                                        FrameLayout frameLayout = (FrameLayout)alertController.c.findViewById(f.custom);
                                        frameLayout.addView(object2, new ViewGroup.LayoutParams(-1, -1));
                                        if (alertController.n) {
                                            frameLayout.setPadding(alertController.j, alertController.k, alertController.l, alertController.m);
                                        }
                                        if (alertController.g != null) {
                                            ((h0.a)viewGroup4.getLayoutParams()).a = 0.0f;
                                        }
                                    } else {
                                        viewGroup4.setVisibility(8);
                                    }
                                    View view6 = viewGroup4.findViewById(f.topPanel);
                                    View view7 = viewGroup4.findViewById(f.contentPanel);
                                    View view8 = viewGroup4.findViewById(f.buttonPanel);
                                    viewGroup2 = alertController.d(view6, view3);
                                    viewGroup = alertController.d(view7, view4);
                                    viewGroup3 = alertController.d(view8, view5);
                                    alertController.A = nestedScrollView = (NestedScrollView)alertController.c.findViewById(f.scrollView);
                                    nestedScrollView.setFocusable(false);
                                    alertController.A.setNestedScrollingEnabled(false);
                                    alertController.F = textView = (TextView)viewGroup.findViewById(16908299);
                                    if (textView != null) {
                                        CharSequence charSequence = alertController.f;
                                        if (charSequence != null) {
                                            textView.setText(charSequence);
                                        } else {
                                            textView.setVisibility(8);
                                            alertController.A.removeView((View)alertController.F);
                                            if (alertController.g != null) {
                                                ViewGroup viewGroup5 = (ViewGroup)alertController.A.getParent();
                                                int n5 = viewGroup5.indexOfChild((View)alertController.A);
                                                viewGroup5.removeViewAt(n5);
                                                viewGroup5.addView((View)alertController.g, n5, new ViewGroup.LayoutParams(-1, -1));
                                            } else {
                                                viewGroup.setVisibility(8);
                                            }
                                        }
                                    }
                                    alertController.o = button4 = (Button)viewGroup3.findViewById(16908313);
                                    button4.setOnClickListener(alertController.S);
                                    if (TextUtils.isEmpty((CharSequence)alertController.p) && alertController.r == null) {
                                        alertController.o.setVisibility(8);
                                        n3 = 0;
                                    } else {
                                        alertController.o.setText(alertController.p);
                                        Drawable drawable = alertController.r;
                                        if (drawable != null) {
                                            int n6 = alertController.d;
                                            drawable.setBounds(0, 0, n6, n6);
                                            alertController.o.setCompoundDrawables(alertController.r, null, null, null);
                                        }
                                        alertController.o.setVisibility(0);
                                        n3 = 1;
                                    }
                                    alertController.s = button3 = (Button)viewGroup3.findViewById(16908314);
                                    button3.setOnClickListener(alertController.S);
                                    if (TextUtils.isEmpty((CharSequence)alertController.t) && alertController.v == null) {
                                        alertController.s.setVisibility(8);
                                    } else {
                                        alertController.s.setText(alertController.t);
                                        Drawable drawable = alertController.v;
                                        if (drawable != null) {
                                            int n7 = alertController.d;
                                            drawable.setBounds(0, 0, n7, n7);
                                            alertController.s.setCompoundDrawables(alertController.v, null, null, null);
                                        }
                                        alertController.s.setVisibility(0);
                                        n3 |= 2;
                                    }
                                    alertController.w = button2 = (Button)viewGroup3.findViewById(16908315);
                                    button2.setOnClickListener(alertController.S);
                                    if (TextUtils.isEmpty((CharSequence)alertController.x) && alertController.z == null) {
                                        alertController.w.setVisibility(8);
                                    } else {
                                        alertController.w.setText(alertController.x);
                                        Drawable drawable = alertController.z;
                                        if (drawable != null) {
                                            int n8 = alertController.d;
                                            drawable.setBounds(0, 0, n8, n8);
                                            alertController.w.setCompoundDrawables(alertController.z, null, null, null);
                                        }
                                        alertController.w.setVisibility(0);
                                        n3 |= 4;
                                    }
                                    Context context = alertController.a;
                                    TypedValue typedValue = new TypedValue();
                                    context.getTheme().resolveAttribute(f.b.a.alertDialogCenterButtons, typedValue, true);
                                    boolean bl5 = typedValue.data != 0;
                                    if (!bl5) break block52;
                                    if (n3 != 1) break block53;
                                    button = alertController.o;
                                    break block54;
                                }
                                if (n3 != 2) break block55;
                                button = alertController.s;
                                break block54;
                            }
                            if (n3 != 4) break block52;
                            button = alertController.w;
                        }
                        alertController.b(button);
                    }
                    if (!(bl3 = n3 != 0)) {
                        viewGroup3.setVisibility(8);
                    }
                    if (alertController.G != null) {
                        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -2);
                        viewGroup2.addView(alertController.G, 0, layoutParams);
                        alertController.c.findViewById(f.title_template).setVisibility(8);
                    } else {
                        alertController.D = (ImageView)alertController.c.findViewById(16908294);
                        if (true ^ TextUtils.isEmpty((CharSequence)alertController.e) && alertController.P) {
                            TextView textView;
                            alertController.E = textView = (TextView)alertController.c.findViewById(f.alertTitle);
                            textView.setText(alertController.e);
                            int n9 = alertController.B;
                            if (n9 != 0) {
                                alertController.D.setImageResource(n9);
                            } else {
                                Drawable drawable = alertController.C;
                                if (drawable != null) {
                                    alertController.D.setImageDrawable(drawable);
                                } else {
                                    alertController.E.setPadding(alertController.D.getPaddingLeft(), alertController.D.getPaddingTop(), alertController.D.getPaddingRight(), alertController.D.getPaddingBottom());
                                    alertController.D.setVisibility(8);
                                }
                            }
                        } else {
                            alertController.c.findViewById(f.title_template).setVisibility(8);
                            alertController.D.setVisibility(8);
                            viewGroup2.setVisibility(8);
                        }
                    }
                    bl = viewGroup4.getVisibility() != 8;
                    n2 = viewGroup2 != null && viewGroup2.getVisibility() != 8 ? 1 : 0;
                    bl2 = viewGroup3.getVisibility() != 8;
                    if (!bl2 && (view = viewGroup.findViewById(f.textSpacerNoButtons)) != null) {
                        view.setVisibility(0);
                    }
                    if (n2 == 0) break block56;
                    NestedScrollView nestedScrollView = alertController.A;
                    if (nestedScrollView != null) {
                        nestedScrollView.setClipToPadding(true);
                    }
                    object = alertController.f == null && alertController.g == null ? null : viewGroup2.findViewById(f.titleDividerNoCustom);
                    if (object == null) break block57;
                    break block58;
                }
                object = viewGroup.findViewById(f.textSpacerNoTitle);
                if (object == null) break block57;
            }
            object.setVisibility(0);
        }
        if ((listView = alertController.g) instanceof AlertController.RecycleListView) {
            AlertController.RecycleListView recycleListView = (AlertController.RecycleListView)listView;
            if (recycleListView != null) {
                if (!bl2 || n2 == 0) {
                    int n10 = recycleListView.getPaddingLeft();
                    int n11 = n2 != 0 ? recycleListView.getPaddingTop() : recycleListView.e;
                    int n12 = recycleListView.getPaddingRight();
                    int n13 = bl2 ? recycleListView.getPaddingBottom() : recycleListView.f;
                    recycleListView.setPadding(n10, n11, n12, n13);
                }
            } else {
                throw null;
            }
        }
        if (!bl) {
            ListView listView3 = alertController.g;
            if (listView3 == null) {
                listView3 = alertController.A;
            }
            if (listView3 != null) {
                int n14 = 0;
                if (bl2) {
                    n14 = 2;
                }
                int n15 = n2 | n14;
                View view = alertController.c.findViewById(f.scrollIndicatorUp);
                View view9 = alertController.c.findViewById(f.scrollIndicatorDown);
                l.c0((View)listView3, (int)n15, (int)3);
                if (view != null) {
                    viewGroup.removeView(view);
                }
                if (view9 != null) {
                    viewGroup.removeView(view9);
                }
            }
        }
        if ((listView2 = alertController.g) != null && (listAdapter = alertController.H) != null) {
            listView2.setAdapter(listAdapter);
            int n16 = alertController.I;
            if (n16 > -1) {
                listView2.setItemChecked(n16, true);
                listView2.setSelection(n16);
            }
        }
    }

    public boolean onKeyDown(int n2, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.g.A;
        boolean bl = nestedScrollView != null && nestedScrollView.l(keyEvent);
        if (bl) {
            return true;
        }
        return Dialog.super.onKeyDown(n2, keyEvent);
    }

    public boolean onKeyUp(int n2, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.g.A;
        boolean bl = nestedScrollView != null && nestedScrollView.l(keyEvent);
        if (bl) {
            return true;
        }
        return Dialog.super.onKeyUp(n2, keyEvent);
    }

    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        AlertController alertController = this.g;
        alertController.e = charSequence;
        TextView textView = alertController.E;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

}

