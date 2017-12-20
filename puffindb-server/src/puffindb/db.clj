(ns puffindb.db
  (:import [org.rocksdb RocksDB Options]))

(defn default-options []
  (doto (Options.)
    (.setCreateIfMissing true)))

(defn open-db []
  (RocksDB/open (default-options) "/tmp/default.db"))

(defn drop-db [db]
  (.close db))
