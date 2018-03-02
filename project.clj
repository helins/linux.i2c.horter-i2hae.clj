(defproject dvlopt/i2c.horter-i2hae
            "0.0.0"

  :description "Clojure library for ADC via I2C (Horter I2HAE)"
  :url         "https://github.com/dvlopt/i2c.horter-i2hae"
  :license     {:name "Eclipse Public License"
                :url  "http://www.eclipse.org/legal/epl-v10.html"}
  :profiles    {:dev {:source-paths ["dev"]
                      :main         user
                      :dependencies [[criterium              "0.4.4"]
                                     [dvlopt/i2c             "0.0.0"]
                                     [org.clojure/clojure    "1.9.0"]
                                     [org.clojure/spec.alpha "0.1.123"]
                                     [org.clojure/test.check "0.9.0"]]
                      :plugins      [[lein-codox      "0.10.3"]
                                     [venantius/ultra "0.5.2"]]
                      :codox        {:output-path  "doc/auto"
                                     :source-paths ["src"]}
                      :repl-options {:timeout 180000}
                      :global-vars  {*warn-on-reflection* true}}})
