(defproject puffindb "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.10.1"]
                 [org.rocksdb/rocksdbjni "6.8.1"]
                 [slacker "0.17.0"]
                 [com.taoensso/nippy "2.14.0"]
                 [org.clojure/tools.logging "1.1.0"]
                 [mount "0.1.16"]
                 [bulbul "0.1.0-SNAPSHOT"]
                 [org.apache.logging.log4j/log4j-api "2.13.3"]
                 [org.apache.logging.log4j/log4j-core "2.13.3"]]
  :main ^:skip-aot puffindb.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
