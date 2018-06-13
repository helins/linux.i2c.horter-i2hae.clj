(ns user

  "For daydreaming in the repl."

  (:require [clojure.spec.alpha              :as s]
            [clojure.spec.gen.alpha          :as gen]
            [clojure.spec.test.alpha         :as st]
            [clojure.test.check.clojure-test :as tt]
            [clojure.test.check.generators   :as tgen]
            [clojure.test.check.properties   :as tprop]
            [clojure.test                    :as t]
            [criterium.core                  :as ct]
            [dvlopt.linux.i2c                :as i2c]
            [dvlopt.linux.i2c.horter-i2hae   :as adc]))




;;;;;;;;;;


(set! *warn-on-reflection*
      true)




;;;;;;;;;;


(comment
  
  

  )
