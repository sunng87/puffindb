(ns puffindb.api
  (:refer-clojure :exclude [get])
  (:import [org.rocksdb RocksDB]
           [java.util List]))

(defn put [db k v]
  (.put ^RocksDB db ^bytes k ^bytes v))

(defn get [db k]
  (.get ^RocksDB db ^bytes k))

(defn mget [db ks]
  (.multiGet ^RocksDB db ^List ks))

(defn rm [db k]
  (.delete ^RocksDB ^bytes k))

(defn scan [db k-start size forward?]
  (with-open [db-iterator (.newIterator ^RocksDB db)]
    (.seek db-iterator k-start)

    (loop [s 0 acc []]
      (if (and (< s size) (.isValid db-iterator))
        (let [k (.key db-iterator)
              v (.value db-iterator)]
          (if forward?
            (.next db-iterator)
            (.prev db-iterator))
          (recur (inc s) (conj acc [k v])))
        acc))))

(defn database-api [db]
  {"put" (partial put db)
   "get" (partial get db)
   "mget" (partial mget db)
   "rm" (partial rm db)
   "scan" (partial scan db)})
