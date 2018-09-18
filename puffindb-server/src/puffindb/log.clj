(ns puffindb.log
  (:require [bulbul.codec :as bc]
            [bulbul.seg :as bs]
            [bulbul.protocol :as bp]
            [bulbul.seg.writer]))

(def puffin-key (bc/byte-block (bc/int16)))
(def puffin-value (bc/byte-block (bc/int16)))

(def puffin-put-codec
  (bc/record
   puffin-key
   puffin-value))

(def puffin-delete-codec
  (bc/record
   puffin-key))

(def puffin-log-codec
  (bc/header
   (bc/enum (bc/byte) {:put 1 :delete 2})
   {:put puffin-put-codec
    :delete puffin-delete-codec}))

(defn open-log-store [dir]
  (let [log-store (bs/segment-log puffin-log-codec {:directory dir
                                                    ;; max size per file: 32MB
                                                    :max-size (* 1024 1024 32)})]
    (bp/open-writer! log-store)
    log-store))

(defn close-log-store! [log-store]
  (bp/close-writer! log-store))
