import com.company.grpc.register.User;
import com.company.grpc.register.userGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost",9191).usePlaintext().build();
        userGrpc.userBlockingStub userStub = userGrpc.newBlockingStub(channel);
        Scanner sc = new Scanner(System.in);

        //Log In
        System.out.println("User Name - ");
        String username = sc.next();
        System.out.println("Password - ");
        String password = sc.next();
        User.LoginRequest loginRequest = User.LoginRequest.newBuilder().setUsername(username).setPassword(password).build();
        User.APIResponse response = userStub.login(loginRequest);
        System.out.println(response.getResponseCode() + "  " + response.getResponsemessage());

        //Register
        System.out.println("Subject Name - ");
        String name = sc.next();
        System.out.println("Registration Id - ");
        int RegID = sc.nextInt();
        User.RegRequest regRequest = User.RegRequest.newBuilder().setName(name).setRegID(RegID).build();
        User.regResponse regresponse = userStub.register(regRequest);
        System.out.println(regresponse.getResponseCode() + "  " + regresponse.getResponsemessage());

    }
}
