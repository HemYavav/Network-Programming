package Lab7.Non_Blocking_IO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class ClientExample {
    public static void main(String[] args) throws IOException {
        try (SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("localhost", 1234))) {
            String message = "Hello, server!";
            ByteBuffer buffer = ByteBuffer.wrap(message.getBytes());
            socketChannel.write(buffer);
            buffer.clear();
        }
    }
}
