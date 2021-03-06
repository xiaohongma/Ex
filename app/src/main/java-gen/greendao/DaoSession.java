package greendao;

import android.database.sqlite.SQLiteDatabase;

import java.util.Map;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.AbstractDaoSession;
import de.greenrobot.dao.identityscope.IdentityScopeType;
import de.greenrobot.dao.internal.DaoConfig;

import model.Contact;
import model.ChatMsg;
import model.RequestMsg;

import greendao.ContactDao;
import greendao.ChatMsgDao;
import greendao.RequestMsgDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see de.greenrobot.dao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig contactDaoConfig;
    private final DaoConfig chatMsgDaoConfig;
    private final DaoConfig requestMsgDaoConfig;

    private final ContactDao contactDao;
    private final ChatMsgDao chatMsgDao;
    private final RequestMsgDao requestMsgDao;

    public DaoSession(SQLiteDatabase db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        contactDaoConfig = daoConfigMap.get(ContactDao.class).clone();
        contactDaoConfig.initIdentityScope(type);

        chatMsgDaoConfig = daoConfigMap.get(ChatMsgDao.class).clone();
        chatMsgDaoConfig.initIdentityScope(type);

        requestMsgDaoConfig = daoConfigMap.get(RequestMsgDao.class).clone();
        requestMsgDaoConfig.initIdentityScope(type);

        contactDao = new ContactDao(contactDaoConfig, this);
        chatMsgDao = new ChatMsgDao(chatMsgDaoConfig, this);
        requestMsgDao = new RequestMsgDao(requestMsgDaoConfig, this);

        registerDao(Contact.class, contactDao);
        registerDao(ChatMsg.class, chatMsgDao);
        registerDao(RequestMsg.class, requestMsgDao);
    }
    
    public void clear() {
        contactDaoConfig.getIdentityScope().clear();
        chatMsgDaoConfig.getIdentityScope().clear();
        requestMsgDaoConfig.getIdentityScope().clear();
    }

    public ContactDao getContactDao() {
        return contactDao;
    }

    public ChatMsgDao getChatMsgDao() {
        return chatMsgDao;
    }

    public RequestMsgDao getRequestMsgDao() {
        return requestMsgDao;
    }

}
