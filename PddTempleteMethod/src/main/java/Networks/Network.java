package Networks;

/**
 *
 * @author Bryan
 */
public abstract class Network {
    String userName;
    String password;

    Network() {}

    /**
     * Publica los datos en cualquier red.
     */
    public boolean post(String message) {
        // Autentícate antes de publicar. Cada red utiliza 
        // un método de autenticación diferente.
        if (logIn(this.userName, this.password)) {
            // Envia los datos de entrada.
            boolean result =  sendData(message.getBytes());
            logOut();
            return result;
        }
        return false;
    }

    abstract boolean logIn(String userName, String password);
    abstract boolean sendData(byte[] data);
    abstract void logOut();
}
