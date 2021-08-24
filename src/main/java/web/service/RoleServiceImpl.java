package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.models.Role;
import web.dao.RoleDao;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class RoleServiceImpl implements RoleService {
    final RoleDao repository;

    @Autowired
    public RoleServiceImpl(RoleDao repository) {
        this.repository = repository;
    }

    @Override
    public List<Role> getAllRoles() {
        return repository.getAllRoles();
    }

    @Override
    public Role findByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public void save(Role role) {
        repository.save(role);
    }
}
