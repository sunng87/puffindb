(ns puffindb.api
  (:import [org.rocksdb RocksDB]))

(defn put [db k v]
  (.put ^RocksDB db ^bytes k ^bytes v))

(defn get [db k]
  (.get ^RocksDB db ^bytes k))

(defn rm [db k]
  (.remove ^RocksDB ^bytes k))

(defn database-api [db]
  {"put" (partial put db)
   "get" (partial get db)
   "rm" (partial rm db)})
