# ADC via I2C

[![Clojars
Project](https://img.shields.io/clojars/v/dvlopt/i2c.horter-i2hae.svg)](https://clojars.org/dvlopt/i2c.horter-i2hae)

Interact with
[this](https://www.horter-shop.de/en/i2c-din-rail-modules/172-kit-i2c-analog-input-module-5-channel-10-bit-4260404260745.html)
for reading up to 5 analog 10 bits inputs via
[I2C](https://en.wikipedia.org/wiki/I%C2%B2C).


## Usage

Using [dvlopt.i2c](https://github.com/dvlopt/i2c) for opening an I2C bus and
reading the ADC (without error checking) :

```clj
(require '[dvlopt.i2c                  :as i2c]
         '[dvlopt.i2c.horter-i2hae.i2c :as adc])


;; First, we need to open an I2C bus where needed
(def bus
     (::i2c/bus (i2c/open "/dev/i2c-1")))


;; Then, select our ADC
(i2c/select-slave bus
                  0x08)


;; This is a byte array, our buffer for reading
(def buff
     (adc/data-buffer))


;; Let's read
(i2c/read-bytes bus
                buff)


;; And finally, we can process the data and extract the values
(adc/process buff)
;; => {1 24
;;     2 546
;;     3 0
;;     4 245
;;     5 0}
```

## License

Copyright © 2017-2018 Adam Helinski

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
