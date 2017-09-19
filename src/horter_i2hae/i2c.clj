(ns horter-i2hae.i2c

  "ADC via I2C"

  {:author "Adam Helinski"}

  (:require [icare.core :as i2c]))




;;;;;;;;;;


(defn- -to-unsigned

  "Convert 2 bytes from a byte array to an unsigned int"

  [^bytes ba i-lsb i-msb]

  (bit-or (bit-and (aget ba
                         i-lsb)
                   0xff)
          (bit-shift-left (bit-and (aget ba
                                         i-msb)
                                   0xff)
                          8)))




;;;;;;;;;;


(defn raw-data

  "Read 11 bytes of raw data into a byte array.

   These bytes have to be processed in order to extract the values.

   Do not forget to select the slave prior to reading.
  
   Returns the given or newly created byte array.
  
   Throws an IOException if something goes wrong during reading.
  
   Cf. `process`"

  ([bus ba offset]

   (i2c/read-bytes bus
                   ba
                   offset
                   11)
   ba)


  ([bus ba]

   (raw-data bus
             ba
             0))


  ([bus]

   (let [ba (byte-array 11)]
     (i2c/read-bytes bus
                     ba)
     ba)))




(defn process

  "Process raw data.

   Returns a map of channel no -> 10 bits unsigned integer.
  
   Cf. `raw-data`"

  [^bytes raw-data]

  {1 (-to-unsigned raw-data 1  2)
   2 (-to-unsigned raw-data 3  4)
   3 (-to-unsigned raw-data 5  6)
   4 (-to-unsigned raw-data 7  8)
   5 (-to-unsigned raw-data 9 10)})
