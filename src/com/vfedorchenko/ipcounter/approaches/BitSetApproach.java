package com.vfedorchenko.ipcounter.approaches;

import com.vfedorchenko.ipcounter.IPAddressUtils;
import com.vfedorchenko.ipcounter.structures.LayeredBitSetForIPv4;

public class BitSetApproach implements UniqueIPCounter {

    LayeredBitSetForIPv4 layeredBitSet = new LayeredBitSetForIPv4();
    @Override
    public void addIpAddress(String ipAddress) {
        layeredBitSet.set(IPAddressUtils.ipToLong(ipAddress));
    }

    @Override
    public long countUniqueIPs() {
        return layeredBitSet.cardinality();
    }
}
