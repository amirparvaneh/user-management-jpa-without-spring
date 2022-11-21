package com.digipay.usermanagement;


import ch.qos.logback.classic.Logger;
import com.digipay.usermanagement.model.entity.Permission;
import com.digipay.usermanagement.model.entity.Role;
import com.digipay.usermanagement.model.entity.User;
import com.digipay.usermanagement.service.PermissionCrudImpl;
import com.digipay.usermanagement.service.RoleCrudImpl;
import com.digipay.usermanagement.service.UserCrudImpl;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        //Logger logger ;
//        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
//        entityManager.getTransaction().begin();
        //we are saving permission : save permission
        Scanner scanner = new Scanner(System.in);
        //todo : get permission info from console -> title;
        System.out.println("Enter a permission title : ");
        String title = scanner.nextLine();
        PermissionCrudImpl permissionCrud = new PermissionCrudImpl();
        Permission permission = new Permission();
        permission.setTitle(title);
        permissionCrud.save(permission);
        //todo : get Role info from console;
        System.out.println("Enter role title : ");
        String roleTitle = scanner.nextLine();
        Role role = new Role();
        role.setTitle(roleTitle);
//        role.setPermissions();
        RoleCrudImpl roleCrud = new RoleCrudImpl();
        roleCrud.save(role);
        //todo : get user info
        System.out.println("Enter your name : ");
        String name = scanner.nextLine();
        System.out.println("Enter your national code : ");
        Long nationalCode = scanner.nextLong();
        User user1 = new User();
        user1.setName(name);
        user1.setNationalID(nationalCode);
        UserCrudImpl userCrud = new UserCrudImpl();
        userCrud.save(user1);
    }
}


//package com.digipay;
//
//        import jakarta.persistence.EntityManagerFactory;
//        import jakarta.persistence.Persistence;
//
//public class JPAUtil {
//    private static final String PERSISTENCE_UNIT_NAME = "TestPersistence";
//    private static EntityManagerFactory factory;
//
//    public static EntityManagerFactory getEntityManagerFactory() {
//        if (factory == null) {
//            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
//        }
//        return factory;
//    }
//
//    public static void shutdown() {
//        if (factory != null) {
//            factory.close();
//        }
//    }
//}

//package com.digipay;
//
//        import com.digipay.model.User;
//        import jakarta.persistence.EntityManager;
//        import org.hibernate.Session;
//        import org.slf4j.Logger;
//        import org.slf4j.LoggerFactory;
//
///**
// * Hello world!
// */
//public class JpaMain {
//    public static void main(String[] args) {
//        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
//        entityManager.getTransaction().begin();
//
//        User user = new User();
//        user.setFirstName("Pankaj");
//        user.setLastName("CEOi");
//        user.setUsername("888pan");
//        user.setPassword("888");
//        user.setAge(19);
//        entityManager.persist(user);
//        entityManager.getTransaction().commit();
//        entityManager.close();
//
//        JPAUtil.shutdown();
//    }
//}