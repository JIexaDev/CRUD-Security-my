package web.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.models.Role;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class RoleDaoImpl implements RoleDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Role> getAllRoles() {
        return entityManager.createQuery("FROM Role", Role.class).getResultList();
    }

    @Override
    public Role findByName(String name) {
        return entityManager.createQuery("SELECT r FROM Role r WHERE r.name=:name", Role.class)
                .setParameter("name", name).getSingleResult();
    }

    @Override
    @Transactional
    public void save(Role role) {
        if (entityManager.contains(role)) {
            entityManager.persist(role);
        } else {
            entityManager.merge(role);
        }
    }
}
