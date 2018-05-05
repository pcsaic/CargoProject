package net.dao;

import net.JPA.JpaAbstractDao;
import net.EntityManagerProvider;
import net.entity.Truck;
import java.util.List;

public class TruckDaoImpl extends JpaAbstractDao<Truck> implements TruckDao {

    public List<Truck> findAll() {
        List <Truck> a = EntityManagerProvider.getEntityManager().createQuery("SELECT a FROM Truck a", Truck.class).getResultList();
        return a;
    }
    public Truck findById(int id)
    {
        Truck truck = EntityManagerProvider.getEntityManager().createQuery("SELECT a FROM Truck a WHERE a.id =:idTruck", Truck.class)
                .setParameter("idTruck", id).getSingleResult();
        return truck;
    }
}
