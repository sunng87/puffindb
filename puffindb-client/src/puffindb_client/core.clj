(ns puffindb-client.core
  (:require [slacker.client :as s]))

(declare sc)

(s/defn-remote sc puffindb.api/put)

(s/defn-remote sc puffindb.api/get)

(s/defn-remote sc puffindb.api/rm)

(defn create-puffindb-client [host port]
  (s/slackerc (str host ":" port) :content-type :nippy))

(defmacro with-puffindb-client [client & body]
  `(s/with-slackerc ~client ~@body))
