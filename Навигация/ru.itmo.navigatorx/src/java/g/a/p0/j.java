/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  io.realm.exceptions.RealmException
 *  io.realm.internal.OsRealmConfig
 *  java.lang.Class
 *  java.lang.ClassNotFoundException
 *  java.lang.IllegalAccessException
 *  java.lang.InstantiationException
 *  java.lang.NoSuchMethodException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.lang.reflect.Constructor
 *  java.lang.reflect.InvocationTargetException
 */
package g.a.p0;

import android.content.Context;
import g.a.b0;
import io.realm.exceptions.RealmException;
import io.realm.internal.OsRealmConfig;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class j {
    public static final int SYNC_CONFIG_OPTIONS = 14;
    public static final j nonSyncFacade = new j();
    public static j syncFacade = null;

    public static {
        try {
            syncFacade = (j)Class.forName((String)"io.realm.internal.SyncObjectServerFacade").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            return;
        }
        catch (InvocationTargetException invocationTargetException) {
            throw new RealmException("Failed to init SyncObjectServerFacade", invocationTargetException.getTargetException());
        }
        catch (NoSuchMethodException noSuchMethodException) {
            throw new RealmException("Failed to init SyncObjectServerFacade", (Throwable)noSuchMethodException);
        }
        catch (IllegalAccessException illegalAccessException) {
            throw new RealmException("Failed to init SyncObjectServerFacade", (Throwable)illegalAccessException);
        }
        catch (InstantiationException instantiationException) {
            throw new RealmException("Failed to init SyncObjectServerFacade", (Throwable)instantiationException);
        }
        catch (ClassNotFoundException classNotFoundException) {
            return;
        }
    }

    public static j getFacade(boolean bl) {
        if (bl) {
            return syncFacade;
        }
        return nonSyncFacade;
    }

    public static j getSyncFacadeIfPossible() {
        j j2 = syncFacade;
        if (j2 != null) {
            return j2;
        }
        return nonSyncFacade;
    }

    public void createNativeSyncSession(b0 b02) {
    }

    public void downloadInitialRemoteChanges(b0 b02) {
    }

    public Object[] getSyncConfigurationOptions(b0 b02) {
        return new Object[14];
    }

    public String getSyncServerCertificateAssetName(b0 b02) {
        return null;
    }

    public String getSyncServerCertificateFilePath(b0 b02) {
        return null;
    }

    public void initialize(Context context, String string) {
    }

    public void realmClosed(b0 b02) {
    }

    public boolean wasDownloadInterrupted(Throwable throwable) {
        return false;
    }

    public void wrapObjectStoreSessionIfRequired(OsRealmConfig osRealmConfig) {
    }
}

