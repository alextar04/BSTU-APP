/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.util.Log
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.view.ViewPropertyAnimator
 *  android.widget.ImageView
 *  android.widget.TextView
 *  java.lang.CharSequence
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.List
 */
package b.a.a.a.a.j;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import android.widget.TextView;
import b.a.a.a.a.j.b;
import b.a.a.a.a.j.c;
import b.a.a.a.a.j.e;
import b.a.a.a.a.j.g;
import b.a.a.b.d;
import c.a.a.m;
import c.a.a.n;
import com.otaliastudios.zoom.ZoomMap;
import f.b.k.h;
import f.p.d.s;
import h.m.b.j;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class a
extends m<e> {
    public final a b;
    public List<c> c;
    public final b d;

    public a(List<c> list, b b2) {
        j.e(list, "data");
        j.e(b2, "callbacks");
        this.d = b2;
        this.b = new a(this);
        this.c = list;
    }

    @Override
    public void a(n n2, int n3, int n4) {
        block7 : {
            ViewPropertyAnimator viewPropertyAnimator;
            int n5;
            Resources resources;
            block8 : {
                e e2;
                block6 : {
                    e2 = (e)n2;
                    j.e(e2, "viewHolder");
                    c c2 = (c)this.c.get(n3);
                    j.e(c2, "markerData");
                    d d2 = c2.a;
                    e2.e = d2.c;
                    e2.f = d2.d;
                    e2.g = d2.b;
                    e2.j = c2.c;
                    StringBuilder stringBuilder = c.b.a.a.a.c("setupViewHolder: ");
                    stringBuilder.append(e2.g);
                    Log.d((String)"MarkerViewHolder", (String)stringBuilder.toString());
                    boolean bl = j.a(e2.i, c2.a.a);
                    boolean bl2 = true;
                    if (bl ^ bl2) {
                        e2.a.setVisibility(4);
                        e2.h = false;
                    }
                    if (c2.c) {
                        e2.a.setVisibility(0);
                        e2.h = bl2;
                    }
                    e2.i = c2.a.a;
                    e2.d.setOnClickListener((View.OnClickListener)new g(e2, c2));
                    e2.c.setText((CharSequence)e2.b(c2));
                    e2.c.setCompoundDrawablesWithIntrinsicBounds(0, 0, e2.a(c2), 0);
                    TextView textView = e2.c;
                    CharSequence charSequence = textView.getText();
                    j.d((Object)charSequence, "markerText.text");
                    if (charSequence.length() != 0) {
                        bl2 = false;
                    }
                    int n6 = bl2 ? 0 : (int)e2.c.getResources().getDimension(2131099804);
                    textView.setCompoundDrawablePadding(n6);
                    if (!c2.b) break block6;
                    h.i.F1(e2.b, 2131034161);
                    TextView textView2 = e2.c;
                    h.i.w1((View)textView2, 2131034161);
                    j.e((Object)textView2, "$this$setTextColorRes");
                    textView2.setTextColor(f.h.e.a.b(textView2.getContext(), 17170443));
                    h.i.x1(textView2, 17170443);
                    View view = e2.a;
                    view.setPivotX((float)view.getWidth() / 2.0f);
                    e2.a.setPivotY((float)e2.b.getBottom());
                    if (e2.a.getScaleX() == 1.15f) break block7;
                    viewPropertyAnimator = e2.a.animate().scaleX(1.15f).scaleY(1.15f);
                    resources = e2.a.getResources();
                    n5 = 2131296260;
                    break block8;
                }
                h.i.F1(e2.b, 17170443);
                TextView textView = e2.c;
                h.i.w1((View)textView, 17170443);
                j.e((Object)textView, "$this$setTextColorRes");
                textView.setTextColor(f.h.e.a.b(textView.getContext(), 17170444));
                h.i.x1(textView, 2131034161);
                if (e2.a.getScaleX() == 1.0f) break block7;
                viewPropertyAnimator = e2.a.animate().scaleX(1.0f).scaleY(1.0f);
                resources = e2.a.getResources();
                n5 = 2131296258;
            }
            viewPropertyAnimator.setDuration((long)resources.getInteger(n5)).start();
        }
    }

    @Override
    public n b(ViewGroup viewGroup, int n2) {
        j.e((Object)viewGroup, "parent");
        if (n2 != 0) {
            if (n2 != 1) {
                if (n2 != 2) {
                    if (n2 != 3) {
                        if (n2 == 4) {
                            long l2 = System.currentTimeMillis();
                            View view = LayoutInflater.from((Context)viewGroup.getContext()).inflate(2131427383, viewGroup, false);
                            long l3 = System.currentTimeMillis();
                            StringBuilder stringBuilder = c.b.a.a.a.c("inflateView: ");
                            stringBuilder.append(l3 - l2);
                            Log.d((String)"MarkerAdapter", (String)stringBuilder.toString());
                            j.d((Object)view, "LayoutInflater.from(pare\u20262 - time}\")\n            }");
                            return new e(view, this.d){
                                {
                                    j.e((Object)view, "view");
                                    j.e(b2, "callbacks");
                                    super(view, b2, null);
                                }

                                public int a(c c2) {
                                    j.e(c2, "markerData");
                                    return 0;
                                }

                                public String b(c c2) {
                                    j.e(c2, "markerData");
                                    d d2 = c2.a;
                                    if (d2 != null) {
                                        return (d2).g;
                                    }
                                    throw new java.lang.NullPointerException("null cannot be cast to non-null type ru.zakoulov.navigatorx.data.Marker.Message");
                                }
                            };
                        }
                        throw new IllegalStateException(c.b.a.a.a.b("Unknown marker type: ", n2));
                    }
                    long l4 = System.currentTimeMillis();
                    View view = LayoutInflater.from((Context)viewGroup.getContext()).inflate(2131427382, viewGroup, false);
                    long l5 = System.currentTimeMillis();
                    StringBuilder stringBuilder = c.b.a.a.a.c("inflateView: ");
                    stringBuilder.append(l5 - l4);
                    Log.d((String)"MarkerAdapter", (String)stringBuilder.toString());
                    j.d((Object)view, "LayoutInflater.from(pare\u20262 - time}\")\n            }");
                    return new e(view, this.d){
                        {
                            j.e((Object)view, "view");
                            j.e(b2, "callbacks");
                            super(view, b2, null);
                        }

                        public int a(c c2) {
                            j.e(c2, "markerData");
                            return 0;
                        }

                        public String b(c c2) {
                            j.e(c2, "markerData");
                            d d2 = c2.a;
                            if (d2 != null) {
                                return (d2).h;
                            }
                            throw new java.lang.NullPointerException("null cannot be cast to non-null type ru.zakoulov.navigatorx.data.Marker.Entrance");
                        }
                    };
                }
                long l6 = System.currentTimeMillis();
                View view = LayoutInflater.from((Context)viewGroup.getContext()).inflate(2131427382, viewGroup, false);
                long l7 = System.currentTimeMillis();
                StringBuilder stringBuilder = c.b.a.a.a.c("inflateView: ");
                stringBuilder.append(l7 - l6);
                Log.d((String)"MarkerAdapter", (String)stringBuilder.toString());
                j.d((Object)view, "LayoutInflater.from(pare\u20262 - time}\")\n            }");
                return new e(view, this.d){
                    {
                        j.e((Object)view, "view");
                        j.e(b2, "callbacks");
                        super(view, b2, null);
                    }

                    public int a(c c2) {
                        j.e(c2, "markerData");
                        d d2 = c2.a;
                        if (d2 != null) {
                            int n2 = (d2).g.ordinal();
                            if (n2 != 0) {
                                if (n2 != 1) {
                                    if (n2 == 2) {
                                        return 2131165312;
                                    }
                                    throw new h.b();
                                }
                                return 2131165313;
                            }
                            return 2131165314;
                        }
                        throw new java.lang.NullPointerException("null cannot be cast to non-null type ru.zakoulov.navigatorx.data.Marker.Toilet");
                    }

                    public String b(c c2) {
                        j.e(c2, "markerData");
                        return "WC";
                    }
                };
            }
            long l8 = System.currentTimeMillis();
            View view = LayoutInflater.from((Context)viewGroup.getContext()).inflate(2131427382, viewGroup, false);
            long l9 = System.currentTimeMillis();
            StringBuilder stringBuilder = c.b.a.a.a.c("inflateView: ");
            stringBuilder.append(l9 - l8);
            Log.d((String)"MarkerAdapter", (String)stringBuilder.toString());
            j.d((Object)view, "LayoutInflater.from(pare\u20262 - time}\")\n            }");
            return new e(view, this.d){
                {
                    j.e((Object)view, "view");
                    j.e(b2, "callbacks");
                    super(view, b2, null);
                }

                public int a(c c2) {
                    j.e(c2, "markerData");
                    d d2 = c2.a;
                    if (d2 != null) {
                        if ((d2).g) {
                            return 2131165293;
                        }
                        return 2131165292;
                    }
                    throw new java.lang.NullPointerException("null cannot be cast to non-null type ru.zakoulov.navigatorx.data.Marker.Stairs");
                }

                public String b(c c2) {
                    j.e(c2, "markerData");
                    String string = c2.d;
                    if (string != null) {
                        return string;
                    }
                    return "";
                }
            };
        }
        long l10 = System.currentTimeMillis();
        View view = LayoutInflater.from((Context)viewGroup.getContext()).inflate(2131427382, viewGroup, false);
        long l11 = System.currentTimeMillis();
        StringBuilder stringBuilder = c.b.a.a.a.c("inflateView: ");
        stringBuilder.append(l11 - l10);
        Log.d((String)"MarkerAdapter", (String)stringBuilder.toString());
        j.d((Object)view, "LayoutInflater.from(pare\u20262 - time}\")\n            }");
        return new e(view, this.d){
            {
                j.e((Object)view, "view");
                j.e(b2, "callbacks");
                super(view, b2, null);
            }

            public int a(c c2) {
                j.e(c2, "markerData");
                return 0;
            }

            public String b(c c2) {
                j.e(c2, "markerData");
                d d2 = c2.a;
                if (d2 != null) {
                    return (d2).g;
                }
                throw new java.lang.NullPointerException("null cannot be cast to non-null type ru.zakoulov.navigatorx.data.Marker.Room");
            }
        };
    }

    @Override
    public int c(int n2) {
        c c2 = (c)this.c.get(n2);
        d d2 = c2.a;
        if (d2 instanceof d.c) {
            return 0;
        }
        if (d2 instanceof d.d) {
            return 1;
        }
        if (d2 instanceof d.e) {
            return 2;
        }
        if (d2 instanceof d.a) {
            return 3;
        }
        if (d2 instanceof d.b) {
            return 4;
        }
        StringBuilder stringBuilder = c.b.a.a.a.c("Unsupported marker: ");
        stringBuilder.append((Object)c2.a);
        throw new IllegalStateException(stringBuilder.toString());
    }

    public static final class a
    implements s {
        public final m<?> a;

        public a(m<?> m2) {
            j.e(m2, "adapter");
            this.a = m2;
        }

        @Override
        public void a(int n2, int n3) {
            ZoomMap zoomMap = this.a.a;
            if (zoomMap != null && zoomMap.e != null) {
                ArrayList arrayList = new ArrayList();
                int n4 = n2 + n3 - 1;
                if (n4 >= n2) {
                    do {
                        ZoomMap.a a2 = (ZoomMap.a)zoomMap.m.get(n4);
                        e e2 = (e)a2.a;
                        j.e(e2, "viewHolder");
                        e2.i = null;
                        arrayList.add((Object)a2);
                        zoomMap.f(a2);
                        if (n4 == n2) break;
                        --n4;
                    } while (true);
                }
                zoomMap.m.removeAll((Collection)arrayList);
                zoomMap.removeViews(n2 + 1, n3);
                zoomMap.o = true;
            }
        }

        @Override
        public void b(int n2, int n3) {
            m<n> m2;
            ZoomMap zoomMap = this.a.a;
            if (zoomMap != null && (m2 = zoomMap.e) != null) {
                ArrayList arrayList = new ArrayList();
                int n4 = n3 + n2;
                int n5 = n2;
                while (n5 < n4) {
                    int n6 = m2.c(n5);
                    n n7 = zoomMap.d(m2, n6);
                    m2.a(n7, n5, n6);
                    arrayList.add((Object)new ZoomMap.a(n7, n6));
                    View view = n7.a;
                    zoomMap.addView(view, ++n5);
                }
                zoomMap.m.addAll(n2, (Collection)arrayList);
                zoomMap.o = true;
            }
        }

        @Override
        public void c(int n2, int n3) {
            ZoomMap zoomMap = this.a.a;
            if (zoomMap != null && zoomMap.e != null) {
                int n4 = n2 + 1;
                View view = zoomMap.getChildAt(n4);
                int n5 = n3 + 1;
                View view2 = zoomMap.getChildAt(n5);
                zoomMap.removeViewAt(n5);
                zoomMap.addView(view, n5);
                zoomMap.removeViewAt(n4);
                zoomMap.addView(view2, n4);
                ZoomMap.a a2 = (ZoomMap.a)zoomMap.m.get(n2);
                List<ZoomMap.a> list = zoomMap.m;
                list.set(n2, list.get(n3));
                zoomMap.m.set(n3, (Object)a2);
                zoomMap.o = true;
            }
        }

        @Override
        public void d(int n2, int n3, Object object) {
            m<n> m2;
            ZoomMap zoomMap = this.a.a;
            if (zoomMap != null && (m2 = zoomMap.e) != null) {
                int n4 = n3 + n2;
                while (n2 < n4) {
                    ZoomMap.a a2 = (ZoomMap.a)zoomMap.m.get(n2);
                    m2.a(a2.a, n2, a2.b);
                    ++n2;
                }
                zoomMap.o = true;
            }
        }
    }

}

