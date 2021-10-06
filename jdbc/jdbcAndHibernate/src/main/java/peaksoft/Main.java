package peaksoft;


import peaksoft.service.UserService;
import peaksoft.service.UserServiceImpl;
import peaksoft.util.Util;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь

        UserService user = new UserServiceImpl();

//        user.createUsersTable();
//        user.saveUser("Aizhan", "Nurmatova", (byte) 24);
//        user.saveUser("Sezim", "Satybaldieva", (byte) 24);
//        user.saveUser("Beksultan", "Mamatkadyr", (byte) 17);
//        user.saveUser("Aibek", "Zhumaev", (byte) 20);
//
//        user.getAllUsers().forEach(System.out::println);
//
//        user.cleanUsersTable();
//        user.createUsersTable();
//        user.removeUserById(2);
        // user.saveUser("Aizhan", "Zakyp", (byte) 20);

//        user.removeUserById(1);

         Util.shutDown();


    }
}



