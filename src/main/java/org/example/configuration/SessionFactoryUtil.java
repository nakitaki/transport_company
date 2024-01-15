package org.example.configuration;
import org.example.entity.*;
import org.example.entity.Package;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class SessionFactoryUtil {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            Configuration configuration = new Configuration();
            configuration.addAnnotatedClass(Company.class);
            configuration.addAnnotatedClass(Driver.class);
            configuration.addAnnotatedClass(Vehicle.class);
            configuration.addAnnotatedClass(VehicleType.class);
            configuration.addAnnotatedClass(Transport.class);
            configuration.addAnnotatedClass(Passengers.class);
            configuration.addAnnotatedClass(Package.class);
            configuration.addAnnotatedClass(Category.class);
            configuration.addAnnotatedClass(Costumer.class);
            configuration.addAnnotatedClass(CargoType.class);
            configuration.addAnnotatedClass(CargoDetails.class);
            ServiceRegistry serviceRegistry
                    = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();

            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        }

        return sessionFactory;
    }
}
