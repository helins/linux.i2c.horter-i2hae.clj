(ns horter-i2hae.i2c

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
  
   Returns the number of read bytes if a byte array was given, should be 11
           a new byte array if none was given
  
   Throws an IOException if something goes wrong during reading.
  
   Cf. `process`"

  ([bus ba offset]

   (i2c/read-bytes bus
                   offset
                   11))


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
  
   Returns a vector containing 5 x 10 bits unsigned integers, one for every analog input canal.
  
   Cf. `raw-data`"

  [^bytes raw-data]

  [(-to-unsigned raw-data 1  2)
   (-to-unsigned raw-data 3  4)
   (-to-unsigned raw-data 5  6)
   (-to-unsigned raw-data 7  8)
   (-to-unsigned raw-data 9 10)])
