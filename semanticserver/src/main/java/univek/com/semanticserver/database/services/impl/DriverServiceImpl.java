package univek.com.semanticserver.database.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import univek.com.semanticserver.database.dao.DriversDAO;
import univek.com.semanticserver.database.domains.Driver;
import univek.com.semanticserver.database.services.DriverService;

@Service
public class DriverServiceImpl implements DriverService {

    private final DriversDAO driversDAO;

    @Autowired
    public DriverServiceImpl(DriversDAO driversDAO) {
        this.driversDAO = driversDAO;
    }

    @Override
    @Transactional(readOnly = true)
    public Driver getById(int id) {
        return driversDAO.list(id);
    }
}
