/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.database.ContentObserver
 *  android.database.Cursor
 *  android.database.DataSetObserver
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.BaseAdapter
 *  android.widget.Filter
 *  android.widget.Filterable
 *  f.i.a.a$a
 *  f.i.a.a$b
 *  f.i.a.b
 *  f.i.a.b$a
 *  java.lang.CharSequence
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 */
package f.i.a;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import f.i.a.a;
import f.i.a.b;
import f.i.a.c;

/*
 * Exception performing whole class analysis.
 */
public abstract class a
extends BaseAdapter
implements Filterable,
b.a {
    public boolean e;
    public boolean f;
    public Cursor g;
    public Context h;
    public int i;
    public a j;
    public DataSetObserver k;
    public f.i.a.b l;

    public a(Context context, Cursor cursor, boolean bl) {
        b b2;
        int n2 = 1;
        int n3 = bl ? n2 : 2;
        if ((n3 & 1) == n2) {
            n3 |= 2;
            this.f = n2;
        } else {
            this.f = false;
        }
        if (cursor == null) {
            n2 = 0;
        }
        this.g = cursor;
        this.e = n2;
        this.h = context;
        int n4 = n2 != 0 ? cursor.getColumnIndexOrThrow("_id") : -1;
        this.i = n4;
        if ((n3 & 2) == 2) {
            this.j = new /* Unavailable Anonymous Inner Class!! */;
            b2 = new /* Unavailable Anonymous Inner Class!! */;
        } else {
            b2 = null;
            this.j = null;
        }
        this.k = b2;
        if (n2 != 0) {
            DataSetObserver dataSetObserver;
            a a2 = this.j;
            if (a2 != null) {
                cursor.registerContentObserver((ContentObserver)a2);
            }
            if ((dataSetObserver = this.k) != null) {
                cursor.registerDataSetObserver(dataSetObserver);
            }
        }
    }

    public abstract void a(View var1, Context var2, Cursor var3);

    public void b(Cursor cursor) {
        Cursor cursor2 = this.g;
        if (cursor == cursor2) {
            cursor2 = null;
        } else {
            if (cursor2 != null) {
                DataSetObserver dataSetObserver;
                a a2 = this.j;
                if (a2 != null) {
                    cursor2.unregisterContentObserver((ContentObserver)a2);
                }
                if ((dataSetObserver = this.k) != null) {
                    cursor2.unregisterDataSetObserver(dataSetObserver);
                }
            }
            this.g = cursor;
            if (cursor != null) {
                DataSetObserver dataSetObserver;
                a a3 = this.j;
                if (a3 != null) {
                    cursor.registerContentObserver((ContentObserver)a3);
                }
                if ((dataSetObserver = this.k) != null) {
                    cursor.registerDataSetObserver(dataSetObserver);
                }
                this.i = cursor.getColumnIndexOrThrow("_id");
                this.e = true;
                this.notifyDataSetChanged();
            } else {
                this.i = -1;
                this.e = false;
                this.notifyDataSetInvalidated();
            }
        }
        if (cursor2 != null) {
            cursor2.close();
        }
    }

    public abstract CharSequence c(Cursor var1);

    public abstract View d(Context var1, Cursor var2, ViewGroup var3);

    public int getCount() {
        Cursor cursor;
        if (this.e && (cursor = this.g) != null) {
            return cursor.getCount();
        }
        return 0;
    }

    public View getDropDownView(int n2, View view, ViewGroup viewGroup) {
        if (this.e) {
            this.g.moveToPosition(n2);
            if (view == null) {
                c c2 = (c)this;
                view = c2.o.inflate(c2.n, viewGroup, false);
            }
            this.a(view, this.h, this.g);
            return view;
        }
        return null;
    }

    public Filter getFilter() {
        if (this.l == null) {
            this.l = new f.i.a.b((b.a)this);
        }
        return this.l;
    }

    public Object getItem(int n2) {
        Cursor cursor;
        if (this.e && (cursor = this.g) != null) {
            cursor.moveToPosition(n2);
            return this.g;
        }
        return null;
    }

    public long getItemId(int n2) {
        Cursor cursor;
        if (this.e && (cursor = this.g) != null && cursor.moveToPosition(n2)) {
            return this.g.getLong(this.i);
        }
        return 0L;
    }

    public View getView(int n2, View view, ViewGroup viewGroup) {
        if (this.e) {
            if (this.g.moveToPosition(n2)) {
                if (view == null) {
                    view = this.d(this.h, this.g, viewGroup);
                }
                this.a(view, this.h, this.g);
                return view;
            }
            throw new IllegalStateException(c.b.a.a.a.b("couldn't move cursor to position ", n2));
        }
        throw new IllegalStateException("this should only be called when the cursor is valid");
    }
}

