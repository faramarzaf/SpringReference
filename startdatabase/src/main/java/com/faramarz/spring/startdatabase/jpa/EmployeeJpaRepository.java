package com.faramarz.spring.startdatabase.jpa;

import com.faramarz.spring.startdatabase.jpa.entity.Employee;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class EmployeeJpaRepository {

    /**
     * @PersistenceContext allows you to specify which persistence unit you want to use.
     * Your project might have multiple data sources connected to different DBs
     * and @PersistenceContext allows you to say which one you want to operate on.
     * <p>
     * Entities are managed by javax.persistence.EntityManager instance using persistence context.
     * Each EntityManager instance is associated with a persistence context.
     * Within the persistence context, the entity instances and their lifecycle are managed.
     * Persistence context defines a scope under which particular entity instances are created, persisted, and removed.
     * A persistence context is like a cache which contains a set of persistent entities ,
     * So once the transaction is finished, all persistent objects are detached from the EntityManager's persistence context and are no longer managed.
     */

    @PersistenceContext
    EntityManager entityManager;


    public List<Employee> findAll() {
        TypedQuery<Employee> namedQuery = entityManager.createNamedQuery("find_all_employees", Employee.class);
       return namedQuery.getResultList();
    }

    public Employee findById(int id) {
        return entityManager.find(Employee.class, id);
    }

    public Employee update(Employee employee) {
        return entityManager.merge(employee);
    }

    public Employee insert(Employee employee) {
        return entityManager.merge(employee);
    }

    public void deleteById(int id) {
        Employee employee = findById(id);
        entityManager.remove(employee);
    }

}
