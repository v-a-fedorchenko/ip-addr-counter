package com.vfedorchenko.ipcounter;

public class IPAddressUtils {

    public static long ipToLong(String ipAddress) {
        long result = 0;
        int currentOctet = 0;
        int shift = 24;

        for (int i = 0; i < ipAddress.length(); i++) {
            char c = ipAddress.charAt(i);
            if (c == '.') {
                result |= ((long) currentOctet << shift);
                currentOctet = 0;
                shift -= 8;
            } else {
                currentOctet = currentOctet * 10 + (c - '0');
            }
        }

        result |= currentOctet;
        return result;
    }
}
