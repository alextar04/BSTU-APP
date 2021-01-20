/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  java.io.IOException
 *  java.io.PrintStream
 *  java.io.PrintWriter
 *  java.lang.Appendable
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.StackTraceElement
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.Collections
 *  java.util.Iterator
 *  java.util.List
 */
package c.c.a.m.u;

import android.util.Log;
import c.c.a.m.m;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class r
extends Exception {
    public static final StackTraceElement[] j = new StackTraceElement[0];
    public final List<Throwable> e;
    public m f;
    public c.c.a.m.a g;
    public Class<?> h;
    public String i;

    public r(String string) {
        List list = Collections.emptyList();
        this.i = string;
        this.setStackTrace(j);
        this.e = list;
    }

    public r(String string, Throwable throwable) {
        List list = Collections.singletonList((Object)throwable);
        this.i = string;
        this.setStackTrace(j);
        this.e = list;
    }

    public r(String string, List<Throwable> list) {
        this.i = string;
        this.setStackTrace(j);
        this.e = list;
    }

    public static void b(List<Throwable> list, Appendable appendable) {
        try {
            r.c(list, appendable);
            return;
        }
        catch (IOException iOException) {
            throw new RuntimeException((Throwable)iOException);
        }
    }

    public static void c(List<Throwable> list, Appendable appendable) {
        int n2 = list.size();
        int n3 = 0;
        while (n3 < n2) {
            Appendable appendable2 = appendable.append((CharSequence)"Cause (");
            int n4 = n3 + 1;
            appendable2.append((CharSequence)String.valueOf((int)n4)).append((CharSequence)" of ").append((CharSequence)String.valueOf((int)n2)).append((CharSequence)"): ");
            Throwable throwable = (Throwable)list.get(n3);
            if (throwable instanceof r) {
                ((r)throwable).f(appendable);
            } else {
                r.d(throwable, appendable);
            }
            n3 = n4;
        }
    }

    public static void d(Throwable throwable, Appendable appendable) {
        try {
            appendable.append((CharSequence)throwable.getClass().toString()).append((CharSequence)": ").append((CharSequence)throwable.getMessage()).append('\n');
            return;
        }
        catch (IOException iOException) {
            throw new RuntimeException(throwable);
        }
    }

    public final void a(Throwable throwable, List<Throwable> list) {
        if (throwable instanceof r) {
            Iterator iterator = ((r)throwable).e.iterator();
            while (iterator.hasNext()) {
                this.a((Throwable)iterator.next(), list);
            }
        } else {
            list.add((Object)throwable);
        }
    }

    public void e(String string) {
        ArrayList arrayList = new ArrayList();
        this.a((Throwable)this, (List<Throwable>)arrayList);
        int n2 = arrayList.size();
        int n3 = 0;
        while (n3 < n2) {
            StringBuilder stringBuilder = c.b.a.a.a.c("Root cause (");
            int n4 = n3 + 1;
            stringBuilder.append(n4);
            stringBuilder.append(" of ");
            stringBuilder.append(n2);
            stringBuilder.append(")");
            Log.i((String)string, (String)stringBuilder.toString(), (Throwable)((Throwable)arrayList.get(n3)));
            n3 = n4;
        }
    }

    public final void f(Appendable appendable) {
        r.d((Throwable)this, appendable);
        r.b(this.e, new a(appendable));
    }

    public Throwable fillInStackTrace() {
        return this;
    }

    public String getMessage() {
        String string;
        String string2;
        String string3;
        StringBuilder stringBuilder = new StringBuilder(71);
        stringBuilder.append(this.i);
        Class<?> class_ = this.h;
        String string4 = "";
        if (class_ != null) {
            StringBuilder stringBuilder2 = c.b.a.a.a.c(", ");
            stringBuilder2.append(this.h);
            string3 = stringBuilder2.toString();
        } else {
            string3 = string4;
        }
        stringBuilder.append(string3);
        if (this.g != null) {
            StringBuilder stringBuilder3 = c.b.a.a.a.c(", ");
            stringBuilder3.append((Object)this.g);
            string2 = stringBuilder3.toString();
        } else {
            string2 = string4;
        }
        stringBuilder.append(string2);
        if (this.f != null) {
            StringBuilder stringBuilder4 = c.b.a.a.a.c(", ");
            stringBuilder4.append((Object)this.f);
            string4 = stringBuilder4.toString();
        }
        stringBuilder.append(string4);
        ArrayList arrayList = new ArrayList();
        this.a((Throwable)this, (List<Throwable>)arrayList);
        if (arrayList.isEmpty()) {
            return stringBuilder.toString();
        }
        if (arrayList.size() == 1) {
            string = "\nThere was 1 cause:";
        } else {
            stringBuilder.append("\nThere were ");
            stringBuilder.append(arrayList.size());
            string = " causes:";
        }
        stringBuilder.append(string);
        for (Throwable throwable : arrayList) {
            stringBuilder.append('\n');
            stringBuilder.append(throwable.getClass().getName());
            stringBuilder.append('(');
            stringBuilder.append(throwable.getMessage());
            stringBuilder.append(')');
        }
        stringBuilder.append("\n call GlideException#logRootCauses(String) for more detail");
        return stringBuilder.toString();
    }

    public void printStackTrace() {
        this.f((Appendable)System.err);
    }

    public void printStackTrace(PrintStream printStream) {
        this.f((Appendable)printStream);
    }

    public void printStackTrace(PrintWriter printWriter) {
        this.f((Appendable)printWriter);
    }

    public static final class a
    implements Appendable {
        public final Appendable e;
        public boolean f = true;

        public a(Appendable appendable) {
            this.e = appendable;
        }

        public Appendable append(char c2) {
            if (this.f) {
                this.f = false;
                this.e.append((CharSequence)"  ");
            }
            boolean bl = false;
            if (c2 == '\n') {
                bl = true;
            }
            this.f = bl;
            this.e.append(c2);
            return this;
        }

        public Appendable append(CharSequence charSequence) {
            if (charSequence == null) {
                charSequence = "";
            }
            this.append(charSequence, 0, charSequence.length());
            return this;
        }

        public Appendable append(CharSequence charSequence, int n2, int n3) {
            if (charSequence == null) {
                charSequence = "";
            }
            if (this.f) {
                this.f = false;
                this.e.append((CharSequence)"  ");
            }
            int n4 = charSequence.length();
            boolean bl = false;
            if (n4 > 0) {
                char c2 = charSequence.charAt(n3 - 1);
                bl = false;
                if (c2 == '\n') {
                    bl = true;
                }
            }
            this.f = bl;
            this.e.append(charSequence, n2, n3);
            return this;
        }
    }

}

