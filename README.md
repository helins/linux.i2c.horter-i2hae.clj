# ADC via I2C

[![Clojars
Project](https://img.shields.io/clojars/v/dvlopt/linux.i2c.horter-i2hae.svg)](https://clojars.org/dvlopt/linux.i2c.horter-i2hae)

Interact with
[this](https://www.horter-shop.de/en/i2c-din-rail-modules/172-kit-i2c-analog-input-module-5-channel-10-bit-4260404260745.html)
for reading up to 5 analog 10 bits inputs via
[I2C](https://en.wikipedia.org/wiki/I%C2%B2C).


## Usage

Using [dvlopt/linux.i2c](https://github.com/dvlopt/linux.i2c.clj) for opening an I2C bus and
reading the ADC (without error handling) :

```clj
(require '[dvlopt.linux.i2c              :as i2c]
         '[dvlopt.linux.i2c.horter-i2hae :as adc])


(with-open [^java.lang.AutoCloseable bus (i2c/bus "/dev/i2c-1")]
  
  (i2c/select-slave bus
                    0x08)

  (adc/read-channels bus)

  => {1 24
      2 546
      3 0
      4 245
      5 0}
  )
```


## License

Copyright © 2017 Adam Helinski

Licensed under the term of the Mozilla Public License 2.0, see LICENSE.
