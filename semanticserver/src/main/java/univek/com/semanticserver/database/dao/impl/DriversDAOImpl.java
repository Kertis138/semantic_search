package univek.com.semanticserver.database.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import univek.com.semanticserver.database.dao.DriversDAO;
import univek.com.semanticserver.database.domains.Driver;

@Repository
public class DriversDAOImpl  implements DriversDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public DriversDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Driver list(int id) {
        try {
            return sessionFactory.getCurrentSession().get(Driver.class, id);
        }
        catch (Exception e) {
            return null;
        }
    }
}
