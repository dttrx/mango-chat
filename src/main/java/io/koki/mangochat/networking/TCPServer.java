package io.koki.mangochat.networking;

public class TCPServer implements Server {
    private volatile boolean running = false;

    @Override
    public void startServer(int port) {
        throw new RuntimeException("not implemented");
    }

    @Override
    public void stopServer() {
        throw new RuntimeException("not implemented");
    }

    @Override
    public boolean isRunning() {
        return running;
    }
}
