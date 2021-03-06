package org.telegram.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import de.greenrobot.dao.AbstractDaoMaster;
import de.greenrobot.dao.identityscope.IdentityScopeType;

import org.telegram.dao.UserDao;
import org.telegram.dao.DialogDao;
import org.telegram.dao.GroupChatDao;
import org.telegram.dao.SecretChatDao;
import org.telegram.dao.MessageDao;
import org.telegram.dao.ContactDao;
import org.telegram.dao.MediaRecordDao;
import org.telegram.dao.FullGroupDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * Master of DAO (schema version 12): knows all DAOs.
*/
public class DaoMaster extends AbstractDaoMaster {
    public static final int SCHEMA_VERSION = 12;

    /** Creates underlying database table using DAOs. */
    public static void createAllTables(SQLiteDatabase db, boolean ifNotExists) {
        UserDao.createTable(db, ifNotExists);
        DialogDao.createTable(db, ifNotExists);
        GroupChatDao.createTable(db, ifNotExists);
        SecretChatDao.createTable(db, ifNotExists);
        MessageDao.createTable(db, ifNotExists);
        ContactDao.createTable(db, ifNotExists);
        MediaRecordDao.createTable(db, ifNotExists);
        FullGroupDao.createTable(db, ifNotExists);
    }
    
    /** Drops underlying database table using DAOs. */
    public static void dropAllTables(SQLiteDatabase db, boolean ifExists) {
        UserDao.dropTable(db, ifExists);
        DialogDao.dropTable(db, ifExists);
        GroupChatDao.dropTable(db, ifExists);
        SecretChatDao.dropTable(db, ifExists);
        MessageDao.dropTable(db, ifExists);
        ContactDao.dropTable(db, ifExists);
        MediaRecordDao.dropTable(db, ifExists);
        FullGroupDao.dropTable(db, ifExists);
    }
    
    public static abstract class OpenHelper extends SQLiteOpenHelper {

        public OpenHelper(Context context, String name, CursorFactory factory) {
            super(context, name, factory, SCHEMA_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            Log.i("greenDAO", "Creating tables for schema version " + SCHEMA_VERSION);
            createAllTables(db, false);
        }
    }
    
    /** WARNING: Drops all table on Upgrade! Use only during development. */
    public static class DevOpenHelper extends OpenHelper {
        public DevOpenHelper(Context context, String name, CursorFactory factory) {
            super(context, name, factory);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            Log.i("greenDAO", "Upgrading schema from version " + oldVersion + " to " + newVersion + " by dropping all tables");
            dropAllTables(db, true);
            onCreate(db);
        }
    }

    public DaoMaster(SQLiteDatabase db) {
        super(db, SCHEMA_VERSION);
        registerDaoClass(UserDao.class);
        registerDaoClass(DialogDao.class);
        registerDaoClass(GroupChatDao.class);
        registerDaoClass(SecretChatDao.class);
        registerDaoClass(MessageDao.class);
        registerDaoClass(ContactDao.class);
        registerDaoClass(MediaRecordDao.class);
        registerDaoClass(FullGroupDao.class);
    }
    
    public DaoSession newSession() {
        return new DaoSession(db, IdentityScopeType.Session, daoConfigMap);
    }
    
    public DaoSession newSession(IdentityScopeType type) {
        return new DaoSession(db, type, daoConfigMap);
    }
    
}
