/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.text.Spanned
 *  android.text.style.ClickableSpan
 *  android.util.Log
 *  android.util.SparseArray
 *  android.view.View
 *  android.view.View$AccessibilityDelegate
 *  android.view.ViewGroup
 *  android.view.accessibility.AccessibilityEvent
 *  android.view.accessibility.AccessibilityNodeInfo
 *  android.view.accessibility.AccessibilityNodeProvider
 *  f.h.l.l
 *  f.h.l.n
 *  f.h.l.o
 *  f.h.l.v.b
 *  f.h.l.v.b$a
 *  f.h.l.v.c
 *  f.h.l.v.d
 *  f.h.l.v.d$a
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.lang.ref.WeakReference
 *  java.lang.reflect.Constructor
 *  java.util.ArrayList
 *  java.util.Collections
 *  java.util.List
 */
package f.h.l;

import android.os.Build;
import android.os.Bundle;
import android.text.Spanned;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import f.h.b;
import f.h.l.l;
import f.h.l.n;
import f.h.l.o;
import f.h.l.v.b;
import f.h.l.v.c;
import f.h.l.v.d;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class a {
    public static final View.AccessibilityDelegate c = new View.AccessibilityDelegate();
    public final View.AccessibilityDelegate a;
    public final View.AccessibilityDelegate b;

    public a() {
        View.AccessibilityDelegate accessibilityDelegate = c;
        this.a = accessibilityDelegate;
        this.b = new a(this);
    }

    public a(View.AccessibilityDelegate accessibilityDelegate) {
        this.a = accessibilityDelegate;
        this.b = new a(this);
    }

    public boolean a(View view, AccessibilityEvent accessibilityEvent) {
        return this.a.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public c b(View view) {
        AccessibilityNodeProvider accessibilityNodeProvider = this.a.getAccessibilityNodeProvider(view);
        if (accessibilityNodeProvider != null) {
            return new c((Object)accessibilityNodeProvider);
        }
        return null;
    }

    public void c(View view, AccessibilityEvent accessibilityEvent) {
        this.a.onInitializeAccessibilityEvent(view, accessibilityEvent);
    }

    public void d(View view, f.h.l.v.b b2) {
        this.a.onInitializeAccessibilityNodeInfo(view, b2.a);
    }

    public void e(View view, AccessibilityEvent accessibilityEvent) {
        this.a.onPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public boolean f(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return this.a.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public boolean g(View view, int n2, Bundle bundle) {
        boolean bl2;
        ClickableSpan clickableSpan;
        block13 : {
            boolean bl;
            block12 : {
                List list = (List)view.getTag(b.tag_accessibility_actions);
                if (list == null) {
                    list = Collections.emptyList();
                }
                for (int i2 = 0; i2 < list.size(); ++i2) {
                    b.a a2 = (b.a)list.get(i2);
                    if (a2.a() != n2) continue;
                    if (a2.d == null) break;
                    Class class_ = a2.c;
                    d.a a3 = null;
                    if (class_ != null) {
                        d.a a4;
                        block10 : {
                            Exception exception;
                            block11 : {
                                a4 = (d.a)class_.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                                if (a4 != null) break block10;
                                try {
                                    throw null;
                                }
                                catch (Exception exception2) {
                                    break block11;
                                }
                                catch (Exception exception3) {
                                    exception = exception3;
                                    a4 = null;
                                }
                            }
                            Class class_2 = a2.c;
                            String string = class_2 == null ? "null" : class_2.getName();
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("Failed to execute command with argument class ViewCommandArgument: ");
                            stringBuilder.append(string);
                            Log.e((String)"A11yActionCompat", (String)stringBuilder.toString(), (Throwable)exception);
                        }
                        a3 = a4;
                    }
                    bl = a2.d.a(view, a3);
                    break block12;
                }
                bl = false;
            }
            if (!bl) {
                bl = this.a.performAccessibilityAction(view, n2, bundle);
            }
            if (bl) return bl;
            if (n2 != b.accessibility_action_clickable_span) return bl;
            int n3 = bundle.getInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", -1);
            SparseArray sparseArray = (SparseArray)view.getTag(b.tag_accessibility_clickable_spans);
            bl2 = false;
            if (sparseArray == null) return bl2;
            WeakReference weakReference = (WeakReference)sparseArray.get(n3);
            bl2 = false;
            if (weakReference == null) return bl2;
            clickableSpan = (ClickableSpan)weakReference.get();
            if (clickableSpan == null) return false;
            ClickableSpan[] arrclickableSpan = f.h.l.v.b.d((CharSequence)view.createAccessibilityNodeInfo().getText());
            int i3 = 0;
            while (arrclickableSpan != null) {
                if (i3 >= arrclickableSpan.length) return false;
                if (!clickableSpan.equals((Object)arrclickableSpan[i3])) {
                    ++i3;
                    continue;
                }
                break block13;
            }
            return false;
        }
        boolean bl3 = true;
        bl2 = false;
        if (!bl3) return bl2;
        clickableSpan.onClick(view);
        return true;
    }

    public void h(View view, int n2) {
        this.a.sendAccessibilityEvent(view, n2);
    }

    public void i(View view, AccessibilityEvent accessibilityEvent) {
        this.a.sendAccessibilityEventUnchecked(view, accessibilityEvent);
    }

    public static final class a
    extends View.AccessibilityDelegate {
        public final a a;

        public a(a a2) {
            this.a = a2;
        }

        public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            return this.a.a(view, accessibilityEvent);
        }

        public AccessibilityNodeProvider getAccessibilityNodeProvider(View view) {
            c c2 = this.a.b(view);
            if (c2 != null) {
                return (AccessibilityNodeProvider)c2.a;
            }
            return null;
        }

        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.a.c(view, accessibilityEvent);
        }

        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            List list;
            f.h.l.v.b b2 = new f.h.l.v.b(accessibilityNodeInfo);
            boolean bl = l.D((View)view);
            if (Build.VERSION.SDK_INT >= 28) {
                b2.a.setScreenReaderFocusable(bl);
            } else {
                b2.h(1, bl);
            }
            Boolean bl2 = (Boolean)new o(b.tag_accessibility_heading, Boolean.class, 28).d(view);
            boolean bl3 = bl2 == null ? false : bl2;
            if (Build.VERSION.SDK_INT >= 28) {
                b2.a.setHeading(bl3);
            } else {
                b2.h(2, bl3);
            }
            CharSequence charSequence = (CharSequence)new n(b.tag_accessibility_pane_title, CharSequence.class, 8, 28).d(view);
            if (Build.VERSION.SDK_INT >= 28) {
                b2.a.setPaneTitle(charSequence);
            } else {
                b2.a.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.PANE_TITLE_KEY", charSequence);
            }
            this.a.d(view, b2);
            CharSequence charSequence2 = accessibilityNodeInfo.getText();
            if (Build.VERSION.SDK_INT < 26) {
                ClickableSpan[] arrclickableSpan;
                b2.a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
                b2.a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
                b2.a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
                b2.a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
                SparseArray sparseArray = (SparseArray)view.getTag(b.tag_accessibility_clickable_spans);
                if (sparseArray != null) {
                    ArrayList arrayList = new ArrayList();
                    for (int i2 = 0; i2 < sparseArray.size(); ++i2) {
                        if (((WeakReference)sparseArray.valueAt(i2)).get() != null) continue;
                        arrayList.add((Object)i2);
                    }
                    for (int i3 = 0; i3 < arrayList.size(); ++i3) {
                        sparseArray.remove(((Integer)arrayList.get(i3)).intValue());
                    }
                }
                if ((arrclickableSpan = f.h.l.v.b.d((CharSequence)charSequence2)) != null && arrclickableSpan.length > 0) {
                    b2.f().putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY", b.accessibility_action_clickable_span);
                    SparseArray sparseArray2 = (SparseArray)view.getTag(b.tag_accessibility_clickable_spans);
                    if (sparseArray2 == null) {
                        sparseArray2 = new SparseArray();
                        view.setTag(b.tag_accessibility_clickable_spans, (Object)sparseArray2);
                    }
                    for (int i4 = 0; i4 < arrclickableSpan.length; ++i4) {
                        int n2;
                        block16 : {
                            ClickableSpan clickableSpan = arrclickableSpan[i4];
                            for (int i5 = 0; i5 < sparseArray2.size(); ++i5) {
                                if (!clickableSpan.equals((Object)((ClickableSpan)((WeakReference)sparseArray2.valueAt(i5)).get()))) continue;
                                n2 = sparseArray2.keyAt(i5);
                                break block16;
                            }
                            n2 = f.h.l.v.b.d;
                            f.h.l.v.b.d = n2 + 1;
                        }
                        sparseArray2.put(n2, (Object)new WeakReference((Object)arrclickableSpan[i4]));
                        ClickableSpan clickableSpan = arrclickableSpan[i4];
                        Spanned spanned = (Spanned)charSequence2;
                        b2.b("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").add((Object)spanned.getSpanStart((Object)clickableSpan));
                        b2.b("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY").add((Object)spanned.getSpanEnd((Object)clickableSpan));
                        b2.b("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY").add((Object)spanned.getSpanFlags((Object)clickableSpan));
                        b2.b("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY").add((Object)n2);
                    }
                }
            }
            if ((list = (List)view.getTag(b.tag_accessibility_actions)) == null) {
                list = Collections.emptyList();
            }
            for (int i6 = 0; i6 < list.size(); ++i6) {
                b2.a((b.a)list.get(i6));
            }
        }

        public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.a.e(view, accessibilityEvent);
        }

        public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            return this.a.f(viewGroup, view, accessibilityEvent);
        }

        public boolean performAccessibilityAction(View view, int n2, Bundle bundle) {
            return this.a.g(view, n2, bundle);
        }

        public void sendAccessibilityEvent(View view, int n2) {
            this.a.h(view, n2);
        }

        public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
            this.a.i(view, accessibilityEvent);
        }
    }

}

