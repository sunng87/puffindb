(ns puffindb.db
  (:import [org.rocksdb RocksDB Options]))

(defn default-options []
  (doto (Options.)
    (.setCreateIfMissing true)))

(defn open-db [path]
  (RocksDB/open (default-options) path))

(defn drop-db [db]
  (.close db))
