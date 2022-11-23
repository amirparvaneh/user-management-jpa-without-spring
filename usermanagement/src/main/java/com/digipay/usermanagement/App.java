package com.digipay.usermanagement;


import com.digipay.usermanagement.model.entity.Permission;
import com.digipay.usermanagement.model.entity.Role;
import com.digipay.usermanagement.service.PermissionServiceImpl;
import com.digipay.usermanagement.service.RoleServiceImpl;


import java.util.ArrayList;
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
        System.out.println("enter an operation ? ");
        System.out.println(" 1 = User Operation \n 2 = Role Operation \n  3 = Permission Operation ");
        Integer inputOperation = scanner.nextInt();
        switch (inputOperation) {
            case 1: {

            }
            case 2: {
                System.out.println(" 1 = Role create \n 2 = deleteRole \n  3 = updateRole \n 4 = listAllRole ");
                RoleServiceImpl roleService = new RoleServiceImpl();
                Integer roleOperation = scanner.nextInt();
                switch (roleOperation) {
                    case 1: {
                        Role role = new Role();
                        System.out.println("Enter Role Title :");
                        String roleTile = scanner.next();
                        PermissionServiceImpl permissionService = new PermissionServiceImpl();
                        List<Permission> permissions = permissionService.findAll();
                        for (Permission permission : permissions) {
                            System.out.println(permission.getId() + "##" + permission.getTitle());
                        }
                        String inputPermission = scanner.next();
                        String[] split = inputPermission.split(",");
                        List<Long> permissionIDList = new ArrayList<>();
                        List<Permission> permissionList = new ArrayList<>();
                        for (String item : split) {
                            permissionIDList.add(Long.parseLong(item));
                        }
                        for (Long permissionId : permissionIDList) {
                            Permission permission = new Permission();
                            permission.setId(permissionId);
                            permissionList.add(permission);
                        }
                        role.setPermission(permissionList);
                        role.setTitle(roleTile);
                        roleService.save(role);
                    }
                    case 3: {
                        System.out.println(" 1 = permission create \n 2 = deletePermission \n  3 = updatePermission \n 4 = listAllPermission ");
                        PermissionServiceImpl permissionService = new PermissionServiceImpl();
                        Integer permissionOperation = scanner.nextInt();
                        switch (permissionOperation) {
                            case 1: {
                                System.out.println("Enter Permission Title :");
                                String title = scanner.next();
                                Permission permission = new Permission();
                                permission.setTitle(title);
                                permissionService.save(permission);
                            }
                            case 2: {

                            }
                            case 3: {

                            }
                            case 4: {

                            }
                        }
                    }
                }

                //todo : get permission info from console -> title;
//        System.out.println("Enter a permission title : ");
//        String title = scanner.nextLine();
//        PermissionServiceImpl permissionCrud = new PermissionServiceImpl();
//        Permission permission = new Permission();
//        permission.setTitle(title);
//        permissionCrud.save(permission);
//        //todo : get Role info from console;
//        System.out.println("Enter role title : ");
//        String roleTitle = scanner.nextLine();
//        Role role = new Role();
//        role.setTitle(roleTitle);
////        role.setPermissions();
//        RoleCrudImpl roleCrud = new RoleCrudImpl();
//        roleCrud.save(role);
//        //todo : get user info
//        System.out.println("Enter your name : ");
//        String name = scanner.nextLine();
//        System.out.println("Enter your national code : ");
//        Long nationalCode = scanner.nextLong();
//        User user1 = new User();
//        user1.setName(name);
//        user1.setNationalID(nationalCode);
//        UserCrudImpl userCrud = new UserCrudImpl();
//        userCrud.save(user1);
            }
        }

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