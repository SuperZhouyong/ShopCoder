package cn.hancang.www.gen;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import cn.hancang.www.greendao.User;
import cn.hancang.www.greendao.ProfessionReport;
import cn.hancang.www.greendao.MajorPerson;
import cn.hancang.www.greendao.QueryScore;

import cn.hancang.www.gen.UserDao;
import cn.hancang.www.gen.ProfessionReportDao;
import cn.hancang.www.gen.MajorPersonDao;
import cn.hancang.www.gen.QueryScoreDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig userDaoConfig;
    private final DaoConfig professionReportDaoConfig;
    private final DaoConfig majorPersonDaoConfig;
    private final DaoConfig queryScoreDaoConfig;

    private final UserDao userDao;
    private final ProfessionReportDao professionReportDao;
    private final MajorPersonDao majorPersonDao;
    private final QueryScoreDao queryScoreDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        userDaoConfig = daoConfigMap.get(UserDao.class).clone();
        userDaoConfig.initIdentityScope(type);

        professionReportDaoConfig = daoConfigMap.get(ProfessionReportDao.class).clone();
        professionReportDaoConfig.initIdentityScope(type);

        majorPersonDaoConfig = daoConfigMap.get(MajorPersonDao.class).clone();
        majorPersonDaoConfig.initIdentityScope(type);

        queryScoreDaoConfig = daoConfigMap.get(QueryScoreDao.class).clone();
        queryScoreDaoConfig.initIdentityScope(type);

        userDao = new UserDao(userDaoConfig, this);
        professionReportDao = new ProfessionReportDao(professionReportDaoConfig, this);
        majorPersonDao = new MajorPersonDao(majorPersonDaoConfig, this);
        queryScoreDao = new QueryScoreDao(queryScoreDaoConfig, this);

        registerDao(User.class, userDao);
        registerDao(ProfessionReport.class, professionReportDao);
        registerDao(MajorPerson.class, majorPersonDao);
        registerDao(QueryScore.class, queryScoreDao);
    }
    
    public void clear() {
        userDaoConfig.clearIdentityScope();
        professionReportDaoConfig.clearIdentityScope();
        majorPersonDaoConfig.clearIdentityScope();
        queryScoreDaoConfig.clearIdentityScope();
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public ProfessionReportDao getProfessionReportDao() {
        return professionReportDao;
    }

    public MajorPersonDao getMajorPersonDao() {
        return majorPersonDao;
    }

    public QueryScoreDao getQueryScoreDao() {
        return queryScoreDao;
    }

}
