import io.grpc.ServerBuilder;

import java.io.IOException;

public class Server {
    public static void main(String[] args) throws IOException, InterruptedException {
        io.grpc.Server server = ServerBuilder.forPort(9191).addService(new Service()).build();
        server.start();
        System.out.println("Server Started at "+server.getPort());
        server.awaitTermination();

    }
}
