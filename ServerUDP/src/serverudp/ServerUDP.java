package serverudp;

// Importa le classi necessarie per la comunicazione di rete e la gestione di dati
import java.net.*;
import java.io.*;

public class ServerUDP {

    // Definisce la porta su cui il server ascolterà in attesa di connessioni
    private static final int PORT = 5000;

    public static void main(String[] args) throws Exception {
        // Crea un socket datagram per la comunicazione UDP
        DatagramSocket serverSocket = new DatagramSocket(PORT);

        // Crea un buffer per la ricezione dei dati
        byte[] receiveData = new byte[1024];

        // Crea un pacchetto datagram per la ricezione
        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);

        // Ciclo infinito per attendere e gestire le richieste dei client
        while (true) {
            // Riceve un datagram dal client
            serverSocket.receive(receivePacket);

            // Converte i dati ricevuti in una stringa
            String message = new String(receivePacket.getData());

            // Stampa il messaggio ricevuto
            System.out.println("Messaggio ricevuto: " + message);

            // Crea un buffer per la risposta
            byte[] sendData = "Ciao, sono il Server!".getBytes();

            // Crea un pacchetto datagram per l'invio, specificando i dati, la lunghezza, 
            // l'indirizzo IP del server e la porta
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, receivePacket.getAddress(), receivePacket.getPort());

            // Invia la risposta al client
            serverSocket.send(sendPacket);
        }
    }
}

