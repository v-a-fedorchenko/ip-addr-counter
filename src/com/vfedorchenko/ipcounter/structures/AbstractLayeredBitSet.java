package com.vfedorchenko.ipcounter.structures;

import java.util.BitSet;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.IntStream;

public abstract class AbstractLayeredBitSet {
    protected final int bitsPerLayer;
    protected final int bitsPerLayerMask;
    protected final int numLayers;
    protected final BitSet[] layers;

    public AbstractLayeredBitSet(int bitsPerLayer, int numLayers) {
        this.bitsPerLayer = bitsPerLayer;
        bitsPerLayerMask = bitsPerLayer - 1;
        this.numLayers = numLayers;
        this.layers = new BitSet[numLayers];
        for (int i = 0; i < numLayers; i++) {
            layers[i] = new BitSet(bitsPerLayer);
        }
    }

    public void set(long ipAddress) {
        int layerIndex = (int) (ipAddress >> 30); 
        int bitIndex = (int) (ipAddress & bitsPerLayerMask);
        layers[layerIndex].set(bitIndex);
    }

    public long cardinality() {
        AtomicLong cardinality = new AtomicLong(0);

        IntStream.range(0, numLayers).parallel().forEach(i -> {
            cardinality.addAndGet(layers[i].cardinality());
        });

        return cardinality.get();
    }
}