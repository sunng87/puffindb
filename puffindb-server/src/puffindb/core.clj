(ns puffindb.core
  (:gen-class)
  (:require [slacker.server :as s]
            [clojure.tools.logging :as logging]
            [mount.core :as m]
            [bulbul.seg :as bullog]

            [puffindb.api :as api]
            [puffindb.db :as db]
            [puffindb.log :as journal])
  (:import [org.rocksdb RocksDB]))

(RocksDB/loadLibrary)

(m/defstate db
  :start (db/open-db "data/db/"))

(m/defstate server
  :start (s/start-slacker-server [{"puffindb.api" (api/database-api db)}] 5005)
  :stop (s/stop-slacker-server server))

(m/defstate journal
  :start (journal/open-log-store "data/journal/")
  :stop (journal/close-log-store! journal))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (m/start)
  (logging/info "PuffinDB started."))
