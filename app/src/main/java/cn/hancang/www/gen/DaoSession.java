package cn.hancang.www.gen;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import cn.hancang.www.greendao.MajorPerson;
import cn.hancang.www.greendao.ProfessionReport;
import cn.hancang.www.greendao.QueryScore;
import cn.hancang.www.greendao.User;

import cn.hancang.www.gen.MajorPersonDao;
import cn.hancang.www.gen.ProfessionReportDao;
import cn.hancang.www.gen.QueryScoreDao;
import cn.hancang.www.gen.UserDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig majorPersonDaoConfig;
    private final DaoConfig professionReportDaoConfig;
    private final DaoConfig queryScoreDaoConfig;
    private final DaoConfig userDaoConfig;

    private final MajorPersonDao majorPersonDao;
    private final ProfessionReportDao professionReportDao;
    private final QueryScoreDao queryScoreDao;
    private final UserDao userDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        majorPersonDaoConfig = daoConfigMap.get(MajorPersonDao.class).clone();
        majorPersonDaoConfig.initIdentityScope(type);

        professionReportDaoConfig = daoConfigMap.get(ProfessionReportDao.class).clone();
        professionReportDaoConfig.initIdentityScope(type);

        queryScoreDaoConfig = daoConfigMap.get(QueryScoreDao.class).clone();
        queryScoreDaoConfig.initIdentityScope(type);

        userDaoConfig = daoConfigMap.get(UserDao.class).clone();
        userDaoConfig.initIdentityScope(type);

        majorPersonDao = new MajorPersonDao(majorPersonDaoConfig, this);
        professionReportDao = new ProfessionReportDao(professionReportDaoConfig, this);
        queryScoreDao = new QueryScoreDao(queryScoreDaoConfig, this);
        userDao = new UserDao(userDaoConfig, this);

        registerDao(MajorPerson.class, majorPersonDao);
        registerDao(ProfessionReport.class, professionReportDao);
        registerDao(QueryScore.class, queryScoreDao);
        registerDao(User.class, userDao);
    }
    
    public void clear() {
        majorPersonDaoConfig.clearIdentityScope();
        professionReportDaoConfig.clearIdentityScope();
        queryScoreDaoConfig.clearIdentityScope();
        userDaoConfig.clearIdentityScope();
    }

    public MajorPersonDao getMajorPersonDao() {
        return majorPersonDao;
    }

    public ProfessionReportDao getProfessionReportDao() {
        return professionReportDao;
    }

    public QueryScoreDao getQueryScoreDao() {
        return queryScoreDao;
    }

    public UserDao getUserDao() {
        return userDao;
    }

}
