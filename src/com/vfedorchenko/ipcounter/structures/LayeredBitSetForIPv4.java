package com.vfedorchenko.ipcounter.structures;

public class LayeredBitSetForIPv4 extends AbstractLayeredBitSet {

    private static final int BITS_PER_LAYER_IPV4 = 1 << 30;
    private static final int NUM_LAYERS_IPV4 = 1 << 2;

    public LayeredBitSetForIPv4() {
        super(BITS_PER_LAYER_IPV4, NUM_LAYERS_IPV4);
    }
}
