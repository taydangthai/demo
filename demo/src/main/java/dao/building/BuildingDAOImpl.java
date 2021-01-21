package dao.building;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import entity.Building;

@Repository
@Transactional
public class BuildingDAOImpl implements BuildingDAO, BuildingDAOPlus{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Building> findAll() {
        try {
            Session session = entityManager.unwrap(Session.class);
            String hql = "SELECT b FROM Building b";
            Query<Building> query = session.createQuery(hql);
            List list = query.getResultList();
            return list;
        } catch (Exception e) {
            System.out.println("Error findAll by BuildingDAOImpl! \n");
            e.printStackTrace();
        }
        return findAll();
    }

    @Override
    public void addB(Building b) {
        try {
            Session session = entityManager.unwrap(Session.class);
            String sql = "INSERT INTO BUILDING(id, name, address, manager, year_use)" +
                    "VALUES (((SELECT MAX(id) FROM building) + 1),\'"+b.getName()+"\'," +
                    "\'"+b.getAddress()+"\',\'"+b.getManager()+"\',"+b.getYearUse()+")";
            Query<Building> query = session.createSQLQuery(sql);
            query.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error addB by BuildingDAOImpl! \n");
            e.printStackTrace();
        }
        return;
    }

    @Override
    public void editB(Building b) {
        try {
            Session session = entityManager.unwrap(Session.class);
            String hql = "UPDATE Building b set b.name = \'"+b.getName()+"\', b.address = \'"+b.getAddress()+"\'," +
                    "b.manager = \'"+b.getManager()+"\', b.yearUse = "+b.getYearUse()+"  where b.id = "+b.getId()+" ";
            Query<Building> query = session.createQuery(hql);
            query.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error editB by BuildingDAOImpl! \n");
            e.printStackTrace();
        }
        return;
    }

    @Override
    public List<Building> getNameById(Long id) {
        try {
            Session session = entityManager.unwrap(Session.class);
            String hql = "SELECT b FROM Building b where b.id = :id ";
            Query<Building> query = session.createQuery(hql);
            query.setParameter("id", id);
            List<Building> list = query.list();
            return list;
        } catch (Exception e) {
            System.out.println("Error findAll by BuildingDAOImpl! \n");
            e.printStackTrace();
        }
        return getNameById(id);
    }

    @Override
    public Building nameById(Long id) {
        Session session = entityManager.unwrap(Session.class);
        String hql = "SELECT b FROM Building b where b.id = :id ";
        Query<Building> query = session.createQuery(hql);
        query.setParameter("id", id);
        Building list = query.getSingleResult();
        return list;
    }
}
