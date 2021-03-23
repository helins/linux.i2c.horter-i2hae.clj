;; This Source Code Form is subject to the terms of the Mozilla Public
;; License, v. 2.0. If a copy of the MPL was not distributed with this
;; file, You can obtain one at https://mozilla.org/MPL/2.0/.


(ns helins.linux.i2c.horter-i2hae

  "Analog to digital conversion via I2C using a [5 channels 10 bit kit from Horter](https://www.horter-shop.de/en/i2c-din-rail-modules/172-kit-i2c-analog-input-module-5-channel-10-bit-4260404260745.html)."

  {:author "Adam Helinski"}
  
  (:require [helins.linux.i2c :as i2c]))


;;;;;;;;;;


(defn read-channels

  "Reads the current value of each channel.

   Returns a map of channel number -> 10 bit value.
  
   Do not forget to select the needed I2C slave device before calling this function."

  [bus]

  (let [result (i2c/read bus
                         11)]
    (reduce (fn interpret-channel [channel->value [channel i-lsb i-msb]]
              (assoc channel->value
                     channel
                     (bit-or (get result
                                  i-lsb)
                             (bit-shift-left (get result
                                                  i-msb)
                                             8))))
            {}
            [[1 1 2]
             [2 3 4]
             [3 5 6]
             [4 7 8]
             [5 9 10]])))
