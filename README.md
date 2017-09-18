# Analog input to I2C

Interact with [this](https://www.horter-shop.de/en/i2c-din-rail-modules/172-kit-i2c-analog-input-module-5-channel-10-bit-4260404260745.html)
for reading up to 5 analog 10 bits inputs via I2C.

Relies on [Icare](https://github.com/dvlopt/icare), an I2C clojure lib.

## Installation

Simple add the following to your dependencies :

    [dvlopt/horter-i2hae "0.0.0-alpha0"]

## Usage

```clj
(require '[icare.core       :as i2c]
         '[horter-i2hae.i2c :as analog-in])


;; first, open an i2c bus where needed
(def bus
     (i2c/open "/dev/i2c-1"))


;; then select the proper slave
(i2c/select bus
            0x08)


;; finally, get the raw data and then extract the value for each channel
;; values are 10 bits unsigned integers, ie. between 0 and 1023 included
(analog-in/process (analog-in/raw-data bus))
;; => [24 546 0 245 0]
```

## License

Copyright © 2017 Adam Helinski

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
