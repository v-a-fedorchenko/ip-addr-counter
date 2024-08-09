package com.vfedorchenko.ipcounter.approaches;

public interface UniqueIPCounter {
    void addIpAddress(String ipAddress);
    long countUniqueIPs();
}
