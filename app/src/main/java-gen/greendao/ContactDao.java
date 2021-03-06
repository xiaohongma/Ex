package greendao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import java.sql.Date;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;
import model.Contact;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table CONTACT.
*/
public class ContactDao extends AbstractDao<Contact, Long> {

    public static final String TABLENAME = "CONTACT";

    /**
     * Properties of entity Contact.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property MemberId = new Property(1, int.class, "memberId", false, "MEMBER_ID");
        public final static Property ContactId = new Property(2, int.class, "contactId", false, "CONTACT_ID");
        public final static Property Email = new Property(3, String.class, "email", false, "EMAIL");
        public final static Property Name = new Property(4, String.class, "name", false, "NAME");
        public final static Property HeadBig = new Property(5, String.class, "headBig", false, "HEAD_BIG");
        public final static Property HeadSmall = new Property(6, String.class, "headSmall", false, "HEAD_SMALL");
        public final static Property RegisterTime = new Property(7, java.util.Date.class, "registerTime", false, "REGISTER_TIME");
        public final static Property CreateTime = new Property(8, java.util.Date.class, "createTime", false, "CREATE_TIME");
        public final static Property Pinyin = new Property(9, String.class, "pinyin", false, "PINYIN");
    };


    public ContactDao(DaoConfig config) {
        super(config);
    }
    
    public ContactDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "'CONTACT' (" + //
                "'_id' INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "'MEMBER_ID' INTEGER NOT NULL ," + // 1: memberId
                "'CONTACT_ID' INTEGER NOT NULL ," + // 2: contactId
                "'EMAIL' TEXT NOT NULL ," + // 3: email
                "'NAME' TEXT NOT NULL ," + // 4: name
                "'HEAD_BIG' TEXT," + // 5: headBig
                "'HEAD_SMALL' TEXT," + // 6: headSmall
                "'REGISTER_TIME' INTEGER," + // 7: registerTime
                "'CREATE_TIME' INTEGER," + // 8: createTime
                "'PINYIN' TEXT NOT NULL );"); // 9: pinyin
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "'CONTACT'";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, Contact entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
        stmt.bindLong(2, entity.getMemberId());
        stmt.bindLong(3, entity.getContactId());
        stmt.bindString(4, entity.getEmail());
        stmt.bindString(5, entity.getName());
 
        String headBig = entity.getHeadBig();
        if (headBig != null) {
            stmt.bindString(6, headBig);
        }
 
        String headSmall = entity.getHeadSmall();
        if (headSmall != null) {
            stmt.bindString(7, headSmall);
        }
 
        java.util.Date registerTime = entity.getRegisterTime();
        if (registerTime != null) {
            stmt.bindLong(8, registerTime.getTime());
        }
 
        java.util.Date createTime = entity.getCreateTime();
        if (createTime != null) {
            stmt.bindLong(9, createTime.getTime());
        }
        stmt.bindString(10, entity.getPinyin());
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public Contact readEntity(Cursor cursor, int offset) {
        Contact entity = new Contact( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.getInt(offset + 1), // memberId
            cursor.getInt(offset + 2), // contactId
            cursor.getString(offset + 3), // email
            cursor.getString(offset + 4), // name
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // headBig
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // headSmall
            cursor.isNull(offset + 7) ? null : new Date(cursor.getLong(offset + 7)), // registerTime
            cursor.isNull(offset + 8) ? null : new Date(cursor.getLong(offset + 8)), // createTime
            cursor.getString(offset + 9) // pinyin
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, Contact entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setMemberId(cursor.getInt(offset + 1));
        entity.setContactId(cursor.getInt(offset + 2));
        entity.setEmail(cursor.getString(offset + 3));
        entity.setName(cursor.getString(offset + 4));
        entity.setHeadBig(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setHeadSmall(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setRegisterTime(cursor.isNull(offset + 7) ? null : new Date(cursor.getLong(offset + 7)));
        entity.setCreateTime(cursor.isNull(offset + 8) ? null : new Date(cursor.getLong(offset + 8)));
        entity.setPinyin(cursor.getString(offset + 9));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(Contact entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(Contact entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    /** @inheritdoc */
    @Override    
    protected boolean isEntityUpdateable() {
        return true;
    }
    
}
