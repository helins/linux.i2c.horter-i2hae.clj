(defproject dvlopt/horter-i2hae
            "0.0.0-alpha4"

  :description  "Clojure lib for reading analog inputs via I2C (Horter I2HAE)"
  :url          "https://github.com/dvlopt/horter-i2hae"
  :license      {:name "Eclipse Public License"
                 :url  "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[dvlopt/icare "0.0.0-alpha0"]]
  :profiles     {:dev {:source-paths ["dev"]
                       :main         user
                       :dependencies [[org.clojure/clojure "1.9.0-alpha20"]
                                      [org.clojure/spec.alpha "0.1.123"]
                                      [org.clojure/test.check "0.9.0"]
                                      [criterium              "0.4.4"]]
                       :plugins      [[venantius/ultra "0.5.1"]
                                      [lein-midje      "3.0.0"]
                                      [lein-codox      "0.10.3"]]
                       :codox        {:output-path  "doc/auto"
                                      :source-paths ["src"]}
                       :repl-options {:timeout 180000}
                       :global-vars  {*warn-on-reflection* true}}})
