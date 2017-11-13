# ADC via I2C

[![Clojars Project](https://img.shields.io/clojars/v/dvlopt/horter-i2hae.svg)](https://clojars.org/dvlopt/horter-i2hae)

Interact with [this](https://www.horter-shop.de/en/i2c-din-rail-modules/172-kit-i2c-analog-input-module-5-channel-10-bit-4260404260745.html)
for reading up to 5 analog 10 bits inputs via I2C.

Relies on [Icare](https://github.com/dvlopt/icare), an I2C clojure lib.

## Usage

```clj
(require '[icare.core       :as i2c]
         '[horter-i2hae.i2c :as adc])


;; first, open an I2C bus where needed
(def bus
     (i2c/open "/dev/i2c-1"))


;; then select the proper slave
(i2c/select bus
            0x08)


;; finally, get the raw data and then extract the value for each channel
;; values are 10 bits unsigned integers, ie. between 0 and 1023 included
(adc/process (adc/raw-data bus))
;; {1 24, 2 546, 3 0, 4 245, 5 0}
```

## License

Copyright © 2017 Adam Helinski

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
