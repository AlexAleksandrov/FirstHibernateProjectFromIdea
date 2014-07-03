import dto.Address;
import dto.TwoWheeler;
import dto.UserDetails;
import dto.Vehicle;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.*;

import java.util.Date;
import java.util.List;


/**
 * Created by Administrator on 10.06.2014.
 */
public class ExecutionClass {
    public static void main(String[] args) {
        UserDetails userDetails = new UserDetails();
        userDetails.setUserId(1);
        userDetails.setUserName("First User");
        userDetails.setDateOfInput(new Date());

        Address addressOfOffice = new Address();
        addressOfOffice.setCity("Odessa");
        addressOfOffice.setPinCode("1234");
        addressOfOffice.setStreet("Chaikovskogo");
//        userDetails.getAddresses().add(addressOfOffice);

        Address addressOfHome = new Address();
        addressOfHome.setCity("Odessa");
        addressOfHome.setPinCode("56789");
        addressOfHome.setStreet("Pushkinskaya");
//        userDetails.getAddresses().add(addressOfHome);

        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleName("Car");
//        userDetails.getVehicle().add(vehicle);
        Vehicle vehicle2 = new Vehicle();
        vehicle2.setVehicleName("Jeep");
//        userDetails.getVehicle().add(vehicle2);

        TwoWheeler twoWheeler = new TwoWheeler();
        twoWheeler.setVehicleName("Mounain Cycle");
        twoWheeler.setPedalsType("Rubber Big Pedals");
//        userDetails.getVehicle().add(twoWheeler);

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session =  sessionFactory.openSession();
        session.beginTransaction();
        for(int i = 0; i < 10;i++){
            UserDetails userDetails1 = new UserDetails();
            userDetails1.setUserName("User" + (i + 1));
            userDetails1.setDateOfInput(new Date());
            session.save(userDetails1);

        }
        session.getTransaction().commit();
//        session.persist(userDetails);


        session.close();
//        userDetails = null;

        session = sessionFactory.openSession();
        session.beginTransaction();
////        Query query = session.getNamedQuery("UserDetails.SelectNameById");
////        query.setInteger("ID",8);
//        Query query = session.getNamedQuery("UserDetails.SelectByName");
//        query.setString("userNameToFind","User7");
////        query.setFirstResult(4);
//        query.setMaxResults(4);
//        List users = query.list();

        UserDetails userDetails1 = new UserDetails();
        userDetails1.setUserName("User7%");
        Example example = Example.create(userDetails1).excludeProperty("userId").excludeProperty("dateOfInput").enableLike();

        Criteria criteria = session.createCriteria(userDetails.getClass());
        criteria.setProjection(Projections.property("userName")).addOrder(Order.desc("userId")).add(example);
        criteria.setCacheable(true);
        List users = criteria.list();
        session.close();

        session = sessionFactory.openSession();
        session.beginTransaction();
////        Query query = session.getNamedQuery("UserDetails.SelectNameById");
////        query.setInteger("ID",8);
//        Query query = session.getNamedQuery("UserDetails.SelectByName");
//        query.setString("userNameToFind","User7");
////        query.setFirstResult(4);
//        query.setMaxResults(4);
//        List users = query.list();

        userDetails1 = new UserDetails();
        userDetails1.setUserName("User7%");
        example = Example.create(userDetails1).excludeProperty("userId").excludeProperty("dateOfInput").enableLike();

        Criteria criteria2 = session.createCriteria(userDetails.getClass());
        criteria2.setProjection(Projections.property("userName")).addOrder(Order.desc("userId")).add(example);
        criteria2.setCacheable(true);
        users = criteria2.list();
        session.close();
//        userDetails = (UserDetails)session.get(UserDetails.class,1);
//        System.out.println(userDetails.getUserName());
        for(Object u: users){
            System.out.println(u.toString());
//            UserDetails currentUser = (UserDetails)u;
//            System.out.println("Found " + currentUser.getUserName());
        }


    }
}
