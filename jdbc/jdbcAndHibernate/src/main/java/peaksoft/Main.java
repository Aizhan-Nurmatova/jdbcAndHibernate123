package peaksoft;

import peaksoft.dao.UserDao;
import peaksoft.dao.UserDaoJdbcImpl;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
        UserDaoJdbcImpl users = new UserDaoJdbcImpl();
      //  users.createUsersTable();

//        users.saveUser("Aizhan","Nurmatova", (byte) 24);
//        users.saveUser("Sezim","Satybaldieva", (byte) 24);
//        users.saveUser("Beksultan","Mamatkadyr", (byte) 17);
//        users.saveUser("Aibek","Zhumaev", (byte) 20);

       // users.getAllUsers().forEach(System.out::println);
//
          users.cleanUsersTable();
        //users.dropUsersTable();
       // users.removeUserById(3);
    }
}
