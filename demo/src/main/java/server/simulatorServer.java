package server;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import service.SimulatorServicelmpl;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class simulatorServer {
    private Server server;

    private void start() throws IOException {
        server = ServerBuilder.forPort(50001)
                .addService(new SimulatorServicelmpl())
                .build()
                .start();

        // 程序停止钩子
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            // Use stderr here since the logger may have been reset by its JVM shutdown hook.
            System.err.println("*** shutting down gRPC server since JVM is shutting down");
            try {
                simulatorServer.this.stop();
            } catch (InterruptedException e) {
                e.printStackTrace(System.err);
            }
            System.err.println("*** server shut down");
        }));
    }

    /**
     * 停止服务
     */
    private void stop() throws InterruptedException {
        if (server != null) {
            server.shutdown().awaitTermination(30, TimeUnit.SECONDS);
        }
    }

    private void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        final simulatorServer server = new simulatorServer();
        server.start();
        System.out.println("asfaslghalskghal");
        server.blockUntilShutdown();

    }
}
