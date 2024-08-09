import com.vfedorchenko.ipcounter.approaches.BitSetApproach;
import com.vfedorchenko.ipcounter.approaches.UniqueIPCounter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    private static final String FILE_NAME = "ip_addresses";

    public static void main(String[] args) {
        UniqueIPCounter ipCounter = new BitSetApproach();

        long startTime = System.nanoTime();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                ipCounter.addIpAddress(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Unique IPs: " + ipCounter.countUniqueIPs() +
                ", Execution time: " + (double) (System.nanoTime() - startTime) / 1000000000 + " s");
    }
}