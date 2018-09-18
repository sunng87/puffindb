(defproject puffindb "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.9.0"]
                 [org.rocksdb/rocksdbjni "5.14.2"]
                 [slacker "0.17.0"]
                 [com.taoensso/nippy "2.13.0"]
                 [org.clojure/tools.logging "0.4.1"]
                 [mount "0.1.13"]
                 [bulbul "0.1.0-SNAPSHOT"]
                 [org.apache.logging.log4j/log4j-api "2.11.1"]
                 [org.apache.logging.log4j/log4j-core "2.11.1"]]
  :main ^:skip-aot puffindb.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
