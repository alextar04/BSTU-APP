/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  i.f0.i.a
 *  i.f0.i.b
 *  i.f0.i.c
 *  i.f0.i.d
 *  i.f0.k.a
 *  i.f0.k.b
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 *  java.lang.Throwable
 *  java.net.InetSocketAddress
 *  java.net.Socket
 *  java.net.SocketAddress
 *  java.security.Security
 *  java.security.cert.X509Certificate
 *  java.util.ArrayList
 *  java.util.List
 *  java.util.logging.Level
 *  java.util.logging.Logger
 *  javax.net.ssl.SSLContext
 *  javax.net.ssl.SSLSocket
 *  javax.net.ssl.SSLSocketFactory
 *  javax.net.ssl.X509TrustManager
 */
package i.f0.i;

import i.f0.i.a;
import i.f0.i.b;
import i.f0.i.c;
import i.f0.i.d;
import i.f0.k.e;
import i.u;
import i.v;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.security.Security;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

public class f {
    public static final f a;
    public static final Logger b;

    public static {
        boolean bl;
        f f2 = a.o();
        if (!(f2 != null || (bl = "conscrypt".equals((Object)System.getProperty((String)"okhttp.platform")) ? true : "Conscrypt".equals((Object)Security.getProviders()[0].getName())) && (f2 = b.n()) != null || (f2 = c.n()) != null || (f2 = d.n()) != null)) {
            f2 = new f();
        }
        a = f2;
        b = Logger.getLogger((String)u.class.getName());
    }

    public static List<String> b(List<v> list) {
        ArrayList arrayList = new ArrayList(list.size());
        int n2 = list.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            v v2 = (v)((Object)list.get(i2));
            if (v2 == v.f) continue;
            arrayList.add((Object)v2.e);
        }
        return arrayList;
    }

    public void a(SSLSocket sSLSocket) {
    }

    public i.f0.k.c c(X509TrustManager x509TrustManager) {
        return new i.f0.k.a(this.d(x509TrustManager));
    }

    public e d(X509TrustManager x509TrustManager) {
        return new i.f0.k.b(x509TrustManager.getAcceptedIssuers());
    }

    public void e(SSLSocketFactory sSLSocketFactory) {
    }

    public void f(SSLSocket sSLSocket, String string, List<v> list) {
    }

    public void g(Socket socket, InetSocketAddress inetSocketAddress, int n2) {
        socket.connect((SocketAddress)inetSocketAddress, n2);
    }

    /*
     * Exception decompiling
     */
    public SSLContext h() {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl11.3 : FAKE_TRY : trying to set 0 previously set to 1
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:203)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.g.p(Method.java:396)
        // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
        // org.benf.cfr.reader.entities.d.b(ClassFile.java:792)
        // org.benf.cfr.reader.b.a(Driver.java:128)
        // org.benf.cfr.reader.a.a(CfrDriverImpl.java:63)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.decompileWithCFR(JavaExtractionWorker.kt:61)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.doWork(JavaExtractionWorker.kt:130)
        // com.njlabs.showjava.decompilers.BaseDecompiler.withAttempt(BaseDecompiler.kt:108)
        // com.njlabs.showjava.workers.DecompilerWorker$b.run(DecompilerWorker.kt:118)
        // java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1162)
        // java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:636)
        // java.lang.Thread.run(Thread.java:764)
        throw new IllegalStateException("Decompilation failed");
    }

    public String i(SSLSocket sSLSocket) {
        return null;
    }

    public Object j(String string) {
        if (b.isLoggable(Level.FINE)) {
            return new Throwable(string);
        }
        return null;
    }

    public boolean k(String string) {
        return true;
    }

    public void l(int n2, String string, Throwable throwable) {
        Level level = n2 == 5 ? Level.WARNING : Level.INFO;
        b.log(level, string, throwable);
    }

    public void m(String string, Object object) {
        if (object == null) {
            string = c.b.a.a.a.j(string, " To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);");
        }
        this.l(5, string, (Throwable)object);
    }

    public String toString() {
        return this.getClass().getSimpleName();
    }
}

