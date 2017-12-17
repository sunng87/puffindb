(ns puffindb.core
  (:gen-class)
  (:require [slacker.server :as s]
            [clojure.tools.logging :as log]
            [mount.core :as m]

            [puffindb.api])
  (:import [org.rocksdb RocksDB]))

(RocksDB/loadLibrary)

(m/defstate server
  :start (s/start-slacker-server [(the-ns 'puffindb.api)] 5005)
  :stop (s/stop-slacker-server server))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (m/start)
  (log/info "PuffinDB started."))
