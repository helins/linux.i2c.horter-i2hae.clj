(ns dvlopt.i2c.horter-i2hae

  "Analog to digital conversion via I2C using a 5 channels 10 bit kit from Horter."

  {:author "Adam Helinski"})




;;;;;;;;;; Private


(defn- -to-unsigned

  "Converts 2 bytes from a byte array into an \"unsigned\" int."

  [^bytes ba i-lsb i-msb]

  (bit-or (bit-and (aget ba
                         i-lsb)
                   0xff)
          (bit-shift-left (bit-and (aget ba
                                         i-msb)
                                   0xff)
                          8)))




;;;;;;;;;;


(defn data-buffer

  "Creates a byte array for reading the necessary data straight from the converter."

  []

  (byte-array 11))




(defn process

  "Process raw data from a byte array.

   Returns a map of channel no -> 10 bits unsigned integer.
  

   Cf. `data-buffer`"

  [^bytes ba]

  {1 (-to-unsigned ba 1  2)
   2 (-to-unsigned ba 3  4)
   3 (-to-unsigned ba 5  6)
   4 (-to-unsigned ba 7  8)
   5 (-to-unsigned ba 9 10)})
